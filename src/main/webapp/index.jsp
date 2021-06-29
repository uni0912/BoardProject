<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo28.domain.*" %>
<%@ page import="kr.ac.kopo.kopo28.service.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	$( document ).ready(function() {
    	console.log( "ready!" );
    	
    	console.log(document);
    	
    	$( "#target" ).click(function() {
    		  alert( "Handler for .click() called." );
    		});
	});	
</script>
</head>
<body>
<h1 style="margin-left: 70px;">자유게시판</h1>
<%  
 BoardService boardService = new BoardServiceImpl();
 List<Board> boards = boardService.selectAll();
 request.setAttribute("boards", boards);
%>
 
<div>Board List</div>

<%
	for(Board board: boards) {
		out.println("<p>" + board.getId() + ". " + board.getTitle()+"</p>");
	}
%>

<c:forEach var="board" items="${boards}">
	<p><c:out value="${board.id}. ${board.title}"/></p>
</c:forEach>

</body>
</html>








