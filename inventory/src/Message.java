import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Message")
public class Message extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        int timeout = 100;
        HttpSession sessionObj = request.getSession(true);
        sessionObj.setMaxInactiveInterval(timeout);
        response.setHeader("Refresh", timeout + "; URL=timeout.jsp");

        PrintWriter out = response.getWriter();

        String messageText = request.getParameter("messageText");
        int messageType = Integer.parseInt(request.getParameter("messageType"));
        String redirectPage = request.getParameter("redirectPage");

        // messageText = GlobalError.errStr;

        StringBuilder sb = new StringBuilder();
        for (String err : GlobalError.errorStrings) {
            sb.append(err).append("<br>");
        }

        messageText = sb.toString();
        GlobalError.errorStrings.clear();
        
        String color = "black";

        if (messageType == 1)
            color = "red";
        if (messageType == 2)
            color = "green";
        if (messageType == 3)
            color = "yellow";

        out.print("<!DOCTYPE html><html lang='en'>");
        out.print("<head><meta charset='UTF-8'>");
        out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.print("<title>Garments Showroom</title>");
        out.print("<link rel='icon' href='images/logo.png'>");
        out.print("<link rel='stylesheet' href='style.css'></head>");
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
        out.print(".cus_btn1{");
        out.print("background-color: #FF6347;");
        out.print("width: 80%;");
        out.print("border-radius: 30px;");
        out.print("color: white;");
        out.print("padding: 16px 32px;");
        out.print("text-align: center;");
        out.print("text-decoration: none;");
        out.print("display: inline-block;");
        out.print("font-size: 16px;");
        out.print("font-weight: bold;");
        out.print("margin: 4px 2px;");
        out.print("transition-duration: 0.2s;");
        out.print("cursor: pointer;");
        out.print("}");
        out.print(".cus_btn1:hover {");
        out.print("background-color: #2d29f7;");
        out.print("color: yellow;");
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
        out.print("</style>");
        out.print("<body>");
        out.print("<div class='container1'>");
        out.print("<center>");
        out.print("<h1 style='color:white;'>Display Message</h1>");
        out.print("</center>");
        out.print("</div>");
        out.print("<div class='container2'><center>");
        //out.print(
                //"<body><center><img src='images/logo.png' width='75'><h1>Display Message</h1><table width='50%' id='cus_table1'>");
        out.print("<table width='50%'><tr><td align='center' style='color:" + color + "'>");
        out.print("<h2>" + messageText + "</h2> </td></tr>");
        out.print("<tr><td align='center'> <a href=" + redirectPage
                + "><button class='cus_btn1'>OK</button></a> </td></tr></table></form></center></center></div></body></html>");
    }
}