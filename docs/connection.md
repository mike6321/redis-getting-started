# Redis CLI 연결

Redis 컨테이너에 CLI로 연결하여 명령어를 실행하는 방법을 안내합니다.

## 기본 연결

Redis CLI로 연결:

```sh
docker exec -it [CONTAINER_ID] redis-cli
```

## 모니터링 모드

실시간으로 Redis 명령어를 모니터링:

```sh
docker exec -it [CONTAINER_ID] redis-cli monitor
```

## 컨테이너 ID 확인

실행 중인 Redis 컨테이너 ID 확인:

```sh
docker ps
```

## 연결 확인

Redis 서버가 정상적으로 동작하는지 확인:

```sh
redis-cli ping
```

응답으로 `PONG`이 출력되면 정상입니다.