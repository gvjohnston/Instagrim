<%-- 
    Document   : logout
    Created on : 21-Oct-2016, 22:08:52
    Author     : g_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>instagrim</title>
    </head>
    <body>
        <header>        
            <h1>InstaGrim ! </h1>
            <h2>Your world in Black and White</h2>
            
        </header>
        <article>
            <h3>Log Out</h3>
            <form method="POST" action="Logout">
                <h4>Are you sure you want to log out?</h4>
                <input type="submit" value="Logout">
            </form>
        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/Instagrim">Home</a></li>
            </ul>
        </footer>
    </body>
</html>