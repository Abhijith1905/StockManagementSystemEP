<%@page import="com.klef.ep.models.Supplier"%>
<%@page import="com.klef.ep.services.SupplierService"%>
<%@page import="javax.naming.InitialContext"%>
<%

int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String password = request.getParameter("password");
String contact = request.getParameter("contact");


InitialContext context = new InitialContext();

SupplierService supplierService = (SupplierService) context.lookup("java:global/StockManagementSystem/SupplierServiceImpl!com.klef.ep.services.SupplierService");

Supplier s = supplierService.viewsupbyid(id);

if(s!=null)
{
    //System.out.println("ID Found");
    Supplier sup = new Supplier();

    sup.setId(id);
    sup.setName(name);
    sup.setPassword(password);
    sup.setContactno(contact);


    
    supplierService.updatesupplier(sup);
    
    Supplier supplier = supplierService.viewsupbyid(id);
    
    session.setAttribute("supplier", supplier);
    
    response.sendRedirect("supplierprofile.jsp");
}
else
{
  out.println("Supplier ID Not Found");
}


%>