$(document).ready(function () {
    $('#main').empty();
    $('#main').load('/electric');
    // $('.nav-link').parent().children("ul").hide();
    $('.sidebar-sticky>ul>li>a').parent().children("ul").hide();
    // $('.detection').attr("style", "display:none;")
    $('.first').on('click', function () {
        $(this).parent().children("ul").toggle("slow");
        // $(this).parent().children("ul").hide();

        //点一下其他二级菜单消失
    });

    $('.ele').on('click', function () {
        $('#main').load('/electric');
    });

    $('.hot').on('click', function () {
        $('#main').load('/hotmelt');
    });

    $('.pic').on('click', function () {
        $('#main').load('/picture');
    });

    $('.worklog').on('click',function () {
       $('#main').load('/worklog');
    });

    $('.person').on('click', function () {
        $('#main').load('/person');
    });

    $('.first').on('click', function () {
        $('#main').load('/electric');
    });
});


//上传图片（单张）
function ajax_upload() {
    var formData = new FormData($("#img_form")[0]);
    // console.log('formData is ' + formData);
    var fileName;
    $.ajax({
        //接口地址
        url: '/upload',
        type: 'POST',
        data: formData,
        //dateType: 'json',
        async: false,
        cache: false,
        contentType: false,   //这里必须是false, 不是文件上传的ajax这里不是这样！！！！！！！！！
        processData: false,
        success: function (data) {
            //成功的回调
            // console.log('success is ' + data.success);
            // console.log('message is ' + data.message);
            // console.log('fileName is ' + data.fileName);
            fileName = data.fileName;

        },
        error: function (returndata) {
            console.log('something wrong...');
        }
    });
    sleep(500);
    var img_path = "img_res/" + fileName;
    // console.log("img_path is " + img_path);
    $('#img_elec').attr("src", img_path);
}




