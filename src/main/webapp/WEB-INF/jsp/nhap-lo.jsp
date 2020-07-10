<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Nhập Lô</title>
<style>
	td {
		contenteditable:true;
	}
</style>
<body>
	<div class="container" style="height:50px;text-align:center">
		<h1 style="margin-top:20px">NHẬP SỐ LIỆU ĐÁNH</h1>   
	</div>
	<hr style="width:100%;color:black;height:3px;background-color:black;"/>
	<br/>
<div class="container-fluid" style="margin-top:0px;">
	<div class="row" style="margin-top:-20px">
		<div class="col-md-1" ></div>
		
		<div class="col-md-4" style="border:1px solid black;">
			<p style="text-align:center;font-size:20px;"><b>Nhà Cái Nhận</b></p>
			 <div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<select class="js-example-responsive" style="width: 100%;text-align:center;" id="selectBaseIn">
					  <option value="">Chọn...</option>
					  <c:forEach items="${bases}" var="base">
					  	<option value="${base.baseName }">${base.baseName }</option>
					  </c:forEach>
					</select>
				</div>
			 </div>
		</div>
		
		<div class="col-md-2" ></div>
		
		<div class="col-md-4" style="border:1px solid black;">
			<p style="text-align:center;font-size:20px;"><b>Nhà Cái Trả</b></p>
			 <div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<select class="js-example-responsive" style="width: 100%;text-align:center;" id="selectBaseOut">
					  <option value="">Chọn...</option>
					  <c:forEach items="${bases}" var="base">
					  	<option value="${base.baseName }">${base.baseName }</option>
					  </c:forEach>
					</select>
				</div>
			 </div>
			 <br/>
		</div>
		<div class="col-md-1" ></div>
	</div>
	<hr style="width:100%;color:black;height:3px;background-color:black;"/>
	<br/>
	<div class="row" style="margin-top:20px">
		<div class="col-md-5">
			<!-- <div class="row">
				<div class="col-md-3" style="text-align:right;font-size: 15px;"><p>KHÁCH HÀNG: </p></div>
				<div class="col-md-8">
					<input type="text" id="uid" name="userId" placeholder="Yêu cầu nhập mã khách hàng!" style="width:95%;" required></input>
					<input type="button" id="btnCheck" name="btnCheck" value="Kiểm Tra" style="margin-top:5px;"></input>
				</div>
				
			</div> -->
			<div class="row">
				<div class="col-md-3" style="text-align:right;font-size: 15px;"><p>LOẠI:</p></div>   
				<div class="col-md-7">
					<select class="js-example-responsive" style="width: 50%;height: 25px;" id="selectType">
					  <option value="">Chọn...</option>
					  <c:forEach items="${types}" var="type">
					  	<option value="${type.typeValue }">${type.typeName }</option>
					  </c:forEach>
					</select>
				</div>
				
			</div>
			<br/>
			
			<div class="row">
				<div class="col-md-3" style="text-align:right;font-size: 15px;"><p>KIỂU:</p></div>   
				<div class="col-md-7" style="border:1px solid black;margin-left:14px;">
					 <div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-4">
							<input type="radio" id="kindA" name="kind" value="4">
							<label>Kiểu A</label>
						</div>
						<div class="col-md-2"></div>
						<div class="col-md-4">
							<input type="radio" id="kindB" name="kind" value="1" checked>
							<label>Kiểu B</label>
						</div>
					 </div>
					 <br/>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col-md-3" style="text-align:right;font-size: 15px;"><p>LÔ:</p></div>   
				<div class="col-md-7">
					<textarea rows="2" cols="43.5" name="usrtxt" wrap="hard" placeholder="Nhập số liệu lô!" id="stringLo"></textarea>
				</div>
			</div>
			<br/>
			
			<!-- <div class="row">
				<div class="col-md-3" style="text-align:right;font-size: 15px;"><p>ĐIỂM:</p></div>
				<div class="col-md-7">
					<input type="text" id="diem" name="diem" placeholder="Nhập số điểm!"></input>
				</div>
				
			</div> -->
			<br/>
			<div class="row">
				<div class="col-md-3" style="text-align:right;"></div>
				<div class="col-md-7">
					<input type="button" id="genLo" name="genLo" value="Kết Quả"></input>
				</div>
				
			</div>
			
		</div>
		<div class="col-md-2"></div>
		
		<div class="col-md-4" style="border:1px solid black;">
			<p>Bảng Lô</p>
			<table class="table table-bordered table-condensed table-striped table-hover" id="myTable">
			  <thead>
				<tr>
				  <th>Số</th>
				  <th>Điểm</th>
				  <th>Đơn vị nhận</th>
				  <th>Đơn vị trả</th>
				  <th></th>
				</tr>
			  </thead>
			  <tbody>
			  
			  </tbody>
			</table>
			<input type="button" id="addRow" name="addRow" value="Thêm dòng" style="margin-bottom:5px;margin-top:10px;"></input>
		</div>
	</div>
	
	<br/>
	<div class="row">
		<div class="col-md-5"></div>
		<div class="col-md-2">
			<input type="button" id="submit" value="Lưu Lại"></input>
		</div>
		<div class="col-md-5"></div>
	</div>
