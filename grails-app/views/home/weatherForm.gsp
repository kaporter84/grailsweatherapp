<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main" />
    </head>
    <body>
        <div class="container">
            <g:form class="form-signin" controller="home" action="weatherByZip">
                <div class="row">
                    <g:if test="${zipdomain.invalidZipCode}">
                        <div class="col-lg">
                            <div class="alert alert-danger">
                                <strong><g:message code="weatherform.invalidzipcode"/></strong>
                            </div>
                        </div>
                    </g:if>
                </div>
                <div class="form-row">
                    <div class="col-lg">
                        <div class="md-form">
                            <label for="zipCode"><g:message code="weatherform.zipcodelabel"/></label>
                            <div class='value ${hasErrors(bean:zipdomain,field:'zipCode','errors')}'>
                                <g:field class="form-control" name="zipCode" type="number" maxlength="5"/>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <div class="col-lg">
                    <div class="md-form">
                        <label for="unitRange"><g:message code="weatherform.unitlabel"/></label><openweather:unitSelect class="form-control" id="unitRange" name="unitRange" /><br>
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
