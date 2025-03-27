package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class GUI extends Application {

    private HelloController controller = new HelloController();
    private Label lblResult;
    private Label lblFuel;
    private Label lblDistance;

    @Override
    public void start(Stage primaryStage){
        HBox root = new HBox();
        root.setMaxWidth(400);
        root.setMaxHeight(600);

        ComboBox<String> langSelect = new ComboBox<>();
        langSelect.getItems().addAll("en_US", "fi_FI", "ja_JP", "fa_IR");
        langSelect.setValue("en_US");
        langSelect.setOnAction(e ->{
            controller.setLang(langSelect.getValue());
            refreshLabels();
        });

        lblDistance = new Label(controller.getResourceBundle().getString("dist"));
        TextField distance = new TextField();
        TilePane tlDistance = new TilePane();
        tlDistance.getChildren().add(lblDistance);
        tlDistance.getChildren().add(distance);

        lblFuel = new Label(controller.getResourceBundle().getString("fuel"));
        TextField fuel = new TextField();
        TilePane tlFuel = new TilePane();
        tlFuel.getChildren().add(lblFuel);
        tlFuel.getChildren().add(fuel);

        lblResult = new Label(controller.getResourceBundle().getString("res"));
        Label result = new Label();
        TilePane tlResult = new TilePane();
        tlResult.getChildren().add(lblResult);
        tlResult.getChildren().add(result);

        root.getChildren().addAll(langSelect, tlDistance, tlFuel, tlResult);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
    private void refreshLabels() {
        lblDistance.setText(controller.getResourceBundle().getString("dist"));
        lblFuel.setText(controller.getResourceBundle().getString("fuel"));
        lblResult.setText(controller.getResourceBundle().getString("res"));
    }
}