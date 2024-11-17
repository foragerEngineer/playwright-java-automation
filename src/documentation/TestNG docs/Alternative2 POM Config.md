# Alternative 2: POM Configuration

```
<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
                <configuration>
                    <forkCount>1</forkCount> <!-- Adjust the number of forks if needed -->
                    <reuseForks>true</reuseForks> <!-- Reuse forks to improve performance -->
                    <suiteXmlFiles>
                        <suiteXmlFile>src/test/resources/testng_suite.xml</suiteXmlFile>
                    </suiteXmlFiles>
                    <argLine>
                        -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                    </argLine>
                    <testFailureIgnore>true</testFailureIgnore>
                </configuration>
            </plugin>
        </plugins>
    </build>
```