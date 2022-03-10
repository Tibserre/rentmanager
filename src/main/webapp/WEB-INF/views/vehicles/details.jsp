
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

        <body class="hold-transition skin-blue sidebar-mini">
            <div class="wrapper">

                <%@ include file="/WEB-INF/views/common/header.jsp" %>
                    <!-- Left side column. contains the logo and sidebar -->
                    <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

                        <!-- Content Wrapper. Contains page content -->
                        <div class="content-wrapper">
                            <!-- Content Header (Page header) -->
                            <section class="content-header">
                                <h1>
                                    Reservations pour le vehicule :
                                    <c:forEach items="${cars}" var="car">
                                        <c:if test="${vehicule eq car.id}">
                                            <td>${car.constructeur}</td>
                                        </c:if>
                                    </c:forEach>
                                </h1>
                            </section>

                            <!-- Main content -->
                            <section class="content">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="box">
                                            <div class="box-body no-padding">
                                                <table class="table table-striped">
                                                    <tr>
                                                        <th style="width: 10px">#</th>
                                                        <th>Voiture</th>
                                                        <th>Client</th>
                                                        <th>Debut</th>
                                                        <th>Fin</th>
                                                        <th>Action</th>
                                                    </tr>
                                                    <c:forEach items="${resas}" var="resa">
                                                        <tr>
                                                            <td>${resa.id}.</td>
                                                            <c:forEach items="${cars}" var="car">
                                                                <c:if test="${resa.vehicle_id eq car.id}">
                                                                    <td>${car.constructeur} </td>
                                                                </c:if>
                                                            </c:forEach>
                                                            <c:forEach items="${users}" var="user">
                                                                <c:if test="${resa.client_id eq user.id}">
                                                                    <td>${user.name} ${user.lastname}</td>
                                                                </c:if>
                                                            </c:forEach>
                                                            <td>${resa.start_resa}</td>
                                                            <td>${resa.end_resa}</td>
                                                            <td>
                                                                <!--<a class="btn btn-primary" href="${pageContext.request.contextPath}/rents/detail?id=${resa.id}">
                                            <i class="fa fa-play"></i>
                                        </a>
                                        <a class="btn btn-success" href="${pageContext.request.contextPath}/rents/update?id=${resa.id}">
                                            <i class="fa fa-edit"></i>
                                        </a>-->
                                                                <a class="btn btn-danger"
                                                                    href="${pageContext.request.contextPath}/rents/delete?id=${resa.id}">
                                                                    <i class="fa fa-trash"></i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                            </div>
                                            <!-- /.box-body -->
                                        </div>
                                        <!-- /.box -->
                                    </div>
                                    <!-- /.col -->
                                </div>
                            </section>
                            <!-- /.content -->
                        </div>

                        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
            </div>
            <!-- ./wrapper -->

            <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
        </body>

    </html>
