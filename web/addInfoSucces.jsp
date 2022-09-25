<%-- 
   Document   : addInfoSucces
   Created on : Jul 12, 2022, 8:52:43 AM
   Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.CarInfo" %>
<!DOCTYPE html>
<html>
    <body>
        <h1>เพิ่มสำเร็จ</h1>
        <%
            CarInfo info = (CarInfo) session.getAttribute("info");
        %>
        ยี่ห้อ:<%= info.getBrand()%><br/>
        รุ่น:<%= info.getModel()%><br/>
        แรงม้า:<%= info.getHorse_power()%><br/>
        ราคา:<%= info.getPrice()%><br/>
        <a href="updateInfo.jsp">แก้ไข</a>
        <a href="saveToFirebase.jsp">save to firebase</a>
    </body>
</html>
