/**
 * 
 */
function doAjaxPost() {  
	  // get the form values  
	  var name = $('#name').val();
	  var education = $('#education').val();
	   
//           var json = [{"member_id":"2","comment":"kkk"},{"member_id":"1","comment":"this is admin 2"},{"member_id":"2","comment":"kkk"},{"member_id":"1","comment":"this is admin"}];
//$.each(json, function(i, data){
//$("table.table").append("<tr><td>" + data.member_id + "</td><td>" + data.comment + "</td></tr>");
//})

	  $.ajax({  
	    type: "POST",  
	    url: contexPath + "/AddUser.htm",  
	    data: "name=" + name + "&education=" + education,  
	    success: function(response){
	      // we have the response 
        
//                     var numbers = [1, 2, 3, 4, 5, 6];
//                    var trHTML = '';
//
//                    $.each(numbers , function (index, value){
//                        trHTML += '<tr><td>' + index + '</td><td>' + value + '</td></tr>';
////                        $('#location').append(trHTML);
////                        $("table.table").append(trHTML);
//                    });

                var trHTML = '';
	      if(response.status == "SUCCESS"){
	    	  userInfo = "<ol>";
	    	  for(i =0 ; i < response.result.length ; i++){
	    		  userInfo += "<br><li><b>Name</b> : " + response.result[i].name + 
	    		  ";<b> Education</b> : " + response.result[i].education;
                     trHTML = '<tr><td>' + response.result[i].name + '</td><td>' + response.result[i].education + '</td></tr>';
	    	  }
	    	  userInfo += "</ol>";  
                  $('#location').append(trHTML);
//	    	  $('#info').html("User has been added to the list successfully. " + userInfo);                  
	    	  $('#name').val('');
		      $('#education').val('');
		      $('#error').hide('slow');
		      $('#info').show('slow');
	      }else{
	    	  errorInfo = "";
	    	  for(i =0 ; i < response.result.length ; i++){
	    		  errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
	    	  }
	    	  $('#error').html("Please correct following errors: " + errorInfo);
	    	  $('#info').hide('slow');
	    	  $('#error').show('slow');
	      }
	    },  
	    error: function(e){  
	      alert('Error: ' + e);  
	    }  
	  });  
	}  