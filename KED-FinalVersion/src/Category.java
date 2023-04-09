import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Category {

    private WebDriver driver;

    public Category(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    

    @FindBy(xpath = "//div[@class='orderlistcontainer']//div[@class='title']") public WebElement Sort;
    @FindBy(className = "products-title") public WebElement ProductName;


    public void checkCategoryPage(){
        assertEquals("Sortiraj po", Sort.getText());

    }

    public void clickOnProductName(){
        ProductName.click();
    }

}
