<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<title>Thông Tin Nhà Cái</title>
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
		<h1>THÔNG TIN NHÀ CÁI</h1>
	</div>
	<hr style="width:100%;color:black;height:3px;background-color:black;"/>
	<br/>
	<br/>
	<form action="save-base" method="post">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6" style="margin-left:40px;">
				<%-- <div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>ID: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="baseId" name="baseId" readonly value="${base.baseId}" style="width: 80%;"></input>
					</div>
				</div> --%>
			
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Tên Nhà Cái: </label>
					</div>
					<div class="col-md-8">
						<input type="hidden" id="baseId" name="baseId" value="${base.baseId }"></input>
						<input type="text" id="baseName" name="baseName" readonly value="${base.baseName}" style="width: 80%;"></input>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Description: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="baseDes" name="baseDes" readonly value="${base.baseDes}" style="width: 80%;"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Hệ Số Lô Đánh: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="rateLIn" name="rateLIn" readonly value="${base.rateLIn}" style="width: 80%;"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Hệ Số Lô Ăn: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="rateLOut" name="rateLOut" readonly value="${base.rateLOut}" style="width: 80%;"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Hệ Số Đề: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="rateD" name="rateD" readonly value="${base.rateD}" style="width: 80%;"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Hệ Số Xiên 2: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="rateX2" name="rateX2" readonly value="${base.rateX2}" style="width: 80%;"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Hệ Số Xiên 3: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="rateX3" name="rateX3" readonly value="${base.rateX3}" style="width: 80%;"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Hệ Số Xiên 4: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="rateX4" name="rateX4" readonly value="${base.rateX4}" style="width: 80%;"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Hệ Số 3 Càng: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="rate3c" name="rate3c" readonly value="${base.rate3c}" style="width: 80%;"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
					</div>
					<div class="col-md-8">
						<input type="button" id="edit"  value="Chỉnh sửa" style="width: 26%;"></input>
						<input type="submit" id="saveUser"  value="Lưu lại" style="width: 26%;"></input>
						<a href="/base"><input type="button" id="back"  value="Quay lại" style="width: 26%;"></input></a>
					</div>
				</div>
				
			</div>
		</div>
	</form>
</body>
<footer style="bottom: 0;position: fixed;">
  <p>Author: TuanOle<br>
  <a href="mailto:tuanole@gmail.com">tuanole@gmail.com</a></p>
</footer>
</html>
