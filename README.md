# Spring
Spring projects

To get the code:
-------------------
Clone the repository:

      $ git clone git://github.com/nguyenhoanghung0/Spring.git

To build the application:
-------------------	
      $ cd vehicletracking
      $ mvn clean install

To run the application:
-------------------	

Navigate to vehicletracking\target
Run the war file "vehicletracking-1.war" to run it on tomcat


Access to configuration page of the application via http://localhost:8080/vehicleTracking-1/
   - Click on "Start" to start Writer/Reader services
   
Webservices:
   - To get trips: http://localhost:8080/vehicleTracking-1/tripinformation
   - To get exception records: http://localhost:8080/vehicleTracking-1/triperrors
