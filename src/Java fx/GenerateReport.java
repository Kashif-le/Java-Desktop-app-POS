package JavaFx;

import com.mysql.cj.xdevapi.Table;
import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class GenerateReport {

    @FXML
    private TableView reportTable;
    @FXML
    private TableColumn txtCategory;
    @FXML
    private TableColumn txtSold;
    @FXML
    private TableColumn txtAmount;
    @FXML
    private TableColumn txtTax;
    @FXML
    private TableColumn txtTotal;
    @FXML
    private Button generateB;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker EndDate;
    @FXML
    private Label reportLabel;

    @FXML
    public void backtohome1(MouseEvent event) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("../views/homePage.fxml"));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(root));

        }

    public void testFunction(ActionEvent Event) throws IOException
    {
        LocalDate test;
        test = startDate.getValue();
        System.out.println(test);

    }




    }

