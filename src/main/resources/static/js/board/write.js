/*썸머노트*/
$("#sendSummer").click(function(){
    if(!$("#title").val()){
        alert("제목을 입력해주세요.");
        return;
    }
    if(!$("#summernote").val() || $("#summernote").val() == null){
        alert("내용을 입력해주세요.");
        return;
    }
    document.postForm.submit();
})


$(document).ready(function () {
    var fontList = ['맑은 고딕', '돋움', '궁서', '굴림', '굴림체', '궁서체', '나눔 고딕', '바탕', '바탕체', '새굴림', 'HY견고딕', 'HY견명조', 'HY궁서B', 'HY그래픽M', 'HY목각파임B', 'HY신명조', 'HY얕은샘물M', 'HY엽서L', 'HY엽서M', 'HY중고딕', 'HY헤드라인M', '휴먼매직체', '휴먼모음T', '휴먼아미체', '휴먼둥근헤드라인', '휴먼편지체', '휴먼옛체'];
    var setting = {

        placeholder:  '500자 이내로 자유롭게 글을 작성할 수 있습니다. 명예훼손이나 비방, 불쾌감을 주는 글, 욕설, 남을 모욕하는 글은 제재가 있을 수 있습니다.',
        height: 500,
        tabsize: 2,
        maxHeight: null,
        minHeight: null,
        maxWidth: 888,
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
        callbacks : {

        }

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