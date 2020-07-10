<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<body>
	<div class="container" style="height: 50px; text-align: center">
		<h1 style="margin-top: 20px">NHẬP SỐ LIỆU ĐÁNH</h1>
	</div>
	<hr
		style="width: 100%; color: black; height: 3px; background-color: black;" />
	<br />
	<div class="container-fluid" style="margin-top: 0px;">
		<div class="row" style="margin-top: -20px">
			<div class="col-md-4"></div>
			<div class="col-md-4" style="border: 1px solid black;">
				<p style="text-align: center; font-size: 20px;">
					<b>Nhà Cái</b>
				</p>
				<div class="row">
					<div class="col-md-4" style="text-align: center">
						<input type="radio" id="a1" name="cai" value="1"> <label
							for="male">A1</label><br>
					</div>
					<div class="col-md-4" style="text-align: center">
						<input type="radio" id="b1" name="cai" value="2"> <label
							for="male">B1</label><br>
					</div>
					<div class="col-md-4" style="text-align: center">
						<input type="radio" id="c1" name="cai" value="3"> <label
							for="male">C1</label><br>
					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		<hr
			style="width: 100%; color: black; height: 3px; background-color: black;" />
		<br />
		<div class="row" style="margin-top: -20px">
			<div class="col-md-3"></div>
			<div class="col-md-6" style="text-align: center;">
				<label>Mã Khách Hàng: </label> <input type="text" id="uid"
					name="userId" placeholder="Yêu cầu nhập mã khách hàng!"
					style="width: 300px;" required></input> <input type="button"
					id="btnCheck" name="btnCheck" value="Kiểm Tra"></input>
			</div>
			<div class="col-md-3"></div>
		</div>

		<div class="row" style="margin-top: 20px">
			<div class="col-md-5">
				<div class="row">
					<div class="col-md-2" style="text-align: right;">
						<h5>LÔ:</h5>
					</div>
					<div class="col-md-7">
						<textarea rows="3" cols="45" name="usrtxt" wrap="hard"
							placeholder="Nhập số liệu lô!"></textarea>
						<input type="button" id="genLo" name="genLo" value="Kết Quả"></input>
					</div>
				</div>

				<div class="row" style="margin-top: 20px">
					<div class="col-md-2" style="text-align: right;">
						<h5>ĐỀ:</h5>
					</div>
					<div class="col-md-7">
						<textarea rows="3" cols="45" name="usrtxt" wrap="hard"
							placeholder="Nhập số liệu đề!"></textarea>
						<input type="button" id="genDe" name="genDe" value="Kết Quả"></input>
					</div>
				</div>

				<div class="row" style="margin-top: 20px">
					<div class="col-md-2" style="text-align: right;">
						<h5>XIÊN:</h5>
					</div>
					<div class="col-md-7">
						<textarea rows="3" cols="45" name="usrtxt" wrap="hard"
							placeholder="Nhập số liệu xiên!"></textarea>
						<input type="button" id="genXien" name="genXien" value="Kết Quả"></input>
					</div>
				</div>
			</div>

			<div class="col-md-2" style="border: 1px solid black;">
				<p>Bảng Lô</p>
				<table class="table table-sm table-dark fixed_header">
					<thead>
						<tr>
							<th style="width: 85px; font-size: 15px;">Số Đánh</th>
							<th style="width: 85px; font-size: 15px;">Điểm</th>
						</tr>
					</thead>
					<tbody>
						<script language="javascript" type="text/javascript">
							for (var a = 0; a < 10; a++) {
								document.write("<tr>");
								for (var b = 0; b < 1; b++) {
									document
											.write("<td contenteditable='true'>"
													+ 15 + "</td>");
									document
											.write("<td contenteditable='true'>"
													+ 50 + "</td>");
								}
								document.write("</tr>");
							}
						</script>
					</tbody>
				</table>
			</div>

			<div class="col-md-2" style="border: 1px solid black;">
				<p>Bảng Đề</p>
				<table class="table table-sm table-dark fixed_header">
					<thead>
						<tr>
							<th style="width: 85px; font-size: 15px">Số Đánh</th>
							<th style="width: 85px; font-size: 15px">Tiền(K)</th>
						</tr>
					</thead>
					<tbody>
						<script language="javascript" type="text/javascript">
							for (var a = 0; a < 10; a++) {
								document.write("<tr>");
								for (var b = 0; b < 1; b++) {
									document
											.write("<td contenteditable='true'>"
													+ 15 + "</td>");
									document
											.write("<td contenteditable='true'>"
													+ 50 + "</td>");
								}
								document.write("</tr>");
							}
						</script>
					</tbody>
				</table>
			</div>

			<div class="col-md-2" style="border: 1px solid black;">
				<p>Bảng Xiên</p>
				<table class="table table-sm table-dark fixed_header">
					<thead>
						<tr>
							<th style="width: 85px; font-size: 15px">Số Đánh</th>
							<th style="width: 85px; font-size: 15px">Tiền(K)</th>
						</tr>
					</thead>
					<tbody>
						<script language="javascript" type="text/javascript">
							for (var a = 0; a < 10; a++) {
								document.write("<tr>");
								for (var b = 0; b < 1; b++) {
									document
											.write("<td contenteditable='true'>"
													+ 15 + "</td>");
									document
											.write("<td contenteditable='true'>"
													+ 50 + "</td>");
								}
								document.write("</tr>");
							}
						</script>
					</tbody>
				</table>
			</div>

		</div>
		<br />
		<div class="row">
			<div class="col-md-5"></div>
			<div class="col-md-2">
				<a href="/thongke"> <input type="button" id="submit"
					value="Lưu Lại"></input>
				</a>
			</div>
			<div class="col-md-5"></div>
		</div>
	</div>
	<br />
</body>
<footer>
	<p>
		Author: TuanOle<br> <a href="mailto:tuanole@gmail.com">tuanole@gmail.com</a>
	</p>
</footer>
</html>
