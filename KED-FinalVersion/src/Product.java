import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {

    private WebDriver driver;

    public Product(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product-name") public WebElement ProductName;
    //@FindBy(className = "product-name") public WebElement Title;



    public void clickOnProductName(){
        ProductName.click();
    }

    public void checkProductName(String name){
        assertEquals(name, ProductName.getText());

    }



    
}
