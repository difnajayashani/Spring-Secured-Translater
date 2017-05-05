$(document).ready(function () {

    function myFunction(){
        var e = document.getElementById("original-text").value;
        var e2 = document.getElementById("text_trans").value;

        document.getElementById("original-text").value = e2;

        document.getElementById("text_trans").value = e;

    }

    function resetFunction() {
        document.getElementById("translater").reset();
    }


    $("#btnTranslate").submit(function () {
        var from_lang = $("#original").val();
        var to_lang = $('#translated').val();
        var original_text=$('#original-text').val();

            $.ajax({
                url: "https://localhost:8443/transledText",
                data: {"from_lang": from_lang,"to_lang":to_lang,"original_text":original_text},
                success: function (data) {
                    //alert(" value"+ data);
                    $('#text_trans').val(data);

                }
            })

    });
});