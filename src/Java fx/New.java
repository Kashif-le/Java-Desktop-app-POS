package JavaFx;

import Connection.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class New {

    @FXML
    private TextField txtf1;

    @FXML
    private TextField txtf2;

    @FXML
    private Button btn;

    @FXML
    private Label txtlabel;


    public void alter2(int x) throws SQLException {


        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        //Statement stmt = connection.createStatement();
String b =txtf1.getText();
String x2 = String.valueOf(x);
//
        System.out.println(x);
        String sql = "update stock_details set quantity =? where itemid =?";
        try(PreparedStatement stmt = connection.prepareStatement(sql);) {


            System.out.println(x);

            stmt.setString(1, x2);
            stmt.setString(2, b);
            stmt.executeUpdate();
            txtlabel.setText("Info updated!");
        }
        catch (SQLException e){
            txtlabel.setText("Info not updated!");
        }




    }



    public void alterData(MouseEvent event) throws IOException, SQLException {


        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection=connectionClass.getConnection();
        Statement stmt = connection.createStatement();

        String quant1 = txtf2.getText();
        int result = 0;


        try {
            String sql1 = "SELECT quantity FROM stock_details WHERE itemid = '" + txtf1.getText() + "'";
            ResultSet rs_1 = stmt.executeQuery(sql1);
            while (rs_1.next()) {
                int p11 = rs_1.getInt("quantity");

                Integer result_22 = Integer.valueOf(quant1);
                result = p11 - result_22;

                alter2(result);
            }





        }
        catch (SQLException e){
            txtlabel.setText("Info not updated!");
        }

        }




}
