<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Abacus</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

/* Style the body */
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

/* Header/logo Title */
.header {
  padding: 80px;
  text-align: center;
  background: #1abc9c;
  color: white;
}

/* Increase the font size of the heading */
.header h1 {
  font-size: 40px;
}

/* Sticky navbar - toggles between relative and fixed, depending on the scroll position. It is positioned relative until a given offset position is met in the viewport - then it "sticks" in place (like position:fixed). The sticky value is not supported in IE or Edge 15 and earlier versions. However, for these versions the navbar will inherit default position */
.navbar {
  overflow: hidden;
  background-color: #333;
  position: sticky;
  position: -webkit-sticky;
  top: 0;
}

/* Style the navigation bar links */
.navbar a {
  float: left;
  display: block;
  color: white;
  text-align: center;
  padding: 14px 20px;
  text-decoration: none;
}


/* Right-aligned link */
.navbar a.right {
  float: right;
}

/* Change color on hover */
.navbar a:hover {
  background-color: #ddd;
  color: black;
}

/* Active/current link */
.navbar a.active {
  background-color: #666;
  color: white;
}

/* Column container */
.row {  
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
}

/* Create two unequal columns that sits next to each other */
/* Sidebar/left column */
.side {
  -ms-flex: 30%; /* IE10 */
  flex: 30%;
  background-color: #f1f1f1;
  padding: 20px;
}

/* Main column */
.main {   
  -ms-flex: 70%; /* IE10 */
  flex: 70%;
  background-color: white;
  padding: 20px;
}

/* Fake image, just for this example */
.fakeimg {
  background-color: #aaa;
  width: 100%;
  padding: 20px;
}

/* Footer */
.footer {
  padding: 20px;
  text-align: center;
  background: #ddd;
}

/* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 700px) {
  .row {   
    flex-direction: column;
  }
}

/* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
  .navbar a {
    float: none;
    width: 100%;
  }
}
div.gallery {
  margin: 5px;
  border: 1px solid #ccc;
  float: left;
  width: 180px;
}

div.gallery:hover {
  border: 1px solid #777;
}

div.gallery img {
  width: 100%;
  height: auto;
}

div.desc {
  padding: 15px;
  text-align: center;
}


/* The container */
.container {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 12px;
  cursor: pointer;
  font-size: 22px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default radio button */
.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
}

/* Create a custom radio button */
.checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 25px;
  width: 25px;
  background-color: #eee;
  border-radius: 50%;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.container input:checked ~ .checkmark {
  background-color: #2196F3;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the indicator (dot/circle) when checked */
.container input:checked ~ .checkmark:after {
  display: block;
}

/* Style the indicator (dot/circle) */
.container .checkmark:after {
 	top: 9px;
	left: 9px;
	width: 8px;
	height: 8px;
	border-radius: 50%;
	background: white;
}


/*  */

* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Caption text */
.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}

/* The dots/bullets/indicators */
.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}

/*  */


</style>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
  <meta name="author" content="Creative Tim">
  <title>Sample</title>
  <!-- Favicon -->
  <link rel="icon" href="img/brand/favicon.png" type="image/png">
  <!-- Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
  <!-- Icons -->
  <link rel="stylesheet" href="vendor/nucleo/css/nucleo.css" type="text/css">
  <link rel="stylesheet" href="vendor/@fortawesome/fontawesome-free/css/all.min.css" type="text/css">
  <!-- Argon CSS -->
  <link rel="stylesheet" href="css/argon.css?v=1.2.0" type="text/css">
  
  <script src="vendor/jquery/dist/jquery.min.js"></script>
  
  <script src="vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="vendor/js-cookie/js.cookie.js"></script>
  <script src="vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
  <script src="vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
  <!-- Argon JS -->
  <script src="js/argon.js?v=1.2.0"></script>
  
</head>
<body>

<!-- <div class="header">
  <h1>Abacus Exam Portal</h1>
  <p> Need To Add Images Auto Slider</p>
</div> -->

<!--  -->

<div class="slideshow-container">

