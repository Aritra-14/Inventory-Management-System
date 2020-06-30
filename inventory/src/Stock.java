public class Stock {
    private int id;
    private String StockID,SupplierID,SupplierName,stock_desc,cost_price, estimated_selling_price, quantities_in_stock,total_cost_price,total_selling_price,brand_name,size;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockID() {
        return StockID;
    }

    /**
     * 
     * @param name enter <b>users</b> name here
     * @return void
     */
    public void setStockID(String StockID) {
        this.StockID = StockID;
    }

    public String getSupplierID() {
        return SupplierID;        
    }  
    
    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public String getStockDesc() {
        return stock_desc;
    }

    public void setStockDesc(String stock_desc) {
        this.stock_desc = stock_desc;
    }

    public String getCP() {
        return cost_price;
    }

    public void setCP(String cost_price) {
        this.cost_price = cost_price;
    }

    public String getESP() {
        return estimated_selling_price;
    }

    public void setESP(String estimated_selling_price) {
        this.estimated_selling_price = estimated_selling_price;
    }

    public String getQtnLeft() {
        return quantities_in_stock;
    }

    public void setQtnLeft(String quantities_in_stock) {
        this.quantities_in_stock = quantities_in_stock;
    }

    public String getTotalCP() {
        return total_cost_price;
    }

    public void setTotalCP(String total_cost_price) {
        this.total_cost_price = total_cost_price;
    }

    public String getTotalSP() {
        return total_selling_price;
    }

    public void setTotalSP(String total_selling_price) {
        this.total_selling_price = total_selling_price;
    }

    public String getBrandName() {
        return brand_name;
    }

    public void setBrandName(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
 
}