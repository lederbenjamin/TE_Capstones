<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section>
<c:url var="surveyoutput" value="/surveyOutput" />
<table>
	<tr>
   <th><b>Park</b></th>
   <th><b>Survey Count</b></th>
 	</tr>


<c:forEach items="${surveys}" var="survey">
<tr>

<td><c:url var="imgsrc" value="/img/parks/${fn:toLowerCase(survey.parkCode)}.jpg" /><img src="${imgsrc}" width="25%" height="25%"/>
${survey.parkName}</td>
<td>${survey.totalSurveys}</td>

</tr>
</c:forEach>
</table>

</section>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />