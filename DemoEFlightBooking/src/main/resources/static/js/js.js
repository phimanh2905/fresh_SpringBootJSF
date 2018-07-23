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
}
