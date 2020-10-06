<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/mulCalculation" method="post">
		first : <input type="text" name="param1"><br>
		second : <input type="text" name="param2"><br>
		출력<input type="submit" value="=">
	
	
	</form>

</body>
</html>