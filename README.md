# holiday

BEFORE STARTING APPLICATION:

`git clone`  

Inside `holiday/main/resources/application.yml` you need to provide your own API key. You can also change port for application to start.

HOW TO START APPLICATION:
 
run `./mvnw clean install` inside project directory  
navigate to `/target` that just appeared  
run `java -jar holiday-0.0.1-SNAPSHOT.jar`  

Now you can make get request for: localhost:<port>/holiday/<countryCode>/<countryCode2>/<date format="yyyy-MM-dd">

Example: `localhost:8110/holiday/US/PT/2010-10-10`
