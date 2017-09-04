<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add file</title>
</head>
<body>
	<c:if test="${name != null}">
		name:${name}
	</c:if>
	<br />
	<c:if test="${size != null}">
		size:${size}
	</c:if>
	<form method="post" action="${pageContext.request.contextPath}/user/file" enctype="multipart/form-data">
		name:<input type="text" name="name" /><br />
		file:<input type="file" name="file" /><br />
		<input type="submit" value="add  file" />
	</form>
</body>
</html>