package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ListPageHelper;

public class HomePageTests extends TestBase {
    ListPageHelper listPage;

    @BeforeMethod
    public void initTest() {
        listPage = PageFactory.initElements(driver, ListPageHelper.class);
    }

    @Test
    public void addNewListLandscapeTest() {
        int numberOfListsBefore = homePage.getListSize();
        homePage.createNewList("New List");
        listPage.clickOnArrowIcon();
        homePage.turnLandscape();
        homePage.waitUntilPageIsLoaded();
        Assert.assertEquals("New List", homePage.getFirstListTitleText());
        int numberOfListsAfter = homePage.getListSize();
        Assert.assertEquals(numberOfListsAfter, numberOfListsBefore + 1);
    }

    @Test
    public void addNewListBackgroundTest() {
        int numberOfListsBefore = homePage.getListSize();
        homePage.createNewList("New new List");
        listPage.clickOnArrowIcon();
        homePage.runBackground(5);
        homePage.waitUntilPageIsLoaded();
        Assert.assertEquals("New new List", homePage.getFirstListTitleText());
        int numberOfListsAfter = homePage.getListSize();
        Assert.assertEquals(numberOfListsAfter, numberOfListsBefore + 1);
    }


}
