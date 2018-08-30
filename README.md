# HitCounter
This is web application and the HitCounter.jsp page is for collecting and displaying the number of requests to 
an HTML page in this web application. Currently there are two static html pages (myHtml/1.html and myHtml/2.html) 
in this web application. Here we use the Servlet Filter to intercept the all of http requests and do this statistics 
function.

## Building and Integration Testing
mvn clean verify

It will execute the integration tests: starting tomcat7 server and deploy the webapp into it and using Selenium 
WebDriver (chrome) to launch chrome browser to access the web app. In the end, it will verify the hit counter page 
number for each html page correct or not.


