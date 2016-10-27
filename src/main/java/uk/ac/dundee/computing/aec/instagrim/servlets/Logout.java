/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.servlets;

import com.datastax.driver.core.Cluster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.models.User;
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;

/**
 *
 * @author g_000
 */
@WebServlet(name = "Logout", urlPatterns = {"/Logout","/Logout/*"})
public class Logout extends HttpServlet {

    Cluster cluster=null;


    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
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
        
            String username=request.getParameter("username");
            String password=request.getParameter("password");
            //Assumes doPost receives username and password from existing connection. Could not test.
                        
            HttpSession session=request.getSession();
            session.removeAttribute(username);
            session.invalidate();
            // HttpSession should have now terminated the session belonging to "username"
                           
            LoggedIn lg= new LoggedIn();
            lg.setUsername(username);
            lg.setLogedout();
            //request.setAttribute("LoggedIn", lg);
            
            //Logedin boolean for LoggedIn object for "Username" should be set to false now
            
            session.setAttribute("LoggedIn", lg);
            //System.out.println("Session in servlet "+session);
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
//        
//        Assumed to always work so failure condition bellow commented out
//        }else{
//            response.sendRedirect("/Instagrim/logout.jsp");
//        }
        
        
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
