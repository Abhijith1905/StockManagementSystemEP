<%@page import="com.klef.ep.models.Admin"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%@page import="com.klef.ep.services.*" %>
<%
Admin admin = (Admin) session.getAttribute("admin");
if(admin == null)
{
  response.sendRedirect("sessionexpiry.html");
}
InitialContext context = new InitialContext();
AdminService adminService = (AdminService) context.lookup("java:global/StockManagementSystem/AdminServiceImpl!com.klef.ep.services.AdminService");
long stockcount = adminService.stockcount();
long suppliercount=adminService.suppliercount();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--========== BOX ICONS ==========-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">

    <!--========== CSS ==========-->
    <link rel="stylesheet" href="resources/css/navbar.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

    <title>Stock Management System</title>
    <style>
        body {
            margin-top: 20px;
            background: #FAFAFA;
        }
        .order-card {
            color: #fff;
            border-radius: 5px;
            box-shadow: 0 1px 2.94px 0.06px rgba(4,26,55,0.16);
            border: none;
            margin-bottom: 30px;
            transition: all 0.3s ease-in-out;
            padding: 20px;
        }
        .bg-c-blue {
            background: linear-gradient(45deg,#4099ff,#73b4ff);
        }
        .bg-c-green {
            background: linear-gradient(45deg,#2ed8b6,#59e0c5);
        }
        .bg-c-yellow {
            background: linear-gradient(45deg,#FFB64D,#ffcb80);
        }
        .bg-c-pink {
            background: linear-gradient(45deg,#FF5370,#ff869a);
        }
        .card-block {
            padding: 25px;
        }
        .order-card i {
            font-size: 26px;
        }
        .f-left {
            float: left;
        }
        .f-right {
            float: right;
        }
        .main-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .card-container {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
            width: 80%;
        }
        .card {
            flex: 1;
            margin: 0 10px;
        }
        .heading {
            text-align: center;
            margin-bottom: 20px;
        }
        .welcome {
            text-align: center;
            font-size: 1.5em;
            margin-top: 20px;
        }
    </style>
</head>
    <body>
        <!--========== HEADER ==========-->
        <header class="header">
            <div class="header__container">
               

                <a href="#" class="header__logo">StockPro</a>
                
                 <img src="resources/images/supplier_profile.png" alt="" class="header__img">
    
                <!-- <div class="header__search">
                    <input type="search" placeholder="Search" class="header__input">
                    <i class='bx bx-search header__icon'></i>
                </div> -->
    
                <div class="header__toggle">
                    <i class='bx bx-menu' id="header-toggle"></i>
                </div>
            </div>
        </header>

        <!--========== NAV ==========-->
        <div class="nav" id="navbar">
            <nav class="nav__container">
                <div>
                    <a href="#" class="nav__link nav__logo">
                        <i class='bx bxs-disc nav__icon' ></i>
                        <span class="nav__logo-name">StockPro</span>
                    </a>
    
                    <div class="nav__list">
                        <div class="nav__items">
                            <h3 class="nav__subtitle">Profile</h3>
    
                            <a href="adminhome.jsp" class="nav__link active">
                                <i class='bx bx-home nav__icon' ></i>
                                <span class="nav__name">Home</span>
                            </a>
                            
                            <div class="nav__dropdown">
                                <a href="#" class="nav__link">
                                    <i class='bx bx-user nav__icon' ></i>
                                    <span class="nav__name">Profile</span>
                                    <i class='bx bx-chevron-down nav__icon nav__dropdown-icon'></i>
                                </a>

                                <div class="nav__dropdown-collapse">
                                    <div class="nav__dropdown-content">
                                        <a href="adminhome.jsp" class="nav__dropdown-item">My Profile</a>
                                        
                                    </div>
                                </div>
                            </div>

                            
                        </div>
    
    					<a href="addadmin.jsf" class="nav__link">
                                <i class='bx bx-user nav__icon' ></i>
                                <span class="nav__name">Add Admin</span>
                            </a>
                            
                        <div class="nav__items">
                            <h3 class="nav__subtitle">Manage</h3>
    
                            <div class="nav__dropdown">
                                <a href="#" class="nav__link">
                                    <i class='bx bx-bell nav__icon' ></i>
                                    <span class="nav__name">Manage Suppliers</span>
                                    <i class='bx bx-chevron-down nav__icon nav__dropdown-icon'></i>
                                </a>

                                <div class="nav__dropdown-collapse">
                                    <div class="nav__dropdown-content">
                                        <a href="supplierreg.jsf" class="nav__dropdown-item">Add</a>
                                        <a href="viewallsuppliers.jsf" class="nav__dropdown-item">View</a>
                                        <a href="updatesupplierbyadmin1.jsf" class="nav__dropdown-item">Update</a>
                                        
                                    </div>
                                </div>

                            </div>
                            
                            <div class="nav__dropdown">
                                <a href="#" class="nav__link">
                                    <i class='bx bx-bell nav__icon' ></i>
                                    <span class="nav__name">Manage Stock</span>
                                    <i class='bx bx-chevron-down nav__icon nav__dropdown-icon'></i>
                                </a>

                                <div class="nav__dropdown-collapse">
                                    <div class="nav__dropdown-content">
                                        <a href="insertstock.jsp" class="nav__dropdown-item">Add</a>
                                        <a href="viewstocks.jsp" class="nav__dropdown-item">View </a>
                                       
                                        <a href="updatestock.jsf" class="nav__dropdown-item">Update</a>
										<a href="viewallstock.jsf" class="nav__dropdown-item">Delete</a>
                                        
                                    </div>
                                </div>

                            </div>

                            <a href="#" class="nav__link">
                                <i class='bx bx-compass nav__icon' ></i>
                                <span class="nav__name">Explore</span>
                            </a>
                            <a href="#" class="nav__link">
                                <i class='bx bx-bookmark nav__icon' ></i>
                                <span class="nav__name">Saved</span>
                            </a>
                        </div>
                    </div>
                </div>

                <a href="login.jsf" class="nav__link nav__logout">
                    <i class='bx bx-log-out nav__icon' ></i>
                    <span class="nav__name">Log Out</span>
                </a>
            </nav>
        </div>

         <!--========== CONTENTS ==========-->
    <main>
        <section class="main-container">
            <div class="heading">
                <h1>Welcome to Stock Management System</h1>
            </div>
            <div class="welcome">
                <p>Welcome, <%= admin.getUsername() %></p>
            </div>
            <div class="card-container">
                <div class="card bg-c-green order-card">
                    <div class="card-block">
                        <h6 class="m-b-20">Total Suppliers</h6>
                        <h2 class="text-right"><i class="fa fa-users f-left"></i><span><%= suppliercount %></span></h2>
                        <p class="m-b-0">Suppliers Count:<span class="f-right"><%= suppliercount %></span></p>
                    </div>
                </div>
                <div class="card bg-c-yellow order-card">
                    <div class="card-block">
                        <h6 class="m-b-20">Total Stocks</h6>
                        <h2 class="text-right"><i class="bx bx-line-chart f-left"></i><span><%= stockcount %></span></h2>
                        <p class="m-b-0">Stock Count:<span class="f-right"><%= stockcount %></span></p>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <!--========== MAIN JS ==========-->
</body>
</html>
