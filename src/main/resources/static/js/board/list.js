$(document).ready(function() {
    if(boardType == 0){
        $(".a-write").parent().hide()
    }
    switch (boardType) {
        case 1: case 2:
            $("#choice1").html("팝니다");
            $("#choice2").html("삽니다");
            break;
        case 3: case 4:
                $("#choice1").html("임대");
                $("#choice2").html("매매");
                break;
        case 5:
                $("#choice1").html("지식인");
                break;
        case 0:
                $("#choice1").html("공지");
                break;
    };
    switch (boardType) {
        case 1: case 3:
            $("#choice1").css("border-bottom", "3px solid green");
            $("#choice1").css("color", "#80b763");

            $("#choice2").css("border-bottom", "none");
            break;
        case 2:  case 4:
            $("#choice2").css("border-bottom", "3px solid green");
            $("#choice2").css("color", "#80b763");

            $("#choice1").css("border-bottom", "none");
            break;
        case 0: case 5:
            $("#choice1").css("border-bottom", "3px solid green");
            $("#choice1").css("color", "#80b763");
            $("#choice2").css("display", "none");
            break;
    };

    $("#choice1").on("click", function () {
        switch ($("#choice1").text()) {
            case "팝니다":
                location.href = "/board/list?boardType=1";
                break;
            case "임대":
                location.href = "/board/list?boardType=3";
                break;
            case "지식인":
                location.href = "/board/list?boardType=5";
                break;
            case "공지":
                location.href = "/board/list?boardType=0";
                break;
        };
    });

    $("#choice2").on("click", function () {
        switch ($("#choice2").text()) {
            case "삽니다":
                location.href = "/board/list?boardType=2";
                break;

            case "매매":
                location.href = "/board/list?boardType=4";
                break;
        };
    });

});