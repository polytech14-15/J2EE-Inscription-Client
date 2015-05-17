<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil </title>
    </head>
    <body>
        <h1>Page d'accueil <%= request.getContextPath () %> </h1>

           <a href="Controleur?action=ajouteInscription">Ajout d'une nouvelle inscription </a>
    </body>
</html>
