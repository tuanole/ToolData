<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<title>Quản Lý Bộ Số</title>
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
		<h1>THÔNG TIN SỐ</h1>
	</div>
	<hr style="width:100%;color:black;height:3px;background-color:black;"/>
	<br/>
	<br/>
	<form action="save-set" method="post">
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
						<label>Tên Bộ: </label>
					</div>
					<div class="col-md-8">
						<input type="hidden" id="id" name="id" value=""></input>
						<input type="text" id="boName" name="boName" required="required" placeholder="Ex: BO01" value="" style="width: 80%;"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Số: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="boKey" name="boKey" required="required" placeholder="Format: 01 02 03 04 ..." value="" style="width: 80%;"></input>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
						<label>Description: </label>
					</div>
					<div class="col-md-8">
						<input type="text" id="boDes" name="boDes" required="required" value="" style="width: 80%;"></input>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-3" style="text-align:right;">
					</div>
					<div class="col-md-8">
						<input type="submit" id="saveSet"  value="Lưu lại" style="width: 26%;margin-left: 70px;"></input>
						<a href="/manager-set"><input type="button" id="back"  value="Quay lại" style="width: 26%;"></input></a>
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
