<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.util.List" %>
<%@include file="suppliernavbar.html" %>  
<%@page import="com.klef.ep.services.SupplierService"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="com.klef.ep.models.Stock"%>
<%@page import="com.klef.ep.models.Supplier"%>
<% 
Supplier supplier = (Supplier) session.getAttribute("supplier");
if (supplier == null) {
    response.sendRedirect("sessionexpiry.html");
}
%>
<!DOCTYPE html>
<html>
<head>
<title>EP PROJECT - View All Stocks</title>
<link type="text/css" rel="stylesheet" href="style.css"/>
<style>


h2 {
    text-align: center;
    text-decoration: underline;
    font-size: 24px;
    color: #333;
    margin-top: 20px;
}

table {
    border-collapse: collapse;
    width: 80%;
    margin: 20px auto;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
}

th {
    background-color: #e1e7fc;
    color: black;
    font-weight: bold;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

tr:hover {
    background-color: #ddd;
}

td form {
    margin: 0;
}

a {
    color: #FF0000;
    text-decoration: none;
    font-weight: bold;
}

a:hover {
    text-decoration: underline;
}

.no-records {
    background-color: white;
    border: 1px solid #ddd;
    padding: 20px;
    text-align: center;
    width: 80%;
    margin: 20px auto;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>

<h2 align="center"><u>View All Stocks</u></h2>

<%
InitialContext context = new InitialContext();
SupplierService supplierService = (SupplierService) context.lookup("java:global/StockManagementSystem/SupplierServiceImpl!com.klef.ep.services.SupplierService");

List<Stock> stocklist = supplierService.viewallstock(supplier.getName());

if (stocklist == null || stocklist.isEmpty()) {
%>
    <div class="no-records">
        <p>No records available</p>
    </div>
<%
} else {
%>
    <table align="center">
        <tr>
            <th>Item Code</th>
            <th>Name</th>
            <th>Category</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Purchase Date</th>
            <th>Image</th>
        </tr>
        <%
        for (Stock stock : stocklist) {
        %>
            <tr>
                <td><%= stock.getItemCode() %></td>
                <td><%= stock.getItemName() %></td>
                <td><%= stock.getCategory() %></td>
                <td><%= stock.getQuantity() %></td>
                <td><%= stock.getUnitPrice() %></td>
                <td><%= stock.getPurchasedate() %></td>
                <td><img src="viewstocksbyidbysupplier.jsp?itemCode=<%= stock.getItemCode() %>" width="100" height="100" alt="No image provided"/></td>
            </tr>
        <%
        }
        %>
    </table>
<%
}
%>

</body>
</html>
