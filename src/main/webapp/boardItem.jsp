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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  
 BoardItemService boardItemService = new BoardItemServiceImpl();
 List<BoardItem> boardItems = boardItemService.selectAll();
 request.setAttribute("boardItems", boardItems);
%>
 
<div>BoardItem List</div>

<table border =" 1px solid black" class="table table-hover container">
            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>등록일자</th>
            </tr>
        </thead>
        <tbody>
<c:forEach var="boardItem" items="${boardItems}">
	<tr>
	<td><c:out value="${boardItem.id} "/></td>
	<td><c:out value="${boardItem.title}"/></td>
	<td><c:out value="${boardItem.date}"/></td>	
	</tr>
</c:forEach>
</tbody>
        </table>
</body>
</html>