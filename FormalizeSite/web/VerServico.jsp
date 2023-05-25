<%-- 
    Document   : VerServico
    Created on : 25 de mai. de 2023, 09:02:01
    Author     : gabriel.esmunoz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver Servico</title>
        <link rel="stylesheet" href="formulario.css" />
    </head>
    <body>
        <form method="POST" action="Controller" class="formulario-content">
            <div>
                <label id="tipo">Tipo de Serviço</label>
                <input type="text" size="22" name="tipoS"  value="<%= request.getParameter("tipoServ")%>" readonly>
            </div>
            <div class="nomSob">
                <label for="nomeC">Nome</label>
                <input type="text" size="22" id="nomeC" name="nomeCliente" required maxlength="60" minlength="4" value="<%= request.getParameter("nomeCli")%>" readonly>

                <label for="marcaV">Marca</label>
                <input type="text" size="22" id="marcaV" name="marcaVeiculo" required maxlength="20" minlength="5" value="<%= request.getParameter("marcaVei")%>" readonly>
            </div>

            <div class="nomSob">
                <label for="emailC">E-mail</label>
                <input type="text" size="22" id="emailC" name="emailCliente"  maxlength="45" minlength="4" value="<%= request.getParameter("emailCli")%>" readonly>

                <label for="modeloV">Modelo</label>
                <input type="text" size="22" id="modeloV" name="modeloVeiculo"  maxlength="20" minlength="5" value="<%= request.getParameter("modeloVei")%>" readonly>
            </div>

            <div class="nomSob">
                <label for="cpfC">CPF</label>
                <input type="text" size="22" id="cpfC" name="cpfCliente"  maxlength="11" minlength="4" value="<%= request.getParameter("cpfCli")%>" readonly>

                <label for="placaV">Placa</label>
                <input type="text" size="22" id="placaV" name="placaVeiculo"  maxlength="7" minlength="5" value="<%= request.getParameter("placaVei")%>" readonly> 
            </div>

            <div class="nomSob">
                <label for="telefoneC">Telefone</label>
                <input type="text" size="22" id="telefoneC" name="telefoneCliente"  maxlength="11" minlength="4" value="<%= request.getParameter("telefoneCli")%>" readonly>

                <label for="tipoV">Tipo</label>
                <input type="text" size="22" id="tipoV" name="tipoVeiculo"  maxlength="20" minlength="5" value="<%= request.getParameter("tipoVei")%>" readonly>
            </div>
            <div class="nomSob">
                <label for="enderecoC">Endereço</label>
                <input type="text" size="22" id="enderecoC" name="enderecoCliente"  maxlength="90" minlength="4" value="<%= request.getParameter("enderecoCli")%>" readonly>

                <label for="anoV">Ano</label>
                <input type="text" size="22" id="anoV" name="anoVeiculo"  maxlength="4" minlength="4" value="<%= request.getParameter("anoVei")%>" readonly>
            </div>
            <div class="nomSob">
                <label for="valor">Valor do Serviço</label>
                <input type="text" pattern="[0-9]+([,\.][0-9]+)?" size="22" id="valor" name="valor"  maxlength="20" minlength="4" value="<%= request.getParameter("valor")%>" readonly>
            </div>

        </form>
    </body>
</html>
