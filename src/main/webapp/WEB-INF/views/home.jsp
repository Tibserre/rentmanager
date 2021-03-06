<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

  <!DOCTYPE html>
  <html>
  <%@include file="/WEB-INF/views/common/head.jsp" %>

    <body class="hold-transition skin-blue sidebar-mini">
      <div class="wrapper">

        <!-- Left side column. contains the logo and sidebar -->
        <%@ include file="/WEB-INF/views/common/header.jsp" %>

          <!-- Left side column. contains the logo and sidebar -->
          <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>


            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
              <!-- Content Header (Page header) -->
              <section class="content-header">
                <h1>
                  Dashboard
                </h1>
              </section>

              <!-- Main content -->
              <section class="content">
                <!-- Info boxes -->
                <div class="row">
                  <a href="${pageContext.request.contextPath}/users" style="color: black ;">
                    <div class="col-md-3 col-sm-6 col-xs-12">
                      <div class="info-box">
                        <span class="info-box-icon bg-aqua"><i class="fa fa-user"></i></span>

                        <div class="info-box-content">
                          <span class="info-box-text">Utilisateurs</span>
                          <span class="info-box-number">${Nb_Clients}</span>
                        </div>
                        <!-- /.info-box-content -->
                      </div>
                      <!-- /.info-box -->
                    </div>
                  </a>
                  <!-- /.col -->
                  <a href="${pageContext.request.contextPath}/cars" style="color: black ;">
                    <div class="col-md-3 col-sm-6 col-xs-12">
                      <div class="info-box">
                        <span class="info-box-icon bg-red"><i class="fa fa-car"></i></span>

                        <div class="info-box-content">
                          <span class="info-box-text">Voitures</span>
                          <span class="info-box-number"> ${Nb_vehicles} </span>
                        </div>
                        <!-- /.info-box-content -->
                      </div>
                      <!-- /.info-box -->
                    </div>
                  </a>
                  <!-- /.col -->

                  <!-- fix for small devices only -->
                  <div class="clearfix visible-sm-block"></div>
                  <a href="${pageContext.request.contextPath}/rents" style="color: black ;">
                    <div class="col-md-3 col-sm-6 col-xs-12">
                      <div class="info-box">
                        <span class="info-box-icon bg-green"><i class="fa fa-pencil"></i></span>

                        <div class="info-box-content">
                          <span class="info-box-text">Reservations</span>
                          <span class="info-box-number">${Nb_Resa}</span>
                        </div>
                        <!-- /.info-box-content -->
                      </div>
                      <!-- /.info-box -->
                    </div>
                  </a>
                  <!-- /.col -->
                </div>
                <!-- /.row -->
              </section>
              <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->

            <jsp:include page='/WEB-INF/views/common/footer.jsp'></jsp:include>


      </div>
      <!-- ./wrapper -->

      <!-- Contains Js code imports -->
      <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>

    </body>

  </html>