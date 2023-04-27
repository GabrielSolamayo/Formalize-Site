<%-- 
    Document   : AcessoUsuario
    Created on : 27 de abr. de 2023, 09:12:31
    Author     : gabriel.esmunoz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formalize</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./conf.css">
        <link rel="stylesheet" type="text/css" href="./menu.css">
    </head>
    <body>
        <!–Azul–>
        <header> 
            <h1 class="titulo">Formalize</h1>
            <p style="margin-right: 1vw">${mens}</p>
        </header>

        <!– Amarelo  –>
        <nav>
            <div class="navbar">
                <a href="./AcessoUsuario.jsp" ">Home</a>
                <a href="./SobreNos.html" target="conteudo">Sobre Nós</a>
                <a href="./CriarFormulario.html" target="conteudo">Criar Formulário</a>
                <a href="./Historico.jsp" target="conteudo">Historico</a>
            </div>
        </nav>

        <!– Vermelho –>
        <main>
            <iframe src="Home.html" name="conteudo"></iframe>
        </main>
   
    <!– Verde –>
    <footer>

    </footer>
</body>
</html>
