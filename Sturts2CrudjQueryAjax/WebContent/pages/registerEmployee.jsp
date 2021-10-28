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
       <!--<div class="navbar-collapse navbar-custom-collapse collapse" id="navbar-collapse">
        <div class="navbar-collapse-header">
          <div class="row">
            <div class="col-6 collapse-brand">
              <a href="#">
                <img src="img/brand/mumbai_police.jpg">
              </a>
            </div>
            <div class="col-6 collapse-close">
              <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse" aria-controls="navbar-collapse" aria-expanded="false" aria-label="Toggle navigation">
                <span></span>
                <span></span>
              </button>
            </div>
          </div>
        </div>
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a href="#" class="nav-link">
              <span class="nav-link-inner--text">Dashboard</span>
            </a>
          </li>
          <li class="nav-item">
            <a href="login.html" class="nav-link">
              <span class="nav-link-inner--text">Login</span>
            </a>
          </li>
          <li class="nav-item">
            <a href="register.html" class="nav-link">
              <span class="nav-link-inner--text">Register</span>
            </a>
          </li>
        </ul>-->
        <hr class="d-lg-none" />
     
      </div>
    </div>
  </nav>
  <!-- Main content -->
  <div class="main-content">
    <!-- Header -->
    <div class="header bg-gradient-primary py-1 py-lg-9 pt-lg-9">
    
     
     <!--  <div class="separator separator-bottom separator-skew zindex-100">
        <svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1" xmlns="http://www.w3.org/2000/svg">
          <polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
        </svg>
      </div> -->
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
 <!-- Start Commented By Ram on Date 12-10-2021 -->
  <!-- <div class="col-lg-6" id="newdiv">
    <label for="uname">New
    <input type="radio" class="form-control" id="new" name="new" style="width:18px;height: 18px;" value="new" checked onclick="myFun(1)">
    
  </label>
 </div>

 <div class="col-lg-6" id="modifydiv">  
  <label for="uname">Modify
 <input type="radio" class="form-control" id="modify" name="modify" style="width:18px;height: 18px;" value="modify" onclick="myFun(2)">  
