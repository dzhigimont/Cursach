package forms;


import org.openqa.selenium.By;
import utility.AssertImage;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.ListOfPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductForm extends BaseForm {

    private ListOfPages imgButton = new ListOfPages(By.xpath("//img[@class='product-gallery__thumb-img']"),"imgButton");
    private Button suggestions = new Button(By.xpath("//a[contains(text(),'Сравнить предложения')]"),"Suggestions");
    private Label img =  new Label(By.xpath("//div[contains(@class,'fotorama__active')]/img"),"Img");

    /**
     *
     *this Class constructor
     *
     */
    public ProductForm(){
        super(By.xpath("//h3[contains(text(),'Описание')] "),"Product.Logo");
    }

     /**
     * clickSuggestions
     *this method clicks on the button the offer from the sellers
     *
     *
     * @return void
     */
    public void clickSuggestions(){
        suggestions.clickAndWait();
    }
     
     /**
     * getUrlImgProduct()
     *this method returns the link to product images
     *
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> getUrlImgProduct(){

        ArrayList<String> urlList= new ArrayList<>();

        for (int i =0;i<imgButton.getListOfPageSize();i++){
            imgButton.clickAndWait(i);
            urlList.add(img.getElement().getAttribute("src"));
        }

        return urlList;
    }

     /**
     * AssertImg()
     *this method compares two images pixel by
     *
     * @param path
     *
     * @return void
     */
    public void AssertImg(String path) throws IOException {
        AssertImage assertImage = new AssertImage();
        String jarPath = ProductForm.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String jPath = jarPath + path;
        int i = 1;
        ArrayList<String> url  =  getUrlImgProduct();
        for (String s:url){
            doAssertFail(assertImage.assertImage(jPath+i+".jpg",assertImage.getImgByUrl(s)),
                    path+"/"+i+".jpg"+" image fully complies with "+s,
                    path+"/"+i+".jpg"+" image fully not complies with "+s);
            i++;
        }

    }

   


}
