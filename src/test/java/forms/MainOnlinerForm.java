package forms;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

import java.util.List;
import java.util.Set;


public class MainOnlinerForm extends BaseForm {

    private Button onlinerCatalog = new Button(By.xpath("//span[contains(text(),'Каталог')]"),"catalog");
    private Button onlinerNews = new Button(By.xpath("//span[contains(text(),'Новости')]"),"News");
    private Button onlinerAutoMarket = new Button(By.xpath("//span[contains(text(),'Автобарахолка')]"),"AutoMarket");
    private Button onlinerApartments = new Button(By.xpath("//span[contains(text(),'Дома и квартиры')]"),"HousesAndApartments");
    private Button onlinerFleaMarket = new Button(By.xpath("//span[contains(text(),'Барахолка')]"),"FleaMarket");
    private Button onlinerForum = new Button(By.xpath("//span[contains(text(),'Форум')]"),"Forum");
    private Button onlinerLogin = new Button(By.xpath("//div[contains(text(),'Вход')]"),"OnlinerLogin");
    private Label userNameLabel = new Label(By.xpath("//p[contains(@class,'user-name')]/a"),"User Name");
    private Button userMessage = new Button(By.xpath("//li/a[contains(text(),'Cообщения')]"),"Message");
    private Button userQuit = new Button(By.xpath("//li/a[contains(text(),'Выйти')]"),"Quit");
    private Button basket = new Button(By.xpath("//a[contains(@class,'b-top-navigation-cart__link')]/span"),"Basket");
    private TextBox search = new TextBox(By.xpath("//input[@name='query']"),"Search");
    private Button find = new Button(By.xpath("//button[contains(text(),'Найти')]"),"Find");
    /**
     *
     *this Class constructor
     *
     */
    public MainOnlinerForm(){
        super(By.xpath("//img[@alt='Onliner']"),"Onliner.logo");
    }


    /**
     * navigateMainForm
     *this method clicks on the button with the corresponding name
     *
     * @param button
     *
     * @return void
     */

    public void navigate(String button){

        switch (button){

            case "catalog" :
                onlinerCatalog.clickAndWait();
                break;

            case "news" :
                onlinerNews.mouseOver();
                break;

            case "autoMarket" :
                onlinerNews.mouseOver();
                onlinerAutoMarket.clickAndWait();
                break;

            case "apartments":
                onlinerApartments.mouseOver();
            break;

            case "fleaMarket":

                onlinerFleaMarket.clickAndWait();
            break;

            case "forum":
                onlinerForum.clickAndWait();
                break;

            case "basket":
                basket.clickAndWait();
                break;

            case "userMessage":
                userMessage.clickAndWait();
                break;

            case "userQuit":
                userQuit.clickAndWait();
                break;


            default:
                logger.fatal(" Not found button whith name " + button+". Look enum Buttons in " + getClass().getName().toString());
                break;

        }



    }

    /**
     * login
     *this method performs user authorization
     *and  success of its execution
     *@param userName = 'user1'
     *@param userPass = '12345'
     * @return void
     */
    public void login(String userName, String userPass){
        onlinerLogin.clickAndWait();
        LoginForm loginForm = new LoginForm();
        loginForm.login(userName,userPass);
        doAssertFail(userNameLabel.getText().contains(userName),"Authorization successful!!! ","Failed Authorization!!!");
    }


    /**
     * productSearch
     *this method find the product in the catalog
     *@param product = 'Iphone 5'
     * @return void
     */

    public void productSearch(String product){
        search.type(product);
        browser.goToFrame(4);
    }


    /**
     * Buttons
     *this enum stores the names of the buttons
     *
     *
     * @return void
     */

    public enum Buttons{
        catalog("catalog"),

        news("news"),

        autoMarket("autoMarket"),

        apartments("apartments"),

        fleaMarket("fleaMarket"),

        forum("forum"),

        basket("basket"),

        userMessage("userMessage"),

        userQuit("userQuit");


        private String value;
        /**
         * Constructor
         * @param values Value
         */
        Buttons(final String values) {
            value = values;
        }

    }


}
