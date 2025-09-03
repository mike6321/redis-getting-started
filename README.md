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

## Data types에 대한 이해

Strings

*  대표적인 타입으로 바이너리 문자를 저장
  * max: 512MB
* 증가 감소에 대한 원자적 연산
  * incremnet / decrement
* 명령어
  * SET
  * SETNX
  * GET
  * MGET
  * INC
  * DEC
* Key 관련
  * TTL
  * DEL (sync)
  * UNLINK (async)
  * MEMORY USAGE

Lists

* 명령어
  * LPUSH
  * RPUSH
  * LPOP
  * RPOP
  * LLEN
  * LRANGE

Sets

* 명령어
  * SADD
  * SREM
  * SISMEMBER
  * SMEMBERS
  * SINTER
  * SCARD

SortedSet

* ordered collection
* Leader Board
* Rate Limiter

* 명령어
  * ZADD
  * ZRANGE
  * ZREM
  * ZCARD
  * ZRANK / ZREVRANK
  * ZINCRBY

Hashes

* 명령어
  * HSET
  * HGET / HMGET
  * HGETALL
  * HDEL
  * HINCRBY



