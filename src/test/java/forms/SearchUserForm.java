package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;


public class SearchUserForm extends BaseForm{

    private TextBox searchUser = new TextBox(By.xpath("//input[contains(@type,'text')]"),"searchUser");
    private Button find = new Button(By.xpath("//span[contains(text(),'Найти')]"),"find");
    /**
     *
     *this Class constructor
     *
     */
    public SearchUserForm(){
        super(By.xpath("//p[contains(text(),'Введите имя пользователя')]"),"SearchUser.Logo");
    }
     /**
     * searchUser()
     *this method fills out a form to search user
     *
     * @param userName
     *
     * @return void
     */
    public void searchUser(String userName){
        searchUser.type(userName);
        find.clickAndWait();
        Button user = new Button(By.xpath("//a[contains(text(),'"+ userName + "')]"),userName);
        user.clickAndWait();

    }



}
