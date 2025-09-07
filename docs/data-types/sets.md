# Sets

Redis의 Sets 데이터 타입에 대해 학습합니다. Sets는 중복되지 않는 문자열의 컬렉션입니다.

## 주요 명령어

- **SADD**: 세트에 멤버 추가
- **SREM**: 세트에서 멤버 제거
- **SISMEMBER**: 멤버가 세트에 포함되어 있는지 확인
- **SMEMBERS**: 세트의 모든 멤버 반환
- **SINTER**: 여러 세트의 교집합 반환
- **SCARD**: 세트의 멤버 개수 반환

## 실습 예제

### 기본 조작

```sh
# 멤버 추가
sadd user:100:follow 150 130 120

# 멤버 개수 확인
scard user:100:follow

# 멤버 포함 여부 확인
sismember user:100:follow 200
# 결과: (integer) 0 (포함되지 않음)
```

### 교집합 구하기

```sh
# 두 개의 세트 생성
sadd user:100:follow 10 20 30
sadd user:200:follow 30 40 50

# 교집합 구하기
sinter user:100:follow user:200:follow
# 결과: 
# 1) "30"
```

### 전체 멤버 조회

```sh
# 모든 멤버 조회
smembers user:100:follow
# 결과:
# 1) "10"
# 2) "20"
# 3) "30"
```

### 멤버 삭제

```sh
# 멤버 삭제
srem user:100:follow 30
```

## 활용 사례

- 사용자 팔로우/팔로워 관리
- 태그 시스템
- 중복 제거가 필요한 데이터 저장