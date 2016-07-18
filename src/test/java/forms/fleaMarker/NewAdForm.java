package forms.fleaMarker;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.CheckBoxList;
import webdriver.elements.TextBox;


public class NewAdForm extends BaseForm{

    private Button sellButton = new Button(By.xpath("//a[contains(text(),'Продам')]")," Sell");
    private Button buyButton = new Button(By.xpath("//a[contains(text(),'Куплю')]")," Buy");
    private Button exchangeButton = new Button(By.xpath("//a[contains(text(),'Обмен)]")," Exchange");
    private Button serviceButton = new Button(By.xpath("//a[contains(text(),'Услуга')]")," Service");
    private Button arendButton = new Button(By.xpath("//a[contains(text(),'Аренда')]")," Arend");
    private CheckBoxList region  = new CheckBoxList(By.xpath("//select[contains(@class,'region-select')]//option"),"region");
    private CheckBoxList section = new CheckBoxList(By.xpath("//select[contains(@class,'selectForumId')]//option"),"section");
    private TextBox title = new TextBox(By.xpath("//input[contains(@name,'subject')]"),"Title");
    private TextBox message = new TextBox(By.xpath("//textarea[contains(@name,'message')]"),"Message");
    private TextBox rate = new TextBox(By.xpath("//input[@name='topic_price']"),"Rate");
    private CheckBoxList currency = new CheckBoxList(By.xpath("//select[contains(@name,'topic_currency')]//option"),"currency");
    private Button auction = new Button(By.xpath("//input[@name='topic_torg']"),"Auction");
    private Button addNewAd = new Button(By.xpath("//button[@name='formSubmitButton']"),"AddNewAd");

    /**
     *
     *this Class constructor
     *
     */
    public NewAdForm(){
        super(By.xpath("//h1[contains(text(),'Новое объявление')]"),"NewAd.Logo");
    }

    /**
     * fillMessage
     *this method fill New Ad form by param
     *
     * 
     *
     * @return void
     */
    public void fillMessage(String category,String section,String head,String location,String itemDescription,
                            String rate,String currency,Boolean auction ){

        switch (category){
            case "Продам":
                sellButton.clickAndWait();
                break;
            case "Куплю":
                buyButton.clickAndWait();
                break;
            case "Услуга":
                serviceButton.clickAndWait();
                break;
            case "Аренда":
                arendButton.clickAndWait();
                break;
            default:

        }

        this.section.selectByText(section);

        this.title.type(head);

        this.region.selectByText(location);

        this.message.type(itemDescription);

        this.rate.type(rate);

        this.currency.selectByText(currency);

        if (auction){

            this.auction.clickAndWait();
        }


    }

     /**
     * addNewAd()
     *this method add New Ad 
     *
     * 
     *
     * @return void
     */
    public void addNewAd(){
        addNewAd.clickAndWait();
    }




}
