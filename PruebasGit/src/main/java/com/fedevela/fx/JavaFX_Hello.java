package com.fedevela.fx;

import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * http://java-buddy.blogspot.mx/2014/02/get-parametersarguments-in-javafx.html
 *
 * @web http://java-buddy.blogspot.com/
 */
public class JavaFX_Hello extends Application {

    @Override
    public void init() throws Exception {
        super.init();

        System.out.println("init()");
        Parameters parameters = getParameters();

        Map<String, String> namedParameters = parameters.getNamed();
        List<String> rawArguments = parameters.getRaw();
        List<String> unnamedParameters = parameters.getUnnamed();

        System.out.println("\nnamedParameters -");
        for (Map.Entry<String,String> entry : namedParameters.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nrawArguments -");
        for(String raw : rawArguments) {
            System.out.println(raw);
        }

        System.out.println("\nunnamedParameters -");
        for(String unnamed : unnamedParameters) {
            System.out.println(unnamed);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        System.out.println("main()");
        launch(args);
    }

}