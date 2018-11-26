<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>
	<table>

		<tr>
			<td id="image" ><c:url var="imgsrc" value="/img/parks/${park.parkCode}.jpg" />
				<img src="${imgsrc}" /></td>
				
			<td id="parkdetails"><b>Park Code: </b>${park.parkCode}<br> 
			
			<b>Park Name: </b>${park.parkName}<br> 
			<b>State: </b>${park.state}<br>
			<b>Size: </b>${park.acreage} acres<br> 
			<b>Elevation: </b>${park.elevationInFeet} feet<br> 
			<b>Total Miles of Trail: </b>${park.milesOfTrail} miles<br> 
			<b>Total Campsites: </b>${park.numberOfCampsites}<br>
			<b>Climate: </b>${park.climate}<br> 
			<b>Year Founded: </b>${park.yearFounded}<br>
			<b>Annual Visitor Count: </b>${park.annualVisitorCount}<br> <br>
			<b>"${park.inspirationalQuote}"</b><br> <b>~${park.inspirationalQuoteSource}</b><br><br> 
			<b>Park Description: </b>${park.parkDescription}<br>
			<b>Entry Fee: </b>$${park.entryFee}.00<br> 
			<b>Total Animal Species: </b>${park.numberOfAnimalSpecies}</td>
			
			
			
		</tr>
	</table>
	<table>
	<tr>
	
	<c:forEach var="weather" items="${weathers}" >
	<td class="weather">
			<c:if test="${convert == 'fahrenheit' || empty convert}">
			    <h3>
				    High:<fmt:formatNumber type="number" pattern="#" value="${weather.high}"/>&#176;F
				</h3>
				<h3>Low:${weather.low}°F</h3>
			</c:if>

			<c:if test="${convert == 'celcius'}">
				<h3>
					
					High:<fmt:formatNumber type="number" pattern="#" value="${(weather.high - 32) / 1.8}" />&#176;C
					
				</h3>
				<h3>
					
					Low:<fmt:formatNumber type="number" pattern="#" value="${(weather.low - 32) / 1.8}" />&#176;C
						
					
				</h3>
			</c:if>
			
			<c:choose>
				
					<c:when test="${weather.fiveDayForecastValue == 1}">
						<td>

						<div>  <b>&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;TODAY</b><br></div>
							  <p id="forecasttext"><b>${weather.forecast}</b></p><br>
							  
							  <c:url var="imgsrc" value="/img/weather/${weather.forecast}.png" /> 
							  <img src="${imgsrc}" /><br> 
							
							<c:choose>
								<c:when test="${weather.forecast == 'snow'}">
		<marquee><b>Be sure to pack snowshoes!</b></marquee>
		</c:when>
								<c:when test="${weather.forecast == 'rain'}">
		<marquee><b>Be sure to grab a rain coat and your rain boots!</b></marquee>
		</c:when>
								<c:when test="${weather.forecast == 'thunderstorms'}">
		<marquee><b>Please seek shelter and avoid hiking on exposed ridges!</b></marquee>
		</c:when>
								<c:when test="${weather.forecast == 'sunny'}">
		<marquee><b>Be sure to pack your sunblock!</b></marquee>
		</c:when>
							</c:choose><br> <c:choose>
								<c:when test="${weather.high > 75}">
		<marquee><b>Remember to pack an extra gallon water!</b></marquee>
		</c:when>
								<c:when test="${weather.high - weather.low > 20}">
		<marquee><b>Be sure to wear breathable layers!</b></marquee>
		</c:when>
								<c:when test="${weather.low < 20}">
		<marquee><b>Be aware of the dangers of frigid temperature exposure!</b></marquee>
		</c:when>
							</c:choose></td>
					</c:when>
					<c:otherwise>
						<td><c:url var="imgsrc" value="/img/weather/${weather.forecast}.png" /> <img src="${imgsrc}" width="35%" height="25%" class="image"/><br> 
						
					</c:otherwise>

				</c:choose>
				
	
			<c:url value="/convertToFahrenheit" var="fahrenheit"/>
            <c:url value="/convertToCelcius" var="celcius"/>
            </td>
</c:forEach>
</tr>
</table>
<c:if test="${convert == 'fahrenheit' || empty convert}">
<form action="${celcius}" method="POST">
<input type="hidden" id="parkCode" name="parkCode" value="${park.parkCode}">
<p><b>CONVERT TO:</b>
<button class="button2" type="submit" name=celcius value="celcius">CELCIUS</button></p></form>
</c:if>

<c:if test="${convert == 'celcius'}">
<form action="${fahrenheit}" method="POST">
<input type="hidden" id="parkCode" name="parkCode" value="${park.parkCode}">
<p><b>CONVERT TO:</b>
<button class="button3" type="submit" name=fahrenheit value="fahrenheit">FAHRENHEIT</button></p></form>
</c:if>
		
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />