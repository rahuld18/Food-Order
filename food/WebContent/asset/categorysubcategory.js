$(document).ready(function(){
$.getJSON("GetAllCategoryJSON",{ajax:true},function(data){
	
	$('#pcategory').append($('<option>').text('-Category-'));
	$.each(data,function(i,item){
	  
		$('#pcategory').append($('<option>').text(item.CATEGORYNAME).val(item.CATEGORYID));	
		
	});
	
	
});

$('#pcategory').change(function(){
	 $.getJSON("GetAllSubcategoryJSON",{ajax:true,cid:$('#pcategory').val()},function(data){
		 $('#psubcategory').empty();
		 $('#psubcategory').append($('<option>').text('-SubCategory-'));
			$.each(data,function(i,item){
		 		$('#psubcategory').append($('<option>').text(item.SUBCATEGORYNAME).val(item.SUBCATEGORYID));	
		 	}); 

	});
});
});