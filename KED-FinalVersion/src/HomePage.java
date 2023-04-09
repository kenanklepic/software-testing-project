import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "sp-register") public WebElement SpanRegister;
    @FindBy(className = "sp-login") public WebElement SpanLogin;
    @FindBy(id = "modlgn-username") public WebElement Username;
    @FindBy(id = "modlgn-passwd") public WebElement passLogin;
    @FindBy(name = "Submit") public WebElement bttnLogin;
    @FindBy(className = "sp-mod-login") public WebElement SpanLogout;
    @FindBy(className = "modal-header") public WebElement HeaderLogout;
    @FindBy(xpath = "//*[@id='login-form']/div[2]/input[1]") public WebElement BttnLogout;
    @FindBy(className = "alert-heading") public WebElement AlertHead;
    @FindBy(id = "search-area259") public WebElement SearchBar;
    @FindBy(id = "ajax-search-button259") public WebElement SearchBttn;
    @FindBy(className = "header") public WebElement Izdvojenohead;
    @FindBy(xpath = "//div[@id='sp-main-menu']/ul/li[2]") public WebElement Category;
    @FindBy(className = "product-image-wrapper") public WebElement ProductName;
    @FindBy(xpath = "//*[@id='slider215']/li[1]/img")public WebElement Banner1;
    @FindBy(xpath = "//*[@id='sp-top1']/div[2]/ul/li[2]/a/img")public WebElement English;
    @FindBy(xpath = "//*[@id='sptab302-0']/div/div/div/ul[1]/li[1]/div/div[2]/p/a")public WebElement Author;


    public void clickOnEnglish(){
        English.click();
    }

    public void clickOnAuthor(){
        Author.click();
        String url = driver.getCurrentUrl();
        assertEquals("https://books.ba/en/bookshop/author/penelope-douglas", url);
    }

    public void clickOnBanner(){
        Banner1.click();
        String url = driver.getCurrentUrl();
        assertEquals("https://books.ba/knjizara/romantika/it-starts-with-us-it-ends-with-us-book-2-1-detail", url);
    }

    public void clickOnCategory(){
        Category.click();
    }


    public void checkHomePage(){
        assertEquals("IZDVOJENO", Izdvojenohead.getText());

    }

    public void getSpanRegister(){
        String spRegister = SpanRegister.getText();
        assertEquals("Registracija", spRegister);
    }

    public void clickOnRegister(){
        SpanRegister.click();
    }

    public void clickOnLogin(){
        SpanLogin.click();
        assertEquals("Prijava", SpanLogin.getText());
    }

    public void setUsername(String username){
        Username.sendKeys(username);
        //assertEquals("kenan.klepic@gmail.com", Username.getAttribute("value"));

    }

    public void setLoginPassword(String password){
        passLogin.sendKeys(password);
        //assertEquals("123456789", Username.getAttribute("value"));

    }

    public void clickOnLoginButton(){
        bttnLogin.click();
        //assertEquals("Prijava", SpanLogin.getText());
    }

    public void checkLogin(){
        assertEquals("Odjava", SpanLogout.getText());
    }

    public void clickOnLogout(){
        SpanLogout.click();
       // assertEquals("Odjava", HeaderLogout.getText());

    }

    public void clickOnBttnLogout(){
        BttnLogout.click();
        //assertEquals("Odjava", HeaderLogout.getText());

    }

    public void checkAlert(){
        assertEquals("Upozorenje", AlertHead.getText());

    }

    public void setSearch(String search){
        SearchBar.sendKeys(search);
        //assertEquals("Tomie", SearchBar.getAttribute("value"));
    }

    public void checkSearch(String name){
        assertEquals(name, SearchBar.getAttribute("value"));

    }

    public void clickSearch(){
        SearchBttn.click();
    }

    public void clickOnProductName(){
        ProductName.click();
    }
    
}
