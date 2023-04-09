import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buy {

    private WebDriver driver;

    public Buy(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cart_tos_field") public WebElement Checkbox;
    @FindBy(id = "proopc-order-submit") public WebElement ConfirmOrder;
    @FindBy(className = "proopc-clear-cart-wrapper") public WebElement ClearCart;
    @FindBy(id = "proopc-item-count") public WebElement ItemCount;

    



    public void clickOnCheckbox(){
        Checkbox.click();
    }

    public void clickOnConfirmOrder(){
        ConfirmOrder.click();
    }

    public void checkBuyPage(){
        assertEquals("Isprazni korpu", ClearCart.getText());
    }

    public void checkNegativeValue(){
        assertEquals("0 PROIZVODA", ItemCount.getText());
    }
    
}
