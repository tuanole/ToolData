<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<title>Phân Tích Data</title>
<body>
	<div class="container" style="text-align:center;height: 30px;">
		<h2>THỐNG KÊ KẾT QUẢ THEO NGÀY</h2>
	</div>
	<hr style="width:100%;color:black;height:2px;background-color:black;"/>
	<div class="row" style="font-size:13px;padding-top: 5px;" >
		<div class="col-md-1"></div>
		<div class="col-md-3" style="margin-left: -50px;">
			<label><h5><b>Bảng Lô</b></h5></label>
			<table class="table table-bordered table-condensed table-striped table-hover" style="width:100%;" id="tableLo">
			  <thead>
				<tr>
				  <th>STT</th>
				  <th>Điểm đánh</th>
				  <th>Số lượt về</th>
				  <th>Tổng</th>
				  <th>Thứ hạng</th>
				</tr>
				<tr>
				  <th>${data.so }</th>
				  <th>${data.diem }</th>
				  <th>${data.soLuot }</th>
				  <th>${data.tong }</th>
				  <th></th>
				</tr>
			  </thead>
			  <tbody>
				<c:forEach items="${listData}" var="item">
					<tr>
					  <td>${item.so }</td>
					  <td>${item.diem }</td>
					  <td>${item.soLuot }</td>
					  <td>${item.tong }</td>
					  <td>${item.hang }</td>
					</tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
		<div class="col-md-4" style="font-size:13px;margin-left: 35px;margin-top: -20px;">
			<div class="row" style="width: 100%;margin-left: 25px;">
				<table class="table table-bordered table-condensed table-striped table-hover" style="width:100%;" id="tableSortLo">
				  <thead>
					<tr>
					  <th></th>
					  <th>0</th>
					  <th>1</th>
					  <th>2</th>
					  <th>3</th>
					  <th>4</th>
					  <th>5</th>
					  <th>6</th>
					  <th>7</th>
					  <th>8</th>
					  <th>9</th>
					  <th>Total</th>
					</tr>
				  </thead>
				  <tbody>
					<tr>
					  <th scope="row">0</th>
					  <td>${listData2.get(0).diem }</td>
					  <td>${listData2.get(1).diem }</td>
					  <td>${listData2.get(2).diem }</td>
					  <td>${listData2.get(3).diem }</td>
					  <td>${listData2.get(4).diem }</td>
					  <td>${listData2.get(5).diem }</td>
					  <td>${listData2.get(6).diem }</td>
					  <td>${listData2.get(7).diem }</td>
					  <td>${listData2.get(8).diem }</td>
					  <td>${listData2.get(9).diem }</td>
					  <td>${listTotal.get(0)}</td>
					</tr>
					<tr>
					  <th scope="row">1</th>
					  <td>${listData2.get(10).diem }</td>
					  <td>${listData2.get(11).diem }</td>
					  <td>${listData2.get(12).diem }</td>
					  <td>${listData2.get(13).diem }</td>
					  <td>${listData2.get(14).diem }</td>
					  <td>${listData2.get(15).diem }</td>
					  <td>${listData2.get(16).diem }</td>
					  <td>${listData2.get(17).diem }</td>
					  <td>${listData2.get(18).diem }</td>
					  <td>${listData2.get(19).diem }</td>
					  <td>${listTotal.get(1)}</td>
					</tr>
					<tr>
					  <th scope="row">2</th>
					  <td>${listData2.get(20).diem }</td>
					  <td>${listData2.get(21).diem }</td>
					  <td>${listData2.get(22).diem }</td>
					  <td>${listData2.get(23).diem }</td>
					  <td>${listData2.get(24).diem }</td>
					  <td>${listData2.get(25).diem }</td>
					  <td>${listData2.get(26).diem }</td>
					  <td>${listData2.get(27).diem }</td>
					  <td>${listData2.get(28).diem }</td>
					  <td>${listData2.get(29).diem }</td>
					  <td>${listTotal.get(2)}</td>
					</tr>
					<tr>
					  <th scope="row">3</th>
					  <td>${listData2.get(30).diem }</td>
					  <td>${listData2.get(31).diem }</td>
					  <td>${listData2.get(32).diem }</td>
					  <td>${listData2.get(33).diem }</td>
					  <td>${listData2.get(34).diem }</td>
					  <td>${listData2.get(35).diem }</td>
					  <td>${listData2.get(36).diem }</td>
					  <td>${listData2.get(37).diem }</td>
					  <td>${listData2.get(38).diem }</td>
					  <td>${listData2.get(39).diem }</td>
					  <td>${listTotal.get(3)}</td>
					</tr>
					<tr>
					  <th scope="row">4</th>
					  <td>${listData2.get(40).diem }</td>
					  <td>${listData2.get(41).diem }</td>
					  <td>${listData2.get(42).diem }</td>
					  <td>${listData2.get(43).diem }</td>
					  <td>${listData2.get(44).diem }</td>
					  <td>${listData2.get(45).diem }</td>
					  <td>${listData2.get(46).diem }</td>
					  <td>${listData2.get(47).diem }</td>
					  <td>${listData2.get(48).diem }</td>
					  <td>${listData2.get(49).diem }</td>
					  <td>${listTotal.get(4)}</td>
					</tr>
					<tr>
					  <th scope="row">5</th>
					  <td>${listData2.get(50).diem }</td>
					  <td>${listData2.get(51).diem }</td>
					  <td>${listData2.get(52).diem }</td>
					  <td>${listData2.get(53).diem }</td>
					  <td>${listData2.get(54).diem }</td>
					  <td>${listData2.get(55).diem }</td>
					  <td>${listData2.get(56).diem }</td>
					  <td>${listData2.get(57).diem }</td>
					  <td>${listData2.get(58).diem }</td>
					  <td>${listData2.get(59).diem }</td>
					  <td>${listTotal.get(5)}</td>
					</tr>
					<tr>
					  <th scope="row">6</th>
					  <td>${listData2.get(60).diem }</td>
					  <td>${listData2.get(61).diem }</td>
					  <td>${listData2.get(62).diem }</td>
					  <td>${listData2.get(63).diem }</td>
					  <td>${listData2.get(64).diem }</td>
					  <td>${listData2.get(65).diem }</td>
					  <td>${listData2.get(66).diem }</td>
					  <td>${listData2.get(67).diem }</td>
					  <td>${listData2.get(68).diem }</td>
					  <td>${listData2.get(69).diem }</td>
					  <td>${listTotal.get(6)}</td>
					</tr>
					<tr>
					  <th scope="row">7</th>
					  <td>${listData2.get(70).diem }</td>
					  <td>${listData2.get(71).diem }</td>
					  <td>${listData2.get(72).diem }</td>
					  <td>${listData2.get(73).diem }</td>
					  <td>${listData2.get(74).diem }</td>
					  <td>${listData2.get(75).diem }</td>
					  <td>${listData2.get(76).diem }</td>
					  <td>${listData2.get(77).diem }</td>
					  <td>${listData2.get(78).diem }</td>
					  <td>${listData2.get(79).diem }</td>
					  <td>${listTotal.get(7)}</td>
					</tr>
					<tr>
					  <th scope="row">8</th>
					  <td>${listData2.get(80).diem }</td>
					  <td>${listData2.get(81).diem }</td>
					  <td>${listData2.get(82).diem }</td>
					  <td>${listData2.get(83).diem }</td>
					  <td>${listData2.get(84).diem }</td>
					  <td>${listData2.get(85).diem }</td>
					  <td>${listData2.get(86).diem }</td>
					  <td>${listData2.get(87).diem }</td>
					  <td>${listData2.get(88).diem }</td>
					  <td>${listData2.get(89).diem }</td>
					  <td>${listTotal.get(8)}</td>
					</tr>
					<tr>
					  <th scope="row">9</th>
					  <td>${listData2.get(90).diem }</td>
					  <td>${listData2.get(91).diem }</td>
					  <td>${listData2.get(92).diem }</td>
					  <td>${listData2.get(93).diem }</td>
					  <td>${listData2.get(94).diem }</td>
					  <td>${listData2.get(95).diem }</td>
					  <td>${listData2.get(96).diem }</td>
					  <td>${listData2.get(97).diem }</td>
					  <td>${listData2.get(98).diem }</td>
					  <td>${listData2.get(99).diem }</td>
					  <td>${listTotal.get(9)}</td>
					</tr>
				  </tbody>
				</table>
			</div>
			<hr style="width:100%;color:black;height:2px;background-color:black;text-align:left;margin-left:0px;"/>
			
			<div style="text-align:right">
				<p style="margin-top: -15px;">${hhLbl }</p>
				<p style="margin-top: -15px;">${luotVePer }%</p>
				<p style="margin-top: -15px;">${lai}%</p>
			</div>
			
			<div class="row" style="font-size:13px;margin-top: -15px;">
				<table class="table table-bordered table-condensed table-striped table-hover" style="width:100%;" id="tableResult">
				  <tbody>
					<tr>
					  <th>Đặc biệt</th>
					  <td colspan="12" style="text-align:center">${results.get(0).lotKey}</td>
					</tr>
					<tr>
					  <th>Giải nhất</th>
					  <td colspan="12" style="text-align:center;">${results.get(1).lotKey}</td>
					</tr>
					<tr>
					  <th>Giải nhì</th>
					  <td colspan="6" style="text-align:center;">${results.get(2).lotKey}</td>
					  <td colspan="6" style="text-align:center;">${results.get(3).lotKey}</td>
					</tr>
					<tr>
					  <th rowspan="2" style="text-align:left;padding-top:35px;">Giải ba</th>
					  <td colspan="4">${results.get(4).lotKey}</td>
					  <td colspan="4" style="text-align:center;">${results.get(5).lotKey}</td>
					  <td colspan="4" style="text-align:right;">${results.get(6).lotKey}</td>
					  <tr>
						  <td colspan="4">${results.get(7).lotKey}</td>
						  <td colspan="4" style="text-align:center;">${results.get(8).lotKey}</td>
						  <td colspan="4" style="text-align:right;">${results.get(9).lotKey}</td>
					  </tr>
					</tr>
					<tr>
					  <th>Giải tư</th>
					  <td colspan="3">${results.get(10).lotKey}</td>
					  <td colspan="3" style="text-align:center">${results.get(11).lotKey}</td>
					  <td colspan="3" style="text-align:center">${results.get(12).lotKey}</td>
					  <td colspan="3" style="text-align:right;">${results.get(13).lotKey}</td>
					</tr>
					<tr>
					  <th rowspan="2" style="text-align:left;">Giải năm</th>
					  <td colspan="4">${results.get(14).lotKey}</td>
					  <td colspan="4" style="text-align:center;">${results.get(15).lotKey}</td>
					  <td colspan="4" style="text-align:right;">${results.get(16).lotKey}</td>
					  <tr>
						  <td colspan="4">${results.get(17).lotKey}</td>
						  <td colspan="4" style="text-align:center;">${results.get(18).lotKey}</td>
						  <td colspan="4" style="text-align:right;">${results.get(19).lotKey}</td>
					  </tr>
					</tr>
					<tr>
					  <th>Giải sáu</th>
					  <td colspan="4">${results.get(20).lotKey}</td>
					  <td colspan="4" style="text-align:center">${results.get(21).lotKey}</td>
					  <td colspan="4" style="text-align:right;">${results.get(22).lotKey}</td>
					</tr>
					<tr>
					  <th>Giải bảy</th>
					  <td colspan="3">${results.get(23).lotKey}</td>
					  <td colspan="3" style="text-align:center;">${results.get(24).lotKey}</td>
					  <td colspan="3" style="text-align:center">${results.get(25).lotKey}</td>
					  <td colspan="3" style="text-align:right;">${results.get(26).lotKey}</td>
					</tr>
				  </tbody>
				</table>
			</div>
		</div>
		<div class="col-md-3" style="margin-left: 45px;">
			<label><h5><b>Bảng Đề</b></h5></label>
			<table class="table table-bordered table-condensed table-striped table-hover" id="myTable">
			  <thead>
				<tr>
				  <th scope="col">STT</th>
				  <th scope="col">Tiền đánh</th>
				  <th scope="col">Tiền trúng</th>
				  <th scope="col">Thứ hạng</th>
				</tr>
				<tr>
				  <th>${dataD.so }</th>
				  <th>${dataD.tienD }</th>
				  <th>${dataD.tienT }</th>
				  <th></th>
				</tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${listDe }" var="item">
			  		<tr>
					  <td>${item.so }</td>
					  <td>${item.tienD }</td>
					  <td>${item.tienT }</td>
					  <td>${item.hang }</td>
					</tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
	</div>	
	<br/>
	<br/>
