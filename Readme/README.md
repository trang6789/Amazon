About Amazon Automation Test 

Work Flow
The work flow for Amazon Automation Test being followed is:
1.	Login fail Amazon Page
2.	Login Pass Amazon Page
3.	Search and check options on Page
4.	Check result display on Page
5.	Change Sort option on Page

Tools, Approaches and Technologies Used
•	Core Java
•	Maven
•	Selenium WebDriver ver3
•	Junit
•	POM
•	TestNG

How to run test case:
•	mvn -Dtest=TestLogInFailPassword test
•	mvn -Dtest=TestLogInSuccess test
•	mvn -Dtest=TestPaginateList test
•	mvn -Dtest=TestSortOptions test
•	mvn -Dtest=SortByDate test
