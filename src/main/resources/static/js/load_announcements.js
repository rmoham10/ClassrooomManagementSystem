async function loadAnnouncements() {
    try {
        const response = await fetch('/api/announcements', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${localStorage.getItem('token')}`
            }
        });

        if (response.ok) {
            const announcements = await response.json();
            let announcementsList = '<h1>Announcements</h1><ul>';
            announcements.forEach(announcement => {
                announcementsList += `
                    <li>
                        <strong>${announcement.title}</strong>: ${announcement.message}
                        (Posted by: ${announcement.admin.firstName} ${announcement.admin.lastName})
                    </li>`;
            });
            announcementsList += '</ul>';
            document.getElementById('content-area').innerHTML = announcementsList;
        } else {
            alert('Failed to load announcements. Please try again.');
        }
    } catch (error) {
        console.error('Error loading announcements:', error);
    }
}
