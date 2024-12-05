# 멀티스테이지를 활용한 스프링 부트 도커파일

### 환경 변수 .env.production

```plain
DATABASE_HOST=host.docker.internal
DATABASE_PORT={DB 포트}
DATABASE_NAME={DB 이름}
DATABASE_USERNAME={DB 유저}
DATABASE_PASSWORD={DB 유저 패스워드}
```

### 도커파일 빌드 및 컨테이너 실행

```bash
docker build -t backend-image .
```

```bash
docker run \
  -p 8080:8080 \
  --name backend-container \
  --env-file .env.prodution \
  -d backend-image
```
