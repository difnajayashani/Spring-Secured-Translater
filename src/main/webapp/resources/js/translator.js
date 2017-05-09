

    function myFunction(){
        var e = document.getElementById("original-text").value;
        var e2 = document.getElementById("text_trans").value;

        document.getElementById("original-text").value = e2;

        document.getElementById("text_trans").value = e;

    }

    function resetFunction() {
        document.getElementById("translater").reset();
    }


