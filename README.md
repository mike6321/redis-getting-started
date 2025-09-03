## Redis 설치

```sh
docker pull redis
```

```sh
docker run --rm -it -p 6379:6379 -d redis:latest
```

## Redis CLI를 통한 접속

```sh
docker exec -it [CONTAINER_ID] redis-cli
```

```
docker exec -it [CONTAINER_ID] redis-cli monitor
```



```sh
docker exec -it bd252f1551a1 /bin/bash
```

```sh
redis-benchmark
```

