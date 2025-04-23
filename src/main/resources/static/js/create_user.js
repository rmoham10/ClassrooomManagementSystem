document.getElementById('createUserForm')?.addEventListener('submit', async (event) => {
    event.preventDefault();
    const firstName = document.getElementById('firstName').value;
    const lastName = document.getElementById('lastName').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const roleID = document.getElementById('role').value;

    try {
        const response = await fetch('/api/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            },
            body: JSON.stringify({ firstName, lastName, email, password, role: { roleID } })
        });

        if (response.ok) {
            alert('User created successfully!');
        } else {
            alert('Failed to create user.');
        }
    } catch (error) {
        console.error('Error:', error);
    }
});
