# 멀티스테이지를 활용한 스프링 부트 도커파일

### 환경 변수 .env

```plain
DATABASE_HOST=host.docker.internal
DATABASE_PORT={DB 포트}
DATABASE_NAME={DB 이름}
DATABASE_USERNAME={DB 유저}
DATABASE_PASSWORD={DB 유저 패스워드}
```

### 멀티 스테이지 빌드 활용

- dockerfile.multistage

```docker
# 빌드 단계 ------------------------------------
# 별칭(AS) : build
FROM eclipse-temurin:21-jdk-alpine AS build

# 컨테이너 내부 작업 디렉토리 설정
WORKDIR /app

# 프로젝트 빌드를 위한 Gradle 파일 복사
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# 의존성 다운로드
RUN ./gradlew dependencies --no-daemon

# 프로젝트 전체 파일 복사
COPY . ./

# 프로젝트 빌드
RUN ./gradlew bootJar --no-daemon

# ---------------------------------------------
# 실행 단계 ------------------------------------
FROM eclipse-temurin:21-jre-alpine

# 컨테이너 내부 작업 디렉토리 설정
WORKDIR /app

# 빌드 단계에서 생성된 JAR 파일 복사
COPY --from=build /app/build/libs/*.jar app.jar

# Spring Boot 프로젝트 포트 노출
EXPOSE 8080

# 프로젝트 실행 시 명령어
CMD ["java", "-jar", "app.jar"]
```

- 이미지 빌드

```bash
docker build -f dockerfile.multistage -t multistage-image .
```

- 컨테이너 생성 & 실행

```bash
docker run \
  -p 8081:8080 \
  --name multistage-container \
  --env-file .env \
  -d multistage-image
```

### 멀티 스테이지 빌드 미활용

- dockerfile.no-multistage

```docker
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

RUN chmod +x gradlew

RUN ./gradlew dependencies --no-daemon
COPY . ./

RUN ./gradlew bootJar --no-daemon

EXPOSE 8080

CMD ["java", "-jar", "/app/build/libs/app.jar"]
```

- 이미지 빌드

```bash
docker build -f dockerfile.no-multistage -t no-multistage-image .
```

- 컨테이너 생성 & 실행

```bash
docker run \
  -p 8082:8080 \
  --name no-multistage-container \
  --env-file .env \
  -d no-multistage-image
```