<div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="Image.jpg" style="width:100%">
  <div class="text">Caption Text</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="Image1.jpg" style="width:100%">
  <div class="text">Caption Two</div>
</div>

<div class="mySlides fade">
  <div class="numbertext">3 / 3</div>
  <img src="Image2.jpg" style="width:100%">
  <div class="text">Caption Three</div>
</div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>

<!--  -->

<br>
<form action="" method="post" id="myForm">
    <input type="lable" name="username" id = "questionId" style="margin-left:500px;width: 500px" disabled/>
    <br>
	  <!-- <input type="checkbox" id="vehicle1" name="vehicle1" value="Bike" style="margin-left:500px"> -->
	  
	  <input type="radio" checked="checked" name="radio" style="margin-left:500px">
  	  <span class="checkmark"></span>
	  <!-- <label for="vehicle1"> Americans</label><br> -->
	  <label for="vehicle1" id="optionOneId"></label><br>
	  <input type="radio" name="radio" style="margin-left:500px">
  	  <span class="checkmark"></span>
	  <label for="vehicle2" id="optionTwoId"></label><br>
	  <input type="radio" name="radio" style="margin-left:500px">
  	  <span class="checkmark"></span>
	  <label for="vehicle3" id="optionThreeId"></label><br>
	  <input type="radio" name="radio" style="margin-left:500px">
  	  <span class="checkmark"></span>
	  <label for="vehicle4" id="optionFourId"></label><br><br>

			<!-- <input type="radio" name="my_options" value="option 1" checked="checked" /> Option 1
		    <input type="radio" name="my_options" value="option 2" /> Option 2
		    <input type="radio" name="my_options" value="option 3" /> Option 3 -->
		

	  <input type="submit" value="Next" id = "nextQue" style="margin-left:500px"><br>
	  <input type="submit" value="Submit" style="margin-left:500px">
	  <br><br><br><br><br>
	
	
	  <div id="quiz"></div>
	<button id="submit">Submit Quiz</button>
	<div id="results"></div>
	
	
</form>


<!-- <div class="navbar">
  <a href="#" class="active">Home</a>
  <a href="#gallary" class="active">Gallary</a>
  <a href="#contactUs" class="active">Contact Us</a> 
  <a href="#" class="right">Link</a>
  <button class="btn btn-default " type="invoice" name="invoice" id ="invoice" style="background: #08588b;color: #fff;">Get Invoice</button>
</div> -->

<!-- <div class="row">
  <div class="side">
    <h2>About Me</h2>
    <h5>Photo of me:</h5>
    <div class="fakeimg" style="height:200px;">Image</div>
    <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
    <h3>More Text</h3>
    <p>Lorem ipsum dolor sit ame.</p>
    <div class="fakeimg" style="height:60px;">Image</div><br>
    <div class="fakeimg" style="height:60px;">Image</div><br>
    <div class="fakeimg" style="height:60px;">Image</div>
  </div>
  <div class="main">
    <h2>TITLE HEADING</h2>
    <h5>Title description, Dec 7, 2017</h5>
    <div class="fakeimg" style="height:200px;">Image</div>
    <p>Some text..</p>
    <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    <br>
    <h2>TITLE HEADING</h2>
    <h5>Title description, Sep 2, 2017</h5>
    <div class="fakeimg" style="height:200px;">Image</div>
    <p>Some text..</p>
    <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
  </div>
</div>
 -->

<!-- <div class = "row" id = "gallary">
<h2>Gallary</h2>
<div class="gallery">
  <a target="_blank" href="img_5terre.jpg">
    <img src="img_5terre.jpg" alt="Cinque Terre" width="600" height="400">
  </a>
  <div class="desc">Add a description of the image here</div>
</div>
</div>
<div class="row">
<div class="gallery">
  <a target="_blank" href="img_forest.jpg">
    <img src="img_forest.jpg" alt="Forest" width="600" height="400">
  </a>
  <div class="desc">Add a description of the image here</div>
</div>

<div class="gallery">
  <a target="_blank" href="img_lights.jpg">
    <img src="img_lights.jpg" alt="Northern Lights" width="600" height="400">
  </a>
  <div class="desc">Add a description of the image here</div>
