# 📦 Reactive E-Commerce Microservices Backend

## 🚧 Development Status

- This project is currently in the **active development phase**
- All services are being iteratively implemented and tested
- CI/CD, advanced observability, and failure recovery workflows are being fine-tuned
- **Contributions are welcome**, but expect ongoing changes


---

## 📌 Professional Summary

A cloud-native, production-grade **E-Commerce Backend System** designed with **Spring WebFlux (Reactive)** and an **event-driven microservice architecture**, ensuring high **scalability**, **resilience**, **observability**, and **performance**. Built with a focus on **modern DevOps**, **distributed tracing**, **security**, and **clean code practices**.

---

## 🧠 Project Rules & Specifications

* ✅ Every service is **strictly reactive** (non-blocking I/O)
* ✅ Follows **12-Factor App** methodology
* ✅ **Standard API responses** for uniformity
* ✅ Secure using **OAuth2 + JWT + JWK**
* ✅ Modular, independently deployable services
* ✅ Uses **Git for version control**, **Docker/Kubernetes** for environment management

---

## 🚀 Advantages of Design & Tech Stack

| Aspect                        | Specification                                               | Advantage                                                |
| ----------------------------- | ----------------------------------------------------------- | -------------------------------------------------------- |
| 🧵 Reactive WebFlux           | Spring WebFlux (non-blocking I/O)                           | ⚡ High throughput, low latency                           |
| 🔐 Authentication             | OAuth2 + JWT + JWK (by IAM service)                         | 🔒 Centralized and stateless security                    |
| 🧰 API Gateway                | Spring Cloud Gateway                                        | 🚦 Request routing + JWT validation                      |
| 📡 Sync + Async Communication | OpenFeign (sync), Kafka + Outbox (async)                    | 🔀 Robust communication + Event resilience               |
| 🧠 Resilience                 | Resilience4j, Spring Retry, Circuit Breakers                | ♻️ Auto-recovery from transient failures                 |
| 📊 Observability              | Fluentd, Elasticsearch, Kibana, Prometheus, Grafana, Zipkin | 👁️ Logs, metrics, and tracing at production-grade level |
| 📦 Packaging & Deployment     | Docker (Stage), Kubernetes (Prod)                           | 🚀 Easy CI/CD & environment separation                   |
| 🧺 Testing                    | JUnit5, Mockito, TestContainers                             | ✅ Comprehensive unit & integration testing               |

---

## 🧱 App Architecture Overview

> ![ER Diagram](https://github.com/codeJars/ecommerce_eda/blob/main/entity_relationship_diagram.png)

### 🔗 Communication Model

* 🛟️ **API Gateway** → Routes requests + validates JWT via JWK endpoint (IAM)
* 🔐 **IAM Service** → Auth endpoints + JWK set provider
* ↻ **Internal Communication**

  * Sync: OpenFeign REST clients
  * Async: Kafka Events + Outbox Pattern

### 🚀 Microservices List

| Service             | Description                                              |
| ------------------- | -------------------------------------------------------- |
| `service-discovery` | Eureka-based service registry                            |
| `config-server`     | Central config service using Git backend                 |
| `api-gateway`       | Gateway for request routing and JWT verification         |
| `iam-service`       | Login, Register, JWK set, Token Refresh, Admin endpoints |
| `customer-service`  | Manages customer profile and preferences                 |
| `product-service`   | Product catalog, categories, pricing, availability       |
| `order-service`     | Order placement, status, and history                     |
| `inventory-service` | Stock levels, allocation, inventory updates              |
| `payment-service`   | Payment gateway integration, status tracking             |
| `shipping-service`  | Shipment creation, tracking, and logistics               |

---

## 🗾️ Standard API Response

### ✅ Success Response

```json
{
  "status": "SUCCESS",
  "code": 200,
  "message": "Operation completed successfully",
  "data": { ... }
}
```

### ❌ Error Response

```json
{
  "status": "ERROR",
  "code": 400,
  "message": "Invalid input provided",
  "errors": [ "fieldA must not be null" ]
}
```

---

## 📌 Microservice Endpoints Overview

### 🔐 IAM Service

* `POST /auth/register` – User registration
* `POST /auth/login` – JWT token generation
* `POST /auth/refresh` – Token refresh
* `GET /.well-known/jwks.json` – JWK set for token verification
* `GET /admin/users` – Admin view of all users
* [Swagger API Docs](http://localhost:8081/swagger-ui.html)

### 👤 Customer Service

* `GET /customers/me` – Get profile
* `PUT /customers/me` – Update profile
* [Swagger API Docs](http://localhost:8082/swagger-ui.html)

### 📦 Product Service

* `GET /products` – List products
* `GET /products/{id}` – Get product by ID
* `POST /products` – Add new product *(admin only)*
* [Swagger API Docs](http://localhost:8083/swagger-ui.html)

### 📁 Order Service

* `POST /orders` – Place order
* `GET /orders/{id}` – Order details
* `GET /orders/me` – My orders
* [Swagger API Docs](http://localhost:8084/swagger-ui.html)

### 📥 Inventory Service

* `GET /inventory/{productId}` – Check stock
* `POST /inventory/reserve` – Reserve items
* [Swagger API Docs](http://localhost:8085/swagger-ui.html)

### 💳 Payment Service

* `POST /payments/initiate` – Start payment
* `GET /payments/status/{txnId}` – Check status
* [Swagger API Docs](http://localhost:8086/swagger-ui.html)

### 🚚 Shipping Service

* `POST /shipping/schedule` – Schedule shipping
* `GET /shipping/track/{orderId}` – Track order
* [Swagger API Docs](http://localhost:8087/swagger-ui.html)

---

## ⚙️ Configuration & Environments

* 🔧 Dev: Local system (Docker Compose)
* 🧪 Stage: Docker containers
* 🚀 Prod: Kubernetes with service discovery

---

## 📈 Observability Setup

| Tool          | Purpose                   |
| ------------- | ------------------------- |
| Fluentd       | Collect logs              |
| Elasticsearch | Log storage               |
| Kibana        | Log visualization         |
| Prometheus    | Metrics collection        |
| Grafana       | Metrics dashboard         |
| Zipkin        | Distributed tracing       |
| Micrometer    | Instrumentation framework |

---

## 🧺 Testing Strategy

* ✅ **Unit Testing**: JUnit5 + Mockito
* ✅ **Integration Testing**: Spring Boot Test + TestContainers
* ↻ Kafka Event tests with embedded broker

---

## 📌 Version Control

* Git managed
* Follows branching strategy: `main`, `dev`, `feature/*`, `hotfix/*`

---

## 🤝 Contribution Guidelines

* Fork this repo
* Create a feature branch
* Commit with clear messages
* Raise a pull request with detailed description

---

## 📄 License

> This project is licensed under the **MIT License**.

---

## 🙌 Contact

> Built by [Aniket Patel](https://www.linkedin.com/in/aniketpatel11/) | GitHub: [codeJars](https://github.com/codeJars)

---

> *Built for scale. Designed with purpose. Delivered with precision.*