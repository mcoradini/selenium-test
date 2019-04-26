package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPageObject extends PageObjects {

	@FindBy(id="id_address_delivery")
	private WebElement savedDeliveryAddress;

	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button")
	private WebElement checkoutButton;

	@FindBy(id="address_delivery")
	private List<WebElement> deliveryAddress;

	@FindBy(id="address_invoice")
	private List<WebElement> billingAddress;

	public WebElement getSavedDeliveryAddress() {
		return savedDeliveryAddress;
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}

	public List<WebElement> getDeliveryAddress() {
		return deliveryAddress;
	}

	public List<WebElement> getBillingAddress() {
		return billingAddress;
	}

	public boolean checkAddressInfo(String addressInfo)
	{
	    List<WebElement> row = driver.findElements(By.id("address_delivery"));
	    for (WebElement info : row)
	    {
	        if (info.getText().trim().contains(addressInfo))
	            return true;
	    }

	    return false;
	}

	public boolean checkBillingInfo(String addressInfo)
	{
	    List<WebElement> row = driver.findElements(By.id("address_invoice"));
	    for (WebElement info : row)
	    {
	        if (info.getText().trim().contains(addressInfo))
	            return true;
	    }

	    return false;
	}

	public AddressPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
