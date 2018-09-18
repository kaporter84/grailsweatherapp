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
            <div class="col-centered">
                <div class="row">

                    <g:if test="${currentWeather != null}">
                        <g:if test="${currentWeather.weather}">
                            <g:each in="${currentWeather.weather}" var="weather">
                                <div class="col-sm-4 col-lg-4">
                                    <div class="weatherBlock">
                                        <h2><b>${currentWeather.name}</b></h2>
                                        <h3>${currentWeather.main?.temp} <openweather:temperatureSymbol unit="${unit}"/></h3>
                                        <openweather:image icon="${weather.icon}"/>
                                        <h4>${weather.description}</h4>
                                    </div>
                                </div>
                            </g:each>

                        </g:if>
                    </g:if>

                    <g:elseif test="${currentWeather == null}">
                        <div class="col">
                            <div class="alert alert-danger">
                                <strong><g:message code="weatherform.invalidzipcode"/></strong>
                            </div>
                        </div>
                    </g:elseif>
                </div>
            </div>
        </div>
    </body>
</html>
