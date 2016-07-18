package forms;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;

public class ListSentMessagesForm extends BaseForm{

    private Button clickTopMessage =new Button(By.xpath("//div[contains(@class,'lpm-subj')]/a"),"ClickTopMessage");

    /**
     *
     *this Class constructor
     *
     */
    public ListSentMessagesForm( ) {
        super(By.xpath("//span[contains(text(),'непрочитанные')]"),"ListSentMessages.Logo");
    }
    /**
     * clickTopMessage()
     *this method click Top Message in the user output message
     *
     * @return void
     */
    public void clickTopMessage(){
        clickTopMessage.clickAndWait();
    }

}