// 检测数据返回
function detection() {
    var url = $('#img_elec').attr("src");
    var threshold_L = $('#threshold_L').val();
    // console.log(threshold_L);
    // console.log(url);
    var detect_json = {};
    detect_json.url = url;
    detect_json.threshold_L = threshold_L;
    // console.log(detect_json);
    // detect_json
    $.ajax({
        url: "/detect_post",
        type: 'POST',
        contentType: "application/json;charset=utf-8",
        dataType: 'json',
        data: JSON.stringify(detect_json),
        async: false,
        cache: false,
        processData: false,
        success: function (response) {
            //成功的回调
            // console.log('into ajax success...');
            // console.log(response);
            error_mag = response.error_msg;
            chengcha_sign = response.chengcha_sign;
            dislocation_sign = response.dislocation_sign;
            hole_sign = response.hole_sign;
            impurity_sign = response.impurity_sign;
            over_cold_welding_sign = response.over_cold_welding_sign;
            Semantic_segmentation = response.Semantic_segmentation;
            // save_path = response.save_path;

            // console.log('response.rlt_path.... = '+ response.rlt_path);
            // after_filename = response.rlt_path;
            //
            // count_hole = response.count_hole;
            // distance_min = response.distance_min;
            // distance_mode = response.distance_mode;
            // distance_max = response.distance_max;
            // border_var = response.border_var;
        },
        error: function (returndata) {
            console.log('something wrong with ajax');
        }
    });
    sleep(200);

    // var error_mag = error_mag;
    var chengcha_sign = chengcha_sign;
    var dislocation_sign = dislocation_sign;
    var hole_sign = hole_sign;
    var impurity_sign = impurity_sign;
    var over_cold_welding_sign = over_cold_welding_sign;
    var Semantic_segmentation = Semantic_segmentation;


    // $('#dislocation_sign').html(dislocation_sign);
    // $('#hole_sign').html(hole_sign);
    // $('#impurity_sign').html(impurity_sign);
    // $('#over_cold_welding_sign').html(over_cold_welding_sign);
    // $('#Semantic_segmentation').html(Semantic_segmentation);

    if (Semantic_segmentation != 1){
        $('#Semantic_segmentation').hide();
        // $("p").hide()
    } else {
        $('#Semantic_segmentation').html("语义分割出错！请检查输入图片");
        $('#Semantic_segmentation').show();

    }


    if (chengcha_sign == 1) {
        $('#chengcha').html("存在承插不到位");
        $('#chengcha').show();
    }else if (chengcha_sign == 0) {
        $('#chengcha').html("不存在承插不到位");
        $('#chengcha').show();
    }else {
        $('#chengcha').hide();
    }


    if (dislocation_sign == 1) {
        $('#dislocation_sign').html("存在一级电阻丝错位");
        $('#dislocation_sign').show()
    }else if (dislocation_sign == 2) {
        $('#dislocation_sign').html("存在二级电阻丝错位");
        $('#dislocation_sign').show()
    }else if (dislocation_sign == 3){
        $('#dislocation_sign').html("存在三级电阻丝错位")
        $('#dislocation_sign').show()
    }else if (dislocation_sign == 0) {
        $('#dislocation_sign').html("不存在错位")
        $('#dislocation_sign').show()
    }else{
        $('#dislocation_sign').hide();
    }

    if(hole_sign == 0){
        $('#hole_sign').html("不存在孔洞")
        $('#hole_sign').show()
    }else if (hole_sign == 1) {
        $('#hole_sign').html("存在一级单个孔洞");
        $('#hole_sign').show()
    }else if (hole_sign == 2){
        $('#hole_sign').html("存在二级单个孔洞");
        $('#hole_sign').show()
    }else if (hole_sign == 3) {
        $('#hole_sign').html("存在三级单个孔洞");
        $('#hole_sign').show()
    }else if (hole_sign == 4){
        $('#hole_sign').html("存在一级组合孔洞");
        $('#hole_sign').show()
    }else if (hole_sign == 5){
        $('#hole_sign').html("存在二级组合孔洞");
        $('#hole_sign').show()
    }else if (hole_sign == 6) {
        $('#hole_sign').html("存在三级组合孔洞");
        $('#hole_sign').show()
    }else {
        $('#hole_sign').hide()
    }

    if (impurity_sign == 1) {
        $('#impurity_sign').html("存在油污夹杂");
        $('#impurity_sign').show()
    }else if (impurity_sign == 2) {
        $('#impurity_sign').html("存在金属夹杂");
        $('#impurity_sign').show()
    }else if (impurity_sign == 3){
        $('#impurity_sign').html("不存在金属夹杂")
        $('#impurity_sign').show()
    }else {
        $('#impurity_sign').hide();
    }

    if (over_cold_welding_sign == 0) {
        $('#over_cold_welding_sign').html("无过焊冷焊");
        $('#over_cold_welding_sign').show()
    }else if (over_cold_welding_sign == 1) {
        $('#over_cold_welding_sign').html("存在一级过焊");
        $('#over_cold_welding_sign').show()

    }else if (over_cold_welding_sign == 2){
        $('#over_cold_welding_sign').html("存在二级过焊")
        $('#over_cold_welding_sign').show()

    }else if (over_cold_welding_sign == 3) {
        $('#over_cold_welding_sign').html("存在三级过焊")
        $('#over_cold_welding_sign').show()

    }else if (over_cold_welding_sign == 4) {
        $('#over_cold_welding_sign').html("存在一级冷焊")
        $('#over_cold_welding_sign').show()

    }else if (over_cold_welding_sign == 5) {
        $('#over_cold_welding_sign').html("存在二级冷焊");
        $('#over_cold_welding_sign').show()

    } else if (over_cold_welding_sign == 6) {
        $('#over_cold_welding_sign').html("存在三级冷焊")
        $('#over_cold_welding_sign').show()

    }else{
        $('#over_cold_welding_sign').hide();
    }



    // var after_path = save_path
    // $('#after_elec').attr('src', after_path);
    //
    // var count_hole = count_hole ;
    // var distance_min = distance_min;
    // var distance_mode = distance_mode ;
    // var distance_max =  distance_max ;
    // var border_var =  border_var ;

    // var about_border_var = Math.round(border_var);

    // console.log(distance_max, distance_mode, distance_min, count_hole, border_var);

    // if (distance_min <= 6 && distance_mode <= 10){
    //     $('#feature').html("冷焊");
    // }else if (distance_mode >= 25 && distance_max >=30){
    //     $('#feature').html("过焊");
    // } else {$('#feature').html("正常");}
    //
    // if (border_var >= 11){
    //     $('#wire').html("存在错位");
    // } else {$('#wire').html("不存在错位");}
    //
    // if (count_hole > 4 ){$('#hole').html("存在孔洞");}
    // else {$('#hole').html("不存在孔洞");}

}




function sleep(delay) {
    var start = (new Date()).getTime();
    while ((new Date()).getTime() - start < delay) {
        continue;
    }
}