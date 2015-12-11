/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.javafx.stage.StageHelper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

/**
 *
 * @author edinaldo
 */
public class LoginController extends Application
{

    public Stage stagePrincipal;
    Stage stage1 = null;

    @FXML
    private Button btn_login;

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    private AnchorPane telaLogin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        try {
            Parent root = FXMLLoader.load(LoginController.class.getResource("/view/Login.fxml"));
            Scene scene = new Scene(root);

            stage.getIcons().add(new Image("imagens/icon.png"));
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("CineLab3d - Login / Cinema e Ingressos");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logar(ActionEvent event) {
        try {
//            String login = this.login.getText();
//            String senha = this.senha.getText();
//            System.out.println(login);
//            System.out.println(senha);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            Stage stage = new Stage();
            stage.getIcons().add(new Image("imagens/icon.png"));
            stage.setTitle("CineLab3d");
            stage.setScene(new Scene(root1));
            stage.setMaximized(true);
            stage.show();

            closeLogin();
        } catch (Exception e) {
System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mensagem de Alerta");
            alert.setHeaderText("Ops, Erro ao tentar abrir a janela");
            alert.setContentText("Desculpe pelo transtorno mas não foi"
                    + " possivel abrir esta janela!");

            alert.showAndWait();
        }
    }

    public void sair(ActionEvent event) {
        Platform.exit();
    }

    public void closeLogin() {
    	stage1 = (Stage) btn_login.getScene().getWindow();
        stage1.hide();
    }

}
