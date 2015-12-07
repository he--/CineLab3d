/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author edinaldo
 */
public class MenuController implements Initializable {
    
    Stage stage1 = null;
    
    @FXML
    public MenuItem btn_filmesEmCartaz;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void filmesEmCartaz(ActionEvent event) {
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/GerenciaFilmes.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("CineLab3d");
            stage.setScene(new Scene(root1));
            stage.setMaximized(true);
            
            stage.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mensagem de Alerta");
            alert.setHeaderText("Ops, Erro ao tentar abrir a janela");
            alert.setContentText("Desculpe pelo transtorno mas não foi"
                    + " possivel abrir esta janela!");

            alert.showAndWait();
        }
    }
}
