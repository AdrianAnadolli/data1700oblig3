function endreBooking(linje) {
    const book = {
        id: $("#id" + linje).text(),
        film: $("#film" + linje).text(),
        antall: $("#antall" + linje).text(),
        fornavn: $("#fornavn" + linje).text(),
        etternavn: $("#etternavn" + linje).text(),
        telefonnr: $("#telefonnr" + linje).text(),
        epost: $("#epost" + linje).text()
    };
    const url = "/endre";
    $.post(url, book, function (retur) {
        if (retur === "Feil") {
            $(location).attr('href', 'index.html');
        } else {
            $(location).attr('href', 'index.html');
        }
    });
}

function slettBooking(linje) {
    const id = $("#id" + linje).text();
    const url = "/slett?id=" + id;
    $.get(url, function (retur) {
        if (retur === "Feil") {
            $(location).attr('href', 'index.html');
        } else {
            $(location).attr('href', 'index.html');
        }
    });
}

$(document).ready(function () {
    updateBookingTable();

    function updateBookingTable() {
        $.get("/bookings", function (data) {

            $("#booking-table-body").empty();
            let linje = 1;

            data.forEach(function (Booking) {
                var row = "<tr>" +
                    "<td contenteditable='false' id='id" + linje + "'>" + Booking.id + "</td>" +
                    "<td contenteditable='true' id='film" + linje + "'>" + Booking.film + "</td>" +
                    "<td contenteditable='true' id='antall" + linje + "'>" + Booking.antall + "</td>" +
                    "<td contenteditable='true' id='fornavn" + linje + "'>" + Booking.fornavn + "</td>" +
                    "<td contenteditable='true' id='etternavn" + linje + "'>" + Booking.etternavn + "</td>" +
                    "<td contenteditable='true' id='telefonnr" + linje + "'>" + Booking.telefonnr + "</td>" +
                    "<td contenteditable='true' id='epost" + linje + "'>" + Booking.epost + "</td>" +
                    "<td><button class='btn btn-primary btn-sm mr-1' onclick='endreBooking(" + linje + ")'>Endre</button>" +
                    "<button class='btn btn-danger btn-sm' onclick='slettBooking(" + linje + ")'>Slett</button></td>" +
                    "</tr>";
                $("#booking-table-body").append(row);
                linje++;
            });
        });
    }


    $('#bookingForm').submit(function (event) {
        event.preventDefault();
        var formData = $(this).serialize();

        $.post('/registrer', formData, function (response) {
            console.log(response);

            if (response === "OK") {
                updateBookingTable();
            }
        });
    });
});