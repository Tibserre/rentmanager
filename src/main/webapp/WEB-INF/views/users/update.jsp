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
                                    Utilisateurs
                                </h1>
                            </section>

                            <!-- Main content -->
                            <section class="content">
                                <div class="row">
                                    <div class="col-md-12">
                                        <!-- Horizontal Form -->
                                        <div class="box">
                                            <!-- form start -->
                                            <form class="form-horizontal" method="post"
                                                action="${pageContext.request.contextPath}/users/update">
                                                <div class="box-body">
                                                    <div class="form-group">
                                                        <div class="col-sm-10">
                                                            <input type="hidden" class="form-control" id="id" name="id"
                                                                value="${user.id}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="last_name"
                                                            class="col-sm-2 control-label">Nom</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="last_name"
                                                                name="last_name" placeholder="Nom"
                                                                value="${user.lastname}" minlength="3" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="first_name"
                                                            class="col-sm-2 control-label">Prenom</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" class="form-control" id="first_name"
                                                                name="first_name" placeholder="Prenom"
                                                                value="${user.name}" minlength="3" required>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="email" class="col-sm-2 control-label">Email</label>

                                                        <div class="col-sm-10">
                                                            <input type="email" class="form-control" id="email"
                                                                name="email" placeholder="Email" value="${user.mail}">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="birthdate" class="col-sm-2 control-label">Date de
                                                            naissance</label>

                                                        <div class="col-sm-10">
                                                            <input type="date" class="form-control" id="birthdate"
                                                                name="birthdate" placeholder="Naissance"
                                                                value="${user.birthdate}" required onchange="verifyAge()">
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- /.box-body -->
                                                <div class="box-footer">
                                                    <button type="submit"
                                                        class="btn btn-info pull-right" id="ButtonModif">Ajouter</button>
                                                </div>
                                                <!-- /.box-footer -->
                                            </form>
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
            <script>
                function verifyAge() {
                    var Bdate = document.getElementById('birthdate').value;
                    var Bday = +new Date(Bdate);
                    if (((Date.now() - Bday) / (31557600000)) > 18) {
                        console.log('OUI');
                        document.getElementById('ButtonModif').disabled = false;
                    } else {
                        console.log('NOP');
                        document.getElementById('ButtonModif').disabled = true;
                    }
                } 
            </script>
            <%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
        </body>

    </html>