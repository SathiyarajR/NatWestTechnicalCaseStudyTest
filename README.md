NatWestTechnicalCaseStudyTest

Exercise 1:  SWAPI - The Star Wars API Test Wrap - Data Driven Test Framework

1. Test Environment  - Mention the environment details here

2. CICD - Build & Test Automation Using Jenkins

        Steps to run the Build using Jenkins e.g. or can be

        Navigate to Jenkins Path and run Below command e.g. C:\Program Files\Jenkins>java -jar jenkins.war --enable-future-java

        Check the Job in http://localhost:8080/job/TestNatWestCaseStudy/  - 

             E.g. Build Commands cd C:\Users\HP\Desktop\Sathya Natwest Projects\NatWestCaseStudy
            run.bat

      Or Integrate with GitHub to fetch the code or use post-build action with reference to testng.xml
      
        Configure/Run and validate test results in console

    Previous Jenkins Build Report:
    http://localhost:8080/job/TestNatWestCaseStudy/7/console

3. Reporting DashBoard   - Allure & TestNG Emailable Report configurations are enabled and Test reports will be automatically generated as part of the build and can be shared by below steps 

    Steps to generate Allure Reports in Local
    
    - > Download and extract allure-commandline-2.18.1.zip file

    -> Check the installation Execute allure --version in console to make sure that allure is available:

	-> $ allure --version 2.0.1

	-> Configuration Include the allure dependecy and config in pom.xml with  allure version like here:

		io.qameta.allure allure-maven 2.10.0 2.14.0

		Test execution: Execute the tests and validate allure-reports folder under project directory
		
		-> Report generation Command from command prompt: e.g. allure serve /home/path/to/project/target/surefire-reports/

4. Deployment - Can be integrated with Teamcity Or Octopus Pipeline to Build and Deploy in respective Environments.


Exercise 2: Program written to determine the number of files that start with T or end in S starting from root. Assume small.dat is provided with all different files. 

        Note: Class Name is Exercise2 & test .dat file is located under resources named as TestFile.dat 
