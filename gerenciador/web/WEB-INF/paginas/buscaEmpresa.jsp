<%-- 
    Document   : buscaEmpresa
    Created on : Jun 12, 2016, 4:20:50 PM
    Author     : regis
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        Resultado da busca:
        <ul>
            <c:forEach var="empresa" items="${empresas}" >
                <li>${empresa.id}: ${empresa.nome}</li>
            </c:forEach>
        </ul>
    </body>
</html>
