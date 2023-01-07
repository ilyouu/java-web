<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Java Web</title>

    <link href="./template/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="./template/css/font.css" rel="stylesheet">

    <link href="./template/css/sb-admin-2.min.css" rel="stylesheet">

    <link href="./template/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <div id="wrapper">

        <jsp:include page="./nav/nav.jsp"></jsp:include>

        <div id="content-wrapper" class="d-flex flex-column">

            <div id="content">
				<jsp:include page="./menu/menu.jsp"></jsp:include>

                <div class="container-fluid">

                    <div class="card shadow mb-4">
                        <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                            <h6 class="m-0 font-weight-bold text-primary">SAVE</h6>
                        </div>
                        <div class="card-body">
                        
                        
                            <select class="form-select" aria-label="Default select example">
							  <option selected>Open this select menu</option>
							  <option value="1">One</option>
							  <option value="2">Two</option>
							  <option value="3">Three</option>
							</select>
							
							SELECT * FROM Customers WHERE CustomerName LIKE 'a%';
							
                        </div>
                    </div>

                </div>

            </div>

            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Bản quyền &copy; PV Bang</span>
                    </div>
                </div>
            </footer>

        </div>

    </div>

    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xác nhận đăng xuất</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Chọn "Đăng xuất" bên dưới nếu bạn đã sẵn sàng.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Không</button>
                    <a class="btn btn-primary" href="<%session.invalidate();%>trang-chu">Đăng xuất</a>
                </div>
            </div>
        </div>
    </div>

    <script src="./template/vendor/jquery/jquery.min.js"></script>
    <script src="./template/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="./template/vendor/jquery-easing/jquery.easing.min.js"></script>

    <script src="./template/js/sb-admin-2.min.js"></script>

    <script src="./template/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="./template/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <script src="./template/js/demo/datatables-demo.js"></script>

</body>

</html>

