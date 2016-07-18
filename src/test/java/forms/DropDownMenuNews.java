package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

public class DropDownMenuNews 

    private Button technology = new Button(By.xpath("//div[@class='b-main-navigation__dropdown-title']/a[contains(text(),'Технологии')]"),"Technology");
    
    
     *clickTechnology
     *this method click button Technology
     *
     * @return void
     */
    public void clickTechnology(){
        technology.clickAndWait();
    }

}