</div>

<div class="gallery">
  <a target="_blank" href="img_mountains.jpg">
    <img src="img_mountains.jpg" alt="Mountains" width="600" height="400">
  </a>
  <div class="desc">Add a description of the image here</div>
</div>
</div> -->



		    <!--  <div class="row" id = "contactUs" style = "margine-left: 0%;">
              <h2>Contact US</h2>
		        <div class="main">
		          <input id="fname" name="fname" placeholder="*First Name" type="text" required="" aria-required="true">
		        </div>
		        <div class="main">
		          <input class="form-control" id="lname" name="lname" placeholder="*Last Name" type="text" required="" aria-required="true">
		        </div>
		        <div class="main">
		          <input class="form-control" id="email" name="email" placeholder="*Enter Your Email Address" type="email" required="" aria-required="true">
		        </div>
		        <div class="main">
		          <input class="form-control" id="contact" name="contact" placeholder="*Enter Your Mobile Number" type="text" minlength="10" maxlength="10" onkeypress="return restrictAlphabets(event)" required="" aria-required="true">
		        </div>
			 <div class="main">
		          <input class="form-control" id="orgName" name="orgName" placeholder="*Organization Name" type="text" required="" aria-required="true">
		        </div>
		        <div class="main">
		          <input class="form-control" id="designation" name="designation" placeholder="*Designation" type="text" required="" aria-required="true">
		        </div>

		        <div class="main">
		          <input class="form-control" id="subject" name="subject" placeholder="*Subject" type="text" required="" aria-required="true">
		        </div>
			<div class="main">
		           <textarea class="form-control" id="msg" name="msg" placeholder="*Message" rows="4" required="" aria-required="true"></textarea>
		        </div>
			
		  
			<div class="col-sm-7 form-group sendBtn" style="padding-right: 0px;">
			        <button class="btn btn-default " type="submit" name="submit" id ="submit" style="background: #08588b;color: #fff;">Send</button>
    			</div>

			</div> -->
			<div class="col-sm-6 form-group">
		          <div id="error-note"></div>
		      <div class="alert msg" style="margin-bottom: 0px;"></div>
		        </div>



<!-- <div class="footer">
  <h2>Footer</h2>
