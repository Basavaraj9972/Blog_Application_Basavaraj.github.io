function validateForm() {
            let isValid = true;

            // Clear previous errors
            document.getElementById('titleError').textContent = '';
            document.getElementById('contentError').textContent = '';
            document.getElementById('imageVideoError').textContent = '';
            document.getElementById('userIdError').textContent = '';
            document.getElementById('blogIdError').textContent = '';

            // Validate Title
            const title = document.getElementById('title').value;
            const titlePattern = /^[A-Za-z\s]+$/;
            if (!title) {
                document.getElementById('titleError').textContent = 'Title should not be empty.';
                isValid = false;
            } else if (!titlePattern.test(title)) {
                document.getElementById('titleError').textContent = 'Title must contain only alphabets and spaces.';
                isValid = false;
            }

            // Validate Content
            const content = document.getElementById('content').value;
            if (!content) {
                document.getElementById('contentError').textContent = 'Content should not be empty.';
                isValid = false;
            } 

			// Validate Image/Video Link
			const urlPattern = /^https?:\/\/.+$/i;	
			if (!imageVideo) {
			   document.getElementById('imageVideoError').textContent = 'Image/Video Link should not be empty.';
			   isValid = false;
			} else if (!(urlPattern.test(imageVideo)) ) {
				document.getElementById('imageVideoError').textContent = 'Please enter a valid image/video URL ending with .jpg, .jpeg, .png, .gif, .bmp, .svg';
				isValid = false;
			}

            // Validate UserId
            const userId = document.getElementById('userId').value;
            if (!userId) {
                document.getElementById('userIdError').textContent = 'UserId should not be empty.';
                isValid = false;
            } else if (userId < 1 || isNaN(userId)) {
                document.getElementById('userIdError').textContent = 'UserId must be a positive number.';
                isValid = false;
            }
			
            const blogId = document.getElementById('blogId').value;
            if (!blogId) {
                document.getElementById('blogIdError').textContent = 'blogId should not be empty.';
                isValid = false;
            } else if (blogId < 1 || isNaN(blogId)) {
                document.getElementById('blogIdError').textContent = 'blogId must be a positive number.';
                isValid = false;
            }

            return isValid;
        }