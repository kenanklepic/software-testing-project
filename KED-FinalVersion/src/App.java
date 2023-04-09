import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.annotations.VisibleForTesting;

public class App {
    /*public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kenan\\Desktop\\ChroDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        RegisterPage page = new RegisterPage(driver);
        page.Run();
        page.setEmail("kenan");


           
        
    }*/
    
    WebDriver driver;
    Register objRegister;
    HomePage homepage;
    Product objproduct;
    ProductPage productPage;
    Buy objBuy;
    Category objCategory;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(6000));
        driver.manage().window().maximize();
        driver.get("https://books.ba/");
    }

    @Test
    public void Register() {
        homepage = new HomePage(driver);
        objRegister = new Register(driver);

        homepage.checkHomePage();
        homepage.getSpanRegister();
        homepage.clickOnRegister();

        objRegister.checkRegisterPage();
        objRegister.setEmail("kenan");
        objRegister.setPassword("12345678");
        objRegister.setPassword2("12345678");
        objRegister.setFName("Kenan");
        objRegister.setLname("Klepic");
        objRegister.setAddress("Crkvice");
        objRegister.setZip("72000");
        objRegister.setCity("Zenica");
        objRegister.setCountry();
        objRegister.setPhone("065776814");
       // objRegister.setCaptcha();
        objRegister.setButton();
        objRegister.checkRegister();

    }
    

    @Test
    public void Login(){
        homepage = new HomePage(driver);
        WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(20));

        homepage.checkHomePage();
        homepage.clickOnLogin();

   

        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-username")));
        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-passwd")));

        homepage.setUsername("kenan.klepic@gmail.com");
        homepage.setLoginPassword("123456789");
        homepage.clickOnLoginButton();
        homepage.checkLogin();

    }

    @Test
    public void Logout(){
        homepage = new HomePage(driver);
        WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(20));


        homepage.clickOnLogin();

        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-username")));
        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-passwd")));


        homepage.setUsername("kenan.klepic@gmail.com");
        homepage.setLoginPassword("123456789");
        homepage.clickOnLoginButton();
        homepage.checkLogin();
        homepage.clickOnLogout();

        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id='login-form']/div[2]/input[1]")));

        homepage.clickOnBttnLogout();
    }

    @Test
    public void NegativeUsername(){
        homepage = new HomePage(driver);
        WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(20));

        homepage.checkHomePage();
        homepage.clickOnLogin();

        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-username")));
        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-passwd")));

        homepage.setUsername("kenan.kenan@gmail.com");
        homepage.setLoginPassword("123456789");
        homepage.clickOnLoginButton();
        homepage.checkAlert();
    }

    @Test
    public void NegativePassword(){
        homepage = new HomePage(driver);
        WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(20));

        homepage.checkHomePage();
        homepage.clickOnLogin();

        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-username")));
        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-passwd")));

        homepage.setUsername("kenan.klepic@gmail.com");
        homepage.setLoginPassword("123");
        homepage.clickOnLoginButton();
        homepage.checkAlert();
    }
    
    @Test
    public void BuyBySearch(){
        homepage = new HomePage(driver);
        objproduct = new Product(driver);
        WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(20));
        productPage = new ProductPage(driver);
        objBuy = new Buy(driver);

        homepage.checkHomePage();
        homepage.clickOnLogin();

        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-username")));
        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-passwd")));

        homepage.setUsername("kenan.klepic@gmail.com");
        homepage.setLoginPassword("123456789");
        homepage.clickOnLoginButton();
        homepage.checkLogin();
        homepage.setSearch("Tomie");
        homepage.checkSearch("Tomie");
        homepage.clickSearch();

        objproduct.checkProductName("TOMIE - COMPLETE DELUXE EDITION");
        objproduct.clickOnProductName();

        productPage.checkProductPage();
        productPage.clickOnAddToCart();
        driver.navigate().back();
        productPage.clickOnCartIcon();
        productPage.clickOnCartShow();


        webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_tos_field")));

        //objBuy.clickOnCheckbox();
        //objBuy.clickOnConfirmOrder();
        }

        @Test
        public void BuyByCategory(){
            homepage = new HomePage(driver);
            objCategory = new Category(driver);
            productPage = new ProductPage(driver);
            objBuy = new Buy(driver);
            WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(20));

            homepage.checkHomePage();
            homepage.clickOnLogin();

            webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-username")));
            webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-passwd")));
    
            homepage.setUsername("kenan.klepic@gmail.com");
            homepage.setLoginPassword("123456789");
            homepage.clickOnLoginButton();
            homepage.checkLogin();
            homepage.clickOnCategory();

            objCategory.checkCategoryPage();
            objCategory.clickOnProductName();

            productPage.checkProductPage();
            productPage.clickOnAddToCart();
            driver.navigate().back();
            productPage.clickOnCartIcon();
            productPage.clickOnCartShow();

            webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_tos_field")));

            objBuy.clickOnCheckbox();
            //objBuy.clickOnConfirmOrder();
        }

        @Test
        public void BuyByHomePage(){

            homepage = new HomePage(driver);
            productPage = new ProductPage(driver);
            objBuy = new Buy(driver);
            WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(20));

            homepage.checkHomePage();
            homepage.clickOnLogin();

            webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-username")));
            webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modlgn-passwd")));
    
            homepage.setUsername("kenan.klepic@gmail.com");
            homepage.setLoginPassword("123456789");
            homepage.clickOnLoginButton();
            homepage.checkLogin();
            homepage.clickOnProductName();

            productPage.checkProductPage();
            productPage.clickOnAddToCart();
            driver.navigate().back();
            productPage.clickOnCartIcon();
            productPage.clickOnCartShow();

            webwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_tos_field")));

            objBuy.clickOnCheckbox();
            //objBuy.clickOnConfirmOrder();

        }

        @Test
    public void RegisterWithUsedEmail() {
        homepage = new HomePage(driver);
        objRegister = new Register(driver);

        homepage.checkHomePage();
        homepage.getSpanRegister();
        homepage.clickOnRegister();

        objRegister.checkRegisterPage();
        objRegister.setEmail("kenan.klepic@gmail.com");
        objRegister.setPassword("12345678");
        objRegister.setPassword2("12345678");
        objRegister.setFName("Kenan");
        objRegister.setLname("Klepic");
        objRegister.setAddress("Crkvice");
        objRegister.setZip("72000");
        objRegister.setCity("Zenica");
        objRegister.setCountry();
        objRegister.setPhone("065776814");
        objRegister.setCaptcha();
        objRegister.setButton();
        objRegister.checkRegisterWithUsedEmail();

    }

    @Test 
    public void TestCartNegativeValue(){
        homepage = new HomePage (driver);
        productPage = new ProductPage(driver);
        objBuy = new Buy(driver);

        homepage.clickOnProductName();

        productPage.checkProductPage();
        productPage.clickOnAddToCart();
        productPage.clickOnQuantity("-1");
        productPage.checkQuantity("-1");

        driver.navigate().back();
        productPage.clickOnCartIcon();
        productPage.clickOnCartShow();

        objBuy.checkBuyPage();
        objBuy.checkNegativeValue();
        
    }

    @Test 
    public void TestCartLargeNumber(){
        homepage = new HomePage (driver);
        productPage = new ProductPage(driver);
        objBuy = new Buy(driver);

        homepage.clickOnProductName();

        productPage.checkProductPage();
        productPage.clickOnAddToCart();
        productPage.clickOnQuantity("9999");
        productPage.checkQuantity("9999");

        driver.navigate().back();
        productPage.clickOnCartIcon();
        productPage.clickOnCartShow();

        objBuy.checkBuyPage();
        objBuy.checkNegativeValue();
        
    }

    @Test
    public void TestBanner(){
        homepage = new HomePage(driver);
        homepage.clickOnBanner();
    }

    @Test 
    public void BosnianToEnglish()//test from Bosnian to English 
    {
        homepage = new HomePage(driver);
        homepage.clickOnEnglish();
    }

    @Test
    public void AuthorToEnglish(){ //this one is supposed to fail. We tested expected value of the url. 
        homepage = new HomePage(driver);
        homepage.clickOnAuthor();
        homepage.clickOnEnglish();

    }

    public void RequiredFields(){
       
        homepage = new HomePage(driver);
        objRegister = new Register(driver);
        homepage.getSpanRegister();
        homepage.clickOnRegister();
        objRegister.setEmail("kenan.klepic@gmail.com");
        objRegister.setFName("Kenan");
        objRegister.setLname("Klepic");
        objRegister.setAddress("Crkvice");
        objRegister.setZip("72000");
        objRegister.setCity("Zenica");
        objRegister.setCountry();
        objRegister.setPhone("065776814");


    }




}
