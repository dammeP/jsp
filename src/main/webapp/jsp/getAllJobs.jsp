<%@page import="kr.or.ddit.jobs.VO.JobsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1px solid black">
		<tr>
		<th>JOb_ID</th>
		<th>JOb_TITLE</th>
		</tr>
		
		<%
			List<JobsVO> JobsList = (List<JobsVO>)request.getAttribute("jobsList");
			for(int i=0; i<JobsList.size(); i++){
		%>
		<tr>
			<td><%=JobsList.get(i).getJob_id() %></td>
			<td><%=JobsList.get(i).getJob_title() %></td>
		</tr>
		
		<% 		
			}
		%>
		
	
	</table>

</body>
</html>