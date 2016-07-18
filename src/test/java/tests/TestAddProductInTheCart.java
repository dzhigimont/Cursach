package tests;


import forms.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;


public class TestAddProductInTheCart extends BaseTest {

    String search;

    /**
     * Before Class method
     */
    @BeforeTest


    @Parameters({"search"})
    /**
     * readParam
     * this method read parameter  from an external file TestSuite.xml
     *
     */

    public void readParam(String search){
        this.search=search;
    }

    public void runTest(){

        MainOnlinerForm mainOnlinerForm = new MainOnlinerForm();

        logger.step(1);
        mainOnlinerForm.productSearch(search);
        SearchResultForm searchResultForm = new SearchResultForm();
        logger.step(2);
        searchResultForm.clickOnTheFirstLink();
        ProductForm productForm = new ProductForm();
        logger.step(3);
        productForm.clickSuggestions();
        PricesForm pricesForm = new PricesForm();
        logger.step(4);
        pricesForm.AddInTheBassket();
        logger.step(5);
        mainOnlinerForm.navigate(MainOnlinerForm.Buttons.basket.toString());
        BasketForm basketForm = new BasketForm();
        logger.step(6);
        basketForm.assertCorrectProductAdded(search);
        basketForm.deleteProduct();

    }

}