</label>
</div> -->
<!-- End Commented By Ram on Date 12-10-2021 -->

  <!-- Start Commented By Ram on Date 12-10-2021 -->
    <!-- <div class="col-lg-6" id="namediv">
       <label for="uname">Name:</label>
      <input type="text" class="form-control" id="name" placeholder="Patient Name" name="patientDetail.name">
    </div>
   
    <div class="col-lg-6">
       <label for="uname">Mobile Number:</label>
      <input type="tel" class="form-control" id="mobileNo" placeholder="Mobile Number" name="patientDetail.mobileNumber">
    </div>
    <div class="col-lg-6">
       <label for="uname">Police Bakal Number:</label>
      <input type="tel" class="form-control" id="policeBakalNo" placeholder="Bakal Number" name="patientDetail.policeBakalNumber">
    </div>
    <div class="col-lg-6" id="agediv"> 
       <label for="uname">Age:</label>
      <input type="text" class="form-control" id="age" placeholder="Age" name="patientDetail.age">
    </div>
    <div class="col-lg-6" id="isolationdiv">
       <label for="uname">Isolation Date:</label>
      <input type="date" class="form-control" id="isolationDate" placeholder="Isolation Date" name="patientDetail.isolationDate">
    </div>
    <div class="col-lg-6" id="firsttestdiv"> 
       <label for="uname">First Test Result Date:</label>
      <input type="date" class="form-control" id="testResultDate" placeholder="First Test Result Date" name="patientDetail.firstTestResultDate">
    </div>
     <div class="col-lg-6" id="testresultdiv">
       <label for="uname">Test Result:</label>
        <select class="form-control" id="sel1" name="patientDetail.testResult">
            <option>Positive</option>
            <option>Negative</option>
        
        </select>
    </div> 
   
    <div class="col-lg-6" id="hospitaldiv">
       <label for="uname">Hospital Name :</label>
      <input type="text" class="form-control" id="hospitalName" placeholder="Hospital Name" name="patientDetail.hospitalName">
    </div>
     <div class="col-lg-6" id="oxygendiv">
       <label for="uname">Oxygan support start Date :</label>
      <input type="date" class="form-control" id="oxygenstartDate" placeholder="Oxygan support start Date" name="patientDetail.oxygenStartDate">
    </div>
     <div class="col-lg-6" id="oxyganendiv"> 
       <label for="uname">Oxygan support end Date :</label>
      <input type="date" class="form-control" id="oxygenendDate" placeholder="Oxygan support end Date" name="patientDetail.oxygenEndDate">
    </div>
     <div class="col-lg-6" id="validatordiv">
       <label for="uname">Ventilator support start Date :</label>
      <input type="date" class="form-control" id="ventilatorSupport" placeholder="Ventilator support start Date" name="patientDetail.ventilatorStartDate">
    </div>
     <div class="col-lg-6" id="validatorenddiv"> 
       <label for="uname">Ventilator support end Date :</label>
      <input type="date" class="form-control" id="ventilatorenddate" placeholder="Ventilator support end Date" name="patientDetail.ventilatorEndDate">
    </div>
      <div class="col-lg-6" id="id1">
       <label for="uname">Arsenic album 30 be taken:</label>
        <select class="form-control" id="sel1" name="patientDetail.arsenicTaken">
            <option>Yes</option>
            <option>No</option>
        
        </select>
    </div> 
      <div class="col-lg-6" id="bloodgroupdiv">
       <label for="uname">Blood Group:</label>
        <select class="form-control" id="sel2" name="patientDetail.bloodGroup">
            <option>A+</option>
            <option>A-</option>
            <option>B+</option>
            <option>B-</option>
            <option>O+</option>
            <option>O-</option>
            <option>AB+</option>
            <option>AB-</option>
        </select>
    </div> -->
    <!-- End Commented By Ram on Date 12-10-2021 -->
    
    <div class="col-lg-6" id="namediv">
       <label for="uname">Employee Name:</label>
      <input type="text" class="form-control" id="empName" placeholder="Employee Name" name="patientDetail.name">
    </div>
   
    <div class="col-lg-6">
       <label for="uname">Mobile Number:</label>
      <input type="tel" class="form-control" id="mobileNo" placeholder="Mobile Number" name="patientDetail.mobileNumber">
    </div>
    <div class="col-lg-6">
       <label for="uname">Aadhar Number:</label>
      <input type="tel" class="form-control" id="aadharNo" placeholder="Aadhar Number" name="patientDetail.policeBakalNumber">
    </div>
    <div class="col-lg-6" id="agediv"> 
       <label for="uname">Age:</label>
      <input type="text" class="form-control" id="age" placeholder="Age" name="patientDetail.age">
    </div>
    <!-- <div class="col-lg-6" id="isolationdiv">
       <label for="uname">Isolation Date:</label>
      <input type="date" class="form-control" id="isolationDate" placeholder="Isolation Date" name="patientDetail.isolationDate">
    </div> -->
    <!-- <div class="col-lg-6" id="firsttestdiv"> 
       <label for="uname">First Test Result Date:</label>
      <input type="date" class="form-control" id="testResultDate" placeholder="First Test Result Date" name="patientDetail.firstTestResultDate">
    </div>
     <div class="col-lg-6" id="testresultdiv">
       <label for="uname">Test Result:</label>
        <select class="form-control" id="sel1" name="patientDetail.testResult">
            <option>Positive</option>
            <option>Negative</option>
        
        </select>
    </div> 
   
    <div class="col-lg-6" id="hospitaldiv">
       <label for="uname">Hospital Name :</label>
      <input type="text" class="form-control" id="hospitalName" placeholder="Hospital Name" name="patientDetail.hospitalName">
    </div>
     <div class="col-lg-6" id="oxygendiv">
       <label for="uname">Oxygan support start Date :</label>
      <input type="date" class="form-control" id="oxygenstartDate" placeholder="Oxygan support start Date" name="patientDetail.oxygenStartDate">
    </div>
     <div class="col-lg-6" id="oxyganendiv"> 
       <label for="uname">Oxygan support end Date :</label>
      <input type="date" class="form-control" id="oxygenendDate" placeholder="Oxygan support end Date" name="patientDetail.oxygenEndDate">
    </div>
     <div class="col-lg-6" id="validatordiv">
       <label for="uname">Ventilator support start Date :</label>
      <input type="date" class="form-control" id="ventilatorSupport" placeholder="Ventilator support start Date" name="patientDetail.ventilatorStartDate">
    </div>
     <div class="col-lg-6" id="validatorenddiv"> 
       <label for="uname">Ventilator support end Date :</label>
      <input type="date" class="form-control" id="ventilatorenddate" placeholder="Ventilator support end Date" name="patientDetail.ventilatorEndDate">
    </div>
      <div class="col-lg-6" id="id1">
       <label for="uname">Arsenic album 30 be taken:</label>
        <select class="form-control" id="sel1" name="patientDetail.arsenicTaken">
            <option>Yes</option>
            <option>No</option>
        
        </select>
    </div> 
      <div class="col-lg-6" id="bloodgroupdiv">
       <label for="uname">Blood Group:</label>
        <select class="form-control" id="sel2" name="patientDetail.bloodGroup">
            <option>A+</option>
            <option>A-</option>
            <option>B+</option>
            <option>B-</option>
            <option>O+</option>
            <option>O-</option>
            <option>AB+</option>
            <option>AB-</option>
        </select>
    </div> -->
  </div>
      <div class="text-center">
                  <button type="button" class="btn btn-primary my-4" id="savebtn">Save </button>
                  <button type="button" class="btn btn-primary my-4" id="searchbtn" onclick="searchClick()">Search </button>
                </div>
