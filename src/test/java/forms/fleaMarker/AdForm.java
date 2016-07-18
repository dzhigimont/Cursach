package forms.fleaMarker;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;


public class AdForm extends BaseForm {

    Label title = new Label(By.xpath("//h1[contains(@class,'title')]/a[2]"),"Title");
    Label rateOld = new Label(By.xpath("//li[contains(@class,'price-secondary')]"),"RateOld");
    Label rateNew = new Label(By.xpath("//li[contains(@class,'price-primary')]"),"RateNew");
    Label torg = new Label(By.xpath("//li[contains(@class,'torg')]"),"Torg");
    Label region = new Label(By.xpath("//strong[contains(@class,'fast-desc-region')]"),"Region");
    Label content = new Label(By.xpath("//div[contains(@class,'content')]/p"),"Content");
    Button edit = new Button(By.xpath("//a[contains(text(),'Редактировать')]"),"Edit");
    Button irrelevant = new Button(By.xpath("//span[contains(text(),'Неактуально')]"),"Irrelevant");
    Button irrelevantNew = new Button(By.xpath("//span[contains(text(),'Да, неактуально')]"),"IrrelevantNew");
    Label section = new Label(By.xpath("//div[@class='mnforum-tpnv']//strong"),"Section");

    /**
     *
     *this Class constructor
     *
     */
    public AdForm(){
        super(By.xpath("//span[contains(text(),'Прикрепить объявление вверху раздела')]"),"Ad.Logo");
    }

    /**
     * deleteAd()
     *this method delete new add Ad 
     *
     * @return void
     */

    public void deleteAd(){

        irrelevant.clickAndWait();
        irrelevantNew.clickAndWait();
    }
     
     /**
     * assertParam
     *this method assert Parametres in the new add Ad
     *@param 
     * @return void
     */

    public  void assertParam(String category,String section,String head,String location,String itemDescription,
                             String rate,String currency,Boolean auction ){
        String msgPass=" this item fully complies with";
        String msgFail=" this item not complies with";

        this.section.navigateToElement();

        doAssertError(this.section.getText().toLowerCase().contains(section.toLowerCase()),
                "Section = "+section+msgPass,
                "Section = "+section+msgFail);
        title.navigateToElement();
        doAssertError(title.getElement().getText().contains(head),
                "Head = "+head+msgPass,
                "Head = "+head+msgFail);
        region.navigateToElement();
        doAssertError(region.getText().toLowerCase().contains(location.toLowerCase()),
                "Location = "+location+msgPass,
                "Location = "+location+msgFail);
        rateOld.navigateToElement();
        doAssertError(rateOld.getText().replaceAll(" ","").contains(rate),
                "Rate = "+rate+msgPass,
                "Rate = "+rate+msgFail);
        content.navigateToElement();
        doAssertError(content.getText().toLowerCase().contains(itemDescription.toLowerCase()),
                "Content = "+itemDescription+msgPass,
                "Rate = "+itemDescription+msgFail);
        if (auction){
            torg.navigateToElement();
            doAssertError(torg.isPresent(),
                    "Torg = "+auction+msgPass,
                    "Torg = "+auction+msgFail);
        }
    }


}
