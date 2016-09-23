<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<html lang='nl'>
<head>
<v:head title='Brouwers op alfabet' />
</head>
<body>
	<div>
		<a href="<c:url value='/'/>">Menu</a>
	</div>
	<h1>Brouwers op alfabet ${empty letter ? "" : letter}</h1>
	<ul class='zonderbolletjes'>
		<c:forEach items='${alfabet}' var='letter'>
			<spring:url var='url' value='/brouwers/opalfabet/{letter}'>
			<spring:param name='letter' value='${letter}' />
		</spring:url>
			<li><a href='${url}'>${letter}</a></li>
		</c:forEach>
	</ul>
	<c:if test='${not empty brouwers}'>
		<ul>
			<c:forEach items='${brouwers}' var='brouwer'>
				<li>${brouwer.naam}(${brouwer.adres.gemeente})</li>
			</c:forEach>
		</ul>
	</c:if>
</body>
</html>