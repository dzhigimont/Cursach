package utility;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class AssertImage {

     /**
     * assertImage()
     *this method assert two Image full match pixels
     *@param path = d:/img/i.jpg
     *@param image2
     * @return boolean = true
     */
    public boolean assertImage(String path,BufferedImage image2) throws IOException {

        File file1 = new File(path);
        BufferedImage image1 = ImageIO.read(file1);
        int columns = image1.getWidth();
        int rows = image1.getHeight();
        Boolean bool = false;
        outer: for (int row=0; row<rows-1; row++){

            for (int col=0; col<columns-1; col++){

                int rgb = image1.getRGB(col, row);
                int rgb2= image2.getRGB(col, row);
                if(rgb==rgb2){
                    bool=true;
                }
                else{
                    bool= false;
                    break outer;


                }

            }
        }

        return bool;
    }


    /**
     * getImgByUrl()
     *this method get Image by url 
     *@param link = http://
     *
     * @return image
     */
   public BufferedImage getImgByUrl(String link) throws IOException {
       BufferedImage image =null;
       try {

           URL url = new URL(link);

           image = ImageIO.read(url);


       }
       catch (FileNotFoundException e) {
           e.printStackTrace();
       }

       return image;
   }



}
