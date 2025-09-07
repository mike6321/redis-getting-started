# Sorted Sets

Redis의 Sorted Sets 데이터 타입에 대해 학습합니다. Sorted Sets는 스코어에 따라 정렬된 중복되지 않는 문자열의 컬렉션입니다.

## 특징

- 정렬된 컬렉션 (ordered collection)
- 각 멤버는 스코어와 함께 저장됨
- 리더보드 구현에 유용
- Rate Limiter 구현 가능

## 주요 명령어

- **ZADD**: 정렬된 세트에 멤버와 스코어 추가
- **ZRANGE**: 지정된 범위의 멤버들을 스코어 순으로 반환
- **ZREM**: 정렬된 세트에서 멤버 제거
- **ZCARD**: 정렬된 세트의 멤버 개수 반환
- **ZRANK/ZREVRANK**: 멤버의 순위 반환
- **ZINCRBY**: 멤버의 스코어 증가

## 실습 예제

### 게임 스코어 보드 생성

```sh
# 플레이어 스코어 추가
zadd game1:scores 100 user1 200 user2 300 user3
zadd game1:scores 50 user4 150 user5 350 user6
```

### 스코어 순 조회

```sh
# 낮은 스코어부터 조회 (오름차순)
zrange game1:scores 0 +inf byscore limit 0 10 withscores

# 높은 스코어부터 조회 (내림차순)
zrange game1:scores +inf 0 byscore rev limit 0 10 withscores
# 결과:
# 1) "user6"
# 2) "350"
# 3) "user3"
# 4) "300"
# 5) "user2"
# 6) "200"
# 7) "user5"
# 8) "150"
# 9) "user1"
# 10) "100"
# 11) "user4"
# 12) "50"
```

### 멤버 삭제

```sh
# 특정 플레이어 삭제
zrem game1:scores user4
```

### 스코어 증가

```sh
# 특정 플레이어 스코어 증가
zincrby game1:scores 500 user2
# 결과: user2의 스코어가 200 + 500 = 700이 됨
```

## 활용 사례

- 게임 리더보드
- 실시간 랭킹 시스템
- Rate Limiting
- 우선순위 큐