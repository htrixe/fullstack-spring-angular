<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Image</title>
</head>
<body>
	<h3 style="color: red;">Add New Image</h3>

	<div id="addImage">
		<form action="http://localhost:8080/oauth/authorize"
			method="post" modelAttribute="emp">
			
				 <input type="hidden" type="text" name="response_type" value="code" /> 
				 <input type="hidden" type="text" name="client_id" value="photoclient" />
				 <input type="hidden" type="text" name="redirect_uri" value="http://localhost:8081/showImages" />
				 <input type="SUBMIT" value="Get Protected Resource!" />
		</form>
	</div>
</body>
</html>
