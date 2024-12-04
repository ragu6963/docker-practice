### 4-1. Hello World 컨테이너

[hello-world - Official Image | Docker Hub](https://hub.docker.com/_/hello-world)

1. DockerHub에서 `hello-world:latest` 이미지를 다운로드 받는다.
2. 해당 이미지를 기반으로 컨테이너를 생성하고 실행한다.
   - 컨테이너의 이름은 `hello-world` 로 지정한다.
3. 출력 메세지 확인

   ```bash
   Hello from Docker!
   This message shows that your installation appears to be working correctly.

   To generate this message, Docker took the following steps:
    1. The Docker client contacted the Docker daemon.
    2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
       (arm64v8)
    3. The Docker daemon created a new container from that image which runs the
       executable that produces the output you are currently reading.
    4. The Docker daemon streamed that output to the Docker client, which sent it
       to your terminal.

   To try something more ambitious, you can run an Ubuntu container with:
    $ docker run -it ubuntu bash

   Share images, automate workflows, and more with a free Docker ID:
    https://hub.docker.com/

   For more examples and ideas, visit:
    https://docs.docker.com/get-started/
   ```

4. 컨테이너와 이미지를 삭제한다.

### 4-1. 정답

```bash
docker pull hello-world

docker run --name hello-world hello-world

docker rm -f hello-world

docker rmi hello-world
```

### 4-2. Ubuntu 컨테이너

[ubuntu - Official Image | Docker Hub](https://hub.docker.com/_/ubuntu)

1. DockerHub에서 `ubuntu:latest` 이미지를 다운로드 받는다.
2. 해당 이미지를 기반으로 컨테이너를 생성하고 실행한다.
   - 컨테이너의 이름은 `my-ubuntu` 로 지정한다.
   - 컨테이너 실행 후 종료 되지 않도록 옵션을 지정한다.
3. 컨테이너의 내부 터미널에 접속하고, 터미널을 종료한다.
4. 컨테이너와 이미지를 삭제한다.

### 4-2. 정답

```bash
docker pull ubuntu

docker run -d -it --name my-ubuntu ubuntu

docker exec -it ubuntu bash

docker rm -f my-ubuntu

docker rmi ubuntu
```

### 4-3. MySQL 컨테이너

[mysql - Official Image | Docker Hub](https://hub.docker.com/_/mysql)

1. DockerHub에서 `MySQL:8.0` 이미지를 다운로드 받는다.
2. 아래 정보를 기반으로 컨테이너를 생성하고 실행한다.
   - 백그라운드 실행
   - 포트 매핑
     - **`3306:3306`**
   - 환경 변수 파일 활용하여 환경 변수 설정
     - **`MYSQL_DATABASE=demo`**
     - **`MYSQL_ROOT_PASSWORD=1q2w3e4r!`**

### 4-3. 정답

```bash
docker run -d -p 3306:3306 --env-file .env mysql:8.0
```
