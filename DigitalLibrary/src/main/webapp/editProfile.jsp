<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ page import="java.util.List" %>
<%@ page import="Library.*" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.ByteArrayOutputStream" 
import ="javax.imageio.ImageIO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Profile</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<link rel="stylesheet" href="home.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://kit.fontawesome.com/30f7b0adf2.js" crossorigin="anonymous"></script>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	
	<!-- profile Container -->
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
	<link rel="stylesheet" href="testProfile.css" />
	
	<link rel="stylesheet" href="editProfile.css" />

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
		  
    <%-- 		<%  --%>
//                 InputStream getProfile = user.getProfile(); 
//                 ByteArrayOutputStream profilePhotoByteArrayOutputStream = new ByteArrayOutputStream();
//                 byte[] buffer1 = new byte[1024];
//                 int bytesReadProfile;
//                 while ((bytesReadProfile = getProfile.read(buffer1)) != -1) {
//                 	profilePhotoByteArrayOutputStream.write(buffer1, 0, bytesReadProfile);
//                 }
//                 byte[] profilePhotoByteArray = profilePhotoByteArrayOutputStream.toByteArray();
//                 String profilePhoto = Base64.getEncoder().encodeToString(profilePhotoByteArray);
<%--                 style="background-image: url('data:image/jpeg;base64,<%= profilePhoto %>')"; --%>
<!--             %> -->
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
            <a href="#">
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
	
	
	
<!-- Page content -->
<div class = "main-content-box">
	<div class="main">
		<a href="bookDirectoryMain" >
		    <div class = "museNet">MuseNet</div>
		   <div class= "quote"> Unleash your inner bibliophile.</div>
		    </a>
		  </div>
		  
<%


InputStream photoInputStream = user.getProfile(); 
ByteArrayOutputStream photoByteArrayOutputStream = new ByteArrayOutputStream();
byte[] buffer = new byte[1024];
int bytesRead;
while ((bytesRead = photoInputStream.read(buffer)) != -1) {
    photoByteArrayOutputStream.write(buffer, 0, bytesRead);
}
byte[] photoByteArray = photoByteArrayOutputStream.toByteArray();
String photoBase64 = Base64.getEncoder().encodeToString(photoByteArray);
%>

<div class="book-container">
  <div class="profile"> <img src="data:image/jpeg;base64, <%= photoBase64 %>" alt="Profile" /></div>
   <div class="user-info">
   <div class="label" >Name :: </div>
   <div class="input-container">
    <div class="user-name" id ="input" ><%= user.getName() %></div>
    </div>
    <div class="label">Email :: </div>
   <div class="input-container">
    <div class="email" id = "input"> <%= user.getEmail() %></div>
     </div>
    <div class="label">Date of Birth ::</div>
   <div class="input-container">
    <div class="dob" id = "input"> <%= user.getDob() %></div>
     </div>
    <div class="label">Password ::</div>
   <div class="input-container">
     <div class="password" id = "input"> <%= user.getPassword() %></div>
     </div>
     </div>
</div>
	<div class="update-delete">
	
    <button data-id="<%= user.getId() %>" class="update-button">UPDATE</button>
    <button class="delete-button" data-id="<%= user.getId() %>">DELETE</button>
    <button class="save-button" style="display: none;">SAVE</button>
    <button class="cancel-button" style="display: none;">CANCEL</button>
</div>
<script src="editProfile.js"></script>
<script src="index.js"></script>
<script src="testProfile.js"></script> 

</body>
</html>
