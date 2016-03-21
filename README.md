# TestNowJavaSample
This is Selenium with Java automation code for Magento application using Data driven framework

Overview 

The framework is developed in Java using Data Driven model. 

Selenium-WebDriver with testNG framework is used for driving the browsers. This automation suite is compatible with following browsers

Google Chrome
Mozilla Firefox
Internet Explorer
Opera

There are 3 Test Suites that runs scenarios related to following:

Login Suite: Login and Signup related features
Dashboard Suite: Newsletter subscriptions
Checkout Suite: Buying of a product with different checkout methods

Purpose

Major purpose of this example automation is to understand how one can make maximum usage of TestNow cross browser testing with minimum effort by following some best practices mentioned here. Few Best Practices are as follows:

How to initialize different browsers
How to write appropriate setup and teardown's
How to take failed scenario screenshots
How to create html reports which helps TestNow to create consolidated reports for you.
How to organize code in case of Java TestNG setup

Application Under Test (AUT) 

Magento is an ecommerce platform built on open source technology which provides online merchants with a flexible shopping cart system, as well as control over the look, content and functionality of their online store. Magento offers powerful marketing, search engine optimization, and catalog-management tools.

Folder Structure of the Project

1. All the resources files like test cases and test data for each suite are kept in excel files under src/test/resources
2. Object Repositories are maintained in OR.property file which is also kept under src/test/resources
3. src/test/java contains the following packages
  1. com.testnowjavasample.base - This contains the basic functionalities like initialization of XL files and OR.property files
  2. com.testnowjavasample.util - This contains 3 files for 3 different utility functions.
    1. XL_Reader - This file handles all Excel related functions like getting data from excel and writing to it.
    2. Driver_Config - This file contains functions for different types of webdrivers for handling different browsers
    3. TestUtil - This file has separate functions related to the test functionalities like taking screenshot and random string generator
  3. com.testnowjavasample.Login - This contains all testcases related to Login Suite
  4. com.testnowjavasample.Dashboard - This contains all testcases related to Dashboard Suite
  5. com.testnowjavasample.Checkout - This contains all testcases related to Checkout Suite

Requirements 

Programming Language
Java

Dependencies
All mentioned in pom.xml file, no additional dependency installation required

Browsers
Google Chrome
Mozilla Firefox
Internet Explorer
Opera

WebDrivers
chromedriver -- put in any folder inlcuded in PATH variable (777 to avoid permission issues)
operadriver -- mandatorily put in /usr/local/bin/operadriver (777 to avoid permission issues)
iedriver -- put in any folder inlcuded in PATH variable (777 to avoid permission issues)

Reporting

Magento automation reports are created in the following format

HTML : index.html

Reports are created inside the target/surefire-reports directory with above mentioned filename.

Author

Name: Suganya Radha 
Organization: Opex Software 
Email: Suganya.yamasani@opexsoftware.com 


