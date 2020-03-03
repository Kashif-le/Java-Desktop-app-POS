package JavaFx;

import Connection.ConnectionClass;
import JavaFx.models.modelShowDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class controllerShowItemDetails {
    @FXML
    private TableColumn<modelShowDetail, String> colitemid;
    @FXML
    private TableView<modelShowDetail> table;

    @FXML
    private TableColumn<modelShowDetail, String> colname;

    @FXML
    private TableColumn<modelShowDetail, String> colprice;

    @FXML
    private TableColumn<modelShowDetail, String> colcategory;

    @FXML
    private TableColumn<modelShowDetail, String> colquantity;

    @FXML
    private TextField txtsearchid;

    @FXML
    private Label labelstatus;


    ObservableList<modelShowDetail> oblist = FXCollections.observableArrayList();

//    //@Override
   // public void Login(MouseEvent event) throws IOException
  //  , URL location, ResourceBundle resources
public void search(ActionEvent event) throws SQLException {
    ConnectionClass connectionClass = new ConnectionClass();
    Connection connection = connectionClass.getConnection();
    Statement statement = connection.createStatement();


    String sql = "SELECT * FROM stock_details WHERE itemid = '" + txtsearchid.getText() + "';";
    ResultSet rs = statement.executeQuery(sql);
    if (rs.next()) {

        oblist.add(new modelShowDetail(rs.getString("itemid"), rs.getString("name"), rs.getString("price"),
                rs.getString("category"), rs.getString("quantity")));
    }
    else {
        txtsearchid.clear();
        labelstatus.setText("Item ID not found");
    }

    colitemid.setCellValueFactory(new PropertyValueFactory<>("Titemid"));
    colname.setCellValueFactory(new PropertyValueFactory<>("Tname"));
    colprice.setCellValueFactory(new PropertyValueFactory<>("Tprice"));
    colcategory.setCellValueFactory(new PropertyValueFactory<>("Tcategory"));
    colquantity.setCellValueFactory(new PropertyValueFactory<>("Tquantity"));

    table.setItems(oblist);

}
    @FXML
    void back2(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../views/homePage.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

    }

    public void clearTable(MouseEvent event) {

        ObservableList<modelShowDetail> allLocations;
        allLocations = table.getItems();
        //allLocations .forEach(allLocations::remove);
        table.getItems().clear();
        table.refresh();
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
        TextFields.bindAutoCompletion(txtsearchid, itemids);


    }
}
