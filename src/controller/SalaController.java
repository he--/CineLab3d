/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import cine.Cinema;
import cine.Legenda;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.awt.Graphics2Delegate;

/**
 *
 * @author edinaldo
 */
public class SalaController extends FlowPane
{
    public SalaController () 
    {
    	super(10, 10);
    }
   
    public void carregar() {
    	
        Cinema cinema = new Cinema(); 
        int fileira[] = cinema.getFileira();
        String letra[] = cinema.getLetra();
        GridPane gridpane = new GridPane();
        
        for (int j = 0; j < fileira.length; j++) {
//			for (int i = 0; i < letra.length; i++) {
				Button button = new Button("Click Me");
				this.getChildren().add(button);
//			}
		}
       
    }
    
    
}
