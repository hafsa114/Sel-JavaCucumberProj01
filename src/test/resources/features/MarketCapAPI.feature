Feature: CoinMarketCap API OR BACKEND Tasks

  Scenario Outline: 1 - retrieve ids and validate currency conversion
    Given user requests ids using get request call provided
    When ids are retrieved for given currency types "<currencyType1>","<currencyType2>","<currencyType3>"
    Then the ids must be successfully converted to "<conversion>" type
    Examples:
      | currencyType1 | currencyType2 | currencyType3 |conversion|
      | Bitcoin       | Tether        |Ethereum      |BOLI|


  Scenario Outline: 2 - Retrive and validate cryptocurrency info details for single id
    Given user issues the cryptocurrency info call for "<givenID>"
    Then user must verify technical documentation website and confirms "<logo_URL>","<technical_doc_URL>","<SymbolOfCurrency>","<date added>","<tag>" are present as expected
    Examples:
      | givenID | logo_URL                                                     | technical_doc_URL                                 | SymbolOfCurrency | date added               | tag      |
      | 1027    | https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png | https://github.com/ethereum/wiki/wiki/White-Paper | ETH              | 2015-08-07T00:00:00.000Z | mineable |
#Note the technical_doc_url given in document is https://github.com/thereum/wiki/wiki/White-Paper which i considered as spelling mistake and passed corerct url here****
   Scenario: 3 - Retrive and validate cryptocurrency info details of first 10 currencies
     Given user issues the cryptocurrency info call for first 10 currencies
     Then user must fetch and verify currencies with mineable tag and their cryptocurrencies
