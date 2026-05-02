# URL Shortener (Spring Boot)

Backend-проект сервиса сокращения ссылок, реализованный на Java с использованием Spring Boot и PostgreSQL.
Проект создавался как учебный и демонстрационный backend-проект для портфолио Java-разработчика.

---

## 🧱 Архитектура проекта

Проект построен по классической backend-архитектуре:

- **controller** — REST-контроллеры (HTTP API)
- **service** — бизнес-логика приложения
- **repository** — слой доступа к данным (Spring Data JPA)
- **model** — JPA-сущности
- **dto** — объекты передачи данных
- **exception** — централизованная обработка ошибок
- **util** — вспомогательные классы (кодирование short-кодов)

Используется `@ControllerAdvice` для глобальной обработки исключений и единого формата ошибок API.

---

## 🛠️ Стек технологий

- Java 17
- Spring Boot 3.4.1
- Spring Web
- Spring Data JPA
- PostgreSQL 16
- Springdoc OpenAPI / Swagger UI
- Docker / Docker Compose
- Maven

---

## 🚀 Запуск проекта

### 1️⃣ Запуск PostgreSQL через Docker

В корне проекта находится файл `docker-compose.yml`.

Выполните команду:

```bash
docker compose up -d
```

PostgreSQL будет доступен по адресу:

```
localhost:5432
```

Параметры подключения (по умолчанию):

- **Database**: shortener  
- **User**: shortener  
- **Password**: shortener  

---

### 2️⃣ Запуск Spring Boot приложения

Убедитесь, что используется **Java 17**.

Сборка:

```bash
mvn clean package
```

Запуск:

```bash
mvn spring-boot:run
```

После запуска приложение будет доступно по адресу:

```
http://localhost:8080
```

Если `8080` уже занят:

```bash
lsof -iTCP:8080 -sTCP:LISTEN
kill <PID>
```

Или можно временно запустить приложение на другом порту:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

---

## 📘 Swagger / OpenAPI

После запуска документация доступна по адресам:

- `http://localhost:8080/swagger-ui.html`
- `http://localhost:8080/swagger-ui/index.html`

OpenAPI JSON:

- `http://localhost:8080/v3/api-docs`

Если приложение запущено на другом порту, замените `8080` на нужный порт.

---

## 🔗 API

- `POST /shorten` — создать короткую ссылку
- `GET /{code}` — перейти по короткой ссылке
- `GET /stats/{code}` — получить статистику по ссылке

Пример запроса на создание:

```http
POST /shorten
Content-Type: application/json

{
  "url": "https://example.com"
}
```

---

## 🎯 Назначение проекта

Проект предназначен для:

- демонстрации backend-навыков Java-разработчика
- понимания REST-архитектуры
- работы с базой данных через JPA
- настройки окружения через Docker

Frontend намеренно не реализован — проект сфокусирован на backend-части.

---

## 📌 Статус проекта

- Backend стабилен
- PostgreSQL подключён
- Docker-окружение настроено
- Swagger / OpenAPI подключены
- Проект готов к расширению (тесты, security и т.д.)

---

## 👤 Автор

Железнов Александр  
Java Backend Developer (Junior)
