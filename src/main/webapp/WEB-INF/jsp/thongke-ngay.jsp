<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="header.jsp" %>
<script>
	$(document).ready(function() {
	  $(".js-example-basic-single").select2();
	  // Thêm các tùy chọn của bạn vào đây.
	  $("#divA1").css('display', 'none');
	  $("#divB1").css('display', 'none');
	  $("#divC1").css('display', 'none');
	  
	  
	  $("#selectBase").on("change", function(e){
		var temp = $("#selectBase").val();
		//window.alert(temp);
		if(temp == 'A1'){
			$("#divA1").css('display', 'block');
			$("#divB1").css('display', 'none');
			$("#divC1").css('display', 'none');
		}else if(temp == 'B1'){
			$("#divA1").css('display', 'none');
			$("#divB1").css('display', 'block');
			$("#divC1").css('display', 'none');
		}else if(temp == 'C1'){
			$("#divA1").css('display', 'none');
			$("#divB1").css('display', 'none');
			$("#divC1").css('display', 'block');
		}else if(temp == 'all'){
			$("#divA1").css('display', 'block');
			$("#divB1").css('display', 'block');
			$("#divC1").css('display', 'block');
		}else{
			$("#divA1").css('display', 'none');
			$("#divB1").css('display', 'none');
			$("#divC1").css('display', 'none');
		}
	  });
	  
	});

</script>
<body>
	<div class="container" style="height:50px;text-align:center">
		<h1 style="margin-top:20px">THỐNG KÊ SỐ LIỆU THEO NGÀY</h1>   
	</div>
	<hr style="width:100%;color:black;height:3px;background-color:black;"/>
	<br/>
<div class="container-fluid" style="margin-top:0px;">
	<div class="row" style="margin-top:-25px">
		<div class="col-md-4"></div>
		<div class="col-md-4" style="border:1px solid black;font-size:15px;">
			<div class="row">
				<div class="col-md-5" style="text-align:right;">
					<label><b>Nhà Cái: </b></label>
				</div>

				<div class="col-md-7">
					<select class="js-example-responsive" style="width: 50%" id="selectBase">
					  <option value="">Chọn...</option>
					  <option value="all">Tất cả nhà cái</option>
					  <option value="A1">Nhà cái A1</option>
					  <option value="B1">Nhà cái B1</option>
					  <option value="C1">Nhà cái C1</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5" style="text-align:right;">
					<label><b>Ngày Tháng: </b></label>
				</div>
				<div class="col-md-6">
					<label>21/06/2020</label>
				</div>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
</div>
	<hr style="width:100%;color:black;height:3px;background-color:black;"/>
	<br/>
<div class="container-fluid" id="divA1">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<table class="table table-hover table-dark">
			  <thead>
				<tr>
				  <th scope="col">Nhà Cái A1</th>
				  <th scope="col">Tổng Điểm Đánh</th>
				  <th scope="col">Tổng Tiền Đánh(K)</th>
				  <th scope="col">Tổng Điểm Trúng</th>
				  <th scope="col">Tổng Tiền Trúng(K)</th>
				  <th scope="col">Tổng Tiền Lãi(K)</th>
				</tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${A1}" var="a">
			  	<tr>
				  <th scope="row">${a.loai}</th>
				  <td>${a.sumDiem }</td>
				  <td>${a.sumTien }</td>
				  <td>${a.sumDiemTrung }</td>
				  <td>${a.sumTienTrung }</td>
				  <td>${a.sumLai}</td>
				</tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
		<div class="col-md-1"></div>
	</div>	
</div>
<div class="container-fluid" id="divB1">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<table class="table table-hover table-dark">
			  <thead>
				<tr>
				  <th scope="col">Loại B1</th>
				  <th scope="col">Tổng Điểm Đánh</th>
				  <th scope="col">Tổng Tiền Đánh(K)</th>
				  <th scope="col">Tổng Điểm Trúng</th>
				  <th scope="col">Tổng Tiền Trúng(K)</th>
				  <th scope="col">Tổng Tiền Lãi(K)</th>
				</tr>
			  </thead>
			  <tbody>
				<c:forEach items="${B1}" var="a">
			  	<tr>
				  <th scope="row">${a.loai}</th>
				  <td>${a.sumDiem }</td>
				  <td>${a.sumTien }</td>
				  <td>${a.sumDiemTrung }</td>
				  <td>${a.sumTienTrung }</td>
				  <td>${a.sumLai}</td>
				</tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
		<div class="col-md-1"></div>
	</div>	
</div>
<div class="container-fluid" id="divC1">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<table class="table table-hover table-dark">
			  <thead>
				<tr>
				  <th scope="col">Loại C1</th>
				  <th scope="col">Tổng Điểm Đánh</th>
				  <th scope="col">Tổng Tiền Đánh(K)</th>
				  <th scope="col">Tổng Điểm Trúng</th>
				  <th scope="col">Tổng Tiền Trúng(K)</th>
				  <th scope="col">Tổng Tiền Lãi(K)</th>
				</tr>
			  </thead>
			  <tbody>
				<c:forEach items="${C1}" var="a">
			  	<tr>
				  <th scope="row">${a.loai}</th>
				  <td>${a.sumDiem }</td>
				  <td>${a.sumTien }</td>
				  <td>${a.sumDiemTrung }</td>
				  <td>${a.sumTienTrung }</td>
				  <td>${a.sumLai}</td>
				</tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
		<div class="col-md-1"></div>
	</div>	
</div>
	<br/>
</body>
<footer>
  <p>Author: TuanOle<br>
  <a href="mailto:tuanole@gmail.com">tuanole@gmail.com</a></p>
</footer>
</html>
