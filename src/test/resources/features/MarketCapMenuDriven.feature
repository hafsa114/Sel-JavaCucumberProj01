@CoinMarketAppTests
Feature: CoinMarket UI Tests
  Background:Launching CoinMarketCap url
    Given Launch CoinMarketCap Application

   Scenario: 1- Navigate to CoinMarketCap application url and validate the rows count visible on UI application
      When user selects a value from show rows dropdown
      Then row count on the UI should match with selection value

    Scenario Outline:Navigate to CoinMarketCap application url and certify the records based on applied filters
      When user clicks on filter button
      And set MarketCapFilter with "<MarketCapfilter>" range from "<MarketCapMinVal>" to "<MarketCapMaxVal>"
      And Price Filter with "<Pricefilter>" range from "<PriceMinVal>" to "<PriceMaxVal>"
      Then displayed filtered records must be verified as per the set range value using "<MarketCapMinVal>","<MarketCapMaxVal>","<PriceMinVal>","<PriceMaxVal>"
     Examples:
      | MarketCapfilter | MarketCapMinVal | MarketCapMaxVal | Pricefilter | PriceMinVal | PriceMaxVal |
      | Market Cap      | 1000000000      | 10000000000     | Price       | 101         |  1000       |






