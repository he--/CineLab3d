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
import java.awt.Panel;
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
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author edinaldo
 */
public class MenuController extends Eventos{

    @FXML
    private MenuItem btn_filmesEmCartaz;

    @FXML
    private TextField inputSessaoNome;

    @FXML
    private TextArea textareaSessaoNome;

    @FXML
    private TextField inputFilmeNome;

    @FXML
    private TextArea textareaFilmeNome;

    @FXML
    private TextField inputSalaNome;

    @FXML
    private TextArea textareaSalaNome;

    @FXML
    private ChoiceBox selectSalaSessao;

    private Stage stage;
    
    
    public void cadastrarSessao(ActionEvent event) {

        Sessao sessao = new Sessao();
        sessao.setDescricao(inputSessaoNome.getText());
        this.listaSessao.add(sessao);
    }

    public void cadastrarFilme(ActionEvent event) {

        Filme filme = new Filme();
        filme.setDescricao(inputFilmeNome.getText());
        this.listaFilme.add(filme);
    }
    
    public void verSala(ActionEvent event)
    {
    	SalaPane salaPane = new SalaPane(this.cinema);
    	Pane pane = salaPane.carregar();
    	 Scene scene = new Scene(pane);
    	 Stage stage = new Stage();
    	 stage.setScene(scene);
    	 stage.show();
    	
    }
    
    public void cadastrarSalaForm(ActionEvent event) {
//        Sala sala = new Sala();
//        sala.setDescricao(inputSalaNome.getText());
//        this.listaSala.add(sala);

        SalaPane salaPane = new SalaPane(this.cinema);
//        Pane painel = salaPane.carregar();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/GerenciaFilmes.fxml"));

        try {
//            Pane paneCenter = (Pane) loader.load();
            this.painelMenu.setCenter(salaPane.carregar());
        } catch(Exception e) {

        }

    }
}
