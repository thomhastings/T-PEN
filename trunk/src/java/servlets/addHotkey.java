
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import textdisplay.Hotkey;

/**
 *
 * servlet for adding a new Hotkey. This needs to be done asynchronously, hence the servlet.
 */
public class addHotkey extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            if (request.getParameter("UID") != null) {
                        int ctr = 1;
                        int UID=Integer.parseInt(request.getParameter("UID"));
                        while (new Hotkey(UID, ctr).exists()) {
                            ctr++;
                        }
                        new Hotkey(110,UID, ctr);
                        out.print(""+ctr);
                        return;
                    }
            if (request.getParameter("projectID") != null) {
                    int projectID=Integer.parseInt(request.getParameter("projectID"));
                        int ctr = 1;
                        while (new Hotkey(projectID, ctr, true).exists()) {
                            ctr++;
                        }
                        new Hotkey(42,projectID, ctr, true);
                        out.print(""+ctr);
                        return;

                    }
        } catch (SQLException ex) {
            Logger.getLogger(addTag.class.getName()).log(Level.SEVERE, null, ex);
        } finally { 
            out.close();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
