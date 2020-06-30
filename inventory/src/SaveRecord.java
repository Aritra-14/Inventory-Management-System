import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveRecord")
public class SaveRecord extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

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

    // out.println(name+" "+mobile+" "+email+" "+affiliation+" "+occupation);

    int status = Dao.save(s);

    String messageText = "This is some Error Message Text";
    Integer messageType = 2;
    String redirecPage = "Garments_admin.HTM";

    if (status > 0) {
      // successfuly inserted record
      messageText = "Record Successfully Inserted";
      GlobalError.errorStrings.add(messageText);
      messageType = 2;
      redirecPage = "Garments_admin.HTM";
    } else {
      // Error occured
      messageText = "Sorry ! Some Error in Input";
      GlobalError.errorStrings.add(messageText);
      messageType = 1;
      redirecPage = "Garments_admin.HTM";
    }

    request
        .getRequestDispatcher(
            "Message?messageText=" + messageText + "&messageType=" + messageType + "&redirectPage=" + redirecPage)
        .forward(request, response);

    out.close();
  }

}