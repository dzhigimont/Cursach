package forms.apartments;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.ListOfPages;

public class ApartmentsSearchForm extends BaseForm {

    private ListOfPages apartmentsList = new ListOfPages(By.xpath("//a[@data-id]"),"ApartmentsList");

    public ApartmentsSearchForm(){
        super(By.xpath("//span[contains(text(),'Аренда')]"),"ApartmentsSearchForm.Logo");

    }

    public void clickFirstLink( ){
        apartmentsList.clickAndWait(0);
    }

}
