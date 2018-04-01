/*JS dynamically get scrolltop value navigation bar*/
$(document).ready(function () {
    /* affix the navbar after scroll below header */
    $(".navbar").affix({ offset: { top: $("#myCarousel").outerHeight(true) } });
});

//Navigation section and other effects
/*jQuery smooth scrolling to navigation bar +footer+ */
$(document).ready(function () {
    // Initialize Tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Add smooth scrolling to all links in navbar + footer link
    $(".navbar a, footer a[href='#wrapper'], #arrow-icon a[href='#profilepushup']").on('click', function (event) {

        // Make sure this.hash has a value before overriding default behavior
        if (this.hash !== "") {

            // Prevent default anchor click behavior
            event.preventDefault();

            // Store hash
            var hash = this.hash;

            // Using jQuery's animate() method to add smooth page scroll
            // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 900, function () {

                // Add hash (#) to URL when done scrolling (default click behavior)
                window.location.hash = hash;
            });
        } // End if
    });
})

// Home show time
setInterval(function () {

    var currentTime = new Date();
    var hours = currentTime.getHours();
    var minutes = currentTime.getMinutes();
    var seconds = currentTime.getSeconds();
    var day = currentTime.getDate();
    var month = currentTime.getMonth()+1;
    var year = currentTime.getFullYear();
    // Add leading zeros (I use The Ternary Operator technique for If... else statement, src:https://www.sitepoint.com/shorthand-javascript-techniques/ )
    hours = (hours < 10 ? "0" : "") + hours;
    minutes = (minutes < 10 ? "0" : "") + minutes;
    seconds = (seconds < 10 ? "0" : "") + seconds;

    // Compose the string for display
    var currentTimeString = "Current time" + "<br />" + hours + ":" + minutes + ":" + seconds + "<br />" + day + "-" + month + "-"+ year;
    $("#clock").html(currentTimeString);

}, 1000);



// Project section

//function load
function load() {
    document.getElementById("firstprojectcap").innerHTML = "My first website project..."; 
    document.getElementById("secondprojectcap").innerHTML = "Ice Cream store start up project"; 
    document.getElementById("thirdprojectcap").innerHTML = "Independent Lifystyle company start up project!";
    console.log("The caption is loaded");
   
}
//function onScroll()
$(window).scroll(function () {
    $(".slideeffect").each(function () {
        // slide target
        var pos = $(this).offset().top;

        var winTop = $(window).scrollTop();
        if (pos < winTop + 400) {
            $(this).addClass("slideUp");
        }
    });
});
//function mouseover and mouseout 
function mOver(img) {

    img.style.opacity = 1;
    document.getElementById("firstprojectcap").innerHTML = "This is a basic website project I did on the Orientation to Digital Service course in Haaga-Helia!";
    firstprojectcap.style.color = "#ff0000";
    img.style.transform = "rotateY(180deg)";
    img.style.transition = "all 1.0s linear"
}
function mOut(img) {
    img.style.opacity = 0.5;
    document.getElementById("firstprojectcap").innerHTML = "My first website project, It is about my hometown, beautiful places, sports and activities.";
    firstprojectcap.style.color = "#515151";
    img.style.transform = "rotateY(360deg)";

}


// ---Contact section----
//Function validate form and reset form,
function validate_form() {
    //check age
    var age = parseInt(document.getElementById("age").value,10);
    if (age < 18 || age > 100) {
        (alert("Please enter a valid age between 18 and 100"));
        return false;
    }
    document.getElementById("contactrespond").innerHTML = "<p>Thank you for contacting me, I will respond you as soon as possible !</p>";
    return true;
}
function reset() {
    document.getElementById("contactrespond").innerHTML = "<p>seen</p>";
    document.getElementById("form").reset();
}
/*Add Google Maps Function to Set The Map Properties */
function myMap() {
    var myLatLng = { lat: 60.197071, lng: 24.926944 };

    // Create a map object and specify the DOM element for display.
    var map = new google.maps.Map(document.getElementById('googleMap'), {
        center: myLatLng,
        scrollwheel: false,
        zoom: 12,
    });

    // Create a marker and set its position.
    var marker = new google.maps.Marker({
        map: map,
        position: myLatLng,
        title: 'Hello World!'
    });
}







