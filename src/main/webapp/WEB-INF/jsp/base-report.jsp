<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<title>Báo Cáo</title>
<body style="width: 100%">
	<div class="container" style="text-align:center;">
		<h1>THỐNG KÊ KẾT QUẢ</h1>
	</div>
	<hr style="width:100%;color:black;height:3px;background-color:black;"/>
	<br/>
	<div class="row">
		<div class="col-md-2" style="margin-left:50px;"></div>
		<div class="col-md-7">
			<p>Bảng nhà cái vào</p>
			<table class="table table-bordered table-condensed table-striped table-hover" id="myTable">
				<tr>
				  <th rowspan="2" style="text-align:center;">ID</th>
				  <th colspan="5" style="text-align:center;">Lô</th>
				  <th colspan="3" style="text-align:center;">Đề</th>
				  <th rowspan="2" style="text-align:center;">Total</th>
				  <th rowspan="2" style="text-align:center;">HH</th>
				</tr>
				<tr>
				  <th>Tổng điểm</th>
				  <th>Tổng thắng</th>
				  <th>Tiền đánh</th>
				  <th>Tiền thắng</th>
				  <th>Chốt</th>
				  <th>Tiền đánh</th>
				  <th>Tiền thắng</th>
				  <th>Chốt</th>
				</tr>
				<c:forEach items="${listBaseIn }" var="item">
					<tr>
						<td>${item.id }</td>
						<td>${item.sumDiemLo }</td>
						<td>${item.sumDiemWinLo }</td>
						<td>${item.sumTienLo }</td>
						<td>${item.sunTienWinLo }</td>
						<td>${item.chotLo }</td>
						<td>${item.sumTienDe }</td>
						<td>${item.sumTienWinDe }</td>
						<td>${item.chotDe }</td>
						<td>${item.total }</td>
						<td>${item.hh }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-md-3"></div>
	</div>	
	<br/>
	<div class="row">
		<div class="col-md-2" style="margin-left:50px;"></div>
		<div class="col-md-7">
			<p>Bảng nhà cái ra</p>
			<table class="table table-bordered table-condensed table-striped table-hover" id="myTable1">
				<tr>
				  <th rowspan="2" style="text-align:center;">ID</th>
				  <th colspan="5" style="text-align:center;">Lô</th>
				  <th colspan="3" style="text-align:center;">Đề</th>
				  <th rowspan="2" style="text-align:center;">Total</th>
				  <th rowspan="2" style="text-align:center;">HH</th>
				</tr>
				<tr>
				  <th>Tổng điểm</th>
				  <th>Tổng thắng</th>
				  <th>Tiền đánh</th>
				  <th>Tiền thắng</th>
				  <th>Chốt</th>
				  <th>Tiền đánh</th>
				  <th>Tiền thắng</th>
				  <th>Chốt</th>
				</tr>
				<c:forEach items="${listBaseOut }" var="item">
					<tr>
						<td>${item.id }</td>
						<td>${item.sumDiemLo }</td>
						<td>${item.sumDiemWinLo }</td>
						<td>${item.sumTienLo }</td>
						<td>${item.sunTienWinLo }</td>
						<td>${item.chotLo }</td>
						<td>${item.sumTienDe }</td>
						<td>${item.sumTienWinDe }</td>
						<td>${item.chotDe }</td>
						<td>${item.total }</td>
						<td>${item.hh }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-md-3"></div>
	</div>
	<br/>
	<div class="row">
		<div class="col-md-2" style="margin-left:50px;"></div>
		<div class="col-md-7">
			<p>Bảng tổng</p>
			<table class="table table-bordered table-condensed table-striped table-hover" id="myTable2">
				<tr>
				  <th style="text-align:center;">ID</th>
				  <th style="text-align:center;">Tổng Lô(Điểm)</th>
				  <th style="text-align:center;">Tổng Đề(K)</th>
				  <th style="text-align:center;">HH(K)</th>
				</tr>
				<tr>
					<td>${baseTotal.id }</td>
					<td>${baseTotal.sumDiemLo }</td>
					<td style="text-align: right;">${baseTotal.sumTienDe }</td>
					<td style="text-align: right;">${baseTotal.hh }</td>
				</tr>
			</table>
		</div>
		<div class="col-md-3"></div>
	</div>		
	<br/>
</body>
<footer>
  <p>Author: TuanOle<br>
  <a href="mailto:tuanole@gmail.com">tuanole@gmail.com</a></p>
</footer>
</html>