<%-- 
    Document   : hello
    Created on : Oct 18, 2016, 7:42:04 PM
    Author     : Andrii_Kozak1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>list of all entities</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Key</th>
                <th>Value</th>            
            </tr> 
            <c:forEach var="entity" items="${entities}"> 
                <tr>        
                    <td>${entity.key}</td>
                    <td>${entity.value}</td>
                    <td><form method="Post" action="addNew">
                            <input type ="hidden" name="id" value="${entity.id}"/>
                            <input type="submit" value="edit"/>
                        </form></td>
                    <td><form method="Post" action="delete"/>
                        <input type ="hidden" name="id" value="${entity.id}"/>
                        <input type="submit" value="delete"/>
                        </form></td>    
                </tr>
            </c:forEach>
        </table>
        <a href="addNew">Add new entity</a><br/>
        <a href="selectFile">Upload .csv file with entities</a>
    </body>
</html>
