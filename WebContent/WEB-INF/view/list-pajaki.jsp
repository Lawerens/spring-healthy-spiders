<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spiders breed site</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    
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
               <li><input type="button" value="Dodaj" onclick="window.location.href='addForm'; return false;" class="add-button" /></li>
               <div class="dropdown">
                <li>
                	<input type="button" value="Sortuj" class="add-button">
                    <ul><input type="button" value="Malejaco" onclick="window.location.href='sortowanieM'; return false;" class="sort-button" /></ul>
                    <ul><input type="button" value="Rosnaco" onclick="window.location.href='sortowanieR'; return false;" class="sort-button" /></ul>
                </li>
               </div>
               <li>
               	<form:form action="wyszukaj" method="GET"> 
               		<input type="submit" value="Wyszukaj" class="add-button" data-toggle="validator" />
               		<input type="text" name="szukanaNazwa" placeholder="Rodzaj/Gatunek" required />
               	</form:form>
               </li>
           </ul>
       </div>
   </div>
          <div class="zawartosc-glowna">
       <div class="tekst">
           <h2>Strona glowna</h2>
       </div>
       <div class="info">
           <div class="table-responsive">
               <table class="table text-light">
                   <tr>
                       <th>Rodzaj</th>
                       <th>Gatunek</th>
                       <th>Rozmiar</th>
                       <th>Wylinka</th>
                   </tr>
                   
                   <c:forEach var="tempSpider" items="${pajaki}">
                       <c:url var="edytuj" value="/pajaki/edytujPajaka">
                           <c:param name="IdPajak" value="${tempSpider.id}" />
                       </c:url>
                       <c:url var="usun" value="/pajaki/usunPajaka">
                           <c:param name="IdPajak" value="${tempSpider.id}" />
                       </c:url>

                       <tr>
                           <td>${tempSpider.rodzaj} </td>
                           <td>${tempSpider.gatunek} </td>
                           <td>${tempSpider.rozmiar} </td>
                           <td>${tempSpider.wylinka} </td>
                           <td>
                               <a href="${edytuj}" class="opcje">Edytuj</a>
                           </td>
                           <td>    
                               <a href="${usun}" onclick="if(!(confirm('Czy na pewno chcesz usunac ten element?'))) return false" class="opcje">Usun</a>
                           </td>
                       </tr>
					</c:forEach>
               </table>
           </div>
       </div>
     </div>
</div>
     
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>     
</body>
</html>