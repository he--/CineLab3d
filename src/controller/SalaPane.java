/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.org.apache.xpath.internal.operations.Mod;

import cine.Cadeira;
import cine.Cinema;
import cine.Legenda;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.awt.Graphics2Delegate;

/**
 *
 * @author edinaldo
 */
public class SalaPane extends FlowPane
{
    private FlowPane pane;
    
    private Cinema cinema;
    
    public SalaPane (Cinema cinema) 
    {
    	super(10, 10);
    	this.cinema = cinema;
        this.pane = new FlowPane();
    }
    
   
    public Pane carregar() {
    	
        this.cinema.abreSala();
        int fileira[] = this.cinema.getFileira();
        String letra[] = this.cinema.getLetra();
        
//        GridPane gridpane = new GridPane();
        BackgroundSize backgroundSize = new BackgroundSize(20, 20, true, true, true, false);
     // new BackgroundImage(image, repeatX, repeatY, position, size)
        Background background = null;
		BackgroundImage cadeiraLivre = new BackgroundImage( 
				new Image( getClass().getResource("/imagens/poltronaLivre.png").toExternalForm()),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, backgroundSize
				);
		BackgroundImage cadeiraOcupada= new BackgroundImage( 
				new Image( getClass().getResource("/imagens/poltronaOcupada.png").toExternalForm()),
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT, backgroundSize
				);
        for (int j = 0; j < fileira.length; j++) {
			for (int i = 0; i < letra.length; i++) {
				
				//@todo fazer construtor com dois parametros
				Legenda legenda = new Legenda();
				legenda.setLetra(letra[i]);
				legenda.setNumero(j);
				Cadeira cadeira = this.cinema.getSala().getCadeira(legenda);
				
				if (cadeira.isOcupada()) {
					background = new Background(cadeiraOcupada);
				} else {
					background = new Background(cadeiraLivre);
				}
				Button cadeiraBt = new Button();
				cadeiraBt.setBackground(background);
				this.pane.getChildren().add(cadeiraBt);
			}
		}
     return this.pane;  
    }
    
    
}
