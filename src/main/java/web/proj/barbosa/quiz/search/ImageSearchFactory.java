/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.search;

/**
 *
 * @author Iron-Maven
 */
public class ImageSearchFactory {

    public ImageSearchFactory() {
    }
    
    public static IImageSearch getImageSearch(){
        return new ImageSearch();
    }
    
    
}
