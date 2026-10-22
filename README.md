# FinTrack — Smart Expense Tracker

A learning full-stack expense tracker built with Java 17, Spring Boot, Spring Data JPA, HTML, CSS, JavaScript, and Chart.js.

## Features
- Add and list income/expense transactions
- Category and type filters
- Monthly totals and balance summary
- Budget target and budget progress indicator
- Responsive dashboard with Chart.js visualization
- REST API backed by a database

## Quick start (no MySQL installation needed)

**Requirements:** Java 17+ and Maven 3.9+.

1. Extract this ZIP.
2. Open the `FinTrack/backend` folder in VS Code.
3. Open Terminal in that folder (the terminal path must end in `FinTrack\backend`).
4. Run:
   ```powershell
   mvn spring-boot:run
   ```
5. Wait until the log says the application has started, then open `http://localhost:8080` in your browser.

The default configuration uses an embedded H2 file database. Transactions persist in `backend/fintrack-data` and MySQL is not required for the quick start. The H2 console is available at `http://localhost:8080/h2-console` while the app is running (JDBC URL: `jdbc:h2:file:./fintrack-data`, user: `sa`, blank password).

## Optional: use MySQL instead

1. Create a MySQL database: `CREATE DATABASE fintrack;`
2. Set environment variables `FINTRACK_DB_USERNAME` and `FINTRACK_DB_PASSWORD` to your MySQL credentials.
3. From the `backend` folder run:
   ```powershell
   mvn spring-boot:run -Dspring-boot.run.profiles=mysql
   ```

## API
- `GET /api/transactions`
- `POST /api/transactions`
- `DELETE /api/transactions/{id}`

## Troubleshooting
- If port 8080 is busy, close the other app using it or change `server.port` in `application.properties`.
- If Maven reports a dependency download error, check internet connectivity and retry the same command.
- To confirm the terminal is in the right folder, run `dir` and check that `pom.xml` is listed.

## Scope and security
This is a student learning project, not production-ready financial software. It does not currently implement user authentication. Do not store real sensitive financial information in it. Test and understand every feature before listing it as completed experience on a resume.
