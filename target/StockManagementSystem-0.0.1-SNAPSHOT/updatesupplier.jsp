<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="com.klef.ep.services.SupplierService"%>
<%@page import="com.klef.ep.models.Supplier"%>

<%
Supplier sup = (Supplier) session.getAttribute("supplier");
if (sup == null) {
    response.sendRedirect("sessionexpiry.html");
}
%>
<html>
<head>
    <title>Supplier Home</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

        body {
            background-color: #E6E6FA; 
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            padding: 20px;
            margin: 0;
            font-family: 'Poppins', sans-serif;
        }
        .container {
            max-width: 600px;
            width: 100%;
            background: #fff;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .container header {
            text-align: center;
            margin-bottom: 20px;
        }
        .container form {
            display: flex;
            flex-direction: column;
        }
        .container label {
            margin-bottom: 5px;
            font-weight: 500;
        }
        .container input[type="text"],
        .container input[type="password"],
        .container input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 6px;
            font-size: 1rem;
            color: #707070;
            margin-bottom: 15px; 
        }
        .button {
            height: 55px;
            width: 100%;
            color: #fff;
            font-size: 1rem;
            font-weight: 400;
            margin-top: 30px;
            border: none;
            cursor: pointer;
            transition: all 0.2s ease;
            background: rgb(130, 106, 251);
        }
        .button:hover {
            background: rgb(88, 56, 250);
        }
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h3>Update My Profile</h3>
        </header>
        <form method="post" action="profileupdate.jsp">
            <input type="hidden" name="id" value="<%=sup.getId()%>" readonly required>

            <label for="name">Enter Name</label>
            <input type="text" id="name" name="name" value="<%=sup.getName()%>" required minlength="3" maxlength="30" title="Name should be between 3 and 30 characters.">

            <label for="password">Enter Password</label>
            <input type="password" id="password" name="password" value="<%=sup.getPassword()%>" required minlength="3" maxlength="30" title="Password should be between 3 and 30 characters.">

            <label for="contact">Enter Contact</label>
<input type="text" id="contact" name="contact" value="<%=sup.getContactno()%>" required pattern="^[6-9]\d{9}$" title="Contact number should be exactly 10 digits and start with 6, 7, 8, or 9.">


            <input class="button" type="submit" value="Update">
        </form>
    </div>
</body>
</html>
