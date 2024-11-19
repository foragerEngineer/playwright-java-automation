# TestNG Configuration In IntelliJ

Reference: [Run a test suite](https://www.jetbrains.com/help/idea/testng.html#run-test-suite)

# Step 1: Adding Dependencies
Add the following dependencies to your `pom.xml` file:

### TestNG:
```
<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>7.3.0</version> <!-- or the latest version -->
</dependency>
```

### AspectJ:
```
<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjweaver</artifactId>
  <version>1.9.6</version> <!-- or the latest version -->
</dependency>  
```
### Documentation
 - #### Purpose of TestNG:
   - This is needed for the purpose of running the test cases in the TestNG framework.
   - TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use.
   - It is designed to cover all categories of tests: unit, functional, end-to-end, integration, etc.
   - It supports parallel execution of test methods.
   - It provides support for parameterized tests.
   - It allows to define flexible test suite.
   
 - #### Purpose of AspectJ:
   - AspectJ is a seamless aspect-oriented extension to the Java programming language. It is Java platform compatible easy to learn and use. It is now widely used in the industry.
   - AspectJ enables the modularization of crosscutting concerns such as: logging, profiling, synchronization, performance optimization, debugging support, multi-object protocols, resource sharing, distribution, security, etc.
   - It provides support for aspect-oriented programming in Java.

# Step 2: Configuring SureFire in the POM file
Once dependencies are added, you need to configure the TestNG plugin in the `pom.xml` file. Add the following plugin to the `build` section of the `pom.xml` file:
1. Add the following plugin to the `build` section of the `pom.xml` file:
```
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-surefire-plugin</artifactId>
  <version>3.0.0-M5</version> <!-- or the latest version -->
  <configuration>
    <suiteXmlFiles>
      <suiteXmlFile>testng.xml</suiteXmlFile>
    </suiteXmlFiles>
  </configuration>
</plugin>
```
2. Create a `testng.xml` file in the root directory of your project and add the following content:
```
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Suite1">
  <test name="Test1">
    <classes>
      <class name="com.example.TestClass1"/>
    </classes>
  </test>
</suite>
```
3. Replace `com.example.TestClass1` with the name of your test class.
4. Right-click on the `testng.xml` file and select `Run 'testng.xml'`.
5. The test suite will run and you will see the results in the `Run` tab.
6. You can also run the test suite from the command line using the following maven command:
```
mvn test
```
7. The test suite will run and you will see the results in the console.
8. Alternatively, you can run the test suite from the command line using the following maven surefire command:
```
mvn test -Dsurefire:testClass
```
