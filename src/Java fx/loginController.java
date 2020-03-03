package JavaFx;

import Connection.ConnectionClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginController {
    public TextField userName;
    public PasswordField userPassword;
    @FXML
    public Label isConnected;
    @FXML
    private ToggleButton togadmin;
    @FXML
    private ToggleButton togwholesaler;
    @FXML
    private ToggleButton togsalesman;
    @FXML
    private ToggleButton togfirst;
    @FXML
    private ToggleGroup users;
    private boolean flag = false;

    @FXML
    public void Login(MouseEvent event) throws IOException {

        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        if (this.users.getSelectedToggle().equals(this.togsalesman)) {
            flag = true;

            try {
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM user_authentication WHERE username = '" + userName.getText() + "' AND password = '" + userPassword.getText() + "';";
                ResultSet resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    //isConnected.setText("Connected");

                    Parent root = FXMLLoader.load(getClass().getResource("../views/homePage.fxml"));
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setScene(new Scene(root));

                } else {
                    userName.clear();
                    userPassword.clear();
                    isConnected.setText("Wrong user/password");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.users.getSelectedToggle().equals(this.togadmin)) {
            flag = true;
            try {

                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM admin_login_data WHERE username = '" + userName.getText() + "' AND password = '" + userPassword.getText() + "';";
                ResultSet resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    //isConnected.setText("Connected");

                    Parent root = FXMLLoader.load(getClass().getResource("../views/adminHome.fxml"));
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setScene(new Scene(root));

                } else {
                    userName.clear();
                    userPassword.clear();
                    isConnected.setText("Wrong user/password");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        if (this.users.getSelectedToggle().equals(this.togwholesaler)) {
            flag = true;
            try {

                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM wholeseler_login_data WHERE username = '" + userName.getText() + "' AND password = '" + userPassword.getText() + "';";
                ResultSet resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    //isConnected.setText("Connected");

                    Parent root = FXMLLoader.load(getClass().getResource("../views/wholeSalerHome.fxml"));
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setScene(new Scene(root));

                } else {
                    userName.clear();
                    userPassword.clear();
                    isConnected.setText("Wrong user/password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.users.getSelectedToggle().equals(this.togfirst)) {
            isConnected.setText("Select a user to login");}

    }
}

//    @FXML
//    void hme (MouseEvent event) throws IOException {
//
//        if (let_in) {
//            Parent root = FXMLLoader.load(getClass().getResource("ShowItemDetails.fxml"));
//            Node node = (Node) event.getSource();
//            Stage stage = (Stage) node.getScene().getWindow();
//            stage.setScene(new Scene(root));
//            tatars.setText("pressed");
//        }
//    }
