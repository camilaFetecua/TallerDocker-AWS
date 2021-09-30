var app = (function () {

    var add = function() {
        var value = $("#word").val();
        var jsonValue = {"word": value};
        apiclient.addPalabra(jsonValue, view);
    }

    var view = function(error, res) {
        console.log(res);
        if(error != null){
            alert("Verifique los datos ingresados");
            return;
        }
        console.log(res);
        $("#ok").text(res.confirm);
    }

    return {
        addWord: function() {
            add();
        }

    }

})();