<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<script type="text/javascript">
	function pageMove(pg) {
		document.getElementById("pg").value = pg;
		document.getElementById("pageform").action = "${root}/mobile/list";
		document.getElementById("pageform").submit();
	}
	function dels() {
		document.getElementById("dels").action = "${root}/mobile/deletes";
		document.getElementById("dels").submit();
	}
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>


	<div class="container text-center mt-3">
		<div class="col-lg-8 mx-auto">
			<form name="pageform" id="pageform" method="get" action="">
				<input type="hidden" name="pg" id="pg" value="">
			</form>

			<h2 class="p-3 mb-3 shadow bg-light">
				<mark class="sky">핸드폰 등록 조회</mark>
				<button type="button" class="btn btn-danger " onclick="dels()">선택삭제</button>
			</h2>
			<%-- 페이지만의 내용 --%>
			<form action="#" method="post" id="dels">
				<table class="table table-active text-left" border="1">
					<tr class="table-info">
						<td>고유 번호</td>
						<td>모델명</td>
						<td>가격</td>
						<td>제조사</td>
						<td>선택 삭제</td>
					</tr>

					<c:forEach items="${mobileList }" var="m" varStatus="cnt">
						<tr class="table-danger">
							<td><a
								href="${root }/mobile/view?mobileCode=${m.mobileCode }">${m.mobileCode }</a></td>
							<td>${m.model }</td>
							<td>${m.price }</td>
							<td>${m.company }</td>
							<td><input type="checkbox" name="isbn"
								value="${m.mobileCode }"></td>
						</tr>
					</c:forEach>
				</table>
			</form>
			<center>
				<table class="text-center">
					<tr>
						<td>${navigation.navigator }</td>
					</tr>
				</table>
			</center>
			<a href="${root }">초기화면</a>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>