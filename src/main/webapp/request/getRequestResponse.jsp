<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<h1>GET</h1>
	userId 파라미터는 brown, sally 두개를 보내지만 getParameter를 호출하면
	첫번째 파라미터 값을 반환<br>
	request.getParameter("userId") : <%=request.getParameter("userId") %><br><br>

	String[]을 반환<br>
	request.getParameterValues("userId") : 
	<%
		String[] userIds = request.getParameterValues("userId");
		for(String userId : userIds){
			
	%>
		<%=userId %>
	<% 
		}
	%>	<br><br>
	
	parameterMap : Map<String, String[]>
	request.getParameterMap() : <%= request.getParameterMap() %><br><br>
	
	<%
		Enumeration<String> parameters = request.getParameterNames();
		while(parameters.hasMoreElements()){
			String userId = parameters.nextElement(); %>
			
	<%=userId %> 
	<%		
		}
	%>
</body>
</html>