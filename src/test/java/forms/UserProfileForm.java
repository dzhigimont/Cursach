package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;

/**
 * Created by kristinka on 15.07.2016.
 */
public class UserProfileForm extends BaseForm {


    public UserProfileForm(){
        super(By.xpath("//dt[contains(text(),'Учетная запись')]"),"UserProfile.Logo");
    }
}
