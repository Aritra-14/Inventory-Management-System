import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateRecord")
public class UpdateRecord extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String sid = request.getParameter("id");
    int id = Integer.parseInt(sid);
    String StockID = request.getParameter("StockID");
    String SupplierID = request.getParameter("SupplierID");
    String SupplierName = request.getParameter("SupplierName");
    String StockDesc = request.getParameter("stock_desc");
    String cost_price = request.getParameter("cost_price");
    String estimated_selling_price = request.getParameter("estimated_selling_price");
    String quantities_in_stock = request.getParameter("quantities_in_stock");
    String total_cost_price = request.getParameter("total_cost_price");
    String total_selling_price = request.getParameter("total_selling_price");
    String brand_name = request.getParameter("brand_name");
    String size = request.getParameter("size");

    Stock s = new Stock();
    s.setId(id);
    s.setStockID(StockID);
    s.setSupplierID(SupplierID);
    s.setSupplierName(SupplierName);
    s.setStockDesc(StockDesc);
    s.setCP(cost_price);
    s.setESP(estimated_selling_price);
    s.setQtnLeft(quantities_in_stock);
    s.setTotalCP(total_cost_price);
    s.setTotalSP(total_selling_price);
    s.setBrandName(brand_name);
    s.setSize(size);

    int status = Dao.update(s);

    String messageText = "This is some Error Message Text";
    Integer messageType = 2;
    String redirecPage = "Garments_admin.HTM";

    if (status > 0) {
      // successfuly inserted record
      messageText = "Record Successfully Updated";
      GlobalError.errorStrings.add(messageText);
      messageType = 2;
      redirecPage = "View";
    } else {
      // Error occured
      messageText = "Sorry ! Error in Record Modification";
      GlobalError.errorStrings.add(messageText);
      messageType = 1;
      redirecPage = "View";
    }

    request
        .getRequestDispatcher(
            "Message?messageText=" + messageText + "&messageType=" + messageType + "&redirectPage=" + redirecPage)
        .forward(request, response);

  }

}