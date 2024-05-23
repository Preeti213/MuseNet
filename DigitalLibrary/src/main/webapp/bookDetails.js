 function updateBook(button) {
        const id = button.getAttribute('data-id');
        const parentDiv = button.parentElement.parentElement;

    // Get the elements to edit
    const titleElement = parentDiv.querySelector('.book-title');
    const authorGenreElement = parentDiv.querySelector('.author-genre');
    const descriptionElement = parentDiv.querySelector('.description');

    // Get the current values
    const currentTitle = titleElement.innerText.trim();
    const currentAuthorGenre = authorGenreElement.innerText.trim().split('|');
    const currentAuthor = currentAuthorGenre[0].trim();
    const currentGenre = currentAuthorGenre[1].trim();
    const currentDescription = descriptionElement.innerText.trim();

    // Create input fields to edit data
    const newTitleInput = document.createElement('input');
    newTitleInput.value = currentTitle;

    const newAuthorInput = document.createElement('input');
    newAuthorInput.value = currentAuthor;

    const newGenreInput = document.createElement('input');
    newGenreInput.value = currentGenre;

    const newDescriptionInput = document.createElement('textarea');
    newDescriptionInput.value = currentDescription;

    // Replace the cell content with input fields
    titleElement.innerHTML = '';
    titleElement.appendChild(newTitleInput);

    authorGenreElement.innerHTML = '';
    authorGenreElement.appendChild(newAuthorInput);
    authorGenreElement.insertAdjacentHTML('beforeend', ' | ');
    authorGenreElement.appendChild(newGenreInput);
    
    descriptionElement.innerHTML = '';
    descriptionElement.appendChild(newDescriptionInput);

    const updateButton = parentDiv.querySelector('.update-button');
    const deleteButton = parentDiv.querySelector('.delete-button');
    const saveButton = parentDiv.querySelector('.save-button');
     const cancelButton = parentDiv.querySelector('.cancel-button');

    updateButton.style.display = 'none';
    deleteButton.style.display = 'none';
    saveButton.style.display = 'inline-block';
    cancelButton.style.display = 'inline-block';

    saveButton.onclick = function () {
        const newTitle = newTitleInput.value;
        const newAuthor = newAuthorInput.value;
        const newGenre = newGenreInput.value;
        const newDescription = newDescriptionInput.value;
       
        $.ajax({
            type: 'POST',
            url: 'updateBook',
            dataType: 'json',
            data: {
                id: id,
                title: newTitle,
                author: newAuthor,
                genre: newGenre,
                description: newDescription
            },
            success: function (response) {
                console.log('Data updated successfully');
            },
            error: function (xhr, status, error) {
                console.error('Error updating data:', error);
            }
        });

        // Restore the original display
        titleElement.innerHTML = newTitle;
        authorGenreElement.innerHTML = newAuthor + ' | ' + newGenre;
        descriptionElement.innerText = newDescription;
        
        updateButton.style.display = 'inline-block';
        deleteButton.style.display = 'inline-block';
        saveButton.style.display = 'none';
        cancelButton.style.display = 'none';
    };

    cancelButton.onclick = function () {
        
        titleElement.textContent = currentTitle;
        authorGenreElement.textContent = currentAuthor + ' | ' + currentGenre;
        descriptionElement.textContent = currentDescription;

        updateButton.style.display = 'inline-block';
        deleteButton.style.display = 'inline-block';
        saveButton.style.display = 'none';
        cancelButton.style.display = 'none';
    };
}



 function deleteBook() {
  var bookId = $('.delete-button').data('id');
  var servletUrl = 'deleteBook'; 
  
  $.ajax({
    type: 'DELETE',
    url: servletUrl + '?id=' + bookId,
    success: function(response) {
      console.log('Book deleted successfully:', response);
      // Handle success response here
    },
    error: function(xhr, status, error) {
      console.error('Error deleting book:', error);
      // Handle error response here
    }
  });
}
