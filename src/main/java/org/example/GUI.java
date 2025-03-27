package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.text.MessageFormat;

public class GUI extends Application {

    private HelloController controller = new HelloController();
    private Label lblResult;
    private Label lblFuel;
    private Label lblDistance;
    private Button btn;

    @Override
    public void start(Stage primaryStage){
        HBox root = new HBox();
        root.setMaxWidth(400);
        root.setMaxHeight(600);

        ComboBox<String> langSelect = new ComboBox<>();
        langSelect.setMinWidth(100);
        langSelect.getItems().addAll("en_US", "fi_FI", "ja_JP", "fa_IR");
        langSelect.setValue("en_US");
        controller.setLang(langSelect.getValue());
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

        TilePane tlResult = new TilePane();
        lblResult = new Label();
        tlResult.getChildren().add(lblResult);

        btn = new Button(controller.getResourceBundle().getString("btn"));
        btn.setOnAction(e -> {
            double dist = Double.parseDouble(distance.getText());
            double f = Double.parseDouble(fuel.getText());
            double res = controller.calc(dist, f);
            String formattedResult = MessageFormat.format(controller.getResourceBundle().getString("res"), res);
            lblResult.setText(formattedResult);
        });

        GridPane grid = new GridPane(1, 4);

        grid.add(tlDistance, 0, 0);
        grid.add(tlFuel, 0, 1);
        grid.add(tlResult, 0, 2);
        grid.add(btn, 0, 3);

        root.getChildren().addAll(langSelect, grid);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
    private void refreshLabels() {
        lblDistance.setText(controller.getResourceBundle().getString("dist"));
        lblFuel.setText(controller.getResourceBundle().getString("fuel"));
        btn.setText(controller.getResourceBundle().getString("btn"));
        lblResult.setText("");
    }
}