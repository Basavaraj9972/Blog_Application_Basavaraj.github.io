function validateForm() {
            let isValid = true;

            // Clear previous errors
            
            document.getElementById('blogIdError').textContent = '';

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