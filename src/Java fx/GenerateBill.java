package JavaFx;

import Connection.ConnectionClass;
import JavaFx.models.modelBillTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.controlsfx.control.textfield.TextFields;


public class GenerateBill {

    @FXML
    private TextField txtitemid;

    @FXML
    private TextField txtQuantity;
    @FXML
    private DatePicker txtDate;
    @FXML
    private TextField txtbillid;
    @FXML
    private Label txtstatus;
    @FXML
    private Label txttotal;

    @FXML
    private Label abc;
    @FXML
    private Label txttest;
    @FXML
    private TableView<modelBillTable> table;

    @FXML
    private TableColumn<modelBillTable, String> colBllID;

    @FXML
    private TableColumn<modelBillTable, String> colDate;

    @FXML
    private TableColumn<modelBillTable, String> colitemid;

    @FXML
    private TableColumn<modelBillTable, String> colQuan;


    @FXML
    private TableView<modelBillTable> table1;
    @FXML
    private TableColumn<modelBillTable, String> colprice;


    @FXML
    private TextField txtsearchid;

    int total = 0;

    ObservableList<modelBillTable> observlist = FXCollections.observableArrayList();
    ObservableList<modelBillTable> obsl = FXCollections.observableArrayList();


    public boolean check1(String itemcheck) throws SQLException {
        boolean flag = false;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement stmt = connection.createStatement();
        String sql1 = "SELECT quantity FROM stock_details WHERE itemid = '" + txtitemid.getText() + "'";
        ResultSet rs1 = stmt.executeQuery(sql1);
        while (rs1.next()) {
            String p1 = rs1.getString("quantity");
            System.out.println(p1);
            String quant = txtQuantity.getText();
            System.out.println(quant);


            Integer result_1 = Integer.valueOf(p1);
            Integer result_2 = Integer.valueOf(quant);
            System.out.println(result_1);
            System.out.println(result_2);

            if (result_1 < result_2) {
                flag = true;
                // txtstatus.setText("hello");
            }
        }
        return flag;

    }


    public void alter2(int x) throws SQLException {


        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        //Statement stmt = connection.createStatement();
        String b = txtitemid.getText();
        String x2 = String.valueOf(x);
//
        System.out.println(x);
        String sql = "update stock_details set quantity =? where itemid =?";
        try (PreparedStatement stmt = connection.prepareStatement(sql);) {


            System.out.println(x);

            stmt.setString(1, x2);
            stmt.setString(2, b);
            stmt.executeUpdate();
            txtstatus.setText("Info updated!");
        } catch (SQLException e) {
            txtstatus.setText("Info not updated!");
        }


    }


    public void alterData(MouseEvent event) throws IOException, SQLException {

        //boolean flag = false;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement stmt = connection.createStatement();
        String quant1 = txtQuantity.getText();
        int result = 0;

        try {
            String sql1 = "SELECT quantity FROM stock_details WHERE itemid = '" + txtitemid.getText() + "'";
            ResultSet rs_1 = stmt.executeQuery(sql1);
            while (rs_1.next()) {
                int p11 = rs_1.getInt("quantity");

                Integer result_22 = Integer.valueOf(quant1);
                result = p11 - result_22;

                alter2(result);
            }


        } catch (SQLException e) {
            txtstatus.setText("Info not updated!");
        }


    }

    public void saveData(ActionEvent event) throws IOException, SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement statement = connection.createStatement();

        table.getItems().clear();
        table.refresh();


        String saleDate = txtDate.getValue().toString();
        String Quantity = txtQuantity.getText();
        String item1 = txtitemid.getText();
        int Quant = 0;
        Quant = Integer.valueOf(Quantity);


        if (check1(item1)) {
            txtstatus.setText("Sorry, Less Quantity available");
        } else {
            try {

                String sql = "INSERT INTO sales_data VALUES('" + txtbillid.getText() + "','" + saleDate + "','" + txtitemid.getText() + "','" + txtQuantity.getText() + "')";
                if (statement.executeUpdate(sql) == 1) {

                    Statement stmt = connection.createStatement();
                    String sql1 = "SELECT * FROM sales_data WHERE sale_id = '" + txtbillid.getText() + "'";
                    ResultSet rs = stmt.executeQuery(sql1);

                    String sql2 = "SELECT price FROM stock_details WHERE itemid = '" + txtitemid.getText() + "'";
                    ResultSet resultSet = statement.executeQuery(sql2);


                    while (rs.next()) {
                        observlist.add(new modelBillTable(rs.getString("sale_id"), rs.getString("date"), rs.getString("item"),
                                rs.getInt("quantity")));
                    }

                    while (resultSet.next()) {
                        String p = resultSet.getString("price");

                        Integer result = Integer.valueOf(p);
                        result = result * Quant;
                        total += result;
                        txttotal.setText(String.valueOf(total));
                        //String str1 = Integer.toString(result);
                        obsl.add(new modelBillTable(result));


                    }


                    colBllID.setCellValueFactory(new PropertyValueFactory<>("BillId"));
                    colDate.setCellValueFactory(new PropertyValueFactory<>("saleDate"));
                    colitemid.setCellValueFactory(new PropertyValueFactory<>("itemid"));
                    colQuan.setCellValueFactory(new PropertyValueFactory<>("quantity"));
                    colprice.setCellValueFactory(new PropertyValueFactory<>("Price"));

                    table.setItems(observlist);
                    table1.setItems(obsl);
                    // alterData(item1);
                    txtstatus.setText(" ");


                }


//            else
//            {
//                txtstatus.setText("Failed to add Items");
//            }

            } catch (SQLException e) {
                txtstatus.setText("Failed to add Items");
                // e.printStackTrace();
            }
        }

    }


    @FXML
    void back2(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/homePage.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }


    public void printBill(MouseEvent event) {


    }

    public void givesuggestion() throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        Statement statement = connection.createStatement();


        List<String> itemids = new ArrayList<>();
        String sql1 = "SELECT itemid FROM stock_details";

        ResultSet rs1 = statement.executeQuery(sql1);
        while (rs1.next()) {
            String p = rs1.getString("itemid");

            itemids.add(p);

        }
            TextFields.bindAutoCompletion(txtitemid, itemids);


        }
    }


