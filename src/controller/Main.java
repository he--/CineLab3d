/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static javafx.application.Application.launch;
import java.net.URL;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author edinaldo
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        try {

           
            SalaPane sala = new SalaPane();
            sala.carregar();
            Scene scene = new Scene(sala);
            
            stage.getIcons().add(new Image("/imagens/icon.png"));
            stage.setScene(scene);
            stage.setResizable(true);
            stage.setTitle("Login / Cinema e Ingressos");
            stage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
