<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../_header.jsp"%>
</head>
<body>
	<%@ include file="../_menu.jsp"%>

	<!-- CONTEUDO -->
	<div class="container my-3">
		<form action="cadastrar-alimentacao.jsp" method="get" class="my-5">
			<div>
				<input type="submit" value="Cadastrar novo" class="btn btn-primary">
			</div>
	</div>

	</form>
	</br>
	</div>
	<div class="container my-1">
		<h2>Historico de Alimentação</h2>
		<table class="table table-striped my-5">
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Tipo</th>
					<th>Numero de Calorias</th>
					<th>Descrição</th>
					<th>Data de consumo</th>
					<th>Ultima atualização</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${alimentos }" var="alimento">
					<tr>
						<th scope="row">${alimento.id}</th>
						<td>${alimento.tipoAlimento.nome }</td>
						<td>${alimento.caloria }</td>
						<td>${alimento.descricao }</td>
						<td><fmt:formatDate value="${alimento.data.time}"
								pattern="dd/MM/yyyy" /></td>
						<td><fmt:formatDate value="${alimento.data.time}"
								pattern="dd/MM/yyyy" /></td>
						<td>
							<c:url value="alimentacao" var="editar">
								<c:param name="acao" value="editar"></c:param>
								<c:param name="id" value="${alimento.id }"></c:param>
							</c:url>
							<a href="${editar }" class="btn btn-warning">Editar</a>
							
							<c:url value="alimentacao" var="remover">
								<c:param name="acao" value="remover"></c:param>
								<c:param name="id" value="${alimento.id }"></c:param>
							</c:url>
							<a href="${remover }" class="btn btn-danger">Apagar</a>
						</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>

	</div>

</body>
<%@ include file="../_footer.jsp"%>
</html>