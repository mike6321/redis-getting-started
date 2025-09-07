# Redis 설치

Docker를 사용하여 Redis를 설치하고 실행하는 방법을 안내합니다.

## Docker로 Redis 설치

Redis 이미지를 pull합니다:

```sh
docker pull redis
```

Redis 컨테이너를 실행합니다:

```sh
docker run --rm -it -p 6379:6379 -d redis:latest
```

## 성능 테스트

Redis 벤치마크를 실행하여 성능을 측정할 수 있습니다:

```sh
redis-benchmark
```

## 모니터링

Redis 명령어 모니터링:

```sh
redis-cli monitor
```

## 컨테이너 접속

Redis 컨테이너에 bash로 접속:

```sh
docker exec -it [CONTAINER_ID] /bin/bash
```