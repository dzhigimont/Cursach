package forms.apartments;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.ListOfPages;

public class ApartmentsSearchForm extends BaseForm {

    private ListOfPages apartmentsList = new ListOfPages(By.xpath("//a[@data-id]"),"ApartmentsList");
    /**
     *
     *this Class constructor
     *
     */
    public ApartmentsSearchForm(){
        super(By.xpath("//span[contains(text(),'Аренда')]"),"ApartmentsSearchForm.Logo");

    }
     /**
     * clickFirstLink( )
     *this method click first link in the searh box
     *
     * @return void
     */
    public void clickFirstLink( ){
        apartmentsList.clickAndWait(0);
    }

}
