<%-- 
    Document   : addNew
    Created on : Oct 19, 2016, 7:37:25 PM
    Author     : Andrii_Kozak1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit</title>
    </head>
    <body>
        <form method="post" action="save">
            <input name="id" type="hidden" value="${entity.id}"><br/>
            <table border="1">
                <tr>
                    <th> Key</th>
                    <th>Value</th>
                </tr>
                <tr>
                    <td><input name="key" type="text" value="${entity.key}"></td>
                    <td><input name="value" type="number" value="${entity.value}"></td>
                </tr>    
            </table>
            <input type="submit" value="save">            
        </form>    
    </body>
</html>
