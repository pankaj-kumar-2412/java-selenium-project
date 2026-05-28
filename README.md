# Selenium Amazon Login + Product Booking (Add to Cart)

This is a standard Java Selenium Maven project using a Page Object style.

It automates:
- Amazon sign-in
- Product search
- Add first search result to cart (safe booking step)

> Note: This project intentionally stops at **Add to Cart** and does not place payment orders.

## Project Structure

- `pom.xml`
- `src/main/java/com/seleniumproject/config/ConfigReader.java`
- `src/main/java/com/seleniumproject/core/DriverFactory.java`
- `src/main/java/com/seleniumproject/pages/*`
- `src/test/java/com/seleniumproject/tests/AmazonAddToCartTest.java`
- `src/test/resources/config.properties`

## Prerequisites

- Java 17+
- Maven 3.9+
- Chrome/Edge/Firefox installed

## Configuration

Use either `config.properties`, JVM args, or environment variables.

Priority is:
1. JVM `-D` properties
2. Environment variables (`amazon.email` => `AMAZON_EMAIL`)
3. `config.properties`

### Recommended (PowerShell)

```powershell
$env:AMAZON_EMAIL="your-email@example.com"
$env:AMAZON_PASSWORD="your-password"
```

## Run Tests

```powershell
mvn test -Dtest=ConfigReaderTest
mvn test -Dtest=AmazonAddToCartTest -Damazon.product.query="iphone 15"
```

## Known Real-World Constraints

- Amazon may show CAPTCHA, OTP, or bot-detection pages.
- Account lock/security checks can interrupt automation.
- Locators can break when Amazon changes page structure.

If login flow is interrupted by OTP/CAPTCHA, complete it manually in browser and then continue automation from the current page.

