/*썸머노트*/
$("#sendSummer").click(function(){
    if(!$("#itemname").val()){
        alert("상품명을 입력해주세요.");
        return;
    }
    if(!$("#itemprice").val()){
        alert("가격을 입력해주세요.");
        return;
    }
    if(!$("#itemhome").val()){
        alert("원산지를 입력해주세요.");
        return;
    }
    if(!$("#itemdeliverprice").val()){
        alert("배달비를 입력해주세요.");
        return;
    }
    if(!$("#summernote").val()){
        alert("상품설명을 작성해주세요.");
        return;
    }
    document.postForm.submit();
})

$(document).ready(function () {
    var fontList = ['맑은 고딕', '돋움', '궁서', '굴림', '굴림체', '궁서체', '나눔 고딕', '바탕', '바탕체', '새굴림', 'HY견고딕', 'HY견명조', 'HY궁서B', 'HY그래픽M', 'HY목각파임B', 'HY신명조', 'HY얕은샘물M', 'HY엽서L', 'HY엽서M', 'HY중고딕', 'HY헤드라인M', '휴먼매직체', '휴먼모음T', '휴먼아미체', '휴먼둥근헤드라인', '휴먼편지체', '휴먼옛체'];
    var setting = {

        placeholder:  '자유롭게 상품설명 기재하시면 되겠습니다.',
        height: 500,
        tabsize: 2,
        maxHeight: null,
        minHeight: null,
        lang: 'ko-KR', // 언어 세팅
        fontNames: fontList,
        fontNamesIgnoreCheck: fontList,

        toolbar: [
            // [groupName, [list of button]]
            ['Font Style', ['fontname']],
            ['style', ['bold', 'italic', 'underline']],
            ['font', ['strikethrough']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['paragraph']],
            ['height', ['height']],
            ['Insert', ['picture']],
            ['Insert', ['link']],
            ['Misc', ['fullscreen']]
        ],

        //콜백 함수
        callbacks : {}
    };
    $('#summernote').summernote(setting);
})
function sendFile(file, el) {
    var form_data = new FormData();
    form_data.append('file', file);
    $.ajax({
        data: form_data,
        type: "POST",
        url: contextPath +"/boards/Fileupload.bo",
        cache: false,
        contentType: false,
        dataType : "json",
        enctype: 'multipart/form-data',
        processData: false,
        success: function(url) {
            setTimeout(function(){
                $(el).summernote('editor.insertImage', url.url);
            },100)
        }
    });
}