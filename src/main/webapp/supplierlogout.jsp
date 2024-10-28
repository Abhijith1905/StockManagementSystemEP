<%
  session.removeAttribute("supplier");
  response.sendRedirect("login.jsf");
%>