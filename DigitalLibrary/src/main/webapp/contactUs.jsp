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

<!-- Fontawesome CDN Link -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
<!----===== Boxicons CSS ===== -->
<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'
	rel='stylesheet'>
<!-- profile Container -->
 <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
    />
    <link rel="stylesheet" href="testProfile.css" />
 
 
<link rel="stylesheet" href="contact.css">
<title>Contact Us</title>
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
			<div class="content">
				<div class="left-side">
					<div class="address details">
						<i class="fas fa-map-marker-alt"></i>
						<div class="topic">Address</div>
						<div class="text-one">Xyz, NP12</div>
						<div class="text-two">Chandigarh, 160024</div>
					</div>
					<div class="phone details">
						<i class="fas fa-phone-alt"></i>
						<div class="topic">Phone</div>
						<div class="text-one">+0098 9893 5647</div>
						<div class="text-two">+0096 3434 5678</div>
					</div>
					<div class="email details">
						<i class="fas fa-envelope"></i>
						<div class="topic">Email</div>
						<div class="text-one">exploreBooks@gmail.com</div>
						<div class="text-two">info.exploreBooks@gmail.com</div>
					</div>
				</div>
				<div class="right-side">
					<div class="topic-text">Send us a message</div>
					<p>If you have any suggestion from me or any types of quries related
						to my website, you can send me message from here. It's my
						pleasure to help you.</p>
					<form action="#">
						<div class="input-box">
							<input type="text" placeholder="Enter your name">
						</div>
						<div class="input-box">
							<input type="text" placeholder="Enter your email">
						</div>
						
						<div class="input-box message-box"><textarea placeholder="Enter your message" maxlength="500"></textarea></div>
						<div class="button">
							<input type="button" value="Send Now">
						</div>
						
						
					</form>
				</div>
			</div>
		</div>
	
</div>
</div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="index.js"></script> 
    <script src="testProfile.js"></script> 

</body>

</html>

