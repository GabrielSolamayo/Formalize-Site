/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Acesso;
import model.Cliente;
import model.Colaborador;
import model.FormalizeDAO;
import model.Servico;
import model.Veiculo;

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
        FormalizeDAO dao = new FormalizeDAO();
        flag = request.getParameter("flag");
        if(flag.equalsIgnoreCase("login")){
            String user ,password;
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
            
        }else if(flag.equalsIgnoreCase("CriarFormulario")){
            
            Servico servico = new Servico();
            Veiculo veiculo = new Veiculo();
            Cliente cliente = new Cliente();
            
            cliente.setNome(request.getParameter("nomeCliente"));
            cliente.setEmail(request.getParameter("emailCliente"));
            cliente.setCpf(request.getParameter("cpfCliente"));
            cliente.setEndereco(request.getParameter("enderecoCliente"));
            cliente.setTelefone(request.getParameter("telefoneCliente"));
            int resp1 = new FormalizeDAO().criarCli(cliente);
            
            
            veiculo.setPlaca(request.getParameter("placaVeiculo"));
            veiculo.setIdCliente(cliente);
            veiculo.setMarca(request.getParameter("marcaVeiculo"));
            veiculo.setModelo(request.getParameter("modeloVeiculo")); 
            veiculo.setTipo(request.getParameter("tipoVeiculo"));
            veiculo.setAno(request.getParameter("anoVeiculo"));
            
            int resp2 = new FormalizeDAO().criarVei(veiculo);
            
            servico.setTipoServico(request.getParameter("tipoS"));
            float valor = Float.parseFloat(request.getParameter("valor").replace(',', '.'));//Convertendo para float o 'text' do formulario;
            servico.setValorServ(valor);
            servico.setPlaca(veiculo);
            LocalDate dataAtual = LocalDate.now();
            Date dataA = Date.from(dataAtual.atStartOfDay(ZoneId.systemDefault()).toInstant());
            servico.setDataServico(dataA);
            
            


            int resp = new FormalizeDAO().criarForm(servico);
            
            switch (resp) {
                case 1:
                    mensagem = "Formulario salvo com sucesso";
                    break;
                case 2:
                    mensagem = "Erro ao tentar criar";
                    break;
                default:
                    mensagem = "Entre em contato com o administrador";
                    break;
            }
        }else if (flag.equalsIgnoreCase("listarHistorico")){
            List<Servico> servico = dao.listarServico();
            request.setAttribute("listarServicos", servico);
            RequestDispatcher disp = request.getRequestDispatcher("ListarHistorico.jsp");
            disp.forward(request, response);
            
        }else if(flag.equalsIgnoreCase("ExcluirServico")){
            int idServ = Integer.parseInt(request.getParameter("idServ"));
            int resultado = dao.excluirServico(idServ);
            if(resultado == 1){
                mensagem = "Servico excluído com sucesso";
            }else if(resultado == 2){
                mensagem = "Servico '"+idServ+"' nao existe";
            }else{
                mensagem = "Erro ao tentar excluir o Servico";
            }
            request.setAttribute("m", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("MensagensErro.jsp");
            disp.forward(request, response);
            
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
