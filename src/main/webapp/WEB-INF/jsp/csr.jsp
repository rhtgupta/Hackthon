<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSR Portal</title>
<style>
.vertical {
	border-left: 3px solid black;
	height: 600px;
	position: absolute;
	left: 50%;
}

,
.vertical.tbl {
	left: 150px;
}
</style>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#queryBtn").click(function(e) {

			$.ajax({
				url : "sendQuery",
				data : {
					question : $("#question").val()
				},
				type : "POST",
				success : function(response) {
					console.log("value "+response);
					$('#solution').html(response);
				}
			});

		});
	});
</script>
</head>
<body>
	<form:form>
		<div>
			Welcome to CSR Portal
			<div>
				<br /> <br /> Select a Query:&nbsp; <select name="category"
					id="question">
					<c:forEach items="${questions}" var="question">
						<option value="${question}">${question}</option>
					</c:forEach>
				</select> <input type="button" name="Query" value="Query" id="queryBtn">
			</div>
			<br />
			<div>
				Solution :
				<div id="solution"></div>
			</div>
			<div class="vertical">
				<div>
					<table class="tbl">
						<c:forEach items="${suggestions}" var="suggestion"
							varStatus="status">
							<br />
							<tr>
								<c:out value="${suggestion.question}" />
							</tr>
							<br />
							<tr>
								<c:out value="${suggestion.answer}" />
							</tr>
							<br />
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>