# Allure Report Setup For Playwright Java Framework

##### Resources
- [Allure Report - Install for macOS](https://allurereport.org/docs/install-for-macos/)

# Install Allure Report for macOS
Allure Report can be installed on Linux from the Homebrew package repository or manually from an archive.

### Install from Homebrew
1. Make sure Homebrew is installed.
2. In a terminal, run this command:
```
brew install allure
```
3. Run this command to see if it reports the latest version:
```
allure --version
```
# Getting started with Allure Playwright

### Add an allure.properties file
1. Create a new file named `allure.properties` in inside of test/resources.
2. Add the following content to the file:
```
allure.results.directory=target/allure-results
```

# Starting the Allure server