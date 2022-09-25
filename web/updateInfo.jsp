<%-- 
    Document   : updateInfo
    Created on : Jul 12, 2022, 9:25:15 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.CarInfo" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>แก้ไขข้อมูล</h1>
        <%
            CarInfo info = (CarInfo) session.getAttribute("info");
        %>
        <form action="AddNewInfo">
            ยี่ห้อ:<input type="text" name="brand" value="<%= info.getBrand()%>"><br/>
            รุ่น:<input type="text" name="model" value="<%= info.getModel()%>"><br/>
            แรงม้า:<input type="text" name="horse_power" value="<%= info.getHorse_power()%>"><br/>
            ราคา:<input type="text" name="price" value="<%= info.getPrice()%>"><br/>
            <input type="submit" value="แก้ไข">
            <a href="saveToFirebase.jsp">save to firebase</a>
            </form>
        <% session.removeAttribute("info"); %>
    </body>
</html>
