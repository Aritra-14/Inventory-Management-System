import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditRecord")
public class EditRecord extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                response.setContentType("text/html");

                int timeout = 100;
                HttpSession sessionObj = request.getSession(true);
                sessionObj.setMaxInactiveInterval(timeout);
                response.setHeader("Refresh", timeout + "; URL=timeout.jsp");

                String sid = request.getParameter("id");
                int id = Integer.parseInt(sid);
                Stock s = Dao.getStockById(id);

                PrintWriter out = response.getWriter();
                out.print("<!DOCTYPE html><html lang='en'>");
                out.print("<head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.print("<title>Garments Showroom</title><link rel='icon' href='images/logo.png'><link rel='stylesheet' href='style.css'></head>");
                out.print("<style>body {background-image: url('background.jpg');background-repeat: no-repeat;background-size: cover;}");
                out.print(".container1 {");
                out.print("border-top-right-radius: 10px;");
                out.print("border-top-left-radius: 10px;");
                out.print("background-color: #FF6347;");
                out.print("padding-top: 30px;");
                out.print("padding-bottom: 30px;");
                out.print("margin: 65px 150px 0px 150px;");
                out.print("font-size: 20px;");
                out.print("}");
                out.print(".container2 {");
                out.print("border-bottom-right-radius: 10px;");
                out.print("border-bottom-left-radius: 10px;");
                out.print("background-color: #fffbb3;");
                out.print("padding-top: 30px;");
                out.print("padding-bottom: 30px;");
                out.print("padding-left: 0px;");
                out.print("padding-right: 0px;");
                out.print("margin: 0px 150px 0px 150px;");
                out.print("}");
                out.print(".tooltip {");
                out.print("position: relative;");
                out.print("display: inline-block;");
                out.print("border-bottom: 1px dotted black;");
                out.print("}");
                out.print(".tooltip .tooltiptext {");
                out.print("visibility: hidden;");
                out.print("width: 200px;");
                out.print("background-color: rgb(142, 140, 158);");
                out.print("color: #000000;");
                out.print("text-align: justify;");
                out.print("border-radius: 6px;");
                out.print("padding: 10px 10px 10px 10px;");
                out.print("box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);");
                /* Position the tooltip */
                out.print("position: absolute;");
                out.print("z-index: 1;");
                out.print("}");
                out.print(".tooltip:hover .tooltiptext {");
                out.print("visibility: visible;");
                out.print("}");
                out.print("</style>");
                //out.print("<body><center><img src='images/logo.png' width=75><h1>Update Record</h1>");
                out.print("<div class='container1'>");
                out.print("<center>");
                out.print("<h1 style='color:white;'>Update Stock</h1>");
                out.print("</center>");
                out.print("</div>");
                out.print("<div class='container2'><center>");
                out.print("<form action='UpdateRecord' method='POST'><table width='50%'' id='garments_table'>");
                out.print("<input type='hidden' name='id' value='" + s.getId() + "' >");
                out.print("<tr><td>1. Stock ID *</td><td><input type='text' name='StockID' value='" + s.getStockID()+ "' maxlength='80' size='45' placeholder='SXXX' autocomplete='off' pattern='S[0-9]{3}' required>");
                out.print("<div class='tooltip'><img src='info.png' width='25px'><span class='tooltiptext'>Start with S followed by three digits</span></div>");
                out.print("</td>");
                out.print("</tr><tr><td>2. Supplier ID *</td><td><input type='text' name='SupplierID' value='" + s.getSupplierID()+ "' maxlength='80' size='45' placeholder='SUPPXXX' autocomplete='off' pattern='SUPP[0-9]{3}' required>");
                out.print("<div class='tooltip'><img src='info.png' width='25px'><span class='tooltiptext'>Start with SUPP followed by three digits</span></div>");
                out.print("</td");
                out.print("</tr><tr><td>3. Supplier Name *</td><td><input type='text' name='SupplierName' value='" + s.getSupplierName()+ "' maxlength='80' size='45' placeholder='Ratan Sarkhel' autocomplete='off' required></td>");
                out.print("</tr><tr><td>4. Stock Description *</td><td><input type='text' name='stock_desc' value='" + s.getStockDesc()+ "' maxlength='80' size='45' placeholder='For Kids' autocomplete='off' required></td>");
                out.print("</tr><tr><td>5. Cost Price (in INR) *</td><td><input type='number' name='cost_price' value='" + s.getCP()+ "' maxlength='80' size='45' placeholder='500' autocomplete='off' required></td>");
                out.print("</tr><tr><td>6. Estimated Selling Price (in INR) *</td><td><input type='number' name='estimated_selling_price' value='" + s.getESP()+ "' maxlength='80' size='45' placeholder='700' autocomplete='off' required></td>");
                out.print("</tr><tr><td>7. Total Quantities in Stock *</td><td><input type='number' name='quantities_in_stock' value='" + s.getQtnLeft()+ "' maxlength='80' size='45' placeholder='Add existing stock(s) with new stock(s) and enter' autocomplete='off' required></td>");
                out.print("</tr><tr><td>8. Total Cost Price of Stock (in INR) *</td><td><input type='number' name='total_cost_price' value='" + s.getTotalCP()+ "' maxlength='80' size='45' placeholder='5000' autocomplete='off' required></td>");
                out.print("</tr><tr><td>9. Total Selling Price (in INR) *</td><td><input type='number' name='total_selling_price' value='" + s.getTotalSP()+ "' maxlength='80' size='45' placeholder='6000' autocomplete='off' required></td>");
                out.print("</tr><tr><td>10. Brand Name *</td><td><input type='text' name='brand_name' value='" + s.getBrandName()+ "' maxlength='80' size='45' placeholder='Allen Solly' autocomplete='off' required></td>");
                out.print("</tr><tr><td>11. Size *</td><td><input type='text' name='size' value='" + s.getSize()+ "' maxlength='80' size='45' placeholder='M' autocomplete='off' required></td>");
                out.print("</tr><tr><td colspan=2 align='center'><input type='submit'> <input type='reset'></td></tr><tr><td colspan=2 align='center'> <a href='View'>View Existing Stock</a> </td>");
                out.print("</tr></center></container></table></form> </center></body></html>");

                out.close();
        }
}