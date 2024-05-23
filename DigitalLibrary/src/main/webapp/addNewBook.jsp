<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Book</title>
<link rel="stylesheet" href="form.css" />
</head>
<body>

	
	<div class="auth-page">
    <div class="container page">
        <div>
          <h1 class="heading">ADD NEW BOOK</h1>
          <form action ="addNewBook" method = "post" enctype="multipart/form-data">
            
            <label class="label">Title</label>
            <div class="input-container">
             <input type="text" id="title" name="title" placeholder = "Book Title" class="auth-input" required><br>
            </div>

            <label class="label">Genre</label>
            <div class="input-container">
             <input type="text" id="genre" name="genre" placeholder = "Genre" class="auth-input"><br>
            </div>
            
            <label class="label">Author</label>
            <div class="input-container">
             <input type="text" id="author" name="author" placeholder = "Author" class="auth-input"><br>
            </div>
            
            <label class="label">Book Essence:</label>
            <div class="input-container">
               <textarea name="description" id="description" cols="100" rows="8" placeholder="Provide a brief summary or plot..." class="auth-input"></textarea>
             </div>
              <label class="label">Publication Date:</label>
            <div class="input-container">
					<input class="auth-input" type="date" name = "publicationDate" placeholder="ENTER Publication Date"> 
				</div>
              <label class="label">Book Cover:</label>
            <div class="input-container">
               <input type="file" name="image" class="auth-input">
             </div>
             <label class="label">Book Pdf:</label>
            <div class="input-container">
              <input type="file" name="pdf" class="auth-input">
              </div>
                <label class="label">Book EPub:</label>
            <div class="input-container">
              <input type="file" name="epub" class="auth-input">
              </div>

            <div class="center">
              <button class="auth-button pull-right" type="submit">Submit</button>
            </div>

            <div class="center">
              <small>Mood change?<a href="signUp.jsp">byeeeeeee</a>
              </small>
            </div>
          </form>
      </div>
    </div>
  </div>
 <!--  <form action="addBook" method="post">
    <label for="title">Book Title:</label><br>
    <input type="text" id="title" name="title"><br><br>

    <label for="genre">Genre:</label><br>
    <input type="text" id="genre" name="genre"><br><br>

    <label for="author">Author:</label><br>
    <input type="text" id="author" name="author"><br><br>

    <input type="submit" value="Submit">
  </form> -->
</body>
</html>