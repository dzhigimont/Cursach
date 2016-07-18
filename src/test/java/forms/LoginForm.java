package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;


public class LoginForm {

    private Button loginButton = new Button(By.xpath("//button[contains(text(),'Войти')]"),"loginButton");
    private TextBox userName = new TextBox(By.xpath("//input[contains(@placeholder,'Ник или e-mail')]"),"UserName");
    private TextBox userPass = new TextBox(By.xpath("//input[contains(@placeholder,'Пароль')]"),"UserPass");

    /**
     *
     *this Class constructor
     *
     */
    //public LoginForm(){super(By.xpath("//button[contains(text(),'Войти')]"),"Login.Logo");}

    public void login(String name, String password){
        userName.type(name);
        userPass.type(password);
        loginButton.clickAndWait();
    }

}
