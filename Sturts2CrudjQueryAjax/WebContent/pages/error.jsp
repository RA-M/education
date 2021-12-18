<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
  <meta name="author" content="Creative Tim">
  <title>Ram Software</title>
  <!-- Favicon -->
  <link rel="icon" href="img/brand/favicon.png" type="image/png">
  <!-- Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
  <!-- Icons -->
  <link rel="stylesheet" href="vendor/nucleo/css/nucleo.css" type="text/css">
  <link rel="stylesheet" href="vendor/@fortawesome/fontawesome-free/css/all.min.css" type="text/css">
  <!-- Argon CSS -->
  <link rel="stylesheet" href=css/argon.css?v=1.2.0" type="text/css">
    
  
<script src="vendor/jquery/dist/jquery.min.js"></script>
  <script src="vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="vendor/js-cookie/js.cookie.js"></script>
  <script src="vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
  <script src="vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
  <!-- Argon JS -->
  <script src="js/argon.js?v=1.2.0"></script>
  
</head>
 
<body class="bg-default">
  <!-- Navbar -->
   <nav id="navbar-main" class="navbar navbar-horizontal navbar-transparent navbar-main navbar-expand-lg navbar-light">
    <div class="container">
      <a class="navbar-brand" href="#">
        <img src="img/brand/Image1.jpg" alt="Image" height="60" width="50" >
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-collapse" aria-controls="navbar-collapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
        <hr class="d-lg-none" />
     
      </div>
    </div>
  </nav>
  <!-- Main content -->
  <div class="main-content">
    <!-- Header -->
    <div class="header bg-gradient-primary py-1 py-lg-9 pt-lg-9">
    
     
     
    </div>
    
    <!-- Page content -->
    <div class="container mt--8 pb-5">
      <!-- Table -->
 <form id="patientform">
  <div class="row">
<div class="col-lg-6" id="newdiv">
    
 </div>
 <div class="col-lg-12" id="newdiv">
    
 </div>

    <div class="col-lg-6" id="namediv">
       <label for="uname">Email or Password is incorrect</label>
    </div>
  </div>
      <div class="text-left">
                  <button type="button" class="btn btn-primary my-4" id="login">Login Again </button>
                </div>
</form>    
    </div>
  </div>
 <!-- <footer class="py-5" id="footer-main">
    <div class="container">
      <div class="row align-items-center justify-content-xl-between">
        <div class="col-xl-6">
          <div class="copyright text-center text-xl-left text-muted">
            &copy; 2021 <a href="#" class="font-weight-bold ml-1" target="_blank">Ram Team</a>
          </div>
        </div>
        <div class="col-xl-6">
          <ul class="nav nav-footer justify-content-center justify-content-xl-end">
            <li class="nav-item">
              <a href="#" class="nav-link" target="_blank">Ram Team</a>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link" target="_blank">About Us</a>
            </li>
         
         
          </ul>
        </div>
      </div>
    </div>
  </footer> -->
  
  <script type="text/javascript">
  
  $(document).ready(function(){
	  
	  //alert("1");
	  //document.getElementById("searchbtn").style.display = "none";
	  
	  $("form").submit(function(e){
	        e.preventDefault();
	    });
	  
		$("#login").unbind("click");
		$("#login").click(function() 
      	{
			window.location.href = 'index.jsp';
			//document.open("pages/homePage.jsp");
		});
		
});
  
    
  </script>

</body>

</html>