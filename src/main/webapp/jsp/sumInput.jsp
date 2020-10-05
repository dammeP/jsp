<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form id="sumInput" action="<%= request.getContextPath()%>/sumCalculation" method="post">
		start : <input type="text" name="firstNum" placeholder="첫번째 값"><br> 
		end : <input type="text" name="secondNum" placeholder="두번째 값"> <br>
		<input type="submit" value="=" >
	
	</form>

</body>
</html>