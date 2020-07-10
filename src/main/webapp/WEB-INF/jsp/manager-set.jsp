<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<title>Nhà Cái</title>
<body>
	<div class="container" style="text-align:center;">
		<h1>THÔNG TIN NHÀ CÁI</h1>
	</div>
	<hr style="width:100%;color:black;height:3px;background-color:black;"/>
	<br/>
	<br/>
	<div class="row">
		<div class="col-md-1" style="margin-left:20px;"></div>
		<div class="col-md-10">
			<table class="table table-condensed table-striped table-hover" id="myTable">
			  <thead>
				<tr>
				  <th scope="col">ID</th>
				  <th scope="col">Tên bộ</th>
				  <th scope="col">Số</th>
				  <th scope="col">Description</th>
				  <th scope="col"></th>
				</tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${list}" var="base">
			  		<tr>
					  <th scope="row"><a href="/show-set?id=${base.id}">${base.id}</a></th>
					  <td>${base.boName}</td>
					  <td>${base.boKey}</td>
					  <td>${base.boDes}</td>
					  <td><a href="/delete-set?id=${base.id}"><i>Xóa</i></a></td>
					</tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
		<div class="col-md-1"></div>
	</div>
	<br/>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4" style="text-align: center;">
			<a href="/add-set"><input type="button" id="addSet" value="Thêm Bộ"></input></a>
		</div>
		<div class="col-md-4"></div>
	</div>
</body>
<footer style="bottom: 0;position: fixed;">
  <p>Author: TuanOle<br>
  <a href="mailto:tuanole@gmail.com">tuanole@gmail.com</a></p>
</footer>
<script>
	$(document).ready(function() {
	$('#myTable').dataTable({
		"bPaginate": false,
		"scrollY":   "500px",
        "scrollCollapse": true,
		"bFilter": false, //hide Search bar
		"bInfo": false, // hide showing entries
		"bLength" : false,
	});
    $('#myTable').DataTable();
} );
</script>

</html>
