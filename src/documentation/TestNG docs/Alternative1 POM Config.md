# Alternative POM config

#### Description
This is an alternative configuration for the POM file. This configuration is used to run the TestNG suite with AspectJ in the Maven project.

#### Might Run Slower
Running tests using mvn test -Dtest=FirstTest can be slower compared to running the test directly from the test class in your IDE due to several reasons:  
1. Build Lifecycle: Maven goes through its entire build lifecycle, including phases like validate, compile, and test, which can add overhead.
2. Dependency Resolution: Maven checks and resolves dependencies, which can take additional time.
3. Plugin Configuration: Maven executes the maven-surefire-plugin with its configuration, which might include additional setup or teardown steps.
4. Environment Setup: Maven might be setting up a different environment compared to your IDE, which can affect performance.

````
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>src/test/resources/testng_suite.xml</suiteXmlFile>
                    </suiteXmlFiles>
                    <argLine>
                        -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                    </argLine>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>${maven.compiler.version}</version>
                <configuration>
                    <encoding>UTF-8</encoding>
                    <source>${maven.compiler.source}</source>
                    <target>${maven.compiler.target}</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
```