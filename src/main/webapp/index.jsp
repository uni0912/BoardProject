<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.kopo.kopo28.domain.*" %>
<%@ page import="kr.ac.kopo.kopo28.service.*" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script>
	$( document ).ready(function() {
    	console.log( "ready!" );
    	
    	concole.log(document);
    	
    	$( "#target" ).click(function() {
    		  alert( "Handler for .click() called." );
    		});
	});
	
	
</script>
</head>
<body>
<%
	BoardService boardService = new BoardServiceImpl();
	Board board1 = boardService.selectOne(1);
	
	
%>
hello world
board title: <%= board1.getTitle() %>
abcdfjkdsl

<div id="target">
  Click here
</div>
<div id="other">
  Trigger the handler
</div>
</body>
</html>








