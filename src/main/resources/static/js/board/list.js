$("#choice1").css("background", "#ce4869");
$("#choice1").css("border", "2px double black");
$("#choice1").css("border-bottom", "none");

$("#choice2").css("border-bottom", "2px double black");
$("#choice2").css("background", "#65cdd2");

$("#table2").hide();
$("#choice1").on("click", function () {
    $("#choice1").css("background", "#ce4869");
    $("#choice1").css("border", "2px double black");
    $("#choice1").css("border-bottom", "none");

    $("#choice2").css("background", "#65cdd2");
    $("#choice2").css("border", "none");
    $("#choice2").css("border-bottom", "2px double black");

    $("#table1").show();
    $("#table2").hide();
    $("#keyword").val("");
});

$("#choice2").on("click", function () {
    $("#choice2").css("background", "#ce4869")
    $("#choice2").css("border", "2px double black");
    $("#choice2").css("border-bottom", "none");

    $("#choice1").css("background", "#65cdd2")
    $("#choice1").css("border", "none");
    $("#choice1").css("border-bottom", "2px double black");

    $("#table1").hide();
    $("#table2").show();
    $("#keyword").val("");
});
