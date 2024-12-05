# Named Volume 활용 데이터베이스 유지

### 환경 변수

```
MYSQL_ROOT_PASSWORD=
MYSQL_DATABASE=
```

### 도커 명령어

```bash
docker run \
  --name mysql \
  -p 3306:3306 \
  -v mysql_volume:/var/lib/mysql \
  --env-file .env \
  -d mysql:8.0
```
