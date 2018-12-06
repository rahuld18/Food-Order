$(document).ready(function(){
$.getJSON("GetAllCategoryJSON",{ajax:true},function(data){
	
	$('#catname').append($('<option>').text('-Category-'));
	$.each(data,function(i,item){
	  
		$('#catname').append($('<option>').text(item.CATEGORYNAME).val(item.CATEGORYID));	
		
	});
	
	
});
});