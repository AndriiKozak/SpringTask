<%-- 
    Document   : selectFile
    Created on : Oct 21, 2016, 6:12:44 PM
    Author     : Andrii_Kozak1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>select file to upload</title>
    </head>
    <body>
        Select path to .csv file with entities.<br/>
        <form method="POST" action="uploadFile" enctype="multipart/form-data">
            File to upload: <input type="file" name="file"/><br/> 
            <input type="submit" value="Upload"/> Press here to upload the file!
        </form>
        Select path to .tar.gz file containing .csv file with entities.<br/>
        <form method="POST" action="uploadTarFile" enctype="multipart/form-data">
            File to upload: <input type="file" name="file"/><br/> 
            <input type="submit" value="Upload"/> Press here to upload the file!
        </form>
    </body>
</html>
