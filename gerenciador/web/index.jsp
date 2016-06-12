<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/></br>
<c:if test="${usuarioLogado != null}">
    Você está logado como ${usuarioLogado.email}<br/><br/>
</c:if>
<form action="tarefa" method="POST">
    Nome: <input type="text" name="nome"/></br><br/>
    <input type="hidden" name="acao" value="NovaEmpresa" >
    <input type="submit" value="Enviar"/>
</form>
<form action="login" method="post" >
    Email: <input type="text" name="email"/></br></br>
    Senha: <input type="password" name="senha"/></br></br>
    <input type="submit" value="Login"/></br></br>
</form>
<form action="tarefa" method="POST">
    <input type="hidden" name="acao" value="Logout" >
    <input type="submit" value="Logout"/>
</form>
</body>
</html>