/*Add Google Maps Function to Set The Map Properties */
function initMap() {
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




