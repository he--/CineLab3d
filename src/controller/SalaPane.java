/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.xpath.internal.operations.Mod;

import cine.Cadeira;
import cine.Cinema;
import cine.Cliente;
import cine.Legenda;
import cine.Sala;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class SalaPane {
	
    private Pane pane;
    
    private Cinema cinema;
    
    private Image imagenBotao;
    
    @FXML
    private Pane painelCadeiras;
    
    public SalaPane (Cinema cinema) 
    {
    	this.cinema = cinema;
    }
    
   
    public Pane carregar() throws IOException {
    	
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/SalaCinema.fxml"));
        this.pane = (Pane) fxmlLoader.load();
        
        int fileira[] = this.cinema.getFileira();
        String letra[] = this.cinema.getLetra();
        FlowPane cadeiras = new FlowPane(20,20);
        
        BackgroundSize backgroundSize = new BackgroundSize(70, 70, true, true, true, false);
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
				cadeiraBt.setId(legenda.getLetra()+"-"+legenda.getNumero());
				cadeiraBt.setOnAction(this::handleButtonAction);
				cadeiras.getChildren().add(cadeiraBt);
			}
		}
        cadeiras.setLayoutX(170.00);
        cadeiras.setLayoutY(225.00);
        this.pane.getChildren().add(cadeiras);
     return this.pane;  
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
     
        Button botao = (Button) event.getSource();
        Sala sala = this.cinema.getSala();
        StringTokenizer tokenizer = new StringTokenizer(botao.getId(), "-");
        Legenda legenda = new Legenda();
        legenda.setLetra(tokenizer.nextToken());
        legenda.setNumero(Integer.parseInt(tokenizer.nextToken()));
        Cadeira cadeira = sala.getCadeira(legenda);
        cadeira.setOcupada(true);
    }
}
