package forms;


import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;


public class PricesForm extends BaseForm{
    private Button basketRadioButton = new Button(By.xpath("//label/span[contains(text(),'Корзина')]"),"BasketRadioButton");
    private Button addInTheBasket = new Button(By.xpath("//a[contains(text(),'В корзину')]"),"addInTheBasket");
    private Button inTheBasket = new Button(By.xpath("//a[contains(text(),'В корзине')]"),"inTheBasket");


    /**
     *
     *this Class constructor
     *
     */
    public PricesForm(){
        super(By.xpath("//a[contains(text(),'По рейтингу продавца')]"),"Prices.Logo");
    }

    /**
     * AddInTheBassket
     *this method adds the required product to the shopping cart
     *
     * @return void
     */
    public void AddInTheBassket(){
        basketRadioButton.clickAndWait();
        addInTheBasket.clickAndWait();
        inTheBasket.navigateToElement();
        doAssertFail(inTheBasket.isPresent(),"The product is added to cart","The product is NOT added to cart");
    }
}