</form>    
    </div>
  </div>
 <footer class="py-5" id="footer-main">
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
  </footer>
  
  <script type="text/javascript">
  
  $(document).ready(function(){
	  document.getElementById("searchbtn").style.display = "none";
	  
	  $("form").submit(function(e){
	        e.preventDefault();
	    });
	  
		$("#savebtn").unbind("click");
		$("#savebtn").click(function(e) 
      	{
			e.preventDefault();
			debugger;
			var formInput = $("#patientform").serialize();
			alert("Data:"+formInput);
			
			var ajaxXmlData = $("#empName").val()+"~"+$("#mobileNo").val()+"~"+$("#aadharNo").val()+"~"+$("#age").val();
			alert("ajaxData:"+ajaxXmlData)
			/* $.ajax({
	  			type: "POST",
	  			url : "register.action",
	  			data : "ajaxXmlData="+ajaxXmlData,
	  			dataType : "html",
	  			cache : false,
	  			success : function(data){
	  				  			
	  					alert("Success:" + data);
	  					
	  			},
	  			error: function(data){
	  				alert("Currently Unable To Perform Requested Operation.");
	  				
	  				
	  				
	  			}
	  		}); */
			
			
			$.post("save.action", formInput, function(data1)
					{
						//alert(data1);
						debugger;
						$.each(data1.message, function(key, value) {

							if(key == "success") 
							{
								alert(value);
								window.location.href ="index.jsp";
							}
							else if(key == "error") 
							{
								alert(value);
								window.location.href ="index.jsp";
							}
						    });
					},"json");
		});
		
		$("#searchbtn").unbind("click");
		$("#searchbtn").click(function() 
      {
			debugger;
			var formInput = $(this).serialize();
			var ajaxData=$("#email").val()+$("#password").val();
			alert("ajaxData:"+ajaxData)
			$.ajax({
	  			type: "POST",
	  			url : "search.action",
	  			data : "ajaxXmlData="+ajaxData,
	  			dataType : "html",
	  			cache : false,
	  			success : function(data){
	  				  			
	  					alert("Success:" + data);
	  					
	  			},
	  			error: function(data){
	  				alert("Currently Unable To Perform Requested Operation.");
	  				
	  				
	  				
	  			}
	  		}); 
			//return false;
		});
});
  
    function myFun(val){
      //alert("Hello");
      debugger;
      if(val==1){
     
        if(document.getElementById("modify").checked ){
        document.getElementById("modify").checked = false;
       
      }
        document.getElementById("newdiv").style.display = "block";
        document.getElementById("modifydiv").style.display = "block";
        document.getElementById("namediv").style.display = "block";
        document.getElementById("agediv").style.display = "block";
        document.getElementById("isolationdiv").style.display = "block";
        document.getElementById("firsttestdiv").style.display = "block";
        document.getElementById("testresultdiv").style.display = "block";
        document.getElementById("hospitaldiv").style.display = "block";
        document.getElementById("oxygendiv").style.display = "block";
        document.getElementById("oxyganendiv").style.display = "block";
        document.getElementById("validatordiv").style.display = "block";
        document.getElementById("validatorenddiv").style.display = "block";
        document.getElementById("bloodgroupdiv").style.display = "block";
        document.getElementById("id1").style.display = "block";
        document.getElementById("searchbtn").style.display = "none";
        
      }else{
        if(document.getElementById("new").checked ){
        document.getElementById("new").checked = false;
        }
       
      /* document.getElementById("newdiv").style.display = "none";
      document.getElementById("modifydiv").style.display = "none"; */
      document.getElementById("namediv").style.display = "none";
      document.getElementById("agediv").style.display = "none";
      document.getElementById("isolationdiv").style.display = "none";
      document.getElementById("firsttestdiv").style.display = "none";
      document.getElementById("testresultdiv").style.display = "none";
      document.getElementById("hospitaldiv").style.display = "none";
      document.getElementById("oxygendiv").style.display = "none";
      document.getElementById("oxyganendiv").style.display = "none";
      document.getElementById("validatordiv").style.display = "none";
      document.getElementById("validatorenddiv").style.display = "none";
      document.getElementById("bloodgroupdiv").style.display = "none";
      document.getElementById("id1").style.display = "none";
      document.getElementById("searchbtn").style.display = "block";
      }

    }
function searchClick(){
  document.getElementById("newdiv").style.display = "block";
      document.getElementById("modifydiv").style.display = "block";
      document.getElementById("namediv").style.display = "block";
      document.getElementById("agediv").style.display = "block";
      document.getElementById("isolationdiv").style.display = "block";
      document.getElementById("firsttestdiv").style.display = "block";
      document.getElementById("testresultdiv").style.display = "block";
      document.getElementById("hospitaldiv").style.display = "block";
      document.getElementById("oxygendiv").style.display = "block";
      document.getElementById("oxyganendiv").style.display = "block";
      document.getElementById("validatordiv").style.display = "block";
      document.getElementById("validatorenddiv").style.display = "block";
      document.getElementById("bloodgroupdiv").style.display = "block";
      document.getElementById("id1").style.display = "block";


}
  </script>

</body>

</html>