</body>
<footer>
  <p>Author: TuanOle<br>
  <a href="mailto:tuanole@gmail.com">tuanole@gmail.com</a></p>
</footer>
<script>
	$(document).ready(function() {
		
		var out;
		var d = new Date();
		var n = d.getHours().toString() + d.getMinutes().toString();
		if(n > 1822 && n < 1835){
			alert("1");
			out = setTimeout(function() {
			    location.reload();
			}, 10000);	
		}
		
	$('#myTable').dataTable({
		"bPaginate": false,
		"scrollY":   "705px",
        "scrollCollapse": true,
		"bFilter": false, //hide Search bar
		"bInfo": false, // hide showing entries
		"bLength" : false,
	});
	
	$('#tableSortLo').dataTable({
		"bPaginate": false,
		"scrollY":   "700px",
        "scrollCollapse": true,
		"bFilter": false, //hide Search bar
		"bInfo": false, // hide showing entries
		"bLength" : false,
		"ordering": false
	});
	
	$('#tableLo').dataTable({
		"bPaginate": false,
		"scrollY":   "685px",
        "scrollCollapse": true,
		"bFilter": false, //hide Search bar
		"bInfo": false, // hide showing entries
		"bLength" : false,
	});
	$('#tableLo').DataTable();
	
	$('#tableResult').dataTable({
		"bPaginate": false,
		"scrollY":   "700px",
        "scrollCollapse": true,
		"bFilter": false, //hide Search bar
		"bInfo": false, // hide showing entries
		"bLength" : false,
		"ordering": false
	});
		
} );
</script>
</html>