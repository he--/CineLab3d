/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 *
 * @author edinaldo
 */
public class LoginController implements Initializable
{
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void logar(ActionEvent event) {
    }
    
    public void sair(ActionEvent event) {
        Platform.exit();
    }

}
