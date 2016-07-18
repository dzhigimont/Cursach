package forms.apartments;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

public class DropDownMenuApartments {
    
    private Button minsk = new Button(By.xpath("//a[@class='b-main-navigation__dropdown-advert-link']/span[contains(text(),'Минск')]"),"Minsk");
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
