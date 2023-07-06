<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Dodaj pajaka</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"> 
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/dodaj.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    	
    	
    <style>
    	.error{color:red}
    </style>
</head>

<body>
    
     <div class="main">
        <div class="sidebar">
            <div class="logo">
                <img alt="logo" src="${pageContext.request.contextPath}/resources/LOGO.png">
            </div>
            <div class="menu">
                <ul>
                    <li><input type="button" value="Strona glowna" onclick="window.location.href='list'; return false;" class="add-button" /></li>
                </ul>
            </div>
        </div>
        <div class="zawartosc-glowna">
            <div class="tekst">
                <h3>Formularz dodawania pajaka</h3>
            </div>
            
            <div class="info">
            	<div class="form-outline w-25">
	            	<form:form action="zapiszPajaka" modelAttribute="pajaki" method="GET">
	            	<form:hidden path="id" />
		                <div class="mb-2">
		                    <label class="form-label">Rodzaj</label>
		                    <form:input class="form-control" path="rodzaj" type="text" /> 
		       			    <form:errors path="gatunek" cssClass="error" />
		                </div>
		                <div class="mb-2">
		                    <label class="form-label">Gatunek</label>
		                    <form:input class="form-control" path="gatunek" />
		                    <form:errors path="gatunek" cssClass="error" />
		                </div>
		                <div class="mb-2">
		                    <label class="form-label">Rozmiar</label>
		                    <form:input class="form-control" path="rozmiar"/>
		                    <form:errors path="rozmiar" cssClass="error" />
		                </div>
		                <div class="mb-2">
		                    <label class="form-label">Wylinka</label>
		                    <form:input class="form-control" path="wylinka" type="date" />
							<form:errors path="wylinka" cssClass="error" />
		                    <input type="submit" value="Zapisz" class="zapisz" />   
		                </div> 
	           		</div>
            		</form:form>    
            </div> 
        </div>
     </div>
</body>

</html>