package forms.apartments;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Label;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApartmentForm extends BaseForm {

    private Label street =  new Label(By.xpath("//div[contains(@class,'apartment-info__sub-line_large')][not(child::ul)]"),"Street");
    private Label streetCoordinates = new Label(By.xpath("//div[@id='map']/following-sibling::script"),"StreetCoordinates");

    public ApartmentForm(){
        super(By.xpath("//div[contains(@class,'leaflet-marker-icon')]"),"Apartment.Logo");
    }


    public String getStreet(){
        street.navigateToElement();
        return street.getText();

    }



    public String[] getCoordinate(){
        Pattern pat = Pattern.compile("[0-9]+.[0-9]+");
        Matcher m = pat.matcher(browser.getDriver().findElement(streetCoordinates.getLocator()).getAttribute("text"));

        String[] parse=new String[2] ;
        int i=0;
        while (m.find()){
            parse[i]=m.group();
            i++;
        }


        return parse;
    }


    public  void assertCoordinate(String[] parseOnliner,String[] parseMap){
        for (int i=0;i<2;i++){

            doAssertFail(parseMap[i].contains(parseOnliner[i]),
                    "Coordinate "+parseOnliner[i]+" corresponds to "+parseMap[i],
                    "Coordinate "+parseOnliner[i]+" NOT corresponds to "+parseMap[i]);

        }

    }

}
