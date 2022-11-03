# Sel-JavaCucumberProj01
This is an End to End framework that covers WEB and API Automation using Java / Selenium /Rest Assured and Cucumber BDD.

System Requirements - prerequisites
--Java 8
--Maven

Sample Feature File Cucumber :

Feature: CoinMarketCap UI Tasks

Background: user navigates to given application
Given user navigates to CoinMarketCap URL

Scenario: 1 - Open CoinMarketCap application and verify number of rows displayed
When user selects Show rows dropdown and selects Value
Then selected number of rows must be displayed



Note: First time when cloned wait for dependecies to downlaod and project to sync.

Steps to execute the tests:

There two ways to execute the tests from this framework:
1. Run as junit by right clicking on src/test/java/testrunner/TestRunner.java and click Run
![img_3.png](img_3.png)

2. Run as maven task using mvn clean verify
![img_4.png](img_4.png)

Report - Cucumber_SelJava_MS\target\cucumber-report-html\cucumber-html-reports
![img_2.png](img_2.png)


Note: 1 Failure in above report is expected failure as ETH is not associated with tag:mineable in actual.

As per requirement :Confirm that the currency has the mineable tag associated with it:

"tags": [ "mineable" ]

Actual : mineable tag is not associated.Hence test fail.


Below is the API response :


"tags": [
"pos",
"smart-contracts",
"ethereum-ecosystem",
"coinbase-ventures-portfolio",
"three-arrows-capital-portfolio",
"polychain-capital-portfolio",
"binance-labs-portfolio",
"blockchain-capital-portfolio",
"boostvc-portfolio",
"cms-holdings-portfolio",
"dcg-portfolio",
"dragonfly-capital-portfolio",
"electric-capital-portfolio",
"fabric-ventures-portfolio",
"framework-ventures-portfolio",
"hashkey-capital-portfolio",
"kenetic-capital-portfolio",
"huobi-capital-portfolio",
"alameda-research-portfolio",
"a16z-portfolio",
"1confirmation-portfolio",
"winklevoss-capital-portfolio",
"usv-portfolio",
"placeholder-ventures-portfolio",
"pantera-capital-portfolio",
"multicoin-capital-portfolio",
"paradigm-portfolio",
"injective-ecosystem"
],


In case if mineable tag is associated with the ETH then test script will auto pass.