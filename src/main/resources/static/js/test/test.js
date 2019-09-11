var files = [];
$(document).ready(function () {

    console.log("*****");
    $("input").change(function () {
        files = this.files;
    });


    $("#upload-btn").click(function () {
        console.log("11111");
        var fd = new FormData();
        for (var i = 0; i < files.length; i++){
            fd.append("file", files[i]);
        }
        console.log(files);
        $.ajax({
            url:"/testfunction/upload_folder",
            method:"POST",
            data:fd,
            contentType:false,
            processData:false,
            cache:false,
            success: function (response) {
                console.log(response.msg);
                console.log("ajax success");
            },
            error:function () {
                console.log("wrong...");
            }

        })
    });


});



