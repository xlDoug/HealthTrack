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
		<h2>Edicao de Alimentação</h2>
		<c:if test="${not empty msg }">
			<div class="alert alert-success">${msg }</div>
		</c:if>
		<c:if test="${not empty erro }">
			<div class="alert alert-danger">${erro }</div>
		</c:if>


		<form action="alimentacao?acao=atualizar" method="post" class="my-5">
		<input type="hidden" value="editar" name="acao">
		<input value="${alimento.id }" name="codigo">
			<div class="form-group row">
				<label class="col-sm-2 col-form-label" for="dt-consumo">Data
					do Consumo</label>
				<div class="col-sm-3">
					<input type="date" name="dtConsumo" id="dt-consumo"
						class="form-control" value="${alimento.data.time}">
				</div>

				<label class="col-sm-2 col-form-label" for="nm-tipo">Tipo do
					Alimento</label>
				<div class="col-sm-3">
					<input type="text" name="nmTipo" id="nm-tipo" value="${alimento.tipoAlimento.nome }" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label" for="nr-calorias">Numero
					de Calorias</label>
				<div class="col-sm-3">
					<input type="number" value="${alimento.caloria }" name="nrCalorias" id="nr-calorias"
						class="form-control">
				</div>
				<label class="col-sm-2 col-form-label" for="desc">Descrição</label>
				<div class="col-sm-5">
					<input type="text" name="descp" value="${alimento.descricao }" id="desc" class="form-control">
				</div>
			</div>
			<div>
				<input type="submit" value="Atualizar" class="btn btn-primary">
				<input type="reset" value="Limpar" class="btn btn-warning">
			</div>
	</form>
	<div>
		<a href="alimentacao?acao=listar" class="btn btn-success">Voltar</a>
	</div>
	</div>

</body>
<%@ include file="../_footer.jsp"%>
</html>