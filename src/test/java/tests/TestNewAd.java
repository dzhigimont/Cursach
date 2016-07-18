package tests;


import forms.MainOnlinerForm;
import forms.fleaMarker.AdForm;
import forms.fleaMarker.FleaMarketForm;
import forms.fleaMarker.NewAdForm;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

public class TestNewAd extends BaseTest {

    String userName,userPass,category,section, head, location, itemDescription ,rate,currency;
    Boolean auction;
    /**
     * Before Class method
     */
    @BeforeTest


    @Parameters({"userName","userPass","category","section","head","location","itemDescription","rate","currency","auction"})
    /**
     * readParam
     * this method read parameter  from an external file TestSuite.xml
     *
     */

    public void readParam(String userName,String userPass,String category,String section, String head,
                          String location,String itemDescription,String rate,String currency,Boolean auction){
        this.userName=userName;
        this.userPass=userPass;
        this.category=category;
        this.section=section;
        this.head=head;
        this.location=location;
        this.itemDescription =itemDescription ;
        this.rate=rate;
        this.currency=currency;
        this.auction=auction;
    }

    public void runTest(){

        MainOnlinerForm mainOnlinerForm = new MainOnlinerForm();
        mainOnlinerForm.login(userName,userPass);

        logger.step(1);
        mainOnlinerForm.navigate(MainOnlinerForm.Buttons.fleaMarket.toString());
        FleaMarketForm fleaMarketForm = new FleaMarketForm();

        logger.step(2);
        fleaMarketForm.navigate(FleaMarketForm.Buttons.newAd.toString());
        NewAdForm newAdForm = new NewAdForm();

        logger.step(3);
        newAdForm.fillMessage(category,section,head,location,itemDescription,rate,currency,auction );
        newAdForm.addNewAd();
        AdForm adForm = new AdForm();

        logger.step(4);
        adForm.assertParam(category,section,head,location,itemDescription,rate,currency,auction );
        adForm.deleteAd();
        mainOnlinerForm.navigate(MainOnlinerForm.Buttons.userQuit.toString());



    }
}
