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
          <a class="nav-link" href="dashboard">Dashboard</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="alimentacao?acao=listar">Alimentação</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="atividade?acao=listar">Atividade Fisica</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="peso?acao=listar">Peso</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="pressao?acao=listar">Pressao Arterial</a>
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
