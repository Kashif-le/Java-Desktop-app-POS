package JavaFx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class controllerHomePage {
    @FXML
    private Label txtcurruser;

    @FXML
    void sceneShift(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/ShowItemDetails.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void sceneShiftAddRemove(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/addRemoveItems.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void sceneShifGenerateReport(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/generate_report.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void logout(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/LoginPanel.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void toBillGen(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/GenerateBill.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void toStockRequest(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/stockRequest.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    @FXML
    void sceneShiftReverseSale(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/ReverseSale.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }







}
