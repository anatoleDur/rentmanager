<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/common/head.jsp"%>
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
                Reservations
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/rents/create">Ajouter</a>
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
                                <c:forEach items="${listRents}" var="rentInfo">
                                    <tr>
                                        <td>${rentInfo.id}</td>
                                        <td>${rentInfo.vehicle.id} ${rentInfo.vehicle.constructor} ${rentInfo.vehicle.nbPlaces} places</td>
                                        <td>${rentInfo.client.prenom} ${rentInfo.client.nom}</td>
                                        <td>${rentInfo.debut}</td>
                                        <td>${rentInfo.fin}</td>
                                        <td>
                                        
                                            <!-- <form method="post" action="${pageContext.request.contextPath}/cars?id=${vehicle.id}" class="btn btn-primary disabled">
                                            <button type="button" class="btn btn-primary disabled" href="car-detail.html" name="play">
                                                <i class="fa fa-play"></i>
                                            </button>
                                            </form>
                                            <form method="post" action="${pageContext.request.contextPath}/cars?id=${vehicle.id}" class="btn btn-success disabled">
                                            <button type="button" class="btn btn-success disabled" href="#" name="modify">
                                                <i class="fa fa-edit"></i>
                                            </button>
                                            </form> -->
                                            <a class="btn btn-success" href="${pageContext.request.contextPath}/rents/modify?id=${rentInfo.id}">
                                                <i class="fa fa-edit"></i>
                                            </a>
                                            <form method="post" action="rents" class="btn btn-danger">
                                            <button type="submit" class="btn btn-danger" name="delete" value="${rentInfo.id}">
                                                <i class="fa fa-trash"></i>
                                            </button>
                                            </form>
                                            
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
