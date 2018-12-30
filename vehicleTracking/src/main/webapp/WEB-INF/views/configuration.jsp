<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Configuration</title>
</head>
<body>
	<form:form id="form" method="POST" class="cleanform" modelAttribute="configurationForm" 
		enctype="multipart/form-data">
		
		<div>
			<table>
				<tr>
					<td>File to upload:</td>
					<td><input type="file" name="file" /></td>
					<td><input type="submit" name="upload" value="Upload" /></td>
				</tr>
				<tr>
					<td>Start Writer/Reader services:</td>
					<td><button id="start" type="submit" name="start"
							value="start" style="width: 80px">Start</button></td>
					<td/>
				</tr>
			</table>
		</div>		
	</form:form>
</body>
</html>