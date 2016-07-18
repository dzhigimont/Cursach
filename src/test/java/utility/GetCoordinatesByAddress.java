package utility;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import webdriver.BaseEntity;

import java.util.List;

public class GetCoordinatesByAddress extends BaseEntity {


        /**
     * getCoordinates
     *this method find Coordinates by addres
     *@param address 
     * @return String[]
     */
        public String[] getCoordinates (String address){

            String url = browser.getDriver().getCurrentUrl();
            browser.getDriver().get("http://nominatim.openstreetmap.org/");
            String[] rex = null;
            try {

                browser.getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys(address);
                browser.getDriver().findElement(By.cssSelector("button[type='submit']")).click();
                browser.getDriver().findElement(By.cssSelector("a.details")).click();
                browser.waitForPageToLoad();
                String str =  browser.getDriver().findElement(By.xpath("//td[contains(text(),'Centre Point')]/following-sibling::td")).getText() ;
                rex = str.split(",");

                logger.info("the coordinates are successfully found at the address "+address);
            }
            catch (NoSuchElementException e){
                logger.fatal("the coordinates are not found at the address "+address);
            }
            browser.getDriver().get(url);
            browser.waitForPageToLoad();
            return  rex;
        }

    protected String formatLogMsg(final String message) {
        return message;
    }
}

