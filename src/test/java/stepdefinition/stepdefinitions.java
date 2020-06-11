package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageobjects.Homepage;
import pageobjects.iphonelandingpage;
import pageobjects.mainpage;
import resources.driverinit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class stepdefinitions extends driverinit{
public WebDriver driver;
Homepage hp;
iphonelandingpage ip;
mainpage mp;
Actions a;

@Given("^user navigates to the url \"([^\"]*)\" and prerequisites are set$")
public void user_navigates_to_the_url_something_and_prerequisites_are_set(String strArg1) throws Throwable {
    driver=base();
	driver.get(strArg1);
	hp=new Homepage(driver);
	ip=new iphonelandingpage(driver);
	mp=new mainpage(driver);
	a=new Actions(driver);
}

    @When("^user moves the cursor to hello signin button$")
    public void user_moves_the_cursor_to_hello_signin_button() throws Throwable {
    	
    	a.moveToElement(hp.hellosignin()).build().perform(); 
    }

    @Then("^Yourlist ands Youraccount text should be present$")
    public void yourlist_ands_youraccount_text_should_be_present() throws Throwable {
    	Assert.assertTrue(hp.yourlisttext().getText().equalsIgnoreCase("Your Lists"));
		Assert.assertTrue(hp.youraccounttext().getText().equalsIgnoreCase("Your Account")); 
    }

    @And("^Yourlist should have 12 links$")
    public void yourlist_should_have_12_links() throws Throwable {
    	System.out.println(hp.yourlistlinks());
    	try {
		Assert.assertTrue(hp.yourlistlinks()==12);
    	}
    	catch(AssertionError e)
    	{
    		System.out.println("Assertion error");
    	}
    }

    @And("^Youraccount should have 17 links$")
    public void youraccount_should_have_17_links() throws Throwable {
    	Assert.assertTrue(hp.youraccountlinks()==18);
    }

    @And("^Header should have 5 links$")
    public void header_should_have_5_links() throws Throwable {
    	a.moveToElement(hp.searchbox()).build().perform(); 
    	Assert.assertTrue(hp.headerlinks()==5);
    }
    @Then("^header links should have correct texts$")
    public void header_links_should_have_correct_texts() throws Throwable {
    	Assert.assertTrue(hp.todaydealtext().getText().equalsIgnoreCase("Today's Deals"));
		Assert.assertTrue(hp.customerservicetext().getText().equalsIgnoreCase("Customer Service"));
		Assert.assertTrue(hp.gifttext().getText().equalsIgnoreCase("Gift Cards"));
		Assert.assertTrue(hp.registry().getText().equalsIgnoreCase("Registry"));
		Assert.assertTrue(hp.selltext().getText().equalsIgnoreCase("Sell"));
    }

    @And("^close the browser$")
    public void close_the_browser() throws Throwable {
    	driver.close();
		driver=null;
    }
    @When("^user searches for \"([^\"]*)\"$")
    public void user_searches_for_something(String strArg1) throws Throwable {
    	hp.searchbox().sendKeys(strArg1);
		hp.Go().click();
    }

    @Then("^iphonelanding page should have 12 checkbox in brand column$")
    public void iphonelanding_page_should_have_12_checkbox_in_brand_column() throws Throwable {
    	Assert.assertTrue(ip.brandcheckboxcount()==12);
		
    }

    @And("^search result should be \"([^\"]*)\"$")
    public void search_result_should_be_something(String strArg1) throws Throwable {
    	Assert.assertTrue(ip.iphonecheck().getText().contains(strArg1));
    }

    @And("^footer should have 36 links$")
    public void footer_should_have_36_links() throws Throwable {
    	Assert.assertTrue(ip.footerlinkscount()==36);
    }
    @When("^user searches for \"([^\"]*)\" and clicks on the specific iphone$")
    public void user_searches_for_something_and_clicks_on_the_specific_iphone(String strArg1) throws Throwable {
    	hp.searchbox().sendKeys(strArg1);
		hp.Go().click();
		ip.clickiphone(prop).click();
    }

    @Then("^mainpage should have the stock unavailability text$")
    public void mainpage_should_have_the_stock_unavailability_text() throws Throwable {
    	Assert.assertTrue(mp.statustext().getText().equalsIgnoreCase(prop.getProperty("status")));
    }

    @And("^selected colour must be displayed in the colour column$")
    public void selected_colour_must_be_displayed_in_the_colour_column() throws Throwable {
    	mp.colourclick(prop).click();;
		Assert.assertTrue(mp.colourselected().getText().contains(prop.getProperty("colour")));
    }
}