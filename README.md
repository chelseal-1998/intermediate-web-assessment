# Mid WEB Assessment

#### INTRODUCTION

In this project I am automating a website using a Base Framework, the Framework I implemented is a WEB test automation 
framework built on Java and uses Selenium.

#### PRE-REQUISITES
* Gradle - version
* Java - version
* IDE - preferably Intellij IDEA
* Web browser - preferably the latest stable version of Chrome or Firefox

## FEATURES ##
This framework implements a [Page Factory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory) Design approach.

#### SYSTEM UNDER TEST
CDS Website : http://dockerqa:8801/login

#### FRAMEWORK TEST STRUCTURE
Each section's tests are contained within a package.

#### BaseTest
Contains the set-up method. May include methods that are required for the set of tests.
#### CustomConfig
Contains custom properties from the properties file that will be sent to you directly, you will need the properties file 
to be able to run the tests.
#### Common
Contains all the TestData needed for the tests to run.

### Running tests locally (Command Line or IDE:) ###
Execute the following commands in your IDE terminal:
* In Windows terminal : ./gradlew test
* In Mac terminal : gradlew test

#### REPORTING
A test report is generated after each run in the /build/reports/tests/index.html folder in the base repository of the repo.

To view this report:
* Step 1: Right-click on the index.html file
* Step 2: Go to 'open in' > browser > Chrome
* Step 3: Select Chrome or preferred browser, and you should be able to view the report