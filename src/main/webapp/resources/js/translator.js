
$(document).ready(function () {


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
})