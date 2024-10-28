<%@page import="com.klef.ep.models.Stock"%>
<%@page import="com.klef.ep.services.SupplierService"%>
<%@page import="javax.naming.InitialContext"%>
<%

String id = request.getParameter("itemCode");
int totalquantity = Integer.parseInt(request.getParameter("totalquantity"));
int quantity = Integer.parseInt(request.getParameter("quantity"));

InitialContext context = new InitialContext();
SupplierService supplierService = (SupplierService) context.lookup("java:global/StockManagementSystem/SupplierServiceImpl!com.klef.ep.services.SupplierService");

Stock s = supplierService.viewstockbyid(id);

if (s != null) {
    if (totalquantity >= quantity) {
        int newquantity = totalquantity - quantity;
        
        // Update stock quantity
        Stock stk = new Stock();
        stk.setItemCode(id);
        stk.setQuantity(newquantity);

        supplierService.dispatch(stk);

        response.sendRedirect("viewallstockbysupplier.jsf");
        out.println("Quantity dispatched");
    } else {
        out.println("The amount of stock you want to dispatch is not available.");
    }
} else {
    out.println("Stock ID Not Found");
}

%>
