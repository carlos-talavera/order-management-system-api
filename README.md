# 🧩 Event-Driven Microservices Architecture with Saga Pattern

## 📌 Overview

This project demonstrates a **distributed system** based on:

- **Event-Driven Architecture**
- **Saga Pattern (Orchestration or Choreography)**

### Key Characteristics

- Independent, loosely coupled microservices
- Each service is deployable on its own
- Communication:
    - **Asynchronous** via events (RabbitMQ)
    - Minimal **synchronous** calls via REST
- Designed for scalability, resilience, and fault tolerance

---

## ⚙️ Infrastructure

The system relies on the following components:

- **Message Broker:** RabbitMQ
- **Cache:** Redis
- **Database:** PostgreSQL (per service)
- **Observability:**
    - ELK (logs)
    - Prometheus (metrics)
    - Jaeger (tracing)

---

## 🧱 Microservices

### 1. Order Service

**Responsibility:** Manage order lifecycle

**Endpoints:**
- `POST /orders` – Create order
- `GET /orders/{id}` – Get order status
- `PATCH /orders/{id}/cancel` – Cancel order

**Publishes Events:**
- `ORDER_CREATED`
- `ORDER_CANCELLED`
- `ORDER_COMPLETED`

**Consumes Events:**
- `INVENTORY_RESERVED`
- `PAYMENT_PROCESSED`
- `ORDER_SHIPPED`

**Database Tables:**
- `orders`
- `order_items`
- `order_status_log`

**Key Logic:**
- State machine for order transitions
- Idempotent event handling
- Retry mechanisms

---

### 2. Inventory Service

**Responsibility:** Manage stock and reservations

**Consumes:**
- `ORDER_CREATED`

**Publishes:**
- `INVENTORY_RESERVED`
- `INVENTORY_REJECTED`

**Database Tables:**
- `products`
- `stock_reservations`

**Key Logic:**
- Optimistic reservations
- Compensation support

---

### 3. Payment Service

**Responsibility:** Simulate payment processing

**Consumes:**
- `INVENTORY_RESERVED`

**Publishes:**
- `PAYMENT_PROCESSED`
- `PAYMENT_FAILED`

**Key Logic:**
- Simulated payment (90% success rate)
- Retries
- Circuit Breaker (Resilience4j)

---

### 4. Shipping Service (Optional but Recommended)

**Consumes:**
- `PAYMENT_PROCESSED`

**Publishes:**
- `ORDER_SHIPPED`

---

### 5. Notification Service

**Consumes:**
- `ORDER_CREATED`
- `ORDER_COMPLETED`
- `ORDER_SHIPPED`

**Behavior:**
- Sends simulated emails (logged only)

---

### 6. User Service

**Responsibility:** Basic user data management

- Customer data
- Shipping address