# NatWestTechnicalCaseStudyTest

SWAPI  -  The Star Wars API Test Wrap

1. Test Environment

2. Jenkins Build Configuration File

3. Reporting DashBoard

  Integrated with Allure 
  
   Check the installation
    Execute allure --version in console to make sure that allure is  available:

  $ allure --version
  2.0.1

  Configuration
  You can configurate allure version like here:

<plugin>
	<groupId>io.qameta.allure</groupId>
	<artifactId>allure-maven</artifactId>
	<version>2.10.0</version>
	<configuration>
		<reportVersion>2.14.0</reportVersion>
	</configuration>
</plugin>


   Test execution
If you are using IDE to run tests locally it may ignore Allure configuration specified in build file (as IntelliJ IDEA does). In order to make it work consider using allure.properties file to configure Allure. Check out configuration section for more information.

Before building a report you need to run your tests to obtain some basic test report data. Typically it might be a junit-style xml report generated by nearly every popular test framework. For example, suppose you have test reports automatically created by surefire maven plugin stored in the target/surefire-reports:

Report generation Command 
allure serve /home/path/to/project/target/surefire-reports/

4. Deployment - Using Teamcity






