package tests;


import forms.MainOnlinerForm;
import forms.ProductForm;
import forms.SearchResultForm;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import webdriver.BaseTest;

import java.io.IOException;

public class TestPresentFotoProduct extends BaseTest {
    String search,path;

    /**
     * Before Class method
     */
    @BeforeTest


    @Parameters({"search","path"})
    /**
     * readParam
     * this method read parameter  from an external file TestSuite.xml
     *
     */

    public void readParam(String search,String path){
        this.search=search;
        this.path = path;
    }


    public void runTest() throws IOException {
        MainOnlinerForm mainOnlinerForm = new MainOnlinerForm();
        logger.step(1);
        mainOnlinerForm.productSearch(search);
        SearchResultForm searchResultForm = new SearchResultForm();
        logger.step(2);
        searchResultForm.clickOnTheFirstLink();
        ProductForm productForm = new ProductForm();
        logger.step(3);
        productForm.AssertImg(path);

    }
}
