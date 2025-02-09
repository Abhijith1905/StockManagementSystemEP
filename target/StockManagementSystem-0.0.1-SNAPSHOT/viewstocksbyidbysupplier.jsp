<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.io.*" %>
<%
Blob image = null;
Connection con = null;
byte[] imgData = null;

String itemCode = request.getParameter("itemCode");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://my-db-server-31277.mysql.database.azure.com:3306/sms-ep-db?useSSL=true", "abhijith", "Sriram8585");
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery("select imagedata from stock_table where stock_itemcode = '" + itemCode + "'");
    if (rs.next()) {
        image = rs.getBlob(1);
        imgData = image.getBytes(1, (int) image.length());
    }

    response.setContentType("image/jpg");
    OutputStream o = response.getOutputStream();
    o.write(imgData);
    o.flush();
    o.close();
} catch (Exception e) {
    out.println("Image Display Error=" + e.getMessage());
    return;
}
%>
