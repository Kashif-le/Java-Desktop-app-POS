package JavaFx.models;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class modelShowDetail {
    private String Titemid, Tname, Tprice, Tcategory, Tquantity;


public modelShowDetail(String Titemid,String Tname, String Tprice, String Tcategory, String Tquantity){

    this.Titemid = Titemid;
    this.Tname = Tname;
    this.Tprice = Tprice;
    this.Tcategory = Tcategory;
    this.Tquantity = Tquantity;

}

    public String getTitemid() {
        return Titemid;
    }

    public void setTitemid(String titemid) {
        Titemid = titemid;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTprice() {
        return Tprice;
    }

    public void setTprice(String tprice) {
        Tprice = tprice;
    }

    public String getTcategory() {
        return Tcategory;
    }

    public void setTcategory(String tcategory) {
        Tcategory = tcategory;
    }

    public String getTquantity() {
        return Tquantity;
    }

    public void setTquantity(String tquantity) {
        Tquantity = tquantity;
    }
}
