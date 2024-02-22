<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Register</title>
    <link rel="stylesheet" href="register.css">
    
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>

	<div class="f">
	    <form action="register" id="myform">
	        <h2>Register</h2>
	        <input class="ab" type="text" placeholder="Enter Name ..." name="uname">
	        <input class="ab" type="email" placeholder="Enter Email ..." name="umail">
	        <input class="ab" type="password" placeholder="Enter Password ..." name="upass">
	        <div class="file-field input-field">
		      <div class="btn">
		        <span>File</span>
		        <input type="file" name="imgfile">
		      </div>
		      <div class="file-path-wrapper">
		        <input class="file-path validate" type="text">
		      </div>
		    </div>
	        <input class="sb" type="submit" value="Register Here">
	    </form>
	    <div id="load" class="center-align " style="display: none; margin-top: 40px">
	    	<div class="preloader-wrapper big active">
		    <div class="spinner-layer spinner-black-only">
		      <div class="circle-clipper left">
		        <div class="circle"></div>
		      </div><div class="gap-patch">
		        <div class="circle"></div>
		      </div><div class="circle-clipper right">
		        <div class="circle"></div>
		      </div>
		    </div>
	    </div>
	    <h4>Please Wait</h4>
	    </div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
	    $(document).ready(function () {
	        console.log("File is ready");
	
	        $("#myform").on('submit', function (event) {
	            event.preventDefault();
	
	            //var f = $(this).serialize();
				let f =new FormData(this);
				
	            console.log(f);
	            
	            $("#load").show();
	            $("#myform").hide();
	
	            $.ajax({
	                url: 'register',
	                data: f,
	                type: 'POST',
	                success: function (data, textStatus, jqXHR) {
	                    console.log(data);
	                    console.log("Success...........");
	                    $("#load").hide();
	                    $("#myform").show();
	                    alert("Registered Successfully");
	                },
	                error: function (data, textStatus, errorThrown) {
	                    console.log(data);
	                    console.log("Failure...........");
	                    $("#load").hide();
	                    $("#myform").show();
	                    alert("Error Occurred");
	                },
	                processData: false,  // Use colons instead of semicolons
	                contentType: false   // Use colons instead of semicolons
	            });
				
	        });
	    });
	</script>
</body>

<style>
	#load{
		
	}
</style>

</html>

