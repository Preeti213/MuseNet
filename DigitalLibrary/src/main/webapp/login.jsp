<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login Form</title>
<link rel="stylesheet" href="login.css">
<style>

</style>
</head>
<body>

	<div class="box">

		<div class="slider"></div>
		<div class="btn">
			<button class="login">Login</button>
			<button class="signup">Signup</button>
		</div>

		<div class="login-box">
			<form action ="loginUser" method = "post">
				<div class="inputBox">
				 <label for="" >Email</label>
					<input type="text" name="email" required>
				</div>

				<div class="inputBox">
				<label for="" >Password</label>
					<input type="password" name="password" required> 
				</div>
				
				<input type="submit" name="" value="Submit" class="clkbtn">
			</form>
		</div>

		<div class="signup-box">
			<form action ="signupUser" method = "post" enctype="multipart/form-data">
			<div class="profile-icon" onclick="openFileFolder()">
   			 <input type="file" accept="image/*"   onchange="previewPhoto(event)" name="image" >
    	</div>
    	<div class="inputBox">
				<label for="" style="margin-top:25px">Email</label>
					<input style="margin-top:55px" type="email" name="email" placeholder="ENTER YOUR EMAIL" required>
					<span id="emailMessage"></span> 
				</div>
				<div class="inputBox">
				<label for="" style="margin-top:25px">Name</label>
					<input style="margin-top:55px" type="text" name = "username" placeholder="ENTER YOUR NAME" required> 
				</div>
				<div class="inputBox">
				<label for="" style="margin-top:25px">D.O.B</label>
					<input style="margin-top:55px" type="date" name = "dob" placeholder="ENTER YOUR D.O.B"> 
				</div>
				
				<div class="inputBox">
				   <label for="password" style="margin-top:25px">Password</label>
				   <input id="password" style="margin-top:55px" name="password" type="password" placeholder="ENTER YOUR PASSWORD" required> 
				    <span id="passwordCriteriaMessage"></span> <!-- Display password criteria message -->
				</div>
				
				<div class="inputBox">
				    <label for="confirmPassword" style="margin-top:25px">Re-Enter Password</label>
				   <input id="confirmPassword" style="margin-top:55px" type="password" placeholder="CONFIRM PASSWORD" required> 
				   <span id="passwordMatchMessage"></span> <!-- Display password match message -->
				</div>

				<input type="submit" name="" value="Submit" class="clkbtn">
			</form>
		</div>
	</div>
	<script src="login.js"></script>
</body>
</html>