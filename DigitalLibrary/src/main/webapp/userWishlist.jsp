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
 <link rel="stylesheet" href="books.css">
 <link rel="stylesheet" href="home.css">
<script src="https://kit.fontawesome.com/30f7b0adf2.js" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">

<!-- profile Container -->
 <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
    />
    <link rel="stylesheet" href="testProfile.css" />

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
	
	
		
  <%-- 		<%  --%>

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
		  
		
		  
		  
   <div class="container">
	    <div class="discover-books">
	        Discover Books by Genre, Author, and More
	    </div>
	
	    <!-- Search Box -->
	    <div class="search-container">
	        <form action="searchBooks" method="post">
	            <input type="text" placeholder="Search..." name="searchText">
	            <button type="submit"><i class="fa-solid fa-magnifying-glass fa-xl"></i></button>
	        </form>
	    </div>
	</div>
	   			
	    <div class="book-list">
        <!-- <p style="color: red; margin-left: 30px;"><%request.getAttribute("searchMessage");%></p> -->
        <% 
            for (Book b : userWishlist) { 
        %>
        <div class="book">
         <a href="bookDetails?bookId=<%= b.getId() %>" style="text-decoration: none; color: inherit;">
            
            <% 
                InputStream photoInputStream = b.getPhoto(); 
                ByteArrayOutputStream photoByteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = photoInputStream.read(buffer)) != -1) {
                    photoByteArrayOutputStream.write(buffer, 0, bytesRead);
                }
                byte[] photoByteArray = photoByteArrayOutputStream.toByteArray();
                String photoBase64 = Base64.getEncoder().encodeToString(photoByteArray);
            %>
           
            <div class="book-image">
            
                <img src="data:image/jpeg;base64, <%= photoBase64 %>" alt="Book Cover" />
                
            </div>
            <div class="book-details">
            
                <b><%= b.getTitle() %></b>
                 <br>
                <%=  b.getAuthor() %> | <%= b.getGenre() %>
                <br>
                <br>
                <% 
                    String description = b.getDescription();
                if (description.length() > 300) {
                    description = description.substring(0, 300) + "...";
                }
                %>
                
                <%= description %>
                </a>
            </div>
	   			
	   			<div>
	   			<div class="button-group">
               <form action="removeBookFromWishlist?bookId=<%= b.getId()%>&userId=<%=user.getId() %>" method="post">
                    <button class="wishlist-button">Remove From Wishlist</button>
                </form>
            </div>
        <td class="add-to-cart">
           <div class="button-group">
                <form action="bookDetails?bookId=<%=b.getId() %>" method="post">
                    <button class="details-button">Details</button>
                </form>
            </div>
            </div>
        </div>
           
           <% 
            } 
        %> 
	 </div>        
  </div>
  </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="index.js"></script> 
    <script src="testProfile.js"></script> 
</body>
</html>
