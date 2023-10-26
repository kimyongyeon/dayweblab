document.addEventListener("DOMContentLoaded", function () {

    fetch("/list")
        .then(response => response.json())
        .then(data => {
            const tableBody = document.querySelector("#peopleTable tbody");

            data.list.forEach(person => {
                const row = tableBody.insertRow();
                const rowNumber = row.insertCell(0);
                const nameCell = row.insertCell(1);
                const ageCell = row.insertCell(2);
                const addressCell = row.insertCell(3);
                const jobCell = row.insertCell(4);

                rowNumber.textContent = row.rowIndex;
                nameCell.textContent = person.name;
                ageCell.textContent = person.age;
                addressCell.textContent = person.address;
                jobCell.textContent = person.job;
            });
        })
        .catch(error => {
            console.error("Error fetching data:", error);
        });
});