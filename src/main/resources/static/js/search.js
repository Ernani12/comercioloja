document.getElementById('search').addEventListener('input', function() {
    const searchValue = this.value.toLowerCase();
    const rows = document.querySelectorAll('#myTable tbody tr');

    rows.forEach(row => {
        const nameCell = row.cells[1]; // Acessa a segunda célula (índice 1)
        const productName = nameCell.textContent.toLowerCase();
        
        if (productName.includes(searchValue)) {
            row.style.display = ''; // Exibe a linha
        } else {
            row.style.display = 'none'; // Oculta a linha
        }
    });
});