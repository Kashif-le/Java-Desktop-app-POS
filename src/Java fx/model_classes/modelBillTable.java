package JavaFx.models;

public class modelBillTable {


    private String itemid, BillId ,saleDate;
    int quantity,Price;

    public modelBillTable(String MBillId, String MsaleDate, String MTitemid, int Mquantity){

        this.BillId = MBillId;
        this.saleDate = MsaleDate;
        this.itemid = MTitemid;
        this.quantity = Mquantity;
    }


    public modelBillTable(int Mprice){
      this.Price = Mprice;
}

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String billId) {
        BillId = billId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
