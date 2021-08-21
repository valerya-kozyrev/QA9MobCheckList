package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageHelper extends PageBase {

    @FindBy(id = "com.flt.checklist:id/add_shopping_list")
    WebElement addIcon;
    @FindBy(id = "android:id/button1")
    WebElement okButton;
    @FindBy(xpath = "//*[@resource-id = 'android:id/custom']/*[@class='android.widget.EditText']")
    WebElement inputNameField;
    @FindBy(id = "com.flt.checklist:id/list_title")
    WebElement firstListTitle;
    @FindBy(id = "com.flt.checklist:id/list_title")
    List<WebElement> listOfListTitles;

    public HomePageHelper(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(addIcon,5);
    }

    public int getListSize(){
        return listOfListTitles.size();
    }

    public void createNewList(String text){
        clickOnAddIcon();
        listNameInput(text);
        clickOnOkButton();
    }

    public void clickOnAddIcon(){
        addIcon.click();
    }

    public void listNameInput(String text) {
        waitUntilElementIsClickable(okButton,5);
        inputNameField.sendKeys(text);
    }

    public void clickOnOkButton() {
        okButton.click();
    }

    public String getFirstListTitleText(){
        return firstListTitle.getText();
    }

}
