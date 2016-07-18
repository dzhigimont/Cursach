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

    public void clickSuggestions(){
        suggestions.clickAndWait();
    }

    public ArrayList<String> getUrlImgProduct(){

        ArrayList<String> urlList= new ArrayList<>();

        for (int i =0;i<imgButton.getListOfPageSize();i++){
            imgButton.clickAndWait(i);
            urlList.add(img.getElement().getAttribute("src"));
        }

        return urlList;
    }

    public void AssertImg(String path) throws IOException {
        AssertImage assertImage = new AssertImage();
        int i = 1;
        ArrayList<String> url  =  getUrlImgProduct();
        for (String s:url){
            doAssertFail(assertImage.assertImage(path+i+".jpg",assertImage.getImgByUrl(s)),
                    path+"/"+i+".jpg"+" image fully complies with "+s,
                    path+"/"+i+".jpg"+" image fully not complies with "+s);
            i++;
        }

    }

    public  void AsserMainParam(){

    }


}
