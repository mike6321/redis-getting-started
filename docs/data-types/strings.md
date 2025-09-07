# Strings

Redis의 가장 기본적인 데이터 타입인 Strings에 대해 학습합니다.

## 특징

- 대표적인 타입으로 바이너리 문자를 저장
- 최대 크기: 512MB
- 증가/감소에 대한 원자적 연산 지원 (increment/decrement)

## 주요 명령어

### 기본 조작
- **SET**: 키에 값 저장
- **SETNX**: 키가 존재하지 않을 때만 값 저장
- **GET**: 키의 값 조회
- **MGET**: 여러 키의 값을 한번에 조회

### 숫자 조작
- **INCR**: 값을 1 증가
- **INCRBY**: 값을 지정한 수만큼 증가
- **DECR**: 값을 1 감소
- **DECRBY**: 값을 지정한 수만큼 감소

### 키 관리
- **TTL**: 키의 생존 시간 조회
- **DEL**: 키 삭제 (동기)
- **UNLINK**: 키 삭제 (비동기)
- **MEMORY USAGE**: 키가 사용하는 메모리 양 조회

## 실습 예제

### 기본 저장 및 조회

```sh
# 저장
set "users:100:name" "junwoo"
set "users:100:email" "mike6321@naver.com"

# 단건 조회
get users:100:name
get users:100:email

# 다건 조회
mget users:100:email users:100:name
```

### 숫자 증가/감소

```sh
# 증가
incr counter
incrby counter 5

# 감소
decr counter
decrby counter 5
```