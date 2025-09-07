# Lists

Redis의 Lists 데이터 타입에 대해 학습합니다. Lists는 순서가 있는 문자열의 컬렉션입니다.

## 주요 명령어

- **LPUSH**: 리스트의 왼쪽(앞)에 요소 추가
- **RPUSH**: 리스트의 오른쪽(뒤)에 요소 추가
- **LPOP**: 리스트의 왼쪽(앞) 요소 제거 및 반환
- **RPOP**: 리스트의 오른쪽(뒤) 요소 제거 및 반환
- **LLEN**: 리스트의 길이 반환
- **LRANGE**: 지정된 범위의 요소들 반환
- **LTRIM**: 지정된 범위 외의 요소들 제거
- **BRPOP**: 블로킹 방식으로 요소 제거

## 실습 예제

### 스택 구현 (LIFO)

```sh
# 요소 추가
rpush stack1 100
rpush stack1 100
rpush stack1 200

# 요소 제거 (마지막에 추가된 것부터)
rpop stack1
# 결과: (integer) 200
```

### 큐 구현 (FIFO)

```sh
# 요소 추가
rpush queue1 100
rpush queue1 200
rpush queue1 300
rpush queue1 400

# 요소 제거 (처음에 추가된 것부터)
lpop queue1
# 결과: "100"
```

### 범위 조회

```sh
# 전체 조회
lrange queue1 0 -1
# 결과:
# 1) "200"
# 2) "300"  
# 3) "400"
```

### 리스트 크기 제한

```sh
# 요소 추가
rpush queue 100
rpush queue 200
rpush queue 300
rpush queue 400

# 처음 3개 요소만 유지
ltrim queue 0 2
# 결과:
# 1) "100"
# 2) "200"
# 3) "300"
```

### 블로킹 연산

```sh
# 5초간 대기하며 요소 제거 시도
brpop queue 5
# 데이터가 없다면 5초간 대기, 블로킹된 순서대로 값을 응답
```