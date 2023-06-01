

<%@page import="model.Servico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Listar Historico</title>
    </head>
    <body>
        <%
            List<Servico> listaServicos = (List<Servico>) request.getAttribute("listarServicos");
            Servico s = listaServicos.get(0);
            Servico s1 = listaServicos.get(1);            
        %>
               
        <table>
            <tr>
                <th>Tipo de Serviço</th>
                <th>Nome</th>
                <th>Placa</th>
                <th>Valor</th>
                <th>Data</th>
            </tr>
            <%
                for(Servico servico : listaServicos){
            %>
            <tr>
                <td><%= servico.getTipoServico() %></td>//<%--tag usada para exibir (<%= %> --%>
                <td><%= servico.getPlaca().getIdCliente().getNome() %></td>
                <td><%= servico.getPlaca().getPlaca() %></td>
                <td><%= servico.getValorServ() %></td>
                <td><%= servico.getDataServico() %></td>
                <td><a href="Controller?flag=ExcluirServico&idServ=<%= servico.getIdServico() %>">Excluir</a></td>
                <td><a href="AlterarServico.jsp?tipoServ=<%= servico.getTipoServico() %>&nomeCli=<%= servico.getPlaca().getIdCliente().getNome() %>&emailCli=<%= servico.getPlaca().getIdCliente().getEmail() %>&cpfCli=<%= servico.getPlaca().getIdCliente().getCpf() %>&telefoneCli=<%= servico.getPlaca().getIdCliente().getTelefone() %>&enderecoCli=<%= servico.getPlaca().getIdCliente().getEndereco()%>&marcaVei=<%= servico.getPlaca().getMarca() %>&modeloVei=<%= servico.getPlaca().getModelo() %>&placaVei=<%= servico.getPlaca().getPlaca() %>&tipoVei=<%= servico.getPlaca().getTipo() %>&anoVei=<%= servico.getPlaca().getAno() %>&valor=<%= servico.getValorServ() %>&idServ=<%= servico.getIdServico() %>&idCli=<%= servico.getPlaca().getIdCliente().getIdCliente() %>">Alterar</a></td>
                <td><a href="VerServico.jsp?tipoServ=<%= servico.getTipoServico() %>&nomeCli=<%= servico.getPlaca().getIdCliente().getNome() %>&emailCli=<%= servico.getPlaca().getIdCliente().getEmail() %>&cpfCli=<%= servico.getPlaca().getIdCliente().getCpf() %>&telefoneCli=<%= servico.getPlaca().getIdCliente().getTelefone() %>&enderecoCli=<%= servico.getPlaca().getIdCliente().getEndereco()%>&marcaVei=<%= servico.getPlaca().getMarca() %>&modeloVei=<%= servico.getPlaca().getModelo() %>&placaVei=<%= servico.getPlaca().getPlaca() %>&tipoVei=<%= servico.getPlaca().getTipo() %>&anoVei=<%= servico.getPlaca().getAno() %>&valor=<%= servico.getValorServ() %>&idServ=<%= servico.getIdServico() %>&idCli=<%= servico.getPlaca().getIdCliente().getIdCliente() %>">Ver</a></td>
            </tr>
            <%
            }
            %>
        </table>
    </body>
</html>
