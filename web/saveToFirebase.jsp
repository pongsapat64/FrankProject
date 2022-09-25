<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.CarInfo" %>

<%CarInfo info = (CarInfo) session.getAttribute("info");%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- The core Firebase JS SDK is always required and must be listed first -->
        <script src="https://www.gstatic.com/firebasejs/8.10.0/firebase-app.js"></script>
        <script src="https://www.gstatic.com/firebasejs/8.6.3/firebase-database.js"></script>
        

        <!-- TODO: Add SDKs for Firebase products that you want to use
             https://firebase.google.com/docs/web/setup#available-libraries -->

        <script>
            // Your web app's Firebase configuration
            const firebaseConfig = {
                apiKey: "AIzaSyCU_i9zC2VEIj52sspqKlSsOcwK5iaIwCk",
                authDomain: "carproject-9f747.firebaseapp.com",
                databaseURL: "https://carproject-9f747-default-rtdb.firebaseio.com",
                projectId: "carproject-9f747",
                storageBucket: "carproject-9f747.appspot.com",
                messagingSenderId: "173239491155",
                appId: "1:173239491155:web:2cb7342a1dde0d301a84a6"
            };


            // Initialize Firebase
            firebase.initializeApp(firebaseConfig);
        </script>        
    </head>
    <body>
        <h2>Test Firebase 'Car' connection</h2>

        <p>
            <input type="button" value="Save" onclick="save_car();" />
        </p>

        <script>
            var databaseRef = firebase.database().ref('car/');

            window.save_car = function() {
                var uid = firebase.database().ref().child('car').push().key;

                var data = {
                    car_id: uid,
                    brand: '<%= info.getBrand()%>',
                    model: '<%= info.getModel()%>',
                    horse_power: '<%= info.getHorse_power()%>',
                    price: '<%= info.getPrice()%>',
                }

                var updates = {};
                updates['/car/' + uid] = data;
                firebase.database().ref().update(updates);

                alert('Car is created successfully!');
                reload_page();
            }

            function reload_page() {
                window.location.reload();
            }
        </script>
    </body>
</html>
