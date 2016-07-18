package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

/**
 * Created by kristinka on 07.07.2016.
 */
public class CheckBox extends BaseElement {


    /**
     * Constructor
     * @param locator locator
     * @param name name
     */
    public CheckBox(final By locator, final String name) {
        super(locator, name);
    }

    public CheckBox(final By locator) {
        super(locator);
    }

    /**
     * Constructor
     * @param string locator
     * @param name name
     */
    public CheckBox(final String string, final String name) {
        super(string, name);
    }

    /**
     * Returns Element type
     * @return Element type
     */
    protected String getElementType() {return getLoc("loc.CheckBox");}

    /**
     * selectByValue
     *this method select checkbox contains value
     *
     * @param value = "Samsung"
     *
     * @return void
     */

    public void selectByValue(String value){

        info(String.format(getLoc("loc.checkbox.select") + " '%1$s'", value));
        List<WebElement> elementList = browser.getDriver().findElements(locator);
        for (WebElement e: elementList){

            if (e.getAttribute("value").equalsIgnoreCase(value)){
                setElement((RemoteWebElement) e);
                clickAndWait();
                break;
            }

        }

    }

    /**
     * selectByText
     *this method select checkbox contains text
     *
     * @param value = "Samsung"
     *
     * @return void
     */

    public void selectByText(String value){

        info(String.format(getLoc("loc.checkbox.select") + " '%1$s'", value));
        List<WebElement> elementList = browser.getDriver().findElements(locator);
        for (WebElement e: elementList){
            if (e.getText().equalsIgnoreCase(value)){
                setElement((RemoteWebElement) e);
                clickAndWait();
                break;
            }

        }

    }

    /**
     * selectByText
     *this method select All checkbox contains text
     *
     * @return void
     */
    public void selectAll() {

        info(String.format(getLoc("loc.checkbox.select") + " '%1$s'"));
        List<WebElement> elementList = browser.getDriver().findElements(locator);
        for (WebElement e : elementList) {
            setElement((RemoteWebElement) e);
            clickAndWait();

        }
    }

    /**
     * selectByText
     *this method Deselect All checkbox contains text
     *
     * @return void
     */
    public void deSelectAll() {

        info(String.format(getLoc("loc.checkbox.select") + " '%1$s'"));
        List<WebElement> elementList = browser.getDriver().findElements(locator);
        for (WebElement e : elementList) {
            if(e.isSelected())
            setElement((RemoteWebElement) e);
            clickAndWait();

        }
    }


    /**
     * clickAndWait
     *this method Override method  from BaseElement
     *
     * @return void
     */
    @Override
    public void clickAndWait() {

        info(getLoc("loc.clicking"));
        if (browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            ((JavascriptExecutor) browser.getDriver()).executeScript("arguments[0].style.border='4px solid red'", element);
        }
        element.click();
        browser.waitForPageToLoad();

    }

}
