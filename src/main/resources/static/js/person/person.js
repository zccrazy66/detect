var name_temp = "";
//var position_temp = "";

$(".update_modal_btn").on('click',function () {
    // console.log("**&&&&&&&***");
    var name_current_row = $(this).parent().siblings(".emp_name").text();
    console.log("name_current_row is "+ name_current_row);
    name_temp = name_current_row;

});


//    删除用户的AJAX请求
$(".delete").click(function () {

    if (confirm('系统提示：您确定删除该用户吗？')) {
        var name = $(this).parent().siblings('.emp_name').text();
        console.log(name);
        var input_json = {};
        input_json.name = name;
        $.ajax({
            url: "/delete",
            type: 'POST',
            contentType: "application/json;charset=utf-8",
            dataType: 'json',
            data: JSON.stringify(input_json),
            async: false,
            cache: false,
            processData: false,
            success: function (response) {
                //成功的回调
                console.log('into ajax success...');
                if (response.success) {
                    console.log(response.message);
                    $('#main').load('/person');
                }
            },
            error: function (returndata) {
                console.log('something wrong with ajax');
            }
        })
    }
});

   // 新增用户的AJAX请求
$(".insert").click(function () {

    // var id = parseInt($("#id").text())+1;
  // var id =  parseInt($('.emp_id').last().text())+1;
   var name = $("#recipient-name").val();
   var password = $("#message-password").val();
   var position =  $("#message-position").val();
   var power = $("#exampleFormControlSelect1").val();
   //console.log('id = '+id);
   console.log(name,password, position, power);

   var insert_json = {};
  // insert_json.id = id;
   insert_json.name = name;
   insert_json.position = position;
   insert_json.power= power;
   insert_json.password = password;

   $.ajax({
       url: "/insert",
       type: 'POST',
       contentType: "application/json;charset=utf-8",
       dataType : 'json',
       data: JSON.stringify(insert_json),
       async: false,
       cache: false,
       processData: false,
       success: function (response) {
           //成功的回调
           console.log('into ajax success...');
           if (response.success){
               console.log(response.message);
           }
       },
       error: function (returndata) {
           console.log('something wrong with ajax');
       }
   });
   console.log("jump out ajax");
    $('#close_btn').click();
    $('#main').load('/person');
    console.log('remove backdrop');
    $('.modal-backdrop').remove();
});


     //修改用户信息的AJAX请求
 $(".update").click(function () {

     // var id = $(this).parent().siblings('.emp_id').text();
     var name = name_temp;
     var password = $(".update_password").val();
     var position =  $(".update_position").val();
     var power = $(".update_power").val();
 //    console.log("************"+"        "+id);
     console.log( name, password, position, power);

     var update_json = {};
     update_json.name = name;
     update_json.position = position;
     update_json.power= power;
     update_json.password = password;

     $.ajax({
         url: "/update",
         type: 'POST',
         contentType: "application/json;charset=utf-8",
         dataType : 'json',
         data: JSON.stringify(update_json),
         async: false,
         cache: false,
         processData: false,
         success: function (response) {
             //成功的回调
             console.log('into ajax success...');
             if (response.success){
             }
         },
         error: function (returndata) {
             console.log('something wrong with ajax');
         }
     });
     $('#close_btn1').click();
     $('#main').load('/person');
     console.log('remove backdrop');
     $('.modal-backdrop').remove();
 });