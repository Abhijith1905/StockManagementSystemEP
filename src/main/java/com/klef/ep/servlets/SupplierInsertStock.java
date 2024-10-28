package com.klef.ep.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.klef.ep.models.Stock;
import com.klef.ep.services.SupplierService;

@WebServlet("/SupplierInsertStock")
@MultipartConfig
public class SupplierInsertStock extends HttpServlet 
{
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try
        {
        	String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String scategory = request.getParameter("scategory");
			double cost = Double.parseDouble(request.getParameter("scost"));
			int qty = Integer.parseInt(request.getParameter("sqty"));
			String addedBy = request.getParameter("addedBy");		
			String purchasedate = request.getParameter("purchasedate");
			
			Part file = request.getPart("simage");
            
            InitialContext context = new InitialContext();
            SupplierService supplierService = (SupplierService) context.lookup("java:global/StockManagementSystem/SupplierServiceImpl!com.klef.ep.services.SupplierService");
            
            InputStream inputStream = file.getInputStream();
            Blob blob = new javax.sql.rowset.serial.SerialBlob(getBytesFromInputStream(inputStream));

            Stock stock = new Stock();
            stock.setItemCode(sid);
            stock.setCategory(scategory);
            stock.setItemName(sname);
            stock.setQuantity(qty);
            stock.setUnitPrice(cost);
            stock.setPurchasedate(purchasedate);
            stock.setImagedata(blob);
            stock.setAddedBy(addedBy);

            System.out.print(stock);

            supplierService.addstock(stock);

            response.sendRedirect("insertstockbysupplier.jsp");
        }
        catch(Exception e)
        {
            out.print(e);
        }
    }

    private byte[] getBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }
}
