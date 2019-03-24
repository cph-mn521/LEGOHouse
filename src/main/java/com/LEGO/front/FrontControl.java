/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LEGO.front;

import com.LEGO.logic.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet controlling the flow GET and POST commands from homepage
 *
 */
@WebServlet(name = "Control", urlPatterns = {"/control"})
public class FrontControl extends HttpServlet {

    /**
     * Object declaration for use when java dynamic pages needs to be created
     */
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Controller C = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String origin = request.getParameter("origin");

        /**
         * Depending on the value of parameter "origin" dispatches to different
         * pages or java classes
         */
        switch (origin) {
            case "login1":
                //response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
                request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
                break;
            case "registration1":
                request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
                break;
            case "shop":
                request.getRequestDispatcher("jsp/Shop.jsp").forward(request, response);
            case "login":
                if (C.loginCheck(request.getParameter("username"), request.getParameter("password"), request)) {
                    C.CreateCart(request);
                    response.sendRedirect("/LEGOHouse2");
                } else {
                    request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
                }
                break;
            case "logout":
                C.logOut(request);
                response.sendRedirect("/LEGOHouse2");
                break;
            case "registration":
                if (C.createUser(request.getParameter("username"), request.getParameter("password"),
                        request.getParameter("email"), request)) {
                    response.sendRedirect("/LEGOHouse2");
                } else {
                    request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
                }
                break;
            case "addtocart":
                    C.addToCart(request);
                    request.getRequestDispatcher("jsp/Shop.jsp").forward(request, response);
                break;
            case "cart":
                request.getRequestDispatcher("jsp/cart.jsp").forward(request, response);
            default:
                throw new AssertionError();
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
