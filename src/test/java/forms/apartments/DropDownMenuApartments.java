package forms.apartments;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

public class DropDownMenuApartments extends BaseForm {
    
    /**
     *
     *this Class constructor
     *
     */
    private Button minsk = new Button(By.xpath("//a[@class='b-main-navigation__dropdown-advert-link']/span[contains(text(),'Минск')]"),"Minsk");
    public DropDownMenuApartments(){
        super(By.xpath("//a[contains(text(),'Аренда')]"),"DropDownMenuApartments.Logo");
    }
     /**
     * clickMinsk()
     *this method click Minsk from DropDownMenuApartments, becase not realese method navigate
     *
     * @return void
     */

    public void clickMinsk(){
        minsk.clickAndWait();
    }
}
