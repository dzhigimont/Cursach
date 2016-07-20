package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;


public class SentMessageForm extends BaseForm {

    Label userName =new Label(By.xpath("//span[@class='pmmsg-date']"),"UserName");
    Label header =new Label(By.xpath("//h2[@class='pmmsg__subj']"),"Header");
    Label textMessage =new Label(By.xpath("//div[@class='msgpost-txt-i']/p"),"Header");
    Button delMessage = new Button(By.xpath("//a[contains(text(),'Удалить')]"),"DelMessage");
   
    /**
     *
     *this Class constructor
     *
     */
    public SentMessageForm() {
        super(By.xpath("//a[contains(text(),'Удалить')]"),"SentMessageForm" );
    }

    /**
     * assertSentMessage()
     *this method checks the correctness of filling the form sent message
     *
     * @param userName
     * @param header
     *@param text
     * @return void
     */
    public void assertSentMessage(String userName,String header,String text){

        String msgPass = " this item meets the requirements ";
        String msgFail = " this item Not meets the requirements ";
        doAssertFail(this.userName.getText().toLowerCase().contains(userName.toLowerCase()),
                this.userName.getText()+msgPass+userName,
                this.userName.getText()+msgFail+userName);
        doAssertFail(this.header.getText().toLowerCase().contains(header.toLowerCase()),
                this.header.getText()+msgPass+header,
                this.header.getText()+msgFail+header);
        doAssertFail(textMessage.getText().toLowerCase().contains(text.toLowerCase()),
                textMessage.getText()+msgPass+text,
                textMessage.getText()+msgFail+text);

    }
    
    /**
     * delMessage()
     *this method delete sent Message
     * @return void
     */
    public void delMessage(){
        delMessage.clickAndWait();
          browser.goToAlertAndAccept();
    }
}
