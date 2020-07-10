<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<body>
	<div class="container" style="text-align:center;">
		<h1>THÔNG TIN NGƯỜI DÙNG</h1>
	</div>
	<hr style="width:100%;color:black;height:3px;background-color:black;"/>
	<br/>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6" style="text-align:center;">
			<input type="text" placeholder="Tìm kiếm..." name="search" id="txtSearch"></input>
			<input type="button" value="Tìm kiếm" id="search"></input>
		</div>
		<div class="col-md-3"></div>
	</div>
	<br/>
	<br/>
	<div class="row">
		<div class="col-md-2" style="margin-left:20px;"></div>
		<div class="col-md-8">
			<table class="table table-hover table-dark">
			  <thead>
				<tr>
				  <th scope="col">Tên Khách Hàng</th>
				  <th scope="col">Mã Khách Hàng</th>
				  <th scope="col">Số Điện Thoại</th>
				  <th scope="col">Loại Khách Hàng</th>
				  <th scope="col">Rank</th>
				</tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${users}" var="user">
			  	<tr>
				  <td>${user.userName}</td>
				  <td><a href="/infor?userId=${user.userId}">${user.userId}</a></td>
				  <td>${user.userPhone}</td>
				  <td>${user.userDes}</td>
				  <td>${user.rank }</td>
				</tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
		<div class="col-md-2"></div>
	</div>
</body>
<footer>
  <p>Author: TuanOle<br>
  <a href="mailto:tuanole@gmail.com">tuanole@gmail.com</a></p>
</footer>
</html>
