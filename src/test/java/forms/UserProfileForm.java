package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;

public class UserProfileForm extends BaseForm {

/**
     *
     *this Class constructor
     *
     */
    public UserProfileForm(){
        super(By.xpath("//dt[contains(text(),'Учетная запись')]"),"UserProfile.Logo");
    }
}
