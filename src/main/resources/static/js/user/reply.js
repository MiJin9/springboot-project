/*
    Javascript의 모듈화
    함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
    화면 내에서 Javascript 처리를 하다 보면 이벤트 처리와 DOM, Ajax 처리 등
    복잡하게 섞여서 유지보수가 힘들다. 따라서 Javascript를 하나의 모듈처럼 구성하여 사용한다.
 */
console.log("Reply Module.......");

let replyService = (function(){
    console.log("여긴 들어옴 ?");
    function add(replyInfo, callback, error){
        console.log("add reply..........");
        $.ajax({
            url:"/user/new",
            type:"post",
            data:JSON.stringify(replyInfo), // 전달할 JSON데이터에서 문자열처리가 필요한 것들(key, date)을 자동으로 처리해준다.
            contentType:"application/json; charset=utf-8",
            success:function(result, status, xhr){
                if(callback){
                    //외부에서 전달받은 값이 있다면 결과를 해당 함수의 매개변수로 전달하여 사용한다.
                    callback(result);
                }
            },
            error:function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });
    }

    //댓글 삭제
    function remove(rno, callback, error){
        $.ajax({
            type:"DELETE",
            url:"/user/" + rno,
            success:function(result){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }
    //댓글 수정
    function update(reply, callback, error){
        console.log("update...........");
        $.ajax({
            type:"patch",
            url:"/user/" + reply.rno,
            data:JSON.stringify(reply),
            contentType:"application/json; charset=utf-8",
            success:function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });
    }

    // //댓글 목록
    // function getList(params, callback, error){
    //     console.log("list..........");
    //     $.getJSON(
    //         "/user/" + num,
    //         function(result){
    //             if(callback){
    //                 callback(result.replyCnt, result);
    //             }
    //         }
    //     ).fail(function(xhr, status, er){
    //         if(error){
    //             error(er);
    //         }
    //     })
    // }

    //댓글 조회
    function get(rno, callback, error){
        $.get(
            "/user/pages/" + num,
            function(replyInfo){
                if(callback){
                    console.log(replyInfo);
                    callback(replyInfo);
                }
            }
        ).fail(function(xhr, status, err){
            if(error){
                error(err);
            }
        });
    }

    function displayTime(timeValue){
        let today = new Date();
        let dateObj = new Date(timeValue);
        let gap = today.getTime() - dateObj.getTime();

        if(gap < (1000 * 60 * 60 * 24)){
            let hh = dateObj.getHours();
            let mi = dateObj.getMinutes();
            let ss = dateObj.getSeconds();

            return [(hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss].join(' ');
        }else{

            let yy = dateObj.getFullYear();
            let mm = dateObj.getMonth() + 1;
            let dd = dateObj.getDate();

            return [yy, '-', (mm > 9 ? '' : '0') + mm, '-', (dd > 9 ? '' : '0') + dd].join(' ');
        }
    }

    return {add : add, remove : remove, update : update, get : get, displayTime : displayTime};
//    외부에서는 replyService.add(객체, 콜백)형식으로 사용하며,
//    Ajax 호출이 감춰져 있기 때문에 사용부의 코드가 더 깔끔해진다.
})();


















