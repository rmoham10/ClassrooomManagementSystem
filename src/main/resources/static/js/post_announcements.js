document.getElementById('postAnnouncementForm')?.addEventListener('submit', async (event) => {
    event.preventDefault();
    const title = document.getElementById('announcementTitle').value;
    const message = document.getElementById('announcementMessage').value;

    const urlParams = new URLSearchParams(window.location.search);
    const userID = urlParams.get('userID');

    try {
        const response = await fetch('/api/announcements', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            },
            body: JSON.stringify({admin: { userID: userID }, title: title, message: message})
        });

        if (response.ok) {
            alert('Announcement posted successfully!');
            closeModal('postAnnouncementModal');
            navigate('view-announcements');
        } else {
            alert('Failed to post announcement. Please try again.');
        }
    } catch (error) {
        console.error('Error posting announcement:', error);
    }
});
