package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;


public class MessagesUserForm extends BaseForm {

    private Button incomingMessages = new Button(By.xpath("//a[contains(text(),'Входящие')]"),"incomingMessages");
    private Button sentMessages = new Button(By.xpath("//a[contains(text(),'Отправленные')]"),"sentMessages");
    private Button saveMessages = new Button(By.xpath("//a[contains(text(),'Сохраненные')]"),"saveMessages");
    private Button newMessages = new Button(By.xpath("//a[contains(text(),'Написать')]"),"newMessages");
    private Button users = new Button(By.xpath("//span[contains(text(),'Пользователи')]"),"Users");

    /**
    *
    *this Class constructor
    *
    */
    public MessagesUserForm(){
         super(By.xpath("//h1[contains(text(),'Личные сообщения')]"),"Message.logo");
    }
    /**
     * navigate
     *this method clicks on the button with the corresponding name
     *
     * @param button
     *
     * @return void
     */
    public void navigate(String button){

        switch (button){

            case "incomingMessages" :
                incomingMessages.clickAndWait();
                break;

            case "sentMessages" :
                sentMessages.clickAndWait();
                break;

            case "saveMessages" :
                saveMessages.clickAndWait();
                break;

            case "newMessages" :
                newMessages.clickAndWait();
                break;

            case "users":
                users.clickAndWait();
                break;



            default:
                logger.fatal(" Not found button whith name " + button+". Look enum Buttons in " + getClass().getName().toString());
                break;

        }



    }

    /**
     * Buttons
     *this enum stores the names of the buttons
     *
     *
     * @return void
     */
    public enum Buttons{
        incomingMessages("incomingMessages"),

        sentMessages("sentMessages"),

        saveMessages("saveMessages"),

        newMessages("newMessages"),

        users("users");


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
