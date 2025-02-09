<%@page import="com.klef.ep.models.Supplier"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%
Supplier supplier = (Supplier) session.getAttribute("supplier");
if(supplier == null)
{
  response.sendRedirect("sessionexpiry.html");
}
%>



<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--========== BOX ICONS ==========-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
        <!--========== CSS ==========-->
        <link rel="stylesheet" href="resources/css/navbar.css">

        <title>Stock Management System</title>
        
        <style>
         @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}
html,body{
  display: grid;
  height: 100%;
  width: 100%;
  place-items: center;
  background: #F9F6FD;
}
::selection{
  color: #fff;
  background: #1cc7d0;
}
 .card {
            background-color: #e6e6fa; /* Light lavender */
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            padding: 30px;
            max-width: 600px;
            width: 100%;
            text-align: center;
        }

        .card .title {
            font-size: 2em;
            font-weight: bold;
            margin-bottom: 20px;
            color: #333333;
        }

        .card p {
            line-height: 1.8;
            font-size: 1.2em;
            color: #444444;
        }

        .card p span {
            font-weight: bold;
            color: #222222;
        }
        </style>
        
    </head>
    <body>
        <!--========== HEADER ==========-->
        <header class="header">
            <div class="header__container">
               

                <a href="#" class="header__logo">StockPro</a>
                
                 <a href="supplierprofile.jsp">
    <img src="resources/images/supplier_profile.png" alt="" class="header__img">
                </a>
    
    
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
    
                            <a href="supplierhome.jsp" class="nav__link active">
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
                                        <a href="supplierprofile.jsp" class="nav__dropdown-item">My Profile</a>
                                        <a href="updatesupplier.jsp" class="nav__dropdown-item">Update Profile</a>
                                    </div>
                                </div>
                            </div>

                            
                        </div>
    
                        <div class="nav__items">
                            <h3 class="nav__subtitle">Manage</h3>
    
                            
                            
                            <div class="nav__dropdown">
                                <a href="#" class="nav__link">
                                    <i class='bx bx-bell nav__icon' ></i>
                                    <span class="nav__name">Manage Stock</span>
                                    <i class='bx bx-chevron-down nav__icon nav__dropdown-icon'></i>
                                </a>

                                <div class="nav__dropdown-collapse">
                                     <div class="nav__dropdown-content">
                                        <a href="insertstockbysupplier.jsp" class="nav__dropdown-item">Add</a>
                                        <a href="viewstocksbysupplier.jsp" class="nav__dropdown-item">View</a>
                                        <a href="viewallstockbysupplier.jsf" class="nav__dropdown-item">Dispatch</a>
                                        <a href="updatestockbysupplier1.jsf" class="nav__dropdown-item">Update</a>
                                        
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
            <section>
                

        <div class="card">
            <div class="title">
              My Profile
            </div>
            <p>
                <%=supplier.getCategory() %> : Supplier <br/>
                
                Name: <%=supplier.getName()%><br/>
                Gender: <%=supplier.getGender()%><br/>
                Age: <%=supplier.getAge()%><br/>
                Category: <%=supplier.getCategory()%><br/>
                Email: <%=supplier.getEmail()%><br/>
                Contact No: <%=supplier.getContactno()%><br/>
            </p>
        </div>

          
      

                
            </section>
        </main>

        <!--========== MAIN JS ==========-->
        <script src="assets/js/main.js"></script>
    </body>
</html>