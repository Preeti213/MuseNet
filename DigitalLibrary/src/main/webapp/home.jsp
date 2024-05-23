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
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
	
	
	
<!-- Page content -->
<div class = "main-content-box">
	<div class="main">
		<a href="bookDirectoryMain" >
		    <div class = "museNet">MuseNet</div>
		   <div class= "quote"> Unleash your inner bibliophile.</div>
		    </a>
		  </div>
		  
	
	       
	       
	       <!-- home  page text -->
		 <div class="page-text" >
    <div class="main-heading">Welcome to MuseNet</div>
    <div class="subheading">Escape the Ordinary, Dive into a World of Stories</div>
    <div class="paragraph">
      MuseNet isn't just another digital library; it's a sanctuary for bibliophiles, a haven for knowledge seekers, and a realm where imagination knows no bounds. Within MuseNet's virtual walls, you'll discover a treasure trove of literary wonders spanning countless genres, eras, and cultures. Whether you're an avid reader, a casual browser, or a curious explorer, MuseNet invites you to embark on a journey through the vast realms of literature.
    </div>
    <div class="subheading">Dive into a World of Books</div>
    <div class="paragraph">
      With MuseNet, the world's literary classics, contemporary bestsellers, and hidden gems are just a click away. From the timeless prose of Shakespeare to the pulse-pounding thrillers of today, MuseNet's extensive collection caters to every taste and interest. Whether you prefer to immerse yourself in a gripping mystery, lose yourself in a fantastical adventure, or ponder the intricacies of human nature through literary fiction, MuseNet has something for everyone.
    </div>
    <div class="subheading">Unleash Your Imagination</div>
    <div class="paragraph">
      At MuseNet, we believe that reading is more than just a pastime—it's a journey of discovery, a gateway to new worlds, and a source of endless inspiration. With our user-friendly interface and intuitive search features, exploring MuseNet's vast library is as effortless as it is exhilarating. Whether you're browsing by genre, author, or keyword, MuseNet makes it easy to find the perfect book to transport you to new realms of imagination.
    </div>
    <div class="subheading">Your Library, Your Way</div>
    <div class="paragraph">
      MuseNet empowers you to customize your reading experience to suit your preferences. With seamless integration across devices, you can access your favorite books anytime, anywhere. Whether you're curled up with a cozy mystery on your e-reader, listening to an audiobook on your morning commute, or exploring a new adventure on your smartphone, MuseNet ensures that your library is always at your fingertips.
    </div>
    <div class="subheading">Connect with Fellow Readers</div>
    <div class="paragraph">
      At MuseNet, we understand that reading is not just a solitary pursuit—it's a shared experience that brings people together. That's why we've created a vibrant community where readers can connect, collaborate, and celebrate their love of literature. From lively book clubs and discussion forums to author Q&A sessions and virtual meetups, MuseNet offers countless opportunities to engage with fellow readers, exchange recommendations, and deepen your appreciation for the written word.
    </div>
    <div class="subheading">Make MuseNet Your Own</div>
    <div class="paragraph">
      With MuseNet, the possibilities are endless. Create personalized wishlists to keep track of your must-read books, write reviews to share your thoughts with fellow readers, and contribute to the community by recommending your favorite titles. Whether you're discovering a new obsession, revisiting an old favorite, or embarking on a literary adventure, MuseNet is your trusted companion every step of the way.
    </div>
    <div class="subheading">Join the MuseNet Revolution</div>
    <div class="paragraph">
      Ready to embark on your literary odyssey? Join the MuseNet revolution today and experience the magic of storytelling like never before. Whether you're seeking inspiration, enlightenment, or simply a moment of escape, MuseNet welcomes you with open arms. So why wait? Dive into a world of infinite possibilities and let your imagination soar with MuseNet.
    </div>
    <div class="subheading">Start Your Journey Today</div>
    <p>Sign up for MuseNet and unlock a universe of knowledge, inspiration, and discovery. Whether you're a lifelong book lover or a curious newcomer, MuseNet has something for everyone. Join us on a journey through the pages of history, the depths of imagination, and the wonders of the human experience. Welcome to MuseNet—where stories come to life, and the adventure never ends.</p>
    <a href="bookDirectoryMain" class="link">Explore Now</a>
  </div>

	  
		</div>   
	 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="index.js"></script>
       <script src="testProfile.js"></script> 
</body>
</html>
