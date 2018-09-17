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
        <g:form class="form-signin" controller="home" action="weatherByZip">
            <div class="container">
            <div class="form-row">
            <div class="col-lg">
         
                <div class="md-form">
                <label for="zipCode">Zip Code:</label>
                <div class='value ${hasErrors(bean:zipdomain,field:'zipCode','errors')}'>
                <g:field class="form-control" name="zipCode" type="number" maxlength="5"/>
            </div>
            </div>
            </div>
            </div>
            <br>
            <div class="col-lg">
                <div class="md-form">
            <label for="unitRange">Unit Type:</label><openweather:unitSelect class="form-control" id="unitRange" name="unitRange" /><br>
            </div>
            </div>
           
            
            <div class="col-lg">
                <div class="md-form">
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Check Weather"> 
            </div>
            </div>
            
            </div>
    </g:form>
</body>
</html>
