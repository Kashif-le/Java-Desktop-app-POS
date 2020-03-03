package JavaFx;

import com.mysql.cj.protocol.x.XMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import Connection.ConnectionClass;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.beans.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddUser {
    @FXML
    private javafx.scene.control.TextField txtName;
    @FXML
    private javafx.scene.control.TextField txtCNIC;
    @FXML
    private javafx.scene.control.TextField txtAge;
    @FXML
    private javafx.scene.control.TextField txtMobile;
    @FXML
    private javafx.scene.control.TextField txtShift;
    @FXML
    private ComboBox<String> cmbGender;
    @FXML
    private TextArea txtAddress;

    @FXML
    private Label status;

    private Connection cn;
    private Statement st;

    public void initialize()
    {

        cmbGender.getItems().addAll("Male", "Female");
        cmbGender.getSelectionModel().select("Male");
    }

    public Connection getCn() {
        return cn;
    }

//    private void connect() {
//        try {
//            String dbName="ooadproj";
//            String userName="root";
//            String password="";
//            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
//            //System.out.println("Success");
//            //JOptionPane.showMessageDialog(null, "Connect!");
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
    public void saveData(MouseEvent event) throws IOException, SQLException{
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();


       // System.out.println("In the save data function");
        String username = txtName.getText();
        String age = txtAge.getText();
        String Gender = cmbGender.getSelectionModel().getSelectedItem();
        String contact_no  = txtMobile.getText();
        String CNIC = txtCNIC.getText();
        String Address = txtAddress.getText();
        String Shift = txtShift.getText();
        try {
            java.sql.Statement statement=connection.createStatement();
            String sql = "INSERT INTO salesman_data VALUES('"+username+"','"+age+"','"+Gender+"','"+contact_no+"','"+CNIC+"','"+Address+"','"+Shift+"')";
            if(statement.executeUpdate(sql)==1)
            {
                txtName.clear();
                txtAddress.clear();
                txtAge.clear();
                txtCNIC.clear();
                txtMobile.clear();
                txtShift.clear();
                status.setText("User added successfully");
            }
            else
            {
                status.setText("Failed to add user");
            }
            //JOptionPane.showMessageDialog(null, "Record Saved!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void back7(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/adminHome.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

}
