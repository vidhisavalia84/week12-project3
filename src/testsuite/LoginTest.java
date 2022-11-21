package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl="http://the-internet.herokuapp.com/login";
    @Before
    public void browserSetup(){
openBrowser(baseUrl);
    }

@Test
public void userShouldLoginSuccessfullyWithValidCredential(){
        sendTextToElement(By.id("username"),"tomsmith");
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//button[@class='radius'and@type='submit']/i"));
    String expectedMessage="Secure Area";
   String actualMessage= getTextFromElement(By.xpath("//div[@id='content']/div/h2"));
   Assert.assertEquals(actualMessage,expectedMessage);
}



    @Test
    public void verifyTheUserNameErrorMessage(){
        sendTextToElement(By.id("username"),"tomsmith1");
        sendTextToElement(By.id("password"),"SuperSecretPassword!");
        clickOnElement(By.xpath("//button[@class='radius'and@type='submit']/i"));
        String expectedMessage="Your username is invalid!\n" + "×";
       String actualMessage= getTextFromElement(By.id("flash"));
       Assert.assertEquals(actualMessage,expectedMessage);

    }





/*@Test
//without using utility class method
public void verifyThePasswordMessage(){
    driver.findElement(By.id("username")).sendKeys("tomsmith");
    driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
    driver.findElement(By.xpath("//button[@class='radius'and@type='submit']/i")).click();
    String expectedMessage="Your password is invalid!\n" + "×";
   WebElement actualGetMessage= driver.findElement(By.id("flash"));
   String actualMessage=actualGetMessage.getText();
   Assert.assertEquals(expectedMessage,actualMessage);
}*/
    @Test
    public void  verifyThePasswordMessage(){
        sendTextToElement(By.id("username"),"tomsmith");
        sendTextToElement(By.id("password"),"SuperSecretPassword");
        clickOnElement(By.xpath("//button[@class='radius'and@type='submit']/i"));
        String expectedMessage="Your password is invalid!\n" + "×";
       String actualMessage= getTextFromElement(By.id("flash"));
       Assert.assertEquals(actualMessage,expectedMessage);
    }


@After
    public void browserClose(){
      //  closeBrowser();
}

}
