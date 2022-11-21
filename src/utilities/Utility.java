package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {

    public void clickOnElement(By by){

        driver.findElement(by).click();
    }

    public void sendTextToElement(By by,String text){

        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by){
       WebElement actualTextMessage= driver.findElement(by);
        return actualTextMessage.getText();
    }
}
