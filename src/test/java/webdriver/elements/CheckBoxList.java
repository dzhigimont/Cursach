package webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

/**
 * Created by kristinka on 11.07.2016.
 */
public class CheckBoxList extends BaseElement {
    /**
     * Constructor
     * @param locator locator
     * @param name name
     */
    public CheckBoxList(final By locator, final String name) {
        super(locator, name);
    }

    public CheckBoxList(final By locator) {
        super(locator);
    }

    /**
     * Constructor
     * @param string locator
     * @param name name
     */
    public CheckBoxList(final String string, final String name) {
        super(string, name);
    }

    /**
     * Returns Element type
     * @return Element type
     */
    protected String getElementType() {return getLoc("loc.CheckBoxList");}

    /**
     * selectByValue
     *this method select  checkboxList contains Value
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
     *this method select  checkboxList contains Text
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
