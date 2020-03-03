package JavaFx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminHome {
    @FXML
    void back6(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/LoginPanel.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void gotoadduser(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/adduser.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void userinfopg(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/userinfo.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }



}
