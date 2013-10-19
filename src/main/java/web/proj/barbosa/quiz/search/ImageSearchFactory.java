/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web.proj.barbosa.quiz.search;

import web.proj.barbosa.quiz.search.ImageSearch;

/**
 *
 * @author marcus
 */
public class ImageSearchFactory {

    public ImageSearchFactory() {
    }
    
    public static IImageSearch getImageSearch(){
        return new ImageSearch();
    }
    
    
}
