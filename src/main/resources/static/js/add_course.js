document.getElementById('addCourseForm')?.addEventListener('submit', async (event) => {
    event.preventDefault(); // Prevent the default form submission

    // Get form data
    const courseName = document.getElementById('courseName').value;

    try {
        // Send POST request to add course
        const response = await fetch('/api/courses', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('token')}` // Include token if needed
            },
            body: JSON.stringify({courseName: courseName, teacher:  { teacherID: userID}, classes:{classID: classID} }) // Send course data
        });

        // Handle response
        if (response.ok) {
            alert('Course added successfully!');
            // Optionally clear the form or navigate to another page
            document.getElementById('addCourseForm').reset();
        } else {
            const errorData = await response.json();
            alert(`Failed to add course: ${errorData.message || 'Unknown error'}`);
        }
    } catch (error) {
        console.error('Error adding course:', error);
        alert('An unexpected error occurred. Please try again.');
    }
});
