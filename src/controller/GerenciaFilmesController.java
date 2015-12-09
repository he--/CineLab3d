/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.corba.se.pept.transport.Acceptor;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.pept.transport.EventHandler;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import java.net.URL;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author edinaldo
 */
public class GerenciaFilmesController implements Initializable {

    @FXML
    private GridPane gridFilmesCartaz;
    
    private String[][] listaDeFilmes = {
        {"/imagens/filmes/5888_medio.jpg", "/imagens/filmes/7499_medio.jpg", "/imagens/filmes/7554_medio.jpg"},
        {"/imagens/filmes/7590_medio.jpg", "/imagens/filmes/7600_medio.jpg", "/imagens/filmes/images-cine.jpg"},
    };
    
    private Image imagenBotao;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        for (int linha = 0; linha < 2; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                String imagem = this.listaDeFilmes[linha][coluna];
                
                imagenBotao = new Image(getClass().getResourceAsStream(imagem));
                ImageView im = new ImageView(imagenBotao);
                im.setFitHeight(180);
                im.setFitWidth(120);
                Button button = new Button();
                button.setGraphic(im);
                button.setId(linha+"-"+coluna);
                button.setOnAction(this::handleButtonAction);
                
                gridFilmesCartaz.add(button, coluna, linha);
            }
        }
        gridFilmesCartaz.setHgap(10); //horizontal gap in pixels => that's what you are asking for
        gridFilmesCartaz.setVgap(100); //vertical gap in pixels
        gridFilmesCartaz.setPadding(new Insets(10, 10, 10, 10));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
     
        Button botao = (Button) event.getSource();
        
        System.out.println("Id: "+botao.getId());
    }
        
    public void sala(ActionEvent event) {
        try {
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/SalaCinema.fxml"));
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
