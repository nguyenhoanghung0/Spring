<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Vehicle Tracking System</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.core.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.theme.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.tabs.css" />" rel="stylesheet" type="text/css"/>
	
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.core.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.widget.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.tabs.js" />"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#tabs").tabs();
		
			// Append '#' to the window location so "Back" returns to the selected tab
			// after a redirect or a full page refresh (e.g. Views tab).
		
			// However, note this general disclaimer about going back to previous tabs: 
			// http://docs.jquery.com/UI/API/1.8/Tabs#Back_button_and_bookmarking
		
			$("#tabs").bind("tabsselect", function(event, ui) { window.location.hash = ui.tab.hash; });
		});
	</script>
</head>
<body class="home">
	<div id="tabs">
		<ul>
			
			<li><a href="<c:url value="/configuration" />" title="configuration">Configuration</a></li>
			<%-- <li><a href="<c:url value="/tripinformation" />" title="tripinformation">Trip Information</a></li> --%>
		</ul>
	</div>

</body>
</html>