</div> -->
</body>
<script type="text/javascript">
var slideIndex = 0;
const myQuestions = [
	  {
	    question: "Who invented JavaScript?",
	    answers: {
	      a: "Douglas Crockford",
	      b: "Sheryl Sandberg",
	      c: "Brendan Eich"
	    },
	    correctAnswer: "c"
	  },
	  {
	    question: "Which one of these is a JavaScript package manager?",
	    answers: {
	      a: "Node.js",
	      b: "TypeScript",
	      c: "npm"
	    },
	    correctAnswer: "c"
	  },
	  {
	    question: "Which tool can you use to ensure code quality?",
	    answers: {
	      a: "Angular",
	      b: "jQuery",
	      c: "RequireJS",
	      d: "ESLint"
	    },
	    correctAnswer: "d"
	  }
	];
	  $(document).ready(function(){
		  
		  const quizContainer = document.getElementById('quiz');
		  const resultsContainer = document.getElementById('results');
		  const submitButton = document.getElementById('submit');
		  
		  
		// display quiz right away
		  buildQuiz();
		
		
		  myQuestions.forEach( (currentQuestion, questionNumber) => {
			// we'll want to store the list of answer choices
			  const answers = [];

			  // and for each available answer...
			  for(letter in currentQuestion.answers){

			    // ...add an html radio button
			    answers.push(
			      `<label>
			        <input type="radio" name="question${questionNumber}" value="${letter}">
			        ${letter} :
			        ${currentQuestion.answers[letter]}
			      </label>`
			    );
			  }

			  // add this question and its answers to the output
			  output.push(
			    `<div class="question"> ${currentQuestion.question} </div>
			    <div class="answers"> ${answers.join('')} </div>`
			  );
			  // the code we want to run for each question goes here
			});
		
		  
		  showSlides();
		  $("#questionId").val("Who is credited with designing the abacus that is still used today?");
		  document.getElementById("optionOneId").innerText = "Americans";
		  document.getElementById("optionTwoId").innerText = "Chinese";
		  document.getElementById("optionThreeId").innerText = "Mexicans";
		  document.getElementById("optionFourId").innerText = "Russian";
		  
		 
		  $("#invoice").click(function(){
			  var ajaxXmlData1 = "";
			  var sha ="";
			  $.ajax({
		  			type: "POST",
		  			url : "txnPrintForm.action",
		  			dataType : "html",
		  			data : "ajaxXmlData="+ajaxXmlData1+"&sha="+sha,
		  			cache : false,
		  			success : function(data){
		  			 
		  			if(key == "MSG")
		  			{
		  				
		  			}
		  			else if(key == "ERROR")
		  			{
		  				
		  			}
		  			},
		  			error: function(data){
		  				$("#table-loading-filter").hide();
		  			}
		  		});	
		  });
		 
		  
  	});
	  
	  function showSlides() {
		  var i;
		  var slides = document.getElementsByClassName("mySlides");
		  var dots = document.getElementsByClassName("dot");
		  for (i = 0; i < slides.length; i++) {
		    slides[i].style.display = "none";  
		  }
		  slideIndex++;
		  if (slideIndex > slides.length) {slideIndex = 1}    
		  for (i = 0; i < dots.length; i++) {
		    dots[i].className = dots[i].className.replace(" active", "");
		  }
		  slides[slideIndex-1].style.display = "block";  
		  dots[slideIndex-1].className += " active";
		  setTimeout(showSlides, 2000); // Change image every 2 seconds
		}
	  
	  function getNextQuestion() {
//{"00001":{"Ram":"Karuna"}, "00002":{"Ram2":"Karuna2"}}
debugger;
	var obj = { name: "John", age: 30, city: "New York" };
	var myJSON = JSON.stringify(obj);
	var myJSON1 = JSON.parse(myJSON);
	alert(myJSON1.name);
	  }
	  
	  
	  
	  function buildQuiz(){
		  // variable to store the HTML output
		  const output = [];

		  // for each question...
		  myQuestions.forEach(
		    (currentQuestion, questionNumber) => {

		      // variable to store the list of possible answers
		      const answers = [];

		      // and for each available answer...
		      for(letter in currentQuestion.answers){

		        // ...add an HTML radio button
		        answers.push(
		          `<label>
		            <input type="radio" name="question${questionNumber}" value="${letter}">
		            ${letter} :
		            ${currentQuestion.answers[letter]}
		          </label>`
		        );
		      }

		      // add this question and its answers to the output
		      output.push(
		        `<div class="question"> ${currentQuestion.question} </div>
		        <div class="answers"> ${answers.join('')} </div>`
		      );
		    }
		  );

		  // finally combine our output list into one string of HTML and put it on the page
		  quizContainer.innerHTML = output.join('');
		}

	  function showResults(){

		  // gather answer containers from our quiz
		  const answerContainers = quizContainer.querySelectorAll('.answers');

		  // keep track of user's answers
		  let numCorrect = 0;

		  // for each question...
		  myQuestions.forEach( (currentQuestion, questionNumber) => {

		    // find selected answer
		    const answerContainer = answerContainers[questionNumber];
		    const selector = `input[name=question${questionNumber}]:checked`;
		    const userAnswer = (answerContainer.querySelector(selector) || {}).value;

		    // if answer is correct
		    if(userAnswer === currentQuestion.correctAnswer){
		      // add to the number of correct answers
		      numCorrect++;

		      // color the answers green
		      answerContainers[questionNumber].style.color = 'lightgreen';
		    }
		    // if answer is wrong or blank
		    else{
		      // color the answers red
		      answerContainers[questionNumber].style.color = 'red';
		    }
		  });

		  // show number of correct answers out of total
		  resultsContainer.innerHTML = `${numCorrect} out of ${myQuestions.length}`;
		}
	  
	  
  </script>
</html>