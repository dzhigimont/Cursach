package forms.fleaMarker;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.CheckBoxList;
import webdriver.elements.TextBox;

public class EditAdForm extends BaseForm {


    private CheckBoxList region  = new CheckBoxList(By.xpath("//select[contains(@class,'region-select')]//option"),"region");
    private TextBox title = new TextBox(By.xpath("//input[contains(@name,'subject')]"),"Title");
    private TextBox message = new TextBox(By.xpath("//textarea[contains(@name,'message')]"),"Message");
    private TextBox previewMessage = new TextBox(By.xpath("//textarea[contains(@name,'topic_desc')]"),"PreviewMessage");
    private TextBox rate = new TextBox(By.xpath("//input[@name='topic_price']"),"Rate");
    private Button saveEdit = new Button(By.xpath("//button[@name='formSubmitButton']"),"SaveEdit");

    /**
     *
     *this Class constructor
     *
     */
    public EditAdForm(){
        super(By.xpath("//h3[contains(text(),'Подробно опишите товар или услугу')]"),"EditAd.Logo");
    }


    public void editAd(String head,String location,String itemDescription,String previewDescription,
                            String rate){


        this.title.type(head);

        this.region.selectByText(location);

        this.message.type(itemDescription);

        this.rate.type(rate);

        this.previewMessage.type(previewDescription);

        saveEdit.clickAndWait();



    }


}
