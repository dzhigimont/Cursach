package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.ListOfPages;


public class SearchResultForm extends BaseForm {

    private Button firstLink = new Button(By.xpath("//a[@class='product__title-link']"),"firstLink");

    /**
     *
     *this Class constructor
     *
     */
    public SearchResultForm(){

        super(By.xpath("//span[contains(@class,'search__close')]"),"SearchResult.Logo");
    }




    /**
     *
     *this method click on the first link in search list
     *
     */
    public void clickOnTheFirstLink(){

        firstLink.clickAndWait();

    }



}
