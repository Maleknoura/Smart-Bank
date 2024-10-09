

    function openModal(requestId, firstName, currentStatus) {
    document.getElementById('statusModal').style.display = 'block';
    document.getElementById('idInput').value = requestId;
    document.getElementById('firstNameInput').value = firstName;

    const statusSelect = document.getElementById('statusSelect');
    statusSelect.value = currentStatus;
}


    function closeModal() {
    document.getElementById('statusModal').style.display = 'none';
}

    window.onclick = function(event) {
    const modal = document.getElementById('statusModal');
    if (event.target === modal) {
    closeModal();
}
}
