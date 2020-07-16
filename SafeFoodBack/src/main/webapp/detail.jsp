<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세정보</title>
<!-- bootstrap 3.3.7이하는 jQuery 1.x, 3.3.7이상으로 업그레이드 필요 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- jQuery 추가 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);

.container {
	margin-bottom: 10px;
}

#navbar {
	padding-right: 20px;
}

footer {
	background: #f0f0f0;
	padding: 5px 15px 10px 15px;
}

#nut {
	margin-top: 50px;
}

#info th {
	text-align: center;
	width: 80px;
}

#nutr th {
	text-align: center;
	width: 100px;
}
</style>
</head>
<body>
	<jsp:include page="/top.jsp" />

	<div class="container">
		<h2 class="text-center">제품 정보</h2>
		<br>
		<br>
		<div class="row">
			<div id="image" class="col-md-3">
			<img src="${food.img}" width="80%">
			
			</div>
			<div class="col-md-9">
				<table id="info" class="table">
					<tr>
						<th>제품명</th>
						<td id="name">${food.name}</td>
					</tr>
					<tr>
						<th>제조사</th>
						<td id="maker">${food.maker}</td>
					</tr>
					<tr>
						<th>원재료</th>
						<td id="material">${food.material}</td>
					</tr>
					<tr>
						<th>알레르기 성분</th>
						<td id="aller">${food.allergy}</td>
					</tr>
				</table>
				<div class="row">
					<form method="post" action="insertHistory.do">
						<div class="col-md-3">
							<label for="search">Quantity</label>
							<input type="number" id="count" name="count" class="form-control">
							<br>
							<input type="hidden" id="code" name="code" value=${food.code }>
							<input type="submit" id="add" class="btn btn-default" value="추가">
						</div>
					</form>
				</div>
				<br>
				<!-- 				<div class="btn-group" role="group" aria-label="..."> -->
				<!-- 					<button type="button" class="btn btn-default"> -->
				<!-- 						<span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span> -->
				<!-- 						찜 -->
				<!-- 					</button> -->
				<!-- 				</div> -->

			</div>
		</div>
	</div>

	<div class="container" id="nut">
		<h4>영양 정보</h4>
		<div class="row">
			<div class="col-md-6" id="drawChart" style="width: 550px; height: 500px;">
			
			</div>
			<div class="col-md-6" style="padding:93px 0 0 0;">
				<table id="nutr" class="table" >
					<tr>
						<th>일회 제공량</th>
						<td id="wt">${food.supportpereat}</td>
					</tr>
					<tr>
						<th>칼로리</th>
						<td id='cal'>${food.calory}</td>
					</tr>
					<tr>
						<th>탄수화물</th>
						<td id='carbo'>${food.carbo}</td>
					</tr>
					<tr>
						<th>단백질</th>
						<td id='prot'>${food.protein}</td>
					</tr>
					<tr>
						<th>지방</th>
						<td id='fat'>${food.fat}</td>
					</tr>
					<tr>
						<th>당류</th>
						<td id='sugar'>${food.sugar}</td>
					</tr>
					<tr>
						<th>나트륨</th>
						<td id='na'>${food.natrium}</td>
					</tr>
					<tr>
						<th>콜레스테롤</th>
						<td id='col'>${food.chole}</td>
					</tr>
					<tr>
						<th>포화 지방산</th>
						<td id='acid'>${food.fattyacid}</td>
					</tr>
					<tr>
						<th>트랜스지방</th>
						<td id='trans'>${food.transfat}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<jsp:include page="/bottom.jsp" />
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	let wt = ${food.supportpereat};
	let cal = ${food.calory};
	let carbo = ${food.carbo};
	let prot =${food.protein};
	let fat = ${food.fat};
	let sugar =${food.sugar};
	let na = ${food.natrium};
	let col = ${food.chole};
	let acid = ${food.fattyacid};
	let trans = ${food.transfat};

	google.charts.load("current", {	packages : [ "corechart" ]	});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = google.visualization.arrayToDataTable(
				[ [ 'Task', '영양 정보' , { role: "style" }],
				[ '칼로리', parseFloat(cal),"#6195d0" ], 
				[ '탄수화물', parseFloat(carbo) ,"#d3fb00"],
				[ '단백질', parseFloat(prot),"#f7fc61" ], 
				[ '지방', parseFloat(fat) ,"#fb9c00"],
				[ '당류', parseFloat(sugar),"#61d6d0" ], 
				[ '나트륨', parseFloat(na) ,"#f85967"],
				[ '콜레스테롤', parseFloat(col),"#6459d8" ],
				[ '포화지방산', parseFloat(acid),"#f8c567" ],
				[ '트랜스지방', parseFloat(trans),"#645967" ], ]);
		var formatter = new google.visualization.NumberFormat({
			pattern : '###.###'
		});
		formatter.format(data, 1);
		var view = new google.visualization.DataView(data);
		
		var options = {
		        bar: {groupWidth: "95%"},
		        legend: { position: "none" },
		      };
		var chart = new google.visualization.ColumnChart(document.getElementById("drawChart"));
		
		chart.draw(view, options);
	}
</script>
</html>