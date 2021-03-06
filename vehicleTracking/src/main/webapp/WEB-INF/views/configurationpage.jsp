<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;">
	<title>Configuration</title>
	<script type="text/javascript">
		
	</script>
</head>
<body>
	<form:form id="form" method="POST" class="cleanform" modelAttribute="configurationForm" 
		enctype="multipart/form-data">
		
		<table>
			<tr>
				<td><form:label path="">File to upload:</form:label></td>
				<td><input type="file" name="file" /></td>
				<td><input type="submit" name="upload" value="Upload" 
					style="background-color: rgb(99, 177, 117);color:#ffffff"/></td>
			</tr>
			<tr>
				<td><form:label path="numberOfVehicles">Number Of Vehicles:</form:label></td>
				<td><form:input path="numberOfVehicles" disabled="true"/></td>
				<td></td>
			</tr>
			<tr>
				<td><form:label path="numberOfRecordsPerPage">Page Size:</form:label></td>
				<td><form:input path="numberOfRecordsPerPage" /></td>
				<td></td>
			</tr>
			<tr>
				<td><form:label path="writerPeriod">Writer Period:</form:label></td>
				<td><form:input id="writerPeriod" path="writerPeriod" /></td>
				<td>seconds</td>
			</tr>
			<tr>
				<td><form:label path="readerPeriod">Reader Period:</form:label></td>
				<td ><form:input id="readerPeriod" path="readerPeriod" /></td>
				<td>seconds</td>
			</tr>
			<tr>
				<td><form:label path="">Start services:</form:label></td>
				<td><form:button id="start" type="submit" name="start"
						value="start" style="width: 80px" onclick="return validate();">Start</form:button></td>
				<td/>
			</tr>
			<tr>
				<td colspan="3">
					<form:textarea id="errorList" path="errorList"></form:textarea>
				</td>
			</tr>
		</table>
		
	</form:form>
	
</body>
</html>