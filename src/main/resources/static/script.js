// script.js: Common JavaScript logic for all pages

document.addEventListener('DOMContentLoaded', () => {
    // Check for authentication token and redirect if not found
    const token = localStorage.getItem('token');
    if (!token && window.location.pathname !== '/index.html') {
        window.location.href = '/index.html';
    }
});

// Function to log out user
function logout() {
    localStorage.removeItem('token');
    window.location.href = '/index.html';
}

// Function to make authorized API calls
async function authorizedFetch(url, options = {}) {
    const token = localStorage.getItem('token');
    if (!options.headers) {
        options.headers = {};
    }
    options.headers['Authorization'] = `Bearer ${token}`;
    return await fetch(url, options);
}

// Common navigation handler for all dashboards
function navigateTo(section, contentAreaId = 'content-area') {
    let contentArea = document.getElementById(contentAreaId);
    switch (section) {
        case 'manage-users':
            contentArea.innerHTML = '<h3>Manage Users</h3><p>Here you can add, edit, or delete users.</p>';
            break;
        case 'manage-classes':
            contentArea.innerHTML = '<h3>Manage Classes</h3><p>Here you can view and manage classes.</p>';
            break;
        case 'manage-courses':
            contentArea.innerHTML = '<h3>Manage Courses</h3><p>Here you can view and manage courses.</p>';
            break;
        case 'manage-announcements':
            contentArea.innerHTML = '<h3>Manage Announcements</h3><p>Here you can create announcements.</p>';
            break;
        case 'leave-requests':
            contentArea.innerHTML = '<h3>Leave Requests</h3><p>View and approve/reject leave requests here.</p>';
            break;
        default:
            contentArea.innerHTML = '<p>Select a section from the sidebar.</p>';
    }
}

// Function to handle form submissions for CRUD operations
async function handleFormSubmission(event, apiUrl, method = 'POST') {
    event.preventDefault();
    const formData = new FormData(event.target);
    const jsonData = {};
    formData.forEach((value, key) => {
        jsonData[key] = value;
    });

    try {
        const response = await authorizedFetch(apiUrl, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jsonData)
        });

        if (response.ok) {
            alert('Operation completed successfully!');
        } else {
            alert('Operation failed. Please try again.');
        }
    } catch (error) {
        console.error('Error during operation:', error);
    }
}

