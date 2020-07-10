<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<title>Thông Tin Khách Hàng</title>
<script>
	$(document).ready(function() {
	  $("#edit").click(function(){
		$(':input').prop('readonly', false);
	  });
	  
	  $("#saveUser").click(function(){
		$(':input').prop('readonly', true);
	  });
	  
	});
</script>
<body>
	<div class="container" style="text-align:center;">
		<h1>THÔNG TIN NGƯỜI DÙNG</h1>
	</div>
	<hr style="width:100%;color:black;height:3px;background-color:black;"/>
	<br/>
	<br/>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-6" style="margin-left:20px;">
			<div class="row">
				<div class="col-md-3" style="text-align:right;">
					<label>Tên Khách Hàng: </label>
				</div>
				<div class="col-md-3">
					<input type="text" id="uname" readonly value="${user.userName}"></input>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3" style="text-align:right;">
					<label>Mã Khách Hàng: </label>
				</div>
				<div class="col-md-3">
					<input type="text" id="uid" readonly value="${user.userId}"></input>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3" style="text-align:right;">
					<label>Số Điện Thoại: </label>
				</div>
				<div class="col-md-3">
					<input type="text" id="phone" readonly value="${user.userPhone}"></input>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3" style="text-align:right;">
					<label>Loại Khách Hàng: </label>
				</div>
				<div class="col-md-3">
					<input type="text" id="description" readonly value="${user.userDes}"></input>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3" style="text-align:right;">
					<label>Rank: </label>
				</div>
				<div class="col-md-3">
					<input type="text" id="rank" readonly value="${user.rank}"></input>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3" style="text-align:right;">
				</div>
				<div class="col-md-6">
					<input type="button" id="edit"  value="Chỉnh sửa" style="width:99px;"></input>
					<input type="button" id="saveUser"  value="Lưu lại" style="width:99px;"></input>
				</div>
			</div>
			
		</div>
	</div>
</body>
<footer>
  <p>Author: TuanOle<br>
  <a href="mailto:tuanole@gmail.com">tuanole@gmail.com</a></p>
</footer>
</html>
