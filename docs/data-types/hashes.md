# Hashes

Redis의 Hashes 데이터 타입에 대해 학습합니다. Hashes는 필드-값 쌍의 컬렉션으로, 객체를 표현하는데 유용합니다.

## 주요 명령어

- **HSET**: 해시에 필드-값 쌍 저장
- **HGET**: 해시에서 특정 필드의 값 조회
- **HMGET**: 해시에서 여러 필드의 값을 한번에 조회
- **HGETALL**: 해시의 모든 필드-값 쌍 조회
- **HDEL**: 해시에서 특정 필드 삭제
- **HINCRBY**: 해시의 특정 필드 값을 숫자로 증가

## 실습 예제

### 사용자 정보 저장

```sh
# 사용자 정보 저장
hset users:1:info name junwoo email test@test.com phone 010-1111-1111
```

### 단건 조회

```sh
# 개별 필드 조회
hget users:1:info name
hget users:1:info email
hget users:1:info phone
```

### 전체 조회

```sh
# 모든 필드-값 쌍 조회
hgetall users:1:info
# 결과:
# 1) "name"
# 2) "junwoo"
# 3) "email"
# 4) "test@test.com"
# 5) "phone"
# 6) "010-1111-1111"
```

### 필드 삭제

```sh
# 특정 필드 삭제
hdel users:1:info phone
```

### 숫자 필드 증가

```sh
# 방문 횟수 증가
hincrby users:1:info visits 10
```

## 활용 사례

- 사용자 프로필 정보
- 상품 정보
- 세션 데이터
- 설정 정보