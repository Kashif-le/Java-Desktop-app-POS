package JavaFx;

import Connection.ConnectionClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StockRequest {

    @FXML
    private TextField txtquantity;

    @FXML
    private TextField txtitemid;
    @FXML
    private Label requestStatus;
    private Statement st;



    @FXML
    void back3(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/homePage.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
    private Connection cn;
    public Connection getCn() {
        return cn;
    }
    @FXML
    public void sendRequest(MouseEvent event) throws IOException {

            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection=connectionClass.getConnection();


            String itemid = txtitemid.getText();
            String quantity = txtquantity.getText();

        try {
            java.sql.Statement statement=connection.createStatement();
            String sql = "INSERT INTO stock_request VALUES('"+itemid+"','"+quantity+"')";
            //statement.executeUpdate(sql);
            if(statement.executeUpdate(sql)==1)
            {
                txtitemid.clear();
                txtquantity.clear();

                requestStatus.setText("Request send successfully");
            }
            else
            {
                requestStatus.setText("Failed to send request");
            }
            //JOptionPane.showMessageDialog(null, "Record Saved!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
