package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.CartPage;
import com.qa.opencart.pages.CheckoutPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfopage;
import com.qa.opencart.pages.ProductListingPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.pages.WishListPage;

public class BaseTest {
	WebDriver driver;
	protected SoftAssert softAssert;
	protected LoginPage loginPage;
	protected RegisterPage registerPage;
	protected AccountsPage accountsPage;
	protected ResultsPage resultsPage;
	protected ProductInfopage productInfopage;
	protected CartPage cartPage;
	protected WishListPage wishListPage;
	protected ProductListingPage productListingPage;
	protected CheckoutPage checkoutPage;
	protected DriverFactory driverFactory;
	protected Properties prop;

	@Parameters({ "browser" })
	@BeforeTest(groups = "sanityTest")
	public void setup(@Optional String browserName) {
		driverFactory = new DriverFactory();
		prop = driverFactory.initProp();
		if (browserName != null) {
			prop.setProperty("browser", browserName);
			// prop.setProperty("browserversion", browserVersion);
		}
		driver = driverFactory.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();

	}

	@AfterTest(groups = "sanityTest")
	public void tearDown() {
		driver.quit();
	}

}