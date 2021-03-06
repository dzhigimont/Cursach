package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.TextBox;

public class NewMessageForm extends BaseForm {

    private TextBox whomSend = new TextBox(By.xpath("//input[@id='compose_uname']"),"whomSend");
    private TextBox header= new TextBox(By.xpath("//input[@id='compose_subject']"),"Header");
    private TextBox textMessage = new TextBox(By.xpath("//textarea[@id='compose_text']"),"textMessage");
    private Button send = new Button(By.xpath("//button[@value='Отправить']"),"Send");

    /**
     *
     *this Class constructor
     *
     */
    public NewMessageForm() {
        super(By.xpath("//span[contains(text(),'Предварительный просмотр')]"), "NewMessage.Logo");
    }
    /**
     * fillTheMessage()
     *this method fill new Message form with needed param
     *@param username 
     * @param header
     * @param text 
     * @return void
     */
    public void fillTheMessage(String username,String header,String text){
        whomSend.type(username);
        this.header.type(header);
        textMessage.type(text);

    }
    /**
     * sendMessage()
     *this method send new Message
     
     * @return void
     */
    public void sendMessage(){
        send.clickAndWait();
    }


}
