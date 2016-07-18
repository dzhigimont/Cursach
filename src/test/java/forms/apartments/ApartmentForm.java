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
    /**
     *
     *this Class constructor
     *
     */
    public ApartmentForm(){
        super(By.xpath("//div[contains(@class,'leaflet-marker-icon')]"),"Apartment.Logo");
    }

    **
     * getStreet()
     *this method find addres in the catalog
     *
     * @return Strit = 'Minsk'
     */
    public String getStreet(){
        street.navigateToElement();
        return street.getText();

    }


    **
     * getCoordinate()
     *this method find coordinates by addres in the catalog
     *@param product = 'Iphone 5'
     * @return Strit[] 
     */
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

    **
     * ssertCoordinate()
     *this method assert coordinate in the catalog with coordinate in other site
     *@param arseOnliner 
     @param parseMap
     * @return void
     */
    public  void assertCoordinate(String[] parseOnliner,String[] parseMap){
        for (int i=0;i<2;i++){

            doAssertFail(parseMap[i].contains(parseOnliner[i]),
                    "Coordinate "+parseOnliner[i]+" corresponds to "+parseMap[i],
                    "Coordinate "+parseOnliner[i]+" NOT corresponds to "+parseMap[i]);

        }

    }

}
