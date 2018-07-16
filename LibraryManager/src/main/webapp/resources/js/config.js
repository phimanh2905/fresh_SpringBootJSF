function searchTable() {
	var input, filter, table =[], tr, td,th, i;
	  input = document.getElementById("txtSearch");
	  filter = input.value.toUpperCase();
	  table = document.getElementsByClassName("table");
	  //table = document.getElementById("table");
	  //
	  tr = table[0].getElementsByTagName("tr");
	  th = table[0].getElementsByTagName("th");
	  for (i = 0; i < tr.length; i++) 
	  {
	    for (j = 0; j < th.length; j++)
	    {
	    	td = tr[i].getElementsByTagName("td")[j];
	        if (td) 
	        {
	          if (td.innerHTML.toUpperCase().indexOf(filter) > -1) 
	          {
	            tr[i].style.display = "";
	            break;
	            //continue;
	            
	          } else 
	          {
	            tr[i].style.display = "none";
	            
	          }
	  		}
	    }
	  }
	}
function AllChecked()
{
	var ck=true;
	var checkboxs = [],i;
	checkboxs = document.getElementsByClassName("check");
	for(i=0;i<checkboxs.length;i++)
	{
		if(checkboxs[i].checked == false)
		{
			ck=false;
			break;
		}
			
	}
	return ck;
}
function selectAll() {
    var checkboxs = [],i,ck;
	checkboxs = document.getElementsByClassName("check");
	ck = AllChecked();
	if(ck == false)
	{
		for(i=0;i<checkboxs.length;i++)
		{
			if(checkboxs[i].disabled == false)
			{
				checkboxs[i].checked = true;
			}
				
		}
	}
	else
	{
		UncheckAll();
	}
	updateButtonStatus();
}
function UncheckAll() {
    var checkboxs = [],i;
	checkboxs = document.getElementsByClassName("check");
	
	for(i=0;i<checkboxs.length;i++)
		{
			
			if(checkboxs[i].disabled == false)
			{
				checkboxs[i].checked = false;
			}
		}
			
	updateButtonStatus();
}
function updateButtonStatus(){
	var button = document.getElementById("checkAll");
  	button.text(AllChecked()? button.innerText= "Uncheck all" : button.innerText= "Check all");
}


function ready()
{
	updateButtonStatus();
	$('#myDatepicker2').datetimepicker({
        format: 'DD.MM.YYYY'
    });
}
$('.pane-hScroll').scroll(function() {
  $('.pane-vScroll').width($('.pane-hScroll').width() + $('.pane-hScroll').scrollLeft());
});

// Example 2
$('.pane--table2').scroll(function() {
  $('.pane--table2 table').width($('.pane--table2').width() + $('.pane--table2').scrollLeft());
});