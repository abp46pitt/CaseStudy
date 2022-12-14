$("#submit").click(function () {
    $.ajax({
        url: '/ajaxcall',
        data: {
            startDate: $("#startDate").val(),
            endDate: $("#endDate").val(),
            bikeId: $("#bikeId").val()
        },
        success: function (result) {
            console.log(result);
            $("#feedback").text(result);
            if (result === "Successfully added rental") {
                $("#feedback").css("color", "green");
                $('#rentalTable tr:last').after('<tr><td>' + $("#startDate").val() + '</td><td>' + $("#endDate").val() + '</td></tr>');
                $("#profile").show();
            } else {
                $("#feedback").css("color", "red");
            }
        },
        error: function (data) {
            console.log(data);
        }
    });
});

$(function () {
    $("#startDate").datepicker();
});

$(function () {
    $("#endDate").datepicker();
});

$("#button").click(function () {
    if ($("#startDate").val().length !== 0 || $("#endDate").val().length !== 0) {
        $("#startFill").text($("#startDate").val());
        $("#endFill").text($("#endDate").val());
        $("#totalPrice").text(calcPrice($("#startDate").val(), $("#endDate").val()));
        $('#hidden').show();
        console.log($("#startDate").val() + " " + $("#endDate").val());
    }
})

function parseDate(str) {
    var mdy = str.split('/');
    return new Date(mdy[2], mdy[0] - 1, mdy[1]);
}

function calcPrice(sdate, edate) {
    let days = datediff(parseDate(sdate), parseDate(edate));
    if (days === 0) {
        days = 1;
    }
    let price = days * "${bike.price}";

    return price < 0 ? "N/A" : "$" + price;
}

function datediff(first, second) {
    return Math.round((second - first) / (1000 * 60 * 60 * 24));
}