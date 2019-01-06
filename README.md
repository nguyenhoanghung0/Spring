# Spring
Spring projects

To get the code:
Clone the repository:

$ git clone git://github.com/nguyenhoanghung0/Spring.git

To run the application:
From the command line with Maven:

$ cd vehicletracking
$ mvn tomcat:run

Access to configuration page of the application via http://localhost:8080/vehicleTracking
   - Click on "Start" to start Writer/Reader services
   
Webservices:
   - To get trips: http://localhost:8080/vehicleTracking/tripinformation
   - To get exception records: http://localhost:8080/vehicleTracking/triperrors
