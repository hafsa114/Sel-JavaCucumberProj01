package StepDefinitions;

import com.base.ControllerSelTest;
import com.base.ReadConfig;
import com.pages.CoinMarketCapMainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.base.CommonUtilityClass.navigateToBaseUrl;
import static com.base.LocatorsUtilTst.listMarketCapVal;
import static com.base.LocatorsUtilTst.listpriceVal;

public class UIFeatureStepDefs extends ControllerSelTest {
    private  static ReadConfig prop=new ReadConfig();
    WebDriver driver=ControllerSelTest.getDriver(prop.getBrowser());



    public void setDriver() {

    }

    @Given("Launch CoinMarketCap Application")
    public void launch_coin_market_cap_application() {
        navigateToBaseUrl(driver);

    }
    @When("user selects a value from show rows dropdown")
    public void userSelectsAValueFromShowRowsDropdown() {
           CoinMarketCapMainPage.selRowCount(prop.geRowCount(), driver);
    }

    @Then("row count on the UI should match with selection value")
    public void rowCountOnTheUIShouldMatchWithSelectionValue() {
        CoinMarketCapMainPage.validateNoOfRowsShow(prop.geRowCount(),driver);
    }

    @When("user clicks on filter button")
    public void userClicksOnFilterButton() { CoinMarketCapMainPage.clickFilterButton(driver); }
    @And("set MarketCapFilter with {string} range from {string} to {string}")
    public void setMarketCapFilterWithRangeFromTo(String arg0, String arg1, String arg2) {
        CoinMarketCapMainPage.setFilterMarketCapField(arg0,arg1,arg2,driver);
        CoinMarketCapMainPage.applyFilter(driver);
    }

    @And("Price Filter with {string} range from {string} to {string}")
    public void priceFilterWithRangeFromTo(String arg0, String arg1, String arg2) {
        CoinMarketCapMainPage.setFilterPriceField(arg0,arg1,arg2,driver);
        CoinMarketCapMainPage.applyFilter(driver);
    }

    @Then("displayed filtered records must be verified as per the set range value using {string},{string},{string},{string}")
    public void displayedFilteredRecordsMustBeVerifiedAsPerTheSetRangeValueUsing(String arg0, String arg1, String arg2, String arg3) {
         CoinMarketCapMainPage.showResultsClick(prop.getMarketRangeVal(),prop.getPriceRangeVal(),driver);
         CoinMarketCapMainPage.verifyFilteredData(listpriceVal,arg2,arg3,driver);
         CoinMarketCapMainPage.verifyFilteredData(listMarketCapVal,arg0,arg1,driver);
        driver.quit();
    }





}
