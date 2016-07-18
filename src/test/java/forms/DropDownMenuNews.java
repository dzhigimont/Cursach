package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

public class DropDownMenuNews extends BaseForm{

    private Button technology = new Button(By.xpath("//div[@class='b-main-navigation__dropdown-title']/a[contains(text(),'Технологии')]"),"Technology");
    
    /**
     *
     *this Class constructor
     *
     */
    public DropDownMenuNews(){
        super(By.xpath("//a[contains(text(),'Перейти в раздел')]"),"DropDownMenuNews.Logo");
    }
    /**
     *clickTechnology
     *this method click button Technology
     *
     * @return void
     */
    public void clickTechnology(){
        technology.clickAndWait();
    }

}
