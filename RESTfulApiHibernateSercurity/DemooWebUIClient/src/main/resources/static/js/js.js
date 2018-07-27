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
    
    var obj= {'empNo':id,'empName':name,'position':pos};
    console.log(JSON.stringify(obj));
    $.ajax({
    	  method: 'POST',
    	  url: 'http://192.188.88.119:8080/employee',
    	  contentType: 'application/json',
    	  data: JSON.stringify(obj),
    	  async: false,
    	  cache: false,
    	  processData:false
    	})
    	.then(function(data) {
    	  // Handle the response here 192.168.11.105 192.188.88.119
    		alert(data);
    	});
};

function testpost() {
	var id = $("#idx").val();
    var name = $("#namex").val();
    var pos = $("#posx").val();
    

    $.get("/testpost",
            {idx: id, namex: name, posx: pos},
            function (data) {
                alert(data);
                window.location.reload(true);
            }
    );
};
function testput() {
	var id = $("#idx").val();
    var name = $("#namex").val();
    var pos = $("#posx").val();
    

    $.get("/testput",
            {idx: id, namex: name, posx: pos},
            function (data) {
                alert(data);
                window.location.reload(true);
            }
    );
};
function testdelete() {
	var id = $("#idx").val();
    $.get("/testdelete",
            {idx: id},
            function (data) {
                alert(data);
                window.location.reload(true);
            }
    );
};





