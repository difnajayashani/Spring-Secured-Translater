

    function myFunction(){
        var e = document.getElementById("original-text").value;
        var e2 = document.getElementById("text_trans").value;

        document.getElementById("original-text").value = e2;

        document.getElementById("text_trans").value = e;

    }

    function resetFunction() {
        document.getElementById("translater").reset();
    }

    $(document).ready(function(){
        var e = document.getElementById("original");
        var oLang = e.options[e.selectedIndex].text;
        //$("#selectedOl").val(oLang);
        $("input[id=selectedOl]").val(oLang);

    });
