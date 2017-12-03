<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Alimentação</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tether.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css"/> 
</head>

<body>

  <!--  MENU NAVEGAÇÃO-->
  <nav class="navbar navbar-toggleable-md navbar-light bg-faded">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav"
      aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#">HealthTrack</a>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="#">Dashboard</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Alimentação
            <span class="sr-only">(current)</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Atividade Fisica</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Peso</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pressao Arterial</a>
        </li>
      </ul>
      <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
        <li class="dropdown order-1">
          <button type="button" id="dropdownMenu1" data-toggle="dropdown" class="btn btn-outline-secondary btn-link">Login
          </button>
          <ul class="dropdown-menu dropdown-menu-right mt-1">
            <li class="p-3">
              <form class="form" role="form">
                <div class="form-group">
                  <input id="emailInput" placeholder="Email" class="form-control form-control-sm" type="text" required="">
                </div>
                <div class="form-group">
                  <input id="passwordInput" placeholder="Password" class="form-control form-control-sm" type="text" required="">
                </div>
                <div class="form-group">
                  <button type="submit" class="btn btn-primary btn-block">Login</button>
                </div>
                <div class="form-group text-xs-center">
                  <small>
                    <a href="#">Forgot password?</a>
                  </small>
                </div>
              </form>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>

  <!-- CONTEUDO -->
  <div class="container my-3">
    <h2>Cadastro de Alimentação</h2>
    <form action="" method="post" class="my-5">
      <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="dt-consumo">Data do Consumo</label>
        <div class="col-sm-3">
          <input type="date" name="dtConsumo" id="dt-consumo" class="form-control">
        </div>

        <label class="col-sm-2 col-form-label" for="nm-tipo">Tipo do Alimento</label>
        <div class="col-sm-3">
          <input type="text" name="nmTipo" id="nm-tipo" class="form-control">
        </div>
      </div>
      <div class="form-group row">
        <label class="col-sm-2 col-form-label" for="nr-calorias">Numero de Calorias</label>
        <div class="col-sm-3">
          <input type="number" name="nrCalorias" id="nr-calorias" class="form-control">
        </div>
        <label class="col-sm-2 col-form-label" for="desc">Descrição</label>
        <div class="col-sm-5">
          <input type="text" name="descp" id="desc" class="form-control">
        </div>
      </div>
      <div >
          <input type="submit" value="Cadastrar" class="btn btn-primary">
          <input type="reset" value="Limpar" class="btn btn-warning">
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
        <tr>
          <th scope="row">1</th>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
          <td>@mdo</td>
          <td>@mdo</td>
          <td>
              <button class="btn btn-warning" contenteditable="false">Editar</button>
              <button class="btn btn-danger" contenteditable="false">Apagar</button>
          </td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
          <td>@fat</td>
          <td>@fat</td>
          <td>
              <button class="btn btn-warning" contenteditable="false">Editar</button>
              <button class="btn btn-danger" contenteditable="false">Apagar</button>
          </td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
          <td>@twitter</td>
          <td>@twitter</td>
          <td>
              <button class="btn btn-warning" contenteditable="false">Editar</button>
              <button class="btn btn-danger" contenteditable="false">Apagar</button>
          </td>
        </tr>
        <tr>
          <th scope="row">4</th>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
          <td>@twitter</td>
          <td>@twitter</td>
          <td>
              <button class="btn btn-warning" contenteditable="false">Editar</button>
              <button class="btn btn-danger" contenteditable="false">Apagar</button>
          </td>
        </tr>
        <tr>
          <th scope="row">5</th>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
          <td>@twitter</td>
          <td>@twitter</td>
          <td>
            <button class="btn btn-warning" contenteditable="false">Editar</button>
            <button class="btn btn-danger" contenteditable="false">Apagar</button>
          </td>
        </tr>
      </tbody>
    </table>

  </div>

</body>
<footer class="text-center">
  Health Track - 2017
</footer>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/tether.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script 	type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript"  src="${pageContext.request.contextPath}/resources/js/popper.js"/></script>

</html>