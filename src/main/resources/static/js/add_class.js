document.getElementById('addClasses')?.addEventListener('submit', async (event) => {
    event.preventDefault(); // Prevent the default form submission

    // Get form data
    const className = document.getElementById('className').value;

    try {
        // Send POST request to add course
        const response = await fetch('/api/classes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('token')}` // Include token if needed
            },
            body: JSON.stringify({className: className}) // Send course data
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
