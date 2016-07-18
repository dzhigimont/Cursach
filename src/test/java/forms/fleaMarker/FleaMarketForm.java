package forms.fleaMarker;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.CheckBoxList;
import webdriver.elements.TextBox;


public class FleaMarketForm extends BaseForm{

    private Button newAdButtons = new Button(By.xpath("//strong[contains(text(),'Разместить объявление')]"),"newAdButtons");
    private Button searchButton = new Button(By.xpath("//button[contains(text(),'Найти')]"),"searchButton");
    private TextBox searchFleaMarket = new TextBox(By.xpath("//input[contain(@value,'Поиск на Барахолке']"),"searchFleaMarket");
    private CheckBoxList region  = new CheckBoxList(By.xpath("//span[contain(@data)]/b"),"region");

    /**
     *
     *this Class constructor
     *
     */
    public FleaMarketForm(){
        super(By.xpath("//h1[contains(text(),'Барахолка')]"),"FleaMarket.Logo");
    }


    public void navigate(String button){

        switch (button){

            case "newAd" :
                newAdButtons.clickAndWait();
                break;

            default:
                logger.error(" Not found button with name " + button+".Look enum Buttons in form " + getClass().getName().toString());
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
        newAd("newAd");


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


