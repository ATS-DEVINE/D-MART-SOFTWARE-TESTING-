# D-Mart E-Commerce Testing Suite

This is a comprehensive automated testing suite for the D-Mart e-commerce platform using Selenium WebDriver, Java, TestNG, and Maven.

## Project Structure

```
D-Mart-Testing/
├── pom.xml                                    # Maven configuration
├── README.md                                  # Project documentation
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/dmart/testing/
│   │           ├── base/
│   │           │   └── BaseTest.java         # Base test class with setup/teardown
│   │           ├── config/
│   │           │   └── ConfigReader.java     # Configuration reader
│   │           ├── pages/                     # Page Object Model classes
│   │           │   ├── BasePage.java
│   │           │   ├── HomePage.java
│   │           │   ├── LoginPage.java
│   │           │   ├── SignupPage.java
│   │           │   ├── ProductsPage.java
│   │           │   ├── ProductDetailPage.java
│   │           │   ├── CartPage.java
│   │           │   ├── CheckoutPage.java
│   │           │   ├── SellersPage.java
│   │           │   ├── SellerStorePage.java
│   │           │   ├── BuyerDashboardPage.java
│   │           │   ├── SellerDashboardPage.java
│   │           │   └── AdminDashboardPage.java
│   │           └── utils/
│   │               └── ScreenshotUtils.java  # Screenshot utility
│   └── test/
│       ├── java/
│       │   └── com/dmart/testing/tests/
│       │       ├── AuthenticationTests.java       # 15 test cases
│       │       ├── ProductBrowsingTests.java     # 20 test cases
│       │       ├── ShoppingCartTests.java         # 20 test cases
│       │       ├── CheckoutTests.java             # 20 test cases
│       │       ├── UserProfileTests.java          # 20 test cases
│       │       ├── SellerDashboardTests.java      # 20 test cases
│       │       ├── AdminDashboardTests.java       # 20 test cases
│       │       └── EdgeCaseTests.java             # 30 test cases
│       └── resources/
│           ├── config.properties                 # Test configuration
│           ├── log4j2.xml                       # Logging configuration
│           └── testng.xml                       # TestNG suite configuration
└── screenshots/                                 # Failure screenshots (auto-created)
```

## Test Coverage

This testing suite includes **115 test cases** covering:

### 1. Authentication Tests (12 tests)
- Login page accessibility
- Signup page accessibility
- Valid login
- Invalid email login
- Invalid password login
- Empty credentials login
- Empty email login
- Empty password login
- Valid registration
- Duplicate email registration
- Weak password registration
- Logout functionality

### 2. Product Browsing Tests (19 tests)
- Products page accessibility
- Products display
- Product search
- Empty search
- Non-existent product search
- Category filtering
- Product sorting
- Product detail navigation
- Product title display
- Product price display
- Product description display
- Product image display
- Product quantity setting
- Seller navigation from product
- Search from home page
- Product count display
- Pricing tier selection
- Back navigation from product detail
- Multiple product browsing

### 3. Shopping Cart Tests (19 tests)
- Cart page accessibility
- Empty cart display
- Add to cart from product detail
- Add to cart from products page
- Add multiple products to cart
- Remove item from cart
- Update item quantity
- Cart total calculation
- Cart seller grouping
- Continue shopping button
- Checkout navigation from cart
- Cart persistence after refresh
- Cart item count
- Clear cart
- Zero quantity removes item
- Cart item information
- Add same product multiple times
- Cart navigation from product detail
- Cart total update after quantity change

### 4. Checkout Tests (15 tests)
- Checkout page accessibility
- Enter shipping details
- Place order
- Order total display
- Apply valid coupon
- Apply invalid coupon
- Empty coupon code
- Discount amount display
- Select saved address
- Checkout requires shipping details
- Checkout with empty cart
- Cancel checkout
- Multiple sellers order split
- Order confirmation page
- Cart cleared after order

### 5. User Profile Tests (15 tests)
- Buyer dashboard accessibility
- View order history
- Update profile
- View addresses
- View wishlist
- Logout from dashboard
- Profile name display
- Profile email display
- Add new address
- Delete address
- Set default address
- Remove from wishlist
- Move wishlist to cart
- Order details display
- Track order status

### 6. Seller Dashboard Tests (10 tests)
- Seller dashboard accessibility
- View seller products
- View seller orders
- Access seller settings
- Add new product
- Update order status
- Seller logout
- View store status
- Update store information
- Confirm order

### 7. Admin Dashboard Tests (10 tests)
- Admin dashboard accessibility
- View pending sellers
- Approve seller
- Reject seller
- View products for moderation
- Approve product
- Reject product
- Manage coupons
- Create coupon
- Manage categories

### 8. Edge Case Tests (14 tests)
- Search with special characters
- Search with very long string
- Add to cart with maximum quantity
- Add to cart with negative quantity
- Navigation to non-existent product
- Navigation to non-existent seller
- Login with SQL injection attempt
- Login with XSS attempt
- Registration with very long name
- Checkout with invalid phone number format
- Checkout with empty address
- Sellers page with no sellers
- Product page with no products
- Browser back button navigation
- Browser forward button navigation
- Page refresh maintains state
- Direct URL access to cart
- Direct URL access to checkout
- Login page direct access
- Signup page direct access
- Concurrent cart operations
- Rapid page navigation
- Seller store with no products

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Chrome Browser (for Chrome WebDriver)
- Internet connection

## Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd D-Mart-Testing
```

2. Install dependencies:
```bash
mvn clean install
```

## Configuration

Edit `src/test/resources/config.properties` to configure:

- `app.url`: The base URL of the D-Mart application (default: http://localhost:5173)
- `browser`: Browser to use for testing (chrome, firefox, edge)
- `headless`: Run tests in headless mode (true/false)
- Test user credentials for different roles

## Running Tests

### Run all tests:
```bash
mvn test
```

### Run specific test class:
```bash
mvn test -Dtest=AuthenticationTests
```

### Run specific test method:
```bash
mvn test -Dtest=AuthenticationTests#testValidLogin
```

### Run tests with specific browser:
```bash
mvn test -Dbrowser=firefox
```

### Run tests in headless mode:
Update `config.properties` to set `headless=true`

## Test Reports

After test execution, multiple comprehensive reports are generated:

### 1. ExtentReports (Recommended - Interactive Dashboard)
- **Location**: `test-output/ExtentReports/Report_[timestamp].html`
- **Features**:
  - Interactive HTML dashboard with modern UI
  - Pie charts and bar graphs for test results visualization
  - Screenshots automatically attached to failed tests
  - Test execution timeline
  - Detailed test logs with step-by-step information
  - System information (OS, browser, Java version)
  - Filterable test results by status
  - Export to PDF functionality

### 2. TestNG Reports
- **test-output/testng-results.xml** - XML report for CI/CD integration
- **test-output/emailable-report.html** - Email-friendly HTML report
- **test-output/index.html** - TestNG HTML report with detailed results

### 3. Screenshots
- **Location**: `screenshots/` directory
- Automatically captured on test failures
- Named as `[test_name]_[timestamp].png`
- Embedded in ExtentReports for easy viewing

### 4. Custom Markdown Report Template
- **Location**: `TEST_REPORT_TEMPLATE.md`
- A comprehensive template for formal test documentation
- Includes sections for:
  - Executive summary
  - Detailed test results by module
  - Failed test analysis
  - Environment details
  - Coverage analysis
  - Recommendations
  - Appendices

### 5. Sample Report
- **Location**: `SAMPLE_REPORT.md`
- A filled-in example showing how to use the template
- Demonstrates typical test execution results

### Generating Reports

#### Option 1: Automatic Generation
Reports are automatically generated when you run `mvn test`.

#### Option 2: Report Generator Scripts (Windows)
```bash
# After running tests, execute:
generate-report.bat
```

#### Option 3: Report Generator Scripts (Linux/Mac)
```bash
# After running tests, execute:
chmod +x generate-report.sh
./generate-report.sh
```

### Viewing Reports

#### ExtentReports (Best Experience)
1. Navigate to `test-output/ExtentReports/`
2. Open the latest `Report_[timestamp].html` file
3. View interactive dashboard with charts and screenshots

#### TestNG HTML Report
1. Navigate to `test-output/`
2. Open `index.html` in your browser

#### Emailable Report
1. Navigate to `test-output/`
2. Open `emailable-report.html` (suitable for email distribution)

### Report Customization

To customize the ExtentReports:
- Edit `src/main/java/com/dmart/testing/utils/ExtentReportListener.java`
- Modify report title, theme, and system information
- Add custom logging levels or reporters

To customize the markdown template:
- Edit `TEST_REPORT_TEMPLATE.md`
- Add/remove sections as needed
- Use the sample report as a reference

## Technologies Used

- **Selenium WebDriver 4.15.0** - Browser automation
- **TestNG 7.10.2** - Test framework
- **Maven** - Build and dependency management
- **WebDriverManager 5.6.2** - WebDriver management
- **Log4j 2.22.1** - Logging
- **Apache POI 5.2.5** - Excel data handling
- **ExtentReports 5.1.1** - Test reporting

## Page Object Model

The project follows the Page Object Model (POM) design pattern:
- Each page has a corresponding Page class
- Page classes contain locators and methods for interacting with page elements
- Test classes use Page classes to perform actions
- This improves code reusability and maintainability

## Test Data Management

Test data is configured in:
- `config.properties` - Static test data (credentials, URLs)
- Test methods can use dynamic data generation (timestamps, random values)

## Best Practices

1. **Descriptive Test Names**: Each test has a clear description
2. **Priority**: Tests are prioritized to ensure critical tests run first
3. **Independent Tests**: Each test can run independently
4. **Clean Up**: Tests clean up after themselves (logout, clear cart)
5. **Assertions**: Proper assertions to validate expected behavior
6. **Error Handling**: Graceful handling of missing elements/data

## Continuous Integration

This test suite can be integrated with CI/CD pipelines:
- Jenkins
- GitHub Actions
- GitLab CI
- Azure DevOps

Example CI configuration:
```yaml
# GitHub Actions example
- name: Run Tests
  run: mvn test
- name: Upload Test Results
  uses: actions/upload-artifact@v2
  with:
    name: test-results
    path: test-output/
```

## Troubleshooting

### Browser not found:
- Ensure the specified browser is installed
- WebDriverManager will automatically download the correct driver

### Tests fail due to timing:
- Increase `app.timeout` in config.properties
- Add explicit waits in test methods

### Element not found:
- Verify the application is running at the configured URL
- Check if page locators need updating (UI changes)

## License

This testing suite is part of the D-Mart e-commerce platform project.

## Contact

For questions or issues, please contact the development team.
