# Sel-JavaCucumberProj01
This is an End to End framework that covers UI and API Automation using Java / Selenium /Rest Assured and Cucumber BDD.

System Requirements - prerequisites
--Java 8
--Maven

Example:CoinMarket UI Tests 

Background:Launching CoinMarketCap url
Given Launch CoinMarketCap Application

Scenario: 1- Navigate to CoinMarketCap application url and validate the rows count visible on UI application
When user selects a value from show rows dropdown
Then row count on the UI should match with selection value



prerequisites
1.Project Clone.
2.Please verify project sync and dependencies downloaded.

Follow below steps to  execute the tests:

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