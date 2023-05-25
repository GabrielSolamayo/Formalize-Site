
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./conf.css">
        <title>Filtrar Formulário</title>
    </head>
    <body>
        <nav>
            <form method="post" action="Controller">
                <input type="hidden" name="flag" value="FiltrarFormulario"/>
                <p>
                    <label for="filtrar">Filtrar:</label>
                    <input type="filtrar" size="50" maxlength="50" name="filtrar" id="filtrar" />
    
                    <select id="opcoes" name="opcoes">
                        <option value="tipoServ">Tipo de Serviço</option>
                        <option value="data">Data</option>
                        <option value="nomeCli">Nome do Cliente</option>
                        <option value="placa">Placa</option>
                    </select>
                    <input type="submit" value="Pesquisar">
                </p>
            </form>
        </nav>
        <main>
            <iframe src="Controller?flag=listarHistorico" name="conteudo"></iframe>
        </main>
        
    </body>
</html>
