package forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;


public class BasketForm extends BaseForm{

    private Label product = new Label(By.xpath("//div[@class='cart-product-title']//span"),"Product");
    private Button delProduct = new Button(By.xpath("//a[@title='Удалить']"),"delProduct");

    /**
     *
     *this Class constructor
     *
     */
    public BasketForm(){
        super(By.xpath("//h1[contains(text(),'Корзина')]"),"Basket.Logo");
    }

    /**
     * ssertCorrectProductAdded()
     *this method ASSERT header product added with product initial
     *@param product = 'Iphone 5'
     * @return void
     */
    public void assertCorrectProductAdded(String searchProduct){

        product.navigateToElement();
        boolean bool = product.getElement().getText().toLowerCase().contains(searchProduct.toLowerCase());
        doAssertFail(bool,"Added product "+product.getText()+" matches the search "+searchProduct,"Added product "+product.getText()+" NOT matches the search "+searchProduct);
    }
    /**
     * deleteProduct()
     *this method delete product added in the cart
     *@param product = 'Iphone 5'
     * @return void
     */
    public void deleteProduct(){
        delProduct.navigateToElement();
        delProduct.clickAndWait();
    }
}
