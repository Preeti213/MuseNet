<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Google Search Example</title>
</head>
<body>
    <h1>Search Google</h1>
   <% response.setHeader("Content-Disposition", null);
   String searchText = (String)session.getAttribute("searchText") ;%>
   <iframe width="400" height="400" id="cseFrame"></iframe>
<script>
    var searchText = "<%= searchText %>";
    var iframeSrc = "https://cse.google.com/cse.js?cx=15fbcf2665dd14a8a" + encodeURIComponent(searchText);
    document.getElementById("cseFrame").src = iframeSrc;
</script>


</body>
</html>