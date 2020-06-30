import java.util.*;
import java.sql.*;

public class Dao {
  
  public static Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String jdbcUrl =   Credentials.jdbcUrl;
      String username =  Credentials.username;
      String password =  Credentials.password;

      con = DriverManager.getConnection(jdbcUrl, username, password);

    } catch (Exception e) {
      // GlobalError.errStr = e.toString();
      GlobalError.errorStrings.add(e.toString());
      System.out.println(e);     
    }
    return con;
  }

  // ----------------------------------------------------------

  public static int save(Stock s) {
    int status = -1;

    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con
          .prepareStatement("insert into garments_table(StockID,SupplierID,SupplierName,stock_desc,cost_price,estimated_selling_price,quantities_in_stock,total_cost_price,total_selling_price,brand_name,size) values (?,?,?,?,?,?,?,?,?,?,?)");
      ps.setString(1, s.getStockID());
      ps.setString(2, s.getSupplierID());
      ps.setString(3, s.getSupplierName());
      ps.setString(4, s.getStockDesc());
      ps.setString(5, s.getCP());
      ps.setString(6, s.getESP());
      ps.setString(7, s.getQtnLeft());
      ps.setString(8, s.getTotalCP());
      ps.setString(9, s.getTotalSP());
      ps.setString(10, s.getBrandName());
      ps.setString(11, s.getSize());


      status = ps.executeUpdate();
      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
      GlobalError.errorStrings.add(ex.toString());
    }

    return status;
  }

  // ---------------------------------------------------------

  public static int update(Stock s) {
    int status = -1;
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con
          .prepareStatement("update garments_table set StockID=?,SupplierID=?,SupplierName=?,stock_desc=?,cost_price=?,estimated_selling_price=?,quantities_in_stock=?,total_cost_price=?,total_selling_price=?,brand_name=?,size=?where reg_id=?");

      ps.setString(1, s.getStockID());
      ps.setString(2, s.getSupplierID());
      ps.setString(3, s.getSupplierName());
      ps.setString(4, s.getStockDesc());
      ps.setString(5, s.getCP());
      ps.setString(6, s.getESP());
      ps.setString(7, s.getQtnLeft());
      ps.setString(8, s.getTotalCP());
      ps.setString(9, s.getTotalSP());
      ps.setString(10, s.getBrandName());
      ps.setString(11, s.getSize());
      ps.setInt(12, s.getId());
      status = ps.executeUpdate();

      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
      GlobalError.errorStrings.add(ex.toString());
    }

    return status;
  }

  // ----------------------------------------------------------

  public static int delete(int id) {
    int status = 0;
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("delete from garments_table where reg_id=?");
      ps.setInt(1, id);
      status = ps.executeUpdate();

      con.close();
    } catch (Exception e) {
      e.printStackTrace();
      GlobalError.errorStrings.add(e.toString());
    }

    return status;
  }

  // --------------------------------------------------------

  public static Stock getStockById(int id) {
    Stock s = new Stock();

    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("select * from garments_table where reg_id=?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        s.setId(rs.getInt(1));
        s.setStockID(rs.getString(2));
        s.setSupplierID(rs.getString(3));
        s.setSupplierName(rs.getString(4));
        s.setStockDesc(rs.getString(5));
        s.setCP(rs.getString(6));
        s.setESP(rs.getString(7));
        s.setQtnLeft(rs.getString(8));
        s.setTotalCP(rs.getString(9));
        s.setTotalSP(rs.getString(10));
        s.setBrandName(rs.getString(11));
        s.setSize(rs.getString(12));
      }
      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
      GlobalError.errorStrings.add(ex.toString());
    }

    return s;
  }

  // -----------------------------------------------------------------

  public static List<Stock> getAllStockList() {
    List<Stock> list = new ArrayList<Stock>();
    try {
      Connection con = Dao.getConnection();
      PreparedStatement ps = con.prepareStatement("select * from garments_table");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Stock s = new Stock();

        s.setId(rs.getInt(1));
        s.setStockID(rs.getString(2));
        s.setSupplierID(rs.getString(3));
        s.setSupplierName(rs.getString(4));
        s.setStockDesc(rs.getString(5));
        s.setCP(rs.getString(6));
        s.setESP(rs.getString(7));
        s.setQtnLeft(rs.getString(8));
        s.setTotalCP(rs.getString(9));
        s.setTotalSP(rs.getString(10));
        s.setBrandName(rs.getString(11));
        s.setSize(rs.getString(12));
        
        list.add(s);
      }
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
      GlobalError.errorStrings.add(e.toString());
    }

    return list;
  }
}

// -------------------------------------------------------------------