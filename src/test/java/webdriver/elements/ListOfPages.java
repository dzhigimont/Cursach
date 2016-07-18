package webdriver.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;


import java.util.List;


/**
 * Created by kristinka on 11.07.2016.
 */
public class ListOfPages extends BaseElement {
    /**
     * Constructor
     * @param locator locator
     * @param name name
     */
    public ListOfPages(final By locator, final String name) {
        super(locator, name);
    }

    public ListOfPages(final By locator) {
        super(locator);
    }

    /**
     * Constructor
     * @param string locator
     * @param name name
     */
    public ListOfPages(final String string, final String name) {
        super(string, name);
    }

    /**
     * Returns Element type
     * @return Element type
     */
    protected String getElementType() {return getLoc("loc.ListOfPages");}

    /**
     * searchByText
     *this method find  all pages contains Text
     *@param value ="Tv"
     * @return newElementList
     */
    public List<WebElement> searchByText(String value){

        info(String.format(getLoc("loc.checkbox.select") + " '%1$s'", value));
        List<WebElement> elementList = browser.getDriver().findElements(locator);
        List<WebElement> newElementList = null;

        for (WebElement e: elementList){

            if (e.getText().toLowerCase().contains(value.toLowerCase())){
                newElementList.add(e);
            }
        }
        return newElementList ;

    }
    /**
     * getListOfPage
     *this method return List WebElement as per request
     * @return elementList
     */
    public List<WebElement> getListOfPage(){
         List<WebElement> elementList = browser.getDriver().findElements(this.locator);
        return elementList;
    }

    /**
     * getElementOfPage
     *this method return RemoteWebElement as per index
     * @return RemoteWebElement element
     */
    public RemoteWebElement getElementOfPage(int i){

        return (RemoteWebElement)getListOfPage().get(i);
    }

    /**
     * getListOfPageSize
     *this method return size List <WebElement>
     * @return int size List
     */
    public int getListOfPageSize(){
        return getListOfPage().size();
    }

    /**
     * clickAndWait
     *native method implementation
     *the basic version does not work here
     * @return void
     */
    public void clickAndWait(int index) {
        info(getLoc("loc.clicking"));
        getElementOfPage(index).click();
        browser.waitForPageToLoad();
    };









}

