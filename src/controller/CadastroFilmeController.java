/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;

import cine.Filme;
import cine.Sessao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author edinaldo
 */
public class CadastroFilmeController implements Initializable {

	@FXML
	private TextField inputFilmeNome;

	@FXML
	private TextArea extareaFilmeDescricao;

	@FXML
	private TextField inputFilmeImagem;

	private Filme filme;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Metodo responsavel por salvar os dados
     * @param event
     */
    public void cadastrar(ActionEvent event) {
    	filme = new Filme();

    	try {
    		filme.setNome(this.inputFilmeNome.getText());
    		filme.setDescricao(this.extareaFilmeDescricao.getText());
    		filme.setImagem(this.inputFilmeImagem.getText());

	    	this.inputFilmeNome.setText("");
	    	this.extareaFilmeDescricao.setText("");
	    	this.inputFilmeImagem.setText("");
    	mensagemSucesso();
    	} catch (Exception e) {
    		mensagemErro();
    	}
    	System.out.println(filme.toString());
    }

    private void mensagemSucesso() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensagem de Alerta");
        alert.setHeaderText("Cadastro de formulario.");
        alert.setContentText("Dados salvos com sucesso");

        alert.showAndWait();
    }

    private void mensagemErro() {
    	Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Mensagem de Alerta");
        alert.setHeaderText("Ops, Não foi possivel salvar os dados do formulario");
        alert.setContentText("Desculpe pelo transtorno mas não foi"
                + " possivel salvar os dados!");

        alert.showAndWait();
    }

}
