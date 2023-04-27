/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Acesso;
import model.FormalizeDAO;

/**
 *
 * @author gabriel.esmunoz
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag, mensagem;
        flag = request.getParameter("flag");
        if(flag.equalsIgnoreCase("login")){
            String user, password;
            user = request.getParameter("usuario");
            password = request.getParameter("senha");
            
            Acesso acesso = new FormalizeDAO().validarLogin(user, password);
            if(acesso == null){
                request.setAttribute("m", "Usuário não encontrado seu PATIFE >:C");
                RequestDispatcher disp = request.getRequestDispatcher("MensagensErro.jsp");
                disp.forward(request, response);
            }else{
                String nome;
                nome = acesso.getColaborador().getNome();
                mensagem = "Bem vindo " +nome;
                request.setAttribute("mens", mensagem);
                RequestDispatcher disp = request.getRequestDispatcher("AcessoUsuario.jsp");
                disp.forward(request, response);
            }
            
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
