import java.time.Duration;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {

    private WebDriver driver;

    
    public Register(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_field") public WebElement EmailField;
    @FindBy(id = "password_field") public WebElement PasswordField;
    @FindBy(id = "password2_field") public WebElement Password2Field;
    @FindBy(id = "first_name_field") public WebElement FName;
    @FindBy(id = "last_name_field") public WebElement LName;
    @FindBy(id = "address_1_field") public WebElement Address;
    @FindBy(id = "zip_field") public WebElement Zip;
    @FindBy(id = "city_field") public WebElement City;
    @FindBy(id = "virtuemart_country_id_field") public WebElement Country;
    @FindBy(xpath = "//option[@value='27']") public WebElement CountryOpt;
    @FindBy(id = "phone_1_field") public WebElement Phone;
    @FindBy(className = "rc-anchor-content") public WebElement Captcha;
    @FindBy(xpath = "//div[@class='buttonBar-right']//*[text()='Registracija']") public WebElement Bttn;
    @FindBy(className = "alert-heading") public WebElement AlertHeading;
    @FindBy(className = "componentheading") public WebElement ComponentHeading;


    public void checkRegister(){
        assertEquals("Registracija je u toku", ComponentHeading.getText());

    } 

    public void checkRegisterWithUsedEmail(){
        assertEquals("Greška", AlertHeading.getText());

    } 

    public void checkRegisterPage(){
        assertEquals("Registracija", Bttn.getText());

    }

    public void setEmail(String email){
        EmailField.sendKeys(email);
        assertEquals("kenan", EmailField.getAttribute("value"));
    }

    public void setPassword(String password){
        PasswordField.sendKeys(password);
        assertEquals("12345678", PasswordField.getAttribute("value"));

    }

    public void setPassword2(String password){
        Password2Field.sendKeys(password);
        assertEquals("12345678", Password2Field.getAttribute("value"));

    }

    public void setFName(String fName){
        FName.sendKeys(fName);
        assertEquals("Kenan", FName.getAttribute("value"));

    }

    public void setLname(String lName){
        LName.sendKeys(lName);
        assertEquals("Klepic", LName.getAttribute("value"));

    }

    public void setAddress(String address){
        Address.sendKeys(address);
        assertEquals("Crkvice", Address.getAttribute("value"));

    }

    public void setZip(String zip){
        Zip.sendKeys(zip);
        assertEquals("72000", Zip.getAttribute("value"));

    }

    public void setCity(String city){
        City.sendKeys(city);
        assertEquals("Zenica", City.getAttribute("value"));

    }

    public void setCountry(){
        Country.click();
        CountryOpt.click();
        //assertEquals("Bosna i Hercegovina", Country.getAttribute("value"));

    }

    public void setPhone(String phone){
        Phone.sendKeys(phone);
        assertEquals("065776814", Phone.getAttribute("value"));

    }

    public void setCaptcha(){
        Captcha.click();

    }
    
    public void setButton(){
        Bttn.click();

    }




    








    /*public void checkEmail(){
        String toCheck = EmailField.getAttribute("value");
        assertEquals("kenan", EmailField.getAttribute("value"));
    }*/



    
}
