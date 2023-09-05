<%-- 
    Document   : index
    Created on : 28 de ago. de 2023, 20:23:53
    Author     : Gustavo Matheus Pauvels
--%>

<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="erro" class="java.lang.String" scope="session"/>
<jsp:useBean id="financiamento" class="modelo.Financiamento" scope="session"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simulação de Financiamento</title>
    </head>

    <body>
            <h2>Insira as informações para a simulação do financiamento: </h2>

            <form action="calcular" method="POST">
                Valor Financiado: <input type="text" name="valor" size="20"><br/>
                Taxa de juros: <input type="text" name="taxa" size="20"><br/>
                Custo mensal: <input type="text" name="custo" size="20"><br/>
                Prazo para pagar: <input type="text" name="prazo" size="20"><br/>
                <input type="submit" value="Calcular">
            </form>
            
            <form action="limpar" method="POST">
                <input type="submit" value="Limpar"/>
            </form>

   <%--      <c:if test="${not empty financiamento.valorFinanciado and not empty financiamento.taxaJuros and not empty financiamento.custoMensal and not empty financiamento.prazoTotal}">
        </c:if> --%>

        <c:if test="${not empty erro}">
            <span style="color: red;"> ${erro} </span>
        </c:if>
        <c:remove var="erro" scope="session"/>
    </body>
</html>
