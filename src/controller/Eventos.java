/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cine.Cinema;
import cine.Filme;
import cine.Sala;
import cine.Sessao;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author edinaldo
 */
public class Eventos implements Initializable {
    
    @FXML
    protected BorderPane painelMenu;
    
    private Pane paneCenter;
    
    public Cinema cinema;
    
    protected ArrayList<Sessao> listaSessao = new ArrayList<Sessao>();
    protected ArrayList<Filme> listaFilme = new ArrayList<Filme>();
    protected ArrayList<Sala> listaSala = new ArrayList<Sala>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	this.cinema = new Cinema();
    }
    
    public void filmesEmCartaz(ActionEvent event) {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GerenciaFilmes.fxml"));
        
        try {
            Pane paneCenter = (Pane) loader.load();
            painelMenu.setCenter(paneCenter);
        } catch (IOException ex) {
            this.mensagemErro();
        }
    }
    
    public void informacoes(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Informacoes.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("CineLab3d");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            mensagemErro();
        }
    }
    
    public void cadastrarSala(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CadastroSala.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("CineLab3d");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            mensagemErro();
        }
    }
    
    public void cadastroFilme(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CadastroFilme.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("CineLab3d");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
            mensagemErro();
        }
    }
    
    public void cadastroSessao(ActionEvent event) {
        try{
        	Cinema cinema = new Cinema(); 
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CadastroSessao.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("CineLab3d");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException ex) {
        	System.out.println(ex);
            mensagemErro();
        }
    }
    
    public void sair(ActionEvent event) {
        Platform.exit();
    }
    
    private void mensagemErro() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Mensagem de Alerta");
        alert.setHeaderText("Ops, Erro ao tentar abrir a janela");
        alert.setContentText("Desculpe pelo transtorno mas não foi"
                + " possivel abrir esta janela!");

        alert.showAndWait();
    }
    
    private void limparTela() {
    	painelMenu.setCenter(new Pane());
    }
    
}
