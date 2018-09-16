<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="main" />
        <title>Sample title</title>
    </head>
    <body>
        <g:if test="${currentWeather.weather}">
            <g:each in="${currentWeather.weather}" var="weather">
                <div class="weatherBlock">
                    <h2><b>${currentWeather.name}</b></h2>
                    <h3>${currentWeather.main?.temp} <openweather:temperatureSymbol unit="${unit}"/></h3>
                    <openweather:image icon="${weather.icon}"/>
                    <h4>${weather.description}</h4>
                </div>
            </g:each>
        </g:if>
    </body>
</html>
