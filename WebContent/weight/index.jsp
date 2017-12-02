<jsp:include page="helpers/_header.jsp"/>
<body>
<table>
	
	<c:forEach items="${pesagens}" var="p">
	<tr>
		<td>"${p.peso}"</td>
	</tr>
	</c:forEach>
</table>
</body>
<jsp:include page="helpers/_footer.jsp"/>