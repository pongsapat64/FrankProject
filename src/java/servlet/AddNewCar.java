/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CarInfo;

/**
 *
 * @author HP
 */
public class AddNewCar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            CarInfo info = (CarInfo) session.getAttribute("info");
            
            
          if (info == null) {
            String brand = request.getParameter("brand");
            String model = request.getParameter("model");
            int horse_power = Integer.parseInt(request.getParameter("horse_power"));
            int price = Integer.parseInt(request.getParameter("price"));
            info= new CarInfo();
            info.setBrand(brand);
            info.setModel(model);
            info.setHorse_power(horse_power);
            info.setPrice(price);
            
            
            session.setAttribute("carModel", info);
            out.println("<html><body>");
            out.println("<form action='AddNewCar'>");
            out.println(info.getBrand() + " "  + info.getModel() +" " + info.getHorse_power() + " " + info.getPrice() + "<br/>");
            out.println("<input type='submit' value='แก้ไข'>");
            out.println("</form></body></html>");
        }
          
          
          else {
              out.println("<form action='AddNewCar>'");
              out.println("Brand: <input type='text' name='brand' value= '" 
                      + info.getBrand() + "'><br/>");
              out.println("Model: <input type='text' name='model' value= '" 
                      + info.getModel() + "'><br/>");
              out.println("Horse_Power: <input type='text' name='horse_power' value= '" 
                      + info.getHorse_power() + "'><br/>");
              out.println("Price: <input type='text' name='price' value= '" 
                      + info.getPrice() + "'><br/>");
              out.println("<input  type='submit' value='แก้ไข'>");
              out.println("</form></body></html>");
            
            session.removeAttribute("info");
          }

          
    
    } catch (Exception e) {
            response.sendRedirect("addNewCar.html");
    }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    }
