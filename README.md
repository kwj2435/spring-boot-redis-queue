# Redis 기반 대기열 시스템 🚀

이 프로젝트는 **Spring Boot**, **Redis** 그리고 관련 기술들을 활용하여 대기열 시스템을 구현하는 예제입니다. Redis의 다양한 데이터 구조와 기능(List, Pub/Sub, Sorted Set 등)을 활용해 작업을 효율적으로 관리하고 처리합니다.

---

## 📋 주요 기능

1. **대기열 생성 및 관리**
    - 작업 요청을 대기열에 추가.
    - FIFO 또는 우선순위 기반 처리 지원.

2. **실시간 알림**
    - Redis Pub/Sub를 사용하여 작업 완료 알림 전송.

3. **확장성**
    - 여러 작업자(Worker) 노드가 작업을 분배하여 병렬 처리 가능.

4. **우선순위 작업**
    - Sorted Set을 활용하여 높은 우선순위 작업을 우선적으로 처리.

5. **작업 실패 재처리**
    - Redis Streams를 사용하여 작업 실패 시 재처리 로직 지원.

---

## 🛠️ 기술 스택

- **Java**: 17 이상
- **Spring Boot**: 3.x
- **Redis**: 7.x
- **Spring Data Redis**: Redis와의 데이터 상호작용 관리
- **Lombok**: 코드 간소화
- **Docker**: Redis 실행 환경 관리

---

## 📂 프로젝트 구조

```plaintext
src/main/java/com/example/queue
├── config        // Redis, Spring 설정 파일
├── controller    // REST API 및 작업 관리 엔드포인트
├── service       // 비즈니스 로직 구현
├── repository    // Redis 데이터와 상호작용
├── model         // 데이터 모델 정의
├── subscriber    // Pub/Sub 구독 로직
├── publisher     // Pub/Sub 발행 로직
```

---

## 🚀 설치 및 실행

### 1. 필수 조건
- Java 11 이상 설치
- Docker 설치 (선택 사항)

### 2. Redis 실행

Redis는 Docker를 통해 간단히 실행할 수 있습니다:
```bash
docker run --name redis -d -p 6379:6379 redis
```

또는 로컬에서 Redis를 설치하고 실행합니다.

### 3. 프로젝트 클론
```bash
git clone https://github.com/your-repo/redis-queue-system.git
cd redis-queue-system
```

### 4. 의존성 설치 및 실행
```bash
./mvnw clean install
./mvnw spring-boot:run
```

---

## 🔗 주요 엔드포인트

### 1️⃣ 작업 추가
- **URL**: `POST /api/queue`
- **Request Body**:
  ```json
  {
      "task": "example task"
  }
  ```
- **Response**:
  ```json
  {
      "status": "success",
      "message": "Task added to queue"
  }
  ```

### 2️⃣ 대기열 조회
- **URL**: `GET /api/queue`
- **Response**:
  ```json
  ["task1", "task2", "task3"]
  ```

### 3️⃣ 작업 처리
- Redis Pub/Sub 또는 Streams를 통해 자동 처리.

---

## 📌 Redis 명령어 참고

### 1️⃣ List 기반 대기열
- 작업 추가: `RPUSH queue_key value`
- 작업 처리: `LPOP queue_key`
- 대기열 조회: `LRANGE queue_key 0 -1`

### 2️⃣ Sorted Set 기반 우선순위 대기열
- 작업 추가: `ZADD queue_key score value`
- 작업 조회: `ZRANGE queue_key 0 0`
- 작업 제거: `ZREM queue_key value`

### 3️⃣ Pub/Sub
- 작업 발행: `PUBLISH channel_name message`
- 작업 구독: `SUBSCRIBE channel_name`

---

## 🤝 기여 방법

1. 이슈를 생성하거나 개선 사항을 제안합니다.
2. Pull Request를 작성하고 설명을 추가합니다.

---

## 📜 라이선스

이 프로젝트는 [MIT 라이선스](LICENSE)를 따릅니다.

