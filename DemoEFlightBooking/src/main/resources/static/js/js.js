/**
 * define by xam thien
 */

function showHint(str) {
	var str = $('#txtsearch').val();
    if (str.length == 0) {
        $('#result1').html("Không có dữ liệu hiển thị.");
        
    } else {
        $.get("/search",
                {txtsearch: str},
                function (data) {
                    $('#result1').html(data);
                    
                }
        );
    }
};
function booking() {
    var id = $("#idx").val();
    var name = $("#namex").val();
    var pos = $("#posx").val();
    
    var json="{\"empNo\":'"+id+"',\"empName\":'"+name+"',\"position\":'"+pos+"'}";
    $.ajax({
    	  method: 'POST',
    	  url: 'http://192.188.88.119:8080/employee',
    	  contentType: 'application/json',
    	  data: json
    	})
    	.then(function(response) {
    	  // Handle the response here
    	});
};
var xxx = "scsd";

