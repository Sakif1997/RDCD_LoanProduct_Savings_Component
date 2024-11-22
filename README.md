

# Project Name

সঞ্চয়ী প্রোডাক্ট

## Table of Contents

1. [About the Project](#about-the-project)
2. [Target/Goals](#target/goals)
3. [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
4. [Test File Information](#test-file-information)
5. [Usage](#usage)
6. [Report](#report)




# [About the Project](#about-the-project)

The **"সঞ্চয়ী প্রোডাক্ট"** project is designed to streamline the management of savings products within a financial system. It provides a user-friendly dashboard where users can create and manage সঞ্চয়ী (savings) products with precision.

Users start by logging into the dashboard and navigating to the **প্রোডাক্ট ব্যাবস্থাপনা** (Product Management) section. From there, they can select the desired **সঞ্চয়ের ধরণ** (Type of Savings) and proceed to configure various aspects of the product. This includes:

- Setting the **মুনাফা** (Profit) for the product.
- Defining all applicable charges.
- Selecting and uploading necessary documents required for the creation of the savings product.

This project simplifies the product creation process, ensuring that all required information is captured accurately and efficiently, making the system robust and reliable for end-users.
## [Target/Goals](#target/goals)

### Automated Test scenario goals for "Create সঞ্চয়ী প্রোডাক্ট" Project:

1. **Log in and access Product Management**.
2. **Create savings product**: Set profit, define charges, and upload documents.
3. **Validate product details**: Ensure accuracy of saved information.
4. **Ensure system reliability**: Save and display product details correctly.
5. **Test user journey**: Verify smooth navigation and functionality.
6. **Validate product visibility**: Confirm new product appears on the dashboard.

## [Getting Started](#getting-started)

Follow these steps to set up the Selenium project using Eclipse:


## [Prerequisites](#prerequisites)

To set up and run this project, ensure the following tools and configurations are in place:

### 1. **Java Development Kit (JDK)**  
   - Install JDK version 7 or higher.  
   - Add `JAVA_HOME` to the system's environment variables.  

### 2. **Eclipse IDE**  
   - Download and install the latest version of Eclipse IDE for Java Developers.  
   - Configure Eclipse to use the installed JDK.

### 3. **Maven**  
   - Ensure Maven is integrated with Eclipse for dependency management.  
   - Verify Maven installation in Eclipse by navigating to `Window` → `Preferences` → `Maven`.  

### 4. **Google Chrome**  
   - Install the latest version of Google Chrome.  
   - Download the corresponding [ChromeDriver](https://chromedriver.chromium.org/) version and ensure it is added to the system path.  

---

### **Creating the Project in Eclipse**

1. **Create a New Maven Project**:  
   - Open Eclipse.  
   - Navigate to `File` → `New` → `Other...` → Select `Maven Project`.  
   - Select a suitable archetype (e.g., `maven-archetype-quickstart`).  
   - Fill in the group ID, artifact ID, and other details.

2. **Configure the `pom.xml` File**:  
   - After project creation, open `pom.xml`.  
   - Add the necessary dependencies for Selenium, WebDriver Manager, Allure, and Extent Reports:  

     ```xml
     <dependencies>
         <dependency>
             <groupId>org.seleniumhq.selenium</groupId>
             <artifactId>selenium-java</artifactId>
             <version>4.25.0</version>
         </dependency>
         <dependency>
             <groupId>io.github.bonigarcia</groupId>
             <artifactId>webdrivermanager</artifactId>
             <version>5.9.2</version>
         </dependency>
         <dependency>
             <groupId>io.qameta.allure</groupId>
             <artifactId>allure-testng</artifactId>
             <version>2.26.0</version>
         </dependency>
         <dependency>
             <groupId>com.aventstack</groupId>
             <artifactId>extentreports</artifactId>
             <version>5.1.2</version>
         </dependency>
     </dependencies>
     ```

   - Save the file and perform a Maven update by selecting `Maven` → `Update Project`.  

3. **Set Up the Test Project**:  
   - Create packages and classes under `src/test/java`.  
   - Use the **Page Object Model (POM)** pattern:  
     - Create methods for browser setup (e.g., in `BrowserSetup` class).  
     - Organize page-specific methods in the `Utilities` package.  
     - Add test cases in a separate package, e.g., `Test.RDCD_DPS_FDR_PRODUCT`.

4. **Create the TestNG XML Configuration**:  
   - Define the suite and test classes to run all test cases together.  

5. **Generate Reports**:  
   - Ensure the Extent Reports dependency is added in `pom.xml`.  
   - Configure test cases to generate reports upon execution.  

# [Test File Information](#test-file-information)
The following instructions will help you navigate those testing pages. We will create some packages. At the package level, there is a list of classes where you can create methods, use methods for particular pages, and run and test the testing pages separately

- **Set Environment**
i) pom.xml [dependencies set]  

- **Page Object Model:** 
create methods, using methods for separate page and create test cases of those pages  
i) BrowserSetup[package name: `Browser` ]  
ii) Methods and separate page information files [package name:`Utilities`]  
iv) TestCases [package name:`Test.RDCD_DPS_FDR_PRODUCT`] 
- **Create Extent report**
i) pom.xml [dependencies set for Extent report]  
ii) Testng.xml [to run all test file togather]    

![image](https://github.com/user-attachments/assets/35b7da76-49fe-4de3-968a-47df043c834d)

## [Usage](#usage)

### 1. **Browser Setup**

**File:** `BrowserSetup.java`

- This file is located in the **Browser** directory and configures the web browser for automated tests.
- It supports multiple browsers (e.g., Chrome, Edge, Firefox) and manages browser setup and initialization.
  
**Code Example:**

```java
package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {
    private static String BrowserName = System.getProperty("browser", "Edge");
    private static final ThreadLocal<WebDriver> DRIVER_LOCAL = new ThreadLocal<>();
    
    public static ExtentSparkReporter htmlreporter;
    public static ExtentReports extent;    
    
    public static WebDriver getDriver() {
        return DRIVER_LOCAL.get();
    }
    
    public static void setDriver(WebDriver driver) {
        BrowserSetup.DRIVER_LOCAL.set(driver);
    }
    
    public static WebDriver getBrowser(String BrowserName) {
        if (BrowserName.equals("Chrome")) {
            ChromeOptions option1 = new ChromeOptions();
            option1.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(option1);
        } else if (BrowserName.equals("Edge")) {
            EdgeOptions option2 = new EdgeOptions();
            option2.addArguments("--remote-allow-origins=*");
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver(option2);
        } else if (BrowserName.equals("Firefox")) {
            FirefoxOptions option3 = new FirefoxOptions();
            option3.addArguments("--remote-allow-origins=*");
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver(option3);
        } else {
            throw new RuntimeException("Browser not found");
        }
    }
    
    @BeforeSuite
    public static synchronized void setBrowser() {
        htmlreporter = new ExtentSparkReporter("report.html");
        extent = new ExtentReports();
        htmlreporter.config().setTheme(Theme.DARK);
        extent.attachReporter(htmlreporter);
        
        WebDriver webDriver = getBrowser(BrowserName);
        webDriver.manage().window().maximize();
        setDriver(webDriver);
    }
    
    @AfterSuite
    public static synchronized void quitBrowser() {
        getDriver().quit();
        extent.flush();
    }
}
```

### 2. **Utilities**

#### **File:** `method.java` (and individual page object files)

- Located in the **Utilities** directory, this section contains reusable components and methods for different pages.
- `method.java` manages generic methods, while page object files are specific to each page's elements.
The `methods` class contains a collection of utility methods that interact with web elements, manage UI actions, and perform some browser operations in Selenium WebDriver. Below is a breakdown of the methods implemented:

Here is the complete list of methods, each with its description followed by the respective code:

---

1. **To find and return a web element by its locator.**  
```java
public WebElement getElement(By locator) {
    return getDriver().findElement(locator);
}
```

---

2. **To click on a web element identified by the locator.**  
```java
public void click(By locator) {
    getElement(locator).click();
}
```

---

3. **To return the title of the current page.**  
```java
public String PageTitle() {
    return getDriver().getTitle();
}
```

---

4. **To send the provided text to a text input field identified by the locator.**  
```java
public void Fieldvalue(By locator, String text) {
    getElement(locator).sendKeys(text);
}
```

---

5. **To retrieve and return the text of a web element.**  
```java
public String getText(By locator) {
    return getElement(locator).getText();
}
```

---

6. **To wait until the element is visible before proceeding.**  
```java
public void WaitElement(By locator) {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
```

---

7. **To wait for the element to be visible and clickable, then click it.**  
```java
public void WaitElementClick(By locator) {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    wait.until(ExpectedConditions.elementToBeClickable(locator));
    getElement(locator).click();
}
```

---

8. **To select an option in a dropdown by its index.**  
```java
public void DropDownSelectBySerialNumber(By locator, int SerialNumber) {
    Select select = new Select(getElement(locator));
    select.selectByIndex(SerialNumber);
}
```

---

9. **To select an option from a dropdown using the keyboard (arrow keys and Enter).**  
```java
public void DropdownSelectbyKeybord(By locator, int ListNumber) {
    click(locator);
    Actions action = new Actions(getDriver());
    for (int i = 0; i < ListNumber; i++) {
        action.sendKeys(Keys.ARROW_DOWN).perform();
    }
    action.sendKeys(Keys.ENTER).perform();
}
```

---

10. **To select an option from a dropdown by visible text.**  
```java
public void DropDOwnSelectByVisibleTxt(By locator, String text) {
    Select select = new Select(getElement(locator));
    select.selectByVisibleText(text);
}
```

---

11. **To click a dropdown and select an option by visible text.**  
```java
public void DropDownCLickSelect(By locator, String text) {
    click(locator);
    Select select = new Select(getElement(locator));
    select.selectByVisibleText(text);
}
```

---

12. **To switch to an alert and print its message.**  
```java
public void AlertMessage() {
    String alertMessage = getDriver().switchTo().alert().getText();
    System.out.println(alertMessage);
}
```

---

13. **To click on a dropdown-like element and simulate pressing Enter.**  
```java
public void ClickDropDownDiv(By locator) {
    click(locator);
    Actions action = new Actions(getDriver());
    action.sendKeys(Keys.ENTER).perform();
}
```

---

14. **To take a screenshot and attach it to an Allure report.**  
```java
public void takeScreenshot(String name) {
    Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
}
```

---

15. **To select an option from a dropdown using keyboard input (sending keys).**  
```java
public void KeybordInputSelectOption(By locator, String text) {
    click(locator);
    Fieldvalue(locator, text);
    Actions action = new Actions(getDriver());
    action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
}
```

---

16. **To select an option by its index.**  
```java
public void DropDownSelectElement(By locator, int serialnumber) {
    Select select = new Select(getElement(locator));
    select.selectByIndex(serialnumber);
}
```

---

17. **To select an option by visible text.**  
```java
public void SelectByVissibleTxt(By locator, String text) {
    Select select = new Select(getElement(locator));
    select.selectByVisibleText(text);
}
```

---

18. **To hover the mouse over the specified element.**  
```java
public void Hover(By locator) {
    Actions action = new Actions(getDriver());
    action.moveToElement(getElement(locator)).perform();
}
```

---

19. **To send input to a dropdown and select an option using keyboard arrows and Enter.**  
```java
public void DropdownByInput(By locator, String input, int Listnumber) {
    click(locator);
    Fieldvalue(locator, input);
    Actions action = new Actions(getDriver());
    for (int i = 0; i < Listnumber; i++) {
        action.sendKeys(Keys.ARROW_DOWN).perform();
    }
    action.sendKeys(Keys.ENTER).perform();
}
```

---

20. **To select an option in a dropdown-like element using keyboard arrows and Enter.**  
```java
public void DropdownByDivKeybord(By locator, int Listnumber) {
    click(locator);
    Actions action = new Actions(getDriver());
    for (int i = 0; i < Listnumber; i++) {
        action.sendKeys(Keys.ARROW_DOWN).perform();
    }
    action.sendKeys(Keys.ENTER).perform();
}
```

---

21. **To scroll to the bottom of the page.**  
```java
public void ScrollDown() {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
}
```

---

22. **To scroll to the top of the page.**  
```java
public void ScrollUp() {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    js.executeScript("window.scrollTo(0, 0);");
}
```

---

23. **To scroll down the page until the specified element is in view.**  
```java
public void ScrollDownByPageElem(By locator) {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    js.executeScript("arguments[0].scrollIntoView();", getElement(locator));
}
```

---

24. **To select an option in a dropdown-like element using keyboard actions.**  
```java
public void DropdownSelectByDivClass(By locator, int n) {
    click(locator);
    Actions action = new Actions(getDriver());
    for (int i = 0; i < n; i++) {
        action.sendKeys(Keys.ARROW_DOWN).perform();
    }
    action.sendKeys(Keys.ENTER).perform();
}
```

---

25. **To capture a screenshot and return it as a Base64-encoded string.**  
```java
public static String captureScreenshot_base64() {
    TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
    return takesScreenshot.getScreenshotAs(OutputType.BASE64);
}
```

---

26. **To capture a screenshot and save it to a specified file path.**  
```java
public static String captureScreenshot(String filename) {
    TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    File destFile = new File("F:\\office Automation folder\\RDCD_LoanProduct_Savings_Component\\Screenshot" + File.separator + filename);
    try {
        FileUtils.copyFile(sourceFile, destFile);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return destFile.getAbsolutePath();
}
```
#### **File:** `SavingsProductMake.java` 

The `ProductInfoPage` method automates navigation through the application to reach the savings product creation page, where users can input details for a new savings product.

**Method Details**:

- **Purpose:**  
  Automates the navigation steps to access the page for creating a new savings product.

- **Key Actions:**  
  - Waits for the dashboard to load (`WaitElement`).  
  - Clicks through the administrative setup and product management sections (`click`).  
  - Navigates to the "Create Savings Product" section and clicks to initiate the process (`WaitElementClick`).  
  - Waits for the "Product Information" page to load (`WaitElement`).

- **Logging & Reporting:**  
  - No logging or screenshots are captured in this method, focusing purely on navigation within the application.
![image](https://github.com/user-attachments/assets/0ca4993d-c01c-4fba-b0ec-9ddab4342f63)

#### **File:** `ProductSetup1stPage_FDR.java` 
The `ProductSetup1stPage_FDR` class in the **Utilities** package provides methods and locators to automate the first step of setting up an FDR (Fixed Deposit Receipt) product in a financial application. It extends the `methods` class and includes Selenium locators for various input fields, dropdowns, and buttons required on the first setup page. Additionally, it leverages Extent Reports for logging test steps and capturing screenshots.
![image](https://github.com/user-attachments/assets/f774ea5f-e0a9-422e-9661-9b3bcfb30b9b)

### Key Features:
1. **Locators:** Defines `By` locators for elements like dropdowns, input fields, and buttons on the FDR product setup page.
2. **Core Method:**  
   - `FillupFirstProductSetupPage`: Automates the process of selecting dropdown values, entering product details, and saving the form.
3. **Logging & Reporting:** Integrates Extent Reports to log actions, add test steps, and capture screenshots for verification.
4. **Utilities Used:**  
   - Dropdown selections (`DropdownSelectByDivClass`, `DropdownByInput`)  
   - Text input (`Fieldvalue`)  
   - Waiting for elements (`WaitElement`)  
   - Click actions (`click`)  
5. **Exception Handling:** Includes delays (`Thread.sleep`) to ensure the page is fully loaded before interactions.     
![image](https://github.com/user-attachments/assets/81b94540-1f28-44a8-a296-bac565dafddf)

#### **File:** `ProductSetup2ndPage.java` 
The `FillupSecondProductSetupPage` method automates filling out the second step of the FDR product setup, focusing on configuring the profit rate (মুনাফা) for specific years.
![image](https://github.com/user-attachments/assets/26d559cf-4d53-4cb9-a277-326174b041c8)

**Method Details**:

- **Purpose:**  
  Automates the input of activation dates, time periods, and profit rates for a specified number of years, followed by saving the setup.

- **Parameters:**  
  - `ActivationDate` *(String)*: The date when the product becomes active.  
  - `Year` *(String)*: The time period for the FDR (e.g., "1 Year").  
  - `munafayearNumber` *(int)*: Number of years for which profit rates need to be set.  
  - `MunafaRateValues` *(String...)*: Array of profit rates corresponding to each year.

- **Key Actions:**  
  - Waits for the page to load (`WaitElement`).  
  - Enters the activation date (`Fieldvalue`).  
  - Selects a time period from a dropdown (`DropDOwnSelectByVisibleTxt`).  
  - Iteratively fills in profit rates for the specified number of years.  
  - Saves the setup and handles pop-ups (`click`, `WaitElementClick`).


---
![image](https://github.com/user-attachments/assets/a035ed15-24cd-49c8-a8cc-a3b2b7d251bb)

![image](https://github.com/user-attachments/assets/9d31b8c7-1dd2-47ff-831c-0ae41c0bc6d9)

**File:** `ProductSetup3rdPage.java` 

The `AddingCharge` method automates the process of setting up charges for the FDR product in the third step of the setup flow.
![image](https://github.com/user-attachments/assets/a3821574-5bc2-44ce-8c81-12bcc4e97746)

**Method Details**:
- **Purpose:**  
  Automates the process of adding product-related charges by filling in the charge type, date, rate, and selecting the corresponding GL code.

- **Parameters:**  
  - `date` *(String)*: The date when the charge becomes effective.  
  - `Chargerate` *(String)*: The amount for the charge.

- **Key Actions:**  
  - Clicks on the product charge page icon to navigate to the charge setup page.  
  - Waits for the product charge page to load (`WaitElement`).  
  - Selects the charge type and enters the effective date.  
  - Enters the charge rate.  
  - Selects the GL code.  
  - Saves the charge setup by clicking the save button.

- **Logging & Reporting:**  
  - Logs the setup process using Extent Reports.  
  - Captures screenshots at various steps for detailed reporting.
![image](https://github.com/user-attachments/assets/af1e3411-5b14-453f-b7d6-3549be581b5e)  

#### **File:** `ProductSetup4thPage.java` 
The `ProductSendPage` method automates the fourth step of the FDR product setup by selecting necessary documents for the product and finalizing the setup.
![image](https://github.com/user-attachments/assets/a1d9c978-7db6-4b22-a4c6-bd5d05d4fecf)

**Method Details**:

- **Purpose:**  
  Automates the process of selecting the required documents and other related settings for the FDR product, followed by saving the setup.

- **Parameters:**  
  - `PersonName` *(String)*: The name of the person to be selected from a dropdown.

- **Key Actions:**  
  - Waits for the page to load (`WaitElement`).  
  - Selects the necessary document type from a dropdown (`DropdownByDivKeybord`).  
  - Chooses a specific option for "Karjaloi" from another dropdown.  
  - Selects a person from a dropdown by visible text.  
  - Saves the page setup by clicking the save button.

- **Logging & Reporting:**  
  - Logs the setup process using Extent Reports.  
  - Captures screenshots at various steps for reporting and progress tracking.

![image](https://github.com/user-attachments/assets/ecee3016-8cb4-4e20-8a67-2b2f18ebd120)

### 3. **Test Execution**  
**Directory:** `Test.RDCD_DPS_FDR_ProductSetup`

- This directory contains the test scripts, focusing on scenarios related to the **RDCD DPS FDR Product Setup**.
- Scripts include login, product creation, and verification.

### **`Logintest.java`**

The `loggedIn` method automates the login process for the application, entering credentials and navigating to the necessary component for user access.

### **Method Details**:

- **Purpose:**  
  Automates the login process to access the application by entering the server, ID, password, and other required parameters.

- **Parameters:**  
  - `Server` *(String)*: The URL of the login page.  
  - `ID` *(String)*: The user's login ID.  
  - `Password` *(String)*: The user's login password.  
  - `ComponentName` *(String)*: The component that the user will access post-login.  
  - `UserType` *(String)*: The type of user logging in (e.g., admin, regular).  
  - `DoptorName` *(String)*: The department name associated with the user.

- **Key Actions:**  
  - Navigates to the specified server (`getDriver().get`).  
  - Waits for the page to load (`Thread.sleep`).  
  - Performs the login using the `LoggedIn` method of the `Login` class.

---

### **`FDR_Product.java`**

The `ProductSetup` method orchestrates the full setup process for an FDR (Fixed Deposit Receipt) product, guiding through the multi-step product setup.

### **Method Details**:

- **Purpose:**  
  Automates the entire process of setting up an FDR product through multiple steps, starting from login and ending with the product setup completion.

- **Key Actions:**  
  - Logs into the system using the `log_in.loggedIn` method.  
  - Initiates the product setup process via `SPM.ProductInfoPage`.  
  - Fills in the first product setup page (`Firstpage.FillupFirstProductSetupPage`).  
  - Fills in the second product setup page with profit rate values (`Secondpage.FillupSecondProductSetupPage`).  
  - Adds charges for the product (`ThirdPage.AddingCharge`).  
  - Completes the product setup by selecting the necessary documents (`fourthPage.ProductSendPage`).  
  - Waits and completes the test case.
![image](https://github.com/user-attachments/assets/8c45cf5a-55a6-4366-ab00-b1d2ddfe66d1)


## [Report](#report)
**Logging & Reporting:**  
  - Uses Extent Reports to log each step of the process, including successful login, setup steps, and completion of the test.  
  - Screenshots are captured and attached where needed.



The detailed test report can be viewed [here](file:///C:/Users/user/eclipse-workspace/RDCD_DPS_FDR_PRODUCT/report.html)

![image](https://github.com/user-attachments/assets/537628a4-8e29-4850-8f84-f4b6a4c94269)

This structure facilitates maintainable and scalable code while adhering to best practices with the POM design pattern.
