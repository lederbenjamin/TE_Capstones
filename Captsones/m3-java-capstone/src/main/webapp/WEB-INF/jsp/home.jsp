<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>
	<div>
		<table>
			<c:forEach var="park" items="${allParks}">
				<div>
					<tr>
						<td><c:url var="parkImageUrl"
								value="/img/parks/${park.parkCode}.jpg" /> 
								<c:url var="parkDetailUrl" value="/parkDetails">
								<c:param name="parkCode" value="${park.parkCode}" />
							</c:url> <a href="${parkDetailUrl}"><img src="${parkImageUrl}"/></a></td>
			
						<td>
							<p id="parkname">${park.parkName}</p>
							<p id ="parkstate">${park.state}</p>
							<p id="description">${park.parkDescription}</p>
						</td>
					</tr>
				</div>
			</c:forEach>
		</table>
	</div>
</section>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />