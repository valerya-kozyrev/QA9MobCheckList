package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPageHelper extends PageBase{

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement arrowBackIcon;

    public ListPageHelper(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnArrowIcon(){
        waitUntilElementIsClickable(arrowBackIcon,10);
        arrowBackIcon.click();
    }

}
