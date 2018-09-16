<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>Current Weather</title>
        <meta name="layout" content="main" />
    </head>
    <body>
       <g:form controller="home" action="weatherByZip">

           <div class='value ${hasErrors(bean:zipdomain,field:'zipCode','errors')}'>

       <f:field bean="zipdomain" property="zipCode"/>
       </div>
       <openweather:unitSelect id="unitRange" name="unitRange" /><br>
       <input type="submit" value="Check Weather"> 
       </g:form>
    </body>
</html>
