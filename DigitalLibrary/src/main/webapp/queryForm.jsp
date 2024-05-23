<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="Library.*" %>
   
<%@ page import="java.util.Base64" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" %>

<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="home.css">
<script src="https://kit.fontawesome.com/30f7b0adf2.js" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">

<link rel="stylesheet" href="form.css" />
<!-- profile Container -->
 <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
    />
    <link rel="stylesheet" href="testProfile.css" />
 
 
<title>Query Form</title>
</head>
<body>

	<% 
		List<String> authors = (List)session.getAttribute("authors");
		List<String> genres = (List)session.getAttribute("genres"); 
	 	List<Book> list = (List)session.getAttribute("booksList");
	 	User  user = (User)session.getAttribute("userDetails");
	 	List<Book> userWishlist = (List)session.getAttribute("userWishlist");
	 %>
	 <!-- Drop Down Side Nav -->
 	<div class="sidenav">

		<a href="home.jsp" class="home-button">Home</a>
		<a href="bookDirectoryMain" class="home-button"> All Books</a>
		
 		<!-- show author names -->
        <button class="dropdown-btn">Author<i class="fa fa-caret-down"></i> </button>
        <div class="dropdown-container" id="filter">
            <% 
                for (String a: authors) { 
            %> 
           <a href="filterBooks?value1=author&value2=<%= a %>"><%= a %></a>
            <% 
                } 
            %> 
        </div>
        
        <!-- show genre names -->
        <button class="dropdown-btn">Genre<i class="fa fa-caret-down"></i></button>
        <div class="dropdown-container" id="filter"> 
            <% 
                for (String g: genres) { 
            %> 
            <a href="filterBooks?value1=genre&value2=<%= g %>"><%= g %></a>	
            <% 
                } 
            %> 
        </div>
        <a href="requestNewBookForm.jsp" class="home-button">Request Book</a>
        <a href="contactUs.jsp" class="home-button">Contact Us</a>
       
        
           
	</div> 
	
	
		
  <!-- Profile Container -->
	
      <div class="profile-dropdown">
        <div onclick="toggle()" class="profile-dropdown-btn">
          <div class="profile-img" id="profileImg"  >
          
            <i class="fa-solid fa-circle"></i>
          </div>
           
          <span><%= user.getName() %>
            <i class="fa-solid fa-angle-down"></i>
          </span>
          
        </div>

        <div class="profile-dropdown-list">
          <div class="profile-dropdown-list-item">
            <a href="editProfile.jsp">
              <i class="fa-regular fa-user"></i>
              Edit Profile
            </a>
          </div>

          <div class="profile-dropdown-list-item">
            <a href="#">
              <i class="fa-regular fa-envelope"></i>
              Inbox
            </a>
          </div>

          <div class="profile-dropdown-list-item">
            <a href="userWishlist.jsp">
              <i class="fa-solid fa-chart-line"></i>
             WishList
            </a>
          </div>

          <div class="profile-dropdown-list-item">
            <a href="">
              <i class="fa-solid fa-sliders"></i>
              Settings
            </a>
          </div>

          <div class="profile-dropdown-list-item">
            <a href="queryForm.jsp">
              <i class="fa-regular fa-circle-question"></i>
              Help & Support
            </a>
          </div>
          <hr />

          <div class="profile-dropdown-list-item">
           <% 
    			boolean isLoggedIn = (user.getId() != null);
    			if (isLoggedIn) { 
			%>
			<a href="logout">
              <i class="fa-solid fa-arrow-right-from-bracket"></i>
              Log out
            </a>
			<% } else { %>
   		 <a href="login.jsp">
              <i class="fa-solid fa-arrow-right-from-bracket"></i>
              Log In
            </a>
			<% } %>
         
          </div>
        </div>
      </div>
	
<div class = "main-content-box">
	<div class="main">
		<a href="bookDirectoryMain" >
		    <div class = "museNet">MuseNet</div>
		   <div class= "quote"> Unleash your inner bibliophile.</div>
		    </a>
		  </div>
	
	<div class="auth-page">
    <div class="container page">
        <div>
          <h1 class="heading">QUERY FORM</h1>
          <form action ="addQuery" method = "post" enctype="multipart/form-data">
          
             <label class="label">Title</label>
            <div class="input-container">
             <input type="text" id="title" name="title" placeholder = "Enter a descriptive title for your query" class="auth-input" required><br>
            </div>
             <label class="label">Describe your issue or query:</label>
            <div class="input-container">
               <textarea name="description" id="description" cols="100" rows="8" placeholder="Please provide as much detail as possible to help us assist you effectively..." class="auth-input"></textarea>
             </div>
             <label class="label">Attachments:</label>
            <div class="input-container">
              <input type="file" name="pdf" class="auth-input">
              </div>
              <label class="label">Additional Notes</label>
            <div class="input-container">
               <textarea name="description" id="description" cols="100" rows="8" placeholder="Add any extra information that might be helpful..." class="auth-input"></textarea>
             </div>
            <div class="center">
              <button class="auth-button pull-right" type="submit">Submit</button>
            </div>

          </form>
      </div>
    </div>
  </div>
  </div>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="index.js"></script> 
    <script src="testProfile.js"></script> 
</body>
</html>