import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.script.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewRecord")
public class ViewRecord extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        int timeout = 100;
        HttpSession sessionObj = request.getSession(true);
        sessionObj.setMaxInactiveInterval(timeout);
        response.setHeader("Refresh", timeout + "; URL=timeout.jsp");

        PrintWriter out = response.getWriter();

        out.print("<html><head>");
        out.print("<link rel='stylesheet' href='style.css'>");
        out.print("<link rel='icon' href='images/logo.png'>");
        //out.print("<script src='sorting.js'></script>");
        out.print("</head>");
        out.print("<style>body {background-image: url('background.jpg');background-repeat: no-repeat;background-size: cover;}");
        out.print(".container1 {");
        out.print("border-top-right-radius: 10px;");
        out.print("border-top-left-radius: 10px;");
        out.print("background-color: #FF6347;");
        out.print("padding-top: 30px;");
        out.print("padding-bottom: 30px;");
        out.print("margin: 65px 170px 0px 170px;");
        out.print("font-size: 20px;");
        out.print("}");
        out.print("</style>");
        out.print("<body>");
        out.print("<center><img src='images/logo.png' width='75'>");
        List<Stock> list = Dao.getAllStockList();
        int i=1;
        int j=0;
        int totalElementsInserted=0;
        int[] i_arr; 
        String[] StockID_arr;
        String[] SupplierID_arr;
        String[] SupplierName_arr;
        String[] StockDesc_arr;
        String[] CP_arr;
        String[] ESP_arr;
        String[] QtnLeft_arr;
        String[] TotalCP_arr;
        String[] TotalSP_arr;
        String[] BrandName_arr;
        String[] Size_arr;
        int[] Id_arr;

        i_arr = new int [100];
        StockID_arr = new String [100];
        SupplierID_arr = new String [100];
        SupplierName_arr = new String [100];
        StockDesc_arr = new String [100];
        CP_arr = new String [100];
        ESP_arr = new String [100];
        QtnLeft_arr = new String [100];
        TotalCP_arr = new String [100];
        TotalSP_arr = new String [100];
        BrandName_arr = new String [100];
        Size_arr = new String [100];
        Id_arr = new int [100];

        out.print("<table border='1' width='80%' id='cus_table2'>");
        //out.print("<caption><h1>Existing Stock</h1></caption>");
        out.print("<div class='container1'>");
        out.print("<center>");
        out.print("<h1 style='color:white;'>Existing Stock</h1>");
        out.print("</center>");
        out.print("</div>");
        out.print("<tr><th>SL</th><th>StockID</th><th>SupplierID</th><th>SupplierName</th><th>StockDesc</th><th>Cost Price</th><th>Estimated Selling Price</th><th>Quantities Left</th><th>Total Cost Price</th><th>Total Selling Price</th><th>Brand Name</th><th>Size</th><th>Edit</th><th>Delete</th></tr>");
        for (Stock s : list) {
            //out.print("<tr><td>" + i + "</td><td>" + s.getStockID() + "</td><td>" + s.getSupplierID() + "</td><td>"
              //      + s.getSupplierName() + "</td><td>" + s.getStockDesc() + "</td><td>" + s.getCP() + "</td><td>" + s.getESP() + "</td><td>" + s.getQtnLeft() + "</td><td>" + s.getTotalCP() + "</td><td>" + s.getTotalSP() + "</td><td>" + s.getBrandName() + "</td><td>" + s.getSize() + "</td><td><a href='Edit?id="+ s.getId()+"'>Edit</a>"+"</td><td><a href='Delete?id="+s.getId()+"'>Delete</a> "+"</td></tr>");
                //    i++;
            i_arr[j]=i;
            StockID_arr[j]=s.getStockID();
            SupplierID_arr[j]=s.getSupplierID();
            SupplierName_arr[j]=s.getSupplierName();
            StockDesc_arr[j]=s.getStockDesc();
            CP_arr[j]=s.getCP();
            ESP_arr[j]=s.getESP();
            QtnLeft_arr[j]=s.getQtnLeft();
            TotalCP_arr[j]=s.getTotalCP();
            TotalSP_arr[j]=s.getTotalSP();
            BrandName_arr[j]=s.getBrandName();
            Size_arr[j]=s.getSize();
            Id_arr[j]=s.getId();
            j++;
            i++;
            totalElementsInserted++;
        }
        //code of bubble sort, on basis of quantities left
        int n = totalElementsInserted;  
        int m,l;
        String temp1;
        int temp2 = 0;
        int temp3 = 0;
        String temp4;
        String temp5;
        String temp6;
        String temp7;
        String temp8;
        String temp9;
        //String temp10; 
        String temp11;
        String temp12;
        String temp13;
        String temp14;
         for(m=0; m < n-1; m++)
         {  
                 for(l=0; l < (n-m-1); l++)
                 {  
                          if(Integer.parseInt(QtnLeft_arr[l]) > Integer.parseInt(QtnLeft_arr[l+1]))
                          //if(QtnLeft_arr[l].compareTo(QtnLeft_arr[l+1])>0)
                          {  
                                 //swap elements  
                                 temp1 = QtnLeft_arr[l];  
                                 QtnLeft_arr[l] = QtnLeft_arr[l+1];  
                                 QtnLeft_arr[l+1] = temp1; 

                                 temp2 = i_arr[l];  
                                 i_arr[l] = i_arr[l+1];  
                                 i_arr[l+1] = temp2;

                                 temp3 = Id_arr[l];  
                                 Id_arr[l] = Id_arr[l+1];  
                                 Id_arr[l+1] = temp3;

                                 temp4 = StockID_arr[l];  
                                 StockID_arr[l] = StockID_arr[l+1];  
                                 StockID_arr[l+1] = temp4;

                                 temp5 = SupplierID_arr[l];  
                                 SupplierID_arr[l] = SupplierID_arr[l+1];  
                                 SupplierID_arr[l+1] = temp5;

                                 temp6 = SupplierName_arr[l];  
                                 SupplierName_arr[l] = SupplierName_arr[l+1];  
                                 SupplierName_arr[l+1] = temp6;

                                 temp7 = StockDesc_arr[l];  
                                 StockDesc_arr[l] = StockDesc_arr[l+1];  
                                 StockDesc_arr[l+1] = temp7;

                                 temp8 = CP_arr[l];  
                                 CP_arr[l] = CP_arr[l+1];  
                                 CP_arr[l+1] = temp8;

                                 temp9 = ESP_arr[l];  
                                 ESP_arr[l] = ESP_arr[l+1];  
                                 ESP_arr[l+1] = temp9;

                                 temp11 = TotalCP_arr[l];  
                                 TotalCP_arr[l] = TotalCP_arr[l+1];  
                                 TotalCP_arr[l+1] = temp11;

                                 temp12 = TotalSP_arr[l];  
                                 TotalSP_arr[l] = TotalSP_arr[l+1];  
                                 TotalSP_arr[l+1] = temp12;

                                 temp13 = BrandName_arr[l];  
                                 BrandName_arr[l] = BrandName_arr[l+1];  
                                 BrandName_arr[l+1] = temp13;

                                 temp14 = Size_arr[l];  
                                 Size_arr[l] = Size_arr[l+1];  
                                 Size_arr[l+1] = temp14;
                                 
                          }
                 }
         }
        //display
        for(int k=0;k<totalElementsInserted;k++)
            out.print("<tr><td>" + i_arr[k] + "</td><td>" + StockID_arr[k] + "</td><td>" + SupplierID_arr[k] + "</td><td>"
                    + SupplierName_arr[k] + "</td><td>" + StockDesc_arr[k] + "</td><td>" + CP_arr[k] + "</td><td>" + ESP_arr[k] + "</td><td>" + QtnLeft_arr[k] + "</td><td>" + TotalCP_arr[k] + "</td><td>" + TotalSP_arr[k] + "</td><td>" + BrandName_arr[k] + "</td><td>" + Size_arr[k] + "</td><td><a href='Edit?id="+ Id_arr[k]+"'>Edit</a>"+"</td><td><a href='Delete?id="+Id_arr[k]+"'>Delete</a> "+"</td></tr>");
        out.print("<tr><td colspan=14 align='center'> <a href='Garments_admin.HTM'>Add New Records</a></td>");
        out.print("</table></center></body>");   
        out.close();
    }
}