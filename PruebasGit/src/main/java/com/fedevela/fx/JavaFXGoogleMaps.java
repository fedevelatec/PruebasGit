package com.fedevela.fx;

import java.net.MalformedURLException;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Ejemplo sacado de la pagina
 *  http://java-buddy.blogspot.mx/2013/02/embed-google-maps-api-v3-in-javafx.html
 *  Para crear una API KEY en Google
 *  http://java-buddy.blogspot.mx/2013/02/obtain-api-key-for-google-maps-api-v3.html
 * @web http://java-buddy.blogspot.com/
 */
public class JavaFXGoogleMaps extends Application {

    private Scene scene;
    MyBrowser myBrowser;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fedevela Maps");
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);
        myBrowser = new MyBrowser();
        scene = new Scene(myBrowser, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class MyBrowser extends Region {
        HBox toolbar;

        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();


        public MyBrowser(){
            //final URL urlGoogleMaps = getClass().getResource("GoogleMapsV3.html");
            final URL urlGoogleMaps = getClass().getClassLoader().getResource("GoogleMapsV3.html");

            //System.out.println( getClass().get  );
            webEngine.load(urlGoogleMaps.toExternalForm());
            //webEngine.load("GoogleMapsV3.html");
            webEngine.setJavaScriptEnabled(true);

            getChildren().add(webView);

        }
    }
}