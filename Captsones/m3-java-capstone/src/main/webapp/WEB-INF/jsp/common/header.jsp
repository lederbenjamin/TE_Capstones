<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>National Park Geek</title>
 <c:url value="/css/npgeek.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}"> 
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>

<body>
	<header>
		<c:url value="/home" var="homePageHref" />
		<c:url value="/img/logo.png" var="logoSrc" />
		<a href="${homePageHref}"> <img src="${logoSrc}" width="25%" height="25%" 
			alt="National Park Geek logo" />
		</a>
		
	</header>
	<c:url value="/home" var="home" />
	<c:url value="/surveyInput" var="survey" />

	<nav class="topnav">
		
		<ul id="homepagelinks">
			<a href="${home}">Home</a>
			<a href="${survey}">Survey</a>
			
		</ul>
	</nav>