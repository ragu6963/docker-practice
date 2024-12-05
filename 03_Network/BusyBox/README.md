# Bridge 네트워크 DNS 통신

### 도커 명령어

```bash
# Bridge 네트워크 생성
docker network create my-bridge-network

# 컨테이너 생성
docker run -it -d --name container1 --network user-network busybox
docker run -it -d --name container2 --network user-network busybox

# 통신 테스트 1
docker exec container1 ping container2

# 통신 테스트 2
docker exec container2 ping container1

```
