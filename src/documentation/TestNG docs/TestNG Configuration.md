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

# Step 2: Configuring TestNG in the POM file
Once dependencies are added, you need to configure the TestNG plugin in the `pom.xml` file. Add the following plugin to the `build` section of the `pom.xml` file:

```


