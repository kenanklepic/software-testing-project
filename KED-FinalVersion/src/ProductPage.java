import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "addtocart-button") public WebElement AddToCart;
    @FindBy(className = "cart-container") public WebElement CartIcon;
    @FindBy(className = "sp-cart-show") public WebElement CartShow;
    @FindBy(className = "back-to-category") public WebElement BacktoCategory;
    @FindBy(xpath = "//div[@class='products-desc-tab']/ul/li[1]") public WebElement Description;
    @FindBy(xpath = "//*[@id='sp-component']/div[3]/div/div[2]/div[2]/div[2]/form/div[2]/span[1]/input") public WebElement quantityInput;


    public void clickOnQuantity(String quantityinput){
        quantityInput.clear();
        quantityInput.sendKeys(quantityinput);
    }
    
    public void checkQuantity(String quantity){
        assertEquals(quantity, quantityInput.getAttribute("value"));
    }

    public void checkProductPage(){
        assertEquals("OPIS", Description.getText());

    }

    public void clickOnAddToCart(){
        AddToCart.click();
    }

    public void clickOnCartIcon(){
        CartIcon.click();
    }

    public void clickOnCartShow(){
        CartShow.click();
    }


  /*  public void checkProductPage(){
        assertEquals("Povratak na: Stripovi i slikovni romani", BacktoCategory.getText());

    }*/



    
}