</div>
	<br/>
</body>
<footer style="bottom: 0;position: fixed;">
  <p>Author: TuanOle<br>
  <a href="mailto:tuanole@gmail.com">tuanole@gmail.com</a></p>
</footer>
<script>
	$( document ).ready(function() {
		$("#addRow").on("click", function(e){
			$('#myTable').append('<tr><td contenteditable="true"></td><td contenteditable="true"></td><td contenteditable="true"></td><td contenteditable="true"></td><td><input type="button" id="tdXoa" name="tdXoa" class="tdXoas" value="Xóa"></input></td></tr>');
			$(".dataTables_empty").remove();
			$(".odd").remove();
		});
		$('#myTable').dataTable({
			"bPaginate": false,
			"scrollY":   '300px',
	        "scrollCollapse": true,
			"bFilter": false, //hide Search bar
			"bInfo": false, // hide showing entries
			"bLength" : false,
			"ordering": false,
			"responsive": true
		});
		var table = $('#myTable').DataTable();
		$('#myTable').on("click", "#tdXoa", function(){
			$(this).parent().parent().remove();
      });
		
	});
	
	$("#genLo").on("click", function(e){
		$("#myTable tbody").empty();
		var kind = $("input[name='kind']:checked").val();
		var stringLo = $('#stringLo').val();
		var cus = $('#uid').val();
		var type = $('#selectType').val();
		var diem = $('#diem').val();
		var baseIn = $('#selectBaseIn').val();
		var baseOut = $('#selectBaseOut').val();
		if(baseIn == ""){
			alert("Vui lòng chọn nhà cái vào!");
		}else if(baseOut == ""){
			alert("Vui lòng chọn nhà cái ra!");
		}else if(stringLo === ""){
			alert("Vui lòng nhập dữ liêu lô!");
		}else{
			$.ajax({
				type : "GET",
				url : '/calculation?stringLo=' + stringLo + '&kind=' + kind + '&type=' + type + '&diem=' + diem + '&baseIn=' + baseIn + '&baseOut=' + baseOut,
				dataType: "json",
				contentType : 'application/json',
				success : function(response) {
	                $.each(response, function(i, item){
	                	$("#myTable > tbody").append('<tr><td contenteditable="true">' + item.soDanh + '</td><td contenteditable="true">' + item.diem + '</td><td contenteditable="true">' + item.baseIn + '</td><td contenteditable="true">' + item.baseOut + '</td><td><input type="button" id="tdXoa" name="tdXoa" class="tdXoas" value="Xóa"></input></td></tr>');
	                });
	                
	            }
			});
		}
		
	});	
	
	$("#submit").on("click", function(e){
		e.preventDefault();
		var kind = $("input[name='kind']:checked").val();
		var cus = $('#uid').val();
		var type = $('#selectType').val();
		var baseIn = $('#selectBaseIn').val();
		var baseOut = $('#selectBaseOut').val();
		 var customers = new Array();
         $("#myTable TBODY TR").each(function () {
             var row = $(this);
             var customer = {};
             customer.soDanh = row.find("TD").eq(0).html();
             customer.diem = row.find("TD").eq(1).html();
             customer.base = row.find("TD").eq(2).html();
             customer.user = row.find("TD").eq(3).html();
             customers.push(customer);
         });
        $.ajax({
        	type : "POST",
            url: '/save?baseIn=' + baseIn + '&baseOut=' + baseOut + '&kind=' + kind + '&type=' + type,
            data: JSON.stringify(customers),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (r) {
                
            }
        });
        alert("Lưu thành công " + customers.length + " record!");
        location.reload();
	});
</script>
</html>
