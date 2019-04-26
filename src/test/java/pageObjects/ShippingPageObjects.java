package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPageObjects extends PageObjects {

	@FindBy(id="uniform-cgv")
	private WebElement termsOfServiceCheckbox;

	@FindBy(xpath="//*[@id=\"form\"]/p/button")
	private WebElement getCheckoutButton;

	public WebElement getGetCheckoutButton() {
		return getCheckoutButton;
	}

	public WebElement getTermsOfServiceCheckbox() {
		return termsOfServiceCheckbox;
	}

	public ShippingPageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
}
