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

```sh
redis-cli monitor
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

```sh
-- 저장
set "users:100:name" "juwnoo"
set "users:100:email" mike6321@naver.com

-- 단건조회
get users:100:name
get users:100:email

-- 다건조회
get users:100:email users:100:name

-- 증가
incr counter
incrby counter 5

-- 감소
decr counter
decrby counter 5
```



Lists

* 명령어
  * LPUSH
  * RPUSH
  * LPOP
  * RPOP
  * LLEN
  * LRANGE

```sh
-- rpop
rpush stack1 100
rpush stack1 100
rpush stack1 200

rpop stack1
(200)

-- lpop
rpush queue1 100
rpush queue1 200
rpush queue1 300
rpush queue1 400

lpop queue1
(100)

-- lrange
lrange queue1 0 -1
1) "200"
2) "300"
3) "400"

-- ltrim
rpush queue 100
rpush queue 200
rpush queue 300
rpush queue 400
1) "100"
2) "200"
3) "300"
4) "400"

ltrim queue 0 2
1) "100"
2) "200"
3) "300"

--brpop
brpop queue 5 
(데이터가 없다면 5s간 대기, blocking된 순서되로 값을 응답)
```



Sets

* 명령어
  * SADD
  * SREM
  * SISMEMBER
  * SMEMBERS
  * SINTER
  * SCARD

```sh
-- sadd
sadd user:100:follow 150 130 120

-- scard
scard user:100:follow

-- sismember (포함여부 확인)
sismember user:100:follow 200

-- sinter (겹치는 키 확인)
sadd user:100:follow 10 20 30
sadd user:200:follow 30 40 50

sinter user:100:follow user:200:follow
30

-- smembers
smembers user:100:follow
1) "10"
2) "20"
3) "30"

- srem (삭제)
srem user:100:follow 30
```



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

```sh
-- zadd
zadd game1:scores 100 user1 200 user2 300 user3
zadd game1:scores 50 user4 150 user5 350 user6

-- zrange (조회)
zrange game1:scores 0 +inf byscore limit 0 10 withscores
-- zrange reverse (조회)
zrange game1:scores +inf 0 byscore rev limit 0 10 withscores
1) "user4"
2) "50"
3) "user1"
4) "100"
5) "user5"
6) "150"
7) "user2"
8) "200"
9) "user3"
10) "300"
11) "user6"
12) "350"

-- zrem
zrem game1:scores user4

--zincrby
zincrby game1:scores 500 user2
1) "user1"
2) "100"
3) "user5"
4) "150"
5) "user3"
6) "300"
7) "user6"
8) "350"
9) "user2"
10) "700"
```



Hashes

* 명령어
  * HSET
  * HGET / HMGET
  * HGETALL
  * HDEL
  * HINCRBY

```sh
-- hset
hset [key] [field] [value] [field] [value] ...
hset users:1:info name junwoo email test@test.com phone 010-1111-1111

-- hget (단건조회)
hget users:1:info name
hget users:1:info email
hget users:1:info phone

-- hgetall (전체조회)
hgetall users:1:info
1) "name"
2) "junwoo"
3) "email"
4) "test@test.com"
5) "phone"
6) "010-1111-1111"

-- hdel
hdel "users:1:info" phone

-- hincrby
hincrby users:1:info visits 10
```





