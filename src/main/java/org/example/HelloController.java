package org.example;

import com.sun.javafx.css.CalculatedValue;
import javafx.application.Platform;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {

    private ResourceBundle rb = ResourceBundle.getBundle("lang" , new Locale("en", "US"));
    public void setLang(String lang){
        String[] res = lang.split("_");

        try {
            rb = ResourceBundle.getBundle("lang", new Locale(res[0], res[1]));
        } catch (Exception e) {
            System.out.println("Language not found");
        }
        //TODO: set the language of the application

        Platform.runLater(() -> getResourceBundle());

    }
    public ResourceBundle getResourceBundle(){
        return rb;
    }
    public double calculate(double distance, double fuel){
        double res = distance/fuel;
        return res;
    }
}
