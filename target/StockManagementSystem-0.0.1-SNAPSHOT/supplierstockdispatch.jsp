<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>

<html>
<head>
    <title>Dispatch Quantity</title>
    <link rel="stylesheet" href="resources/css/style.css"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #E6E6FA; /* Light lavender background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 50%;
            max-width: 500px;
            margin: auto;
        }

        h3 {
            margin-bottom: 20px;
            color: #333;
        }

        table {
            width: 100%;
        }

        td {
            padding: 10px;
            text-align: left;
        }

        .button {
            background-color: #4CAF50; /* Green */
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3 align="center"><u>Dispatch Quantity</u></h3>
        <center>
            <form method="post" action="dispatch.jsp">
                <table align="center">
                    <input type="hidden" name="totalquantity" value="${param.stkQty}">
                    <input type="hidden" name="itemCode" value="${param.itemCode}">
                    <tr>
                        <td>Total Quantity:</td>
                        <td>${param.stkQty}</td>
                    </tr>
                    <tr>
                        <td><b>Enter Quantity to Dispatch</b></td>
                        <td>
                            <input type="number" name="quantity" required>
                        </td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <input class="button" type="submit" value="Dispatch">
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </div>
</body>
</html>
