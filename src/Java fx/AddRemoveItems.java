package JavaFx;

import Connection.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class AddRemoveItems {


    @FXML
    void back1(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/homePage.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }
        @FXML
        private Button addB;
    @FXML
    private Label txtstatus;

        @FXML
        private Button removeB;

        @FXML
        private TextField txtId;
        @FXML
        private TextField txtName;
        @FXML
        private TextField txtPrice;
         @FXML
         private ComboBox<String> cmbCategory;
        @FXML
        private TextField txtQuantity;
        @FXML
        private TextField txtId2;
    private Connection cn;
//        private ConnectionClass connectionClass = new ConnectionClass();
//        private Connection connection = connectionClass.getConnection();

    public void initialize()
    {

        cmbCategory.getItems().addAll("Cosmetics", "Clothing items","Bakery","Home Utensils","Stationary");
        cmbCategory.getSelectionModel().select("Cosmetics");
    }
//
//        private void connect() {
//            try {
//                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/ooadproj", "root", "");
//                System.out.println("Success");
//                //JOptionPane.showMessageDialog(null, "Connect!");
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Error connection to database");
//            }
//        }

        public void AddItem(MouseEvent actionEvent) throws SQLException, IOException {
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection=connectionClass.getConnection();
            //Statement statement = connection.createStatement();



            String id = txtId.getText();
            String name = txtName.getText();
            String price = txtPrice.getText();
            String category = cmbCategory.getSelectionModel().getSelectedItem();
            String quantity = txtQuantity.getText();
            try {
                java.sql.Statement statement=connection.createStatement();
                String sql = "INSERT INTO stock_details VALUES('"+id+ "','" +name+ "','" +price+ "','" +category+ "','" +quantity+ "')";
                  if (statement.executeUpdate(sql) == 1) {
                      txtName.clear();
                      txtName.clear();
                      txtPrice.clear();
                      txtQuantity.clear();
                      txtstatus.setText("Item added successfully");
                }
                  else { txtstatus.setText("Failed to add Item");
                }
                //JOptionPane.showMessageDialog(null, "Record Saved!");
            } catch (SQLException e) {
                txtstatus.setText("Failed to add Item");
                //e.printStackTrace();
            }
        }

        public void RemoveItem(MouseEvent actionEvent) throws IOException, SQLException {
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection=connectionClass.getConnection();
            String remove = txtId2.getText();
            try {

                java.sql.Statement statement = connection.createStatement();

                String sql = "DELETE FROM stock_details where itemId = '" + remove + "'";
                if(statement.executeUpdate(sql)==1)
                {
                    txtName.clear();
                    txtName.clear();
                    txtPrice.clear();
                    txtQuantity.clear();
                    txtstatus.setText("Item removed successfully");
                }
               else
                {
                    txtstatus.setText("Failed to remove Item");
                }
                //JOptionPane.showMessageDialog(null, "Record Saved!");*/
            } catch (SQLException e) {
                txtstatus.setText("Item not found");
            }
        }
}
