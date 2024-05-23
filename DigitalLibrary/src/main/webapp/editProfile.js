//Get all update buttons
const updateButtons = document.querySelectorAll('.update-button');

// Add event listener to each update button
updateButtons.forEach((button) => {
  button.addEventListener('click', (e) => {
    // Get the parent container
    const container = button.parentNode.parentNode;

    // Get the user data elements
     const profileElement = container.querySelector('.profile img');
    const userNameElement = container.querySelector('.user-name');
    const emailElement = container.querySelector('.email');
    const passwordElement = container.querySelector('.password');
	const dobElement = container.querySelector('.dob');
	
    // Store the original values
    const originalProfile = profileElement.src;
     const originalUserName = userNameElement.textContent.trim();
    const originalEmail = emailElement.textContent.trim();
    const originalPassword = passwordElement.textContent.trim();
    const originalDob = dobElement.textContent.trim();
    
	
    // Create input fields to edit the data
    const profileInput = document.createElement('input');
    profileInput.type = 'file';
    profileInput.accept = 'image/*';
    
    const userNameInput = document.createElement('input');
    userNameInput.type = 'text';
    userNameInput.value = originalUserName;

    const emailInput = document.createElement('input');
    emailInput.type = 'email';
    emailInput.value = originalEmail;

    const passwordInput = document.createElement('input');
    passwordInput.type = 'password';
    passwordInput.value = originalPassword;
	
	const dobInput = document.createElement('input');
    dobInput.type = 'date';
    dobInput.value = originalDob;
    
    // Replace the text elements with input fields
    profileElement.parentElement.appendChild(profileInput);
    
    userNameElement.innerHTML = '';
    userNameElement.appendChild(userNameInput);

    emailElement.innerHTML = '';
    emailElement.appendChild(emailInput);

    passwordElement.innerHTML = '';
    passwordElement.appendChild(passwordInput);

	 dobElement.innerHTML = '';
    dobElement.appendChild(dobInput);
    
    // Show the save and cancel buttons
    const saveButton = container.querySelector('.save-button');
    const cancelButton = container.querySelector('.cancel-button');
    // Hide the update and delete buttons
    const updateButton = container.querySelector('.update-button');
    const deleteButton = container.querySelector('.delete-button');
    
    updateButton.style.display = 'none';
    deleteButton.style.display = 'none';
    saveButton.style.display = 'inline-block';
    cancelButton.style.display = 'inline-block';
  
    profileInput.addEventListener('change', () => {
      if (profileInput.files && profileInput.files[0]) {
        const reader = new FileReader();
        reader.onload = (e) => {
          profileElement.src = e.target.result;
        };
        reader.readAsDataURL(profileInput.files[0]);
      }
    });

  saveButton.addEventListener('click', (e) => {
      const formData = new FormData();
      formData.append('userName', userNameInput.value);
      formData.append('email', emailInput.value);
      formData.append('password', passwordInput.value);
      formData.append('dob', dobInput.value);
      formData.append('userId', button.getAttribute('data-id'));
      
      if (profileInput.files[0]) {
        formData.append('profile', profileInput.files[0]);
      }

      fetch('updateUser', {
        method: 'POST',
        body: formData
      })
      .then(response => {
        if (response.ok) {
          userNameElement.textContent = userNameInput.value;
          emailElement.textContent = emailInput.value;
          passwordElement.textContent = passwordInput.value;
          dobElement.textContent = dobInput.value;
          
          updateButton.style.display = 'inline-block';
          deleteButton.style.display = 'inline-block';
          saveButton.style.display = 'none';
          cancelButton.style.display = 'none';

          alert('User updated successfully');
        } else {
          throw new Error('Failed to update user');
        }
      })
      .catch(error => {
        console.error('Error updating user:', error);
        alert('Failed to update user');
      });
    });
    cancelButton.addEventListener('click', () => {
      profileElement.src = originalProfile;
      userNameElement.textContent = originalUserName;
      emailElement.textContent = originalEmail;
      passwordElement.textContent = originalPassword;
      dobElement.textContent = originalDob;

      updateButton.style.display = 'inline-block';
      deleteButton.style.display = 'inline-block';
      saveButton.style.display = 'none';
      cancelButton.style.display = 'none';

      profileInput.remove();
    });
  });
});
  
$('.delete-button').click(function() {
    var userId = $(this).data('id');
    const servletUrl = 'deleteUser';
    $.ajax({
        type: 'POST', // Change the method to POST
        url: servletUrl, // Fix variable name to use the servletUrl variable
        data: {
            userId: userId, // Change the parameter name to userId
        },
        success: function(response) {
            console.log('User deleted successfully:', response);
            alert('User deleted successfully');
            // Optionally, you can redirect or update the page here
        },
        error: function(xhr, status, error) {
            console.error('Error deleting user:', error);
            alert('Failed to delete user');
        }
    });
});
