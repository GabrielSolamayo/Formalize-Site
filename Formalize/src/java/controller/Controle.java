/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author solam
 */
@WebServlet(name = "Controle", urlPatterns = {"/Controle"})
public class Controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag, mensagem;
        PrintWriter out = response.getWriter();
        flag = request.getParameter("flag");
        if(flag.equalsIgnoreCase("login")){
            String user, password;
            user = request.getParameter("usuario");
            password = request.getParameter("senha");
            FormalizeDAO dao = new FormalizeDAO();
            Acesso acesso = dao.validarLogin(user, password);
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

    
    
    
    
    
    
    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
