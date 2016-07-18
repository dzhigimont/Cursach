package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

/**
 * Created by kristinka on 15.07.2016.
 */
public class SearchUserForm extends BaseForm{

    private TextBox searchUser = new TextBox(By.xpath("//input[contains(@type,'text')]"),"searchUser");
    private Button find = new Button(By.xpath("//span[contains(text(),'Найти')]"),"find");
    public SearchUserForm(){
        super(By.xpath("//p[contains(text(),'Введите имя пользователя')]"),"SearchUser.Logo");
    }

    public void searchUser(String userName){
        searchUser.type(userName);
        find.clickAndWait();
        Button user = new Button(By.xpath("//a[contains(text(),'"+ userName + "')]"),userName);
        user.clickAndWait();

    }



}
