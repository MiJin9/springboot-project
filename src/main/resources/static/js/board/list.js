$("#choice2").css("color", "#888888");
$("#choice2").css("border-bottom", "none");

$("#table2").hide();
$("#choice1").on("click", function () {
    $("#choice1").css("border-bottom", "3px solid green");
    $("#choice1").css("color", "#80b763");

    $("#choice2").css("border-bottom", "none");
    $("#choice2").css("color", "#888888");

    $("#table1").show();
    $("#table2").hide();
    $("#keyword").val("");
});

$("#choice2").on("click", function () {
    $("#choice2").css("border-bottom", "3px solid green");
    $("#choice2").css("color", "#80b763");

    $("#choice1").css("border-bottom", "none");
    $("#choice1").css("color", "#888888");

    $("#table1").hide();
    $("#table2").show();
    $("#keyword").val("");
});
