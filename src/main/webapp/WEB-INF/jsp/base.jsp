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
				  <th scope="col">Tên Nhà Cái</th>
				  <th scope="col">Description</th>
				  <th scope="col">Hệ Số Lô Đánh</th>
				  <th scope="col">Hệ Số Lô Ăn</th>
				  <th scope="col">Hệ Số Đề</th>
				  <th scope="col">Hệ Số Xiên 2</th>
				  <th scope="col">Hệ Số Xiên 3</th>
				  <th scope="col">Hệ Số Xiên 4</th>
				  <th scope="col">Hệ Số 3 Càng</th>
				  <th scope="col"></th>
				</tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${bases}" var="base">
			  		<tr>
					  <th scope="row"><a href="/base-infor?baseId=${base.baseId}">${base.baseId}</a></th>
					  <td>${base.baseName}</td>
					  <td>${base.baseDes}</td>
					  <td>${base.rateLIn}</td>
					  <td>${base.rateLOut}</td>
					  <td>${base.rateD}</td>
					  <td>${base.rateX2}</td>
					  <td>${base.rateX3}</td>
					  <td>${base.rateX4}</td>
					  <td>${base.rate3c}</td>
					  <td><a href="/delete-base?baseId=${base.baseId}"><i>Xóa</i></a></td>
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
			<a href="/add-base"><input type="button" id="addBase" value="Thêm Nhà Cái"></input></a>
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
