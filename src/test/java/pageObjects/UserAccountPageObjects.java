package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserAccountPageObjects extends PageObjects {

	@FindBy(id="customer_firstname")
	private WebElement customerFirstName;

	@FindBy(id="customer_lastname")
	private WebElement customerLastName;

	@FindBy(id="email")
	private WebElement userEmail;

	@FindBy(id="passwd")
	private WebElement userPassword;

	@FindBy(id="firstname")
	private WebElement addressFirstName;

	@FindBy(id="lastname")
	private WebElement addressLastName;

	@FindBy(id="address1")
	private WebElement addressField;

	@FindBy(id="city")
	private WebElement cityField;

	@FindBy(id="id_state")
	private List<WebElement> stateField;

	@FindBy(id="postcode")
	private WebElement zipCodeField;

	@FindBy(id="id_country")
	private List<WebElement> countryField;

	@FindBy(id="phone_mobile")
	private WebElement mobileField;

	@FindBy(id="alias")
	private WebElement aliasField;

	@FindBy(id="submitAccount")
	private WebElement registerButton;

	public WebElement getCustomerFirstName() {
		return customerFirstName;
	}

	public WebElement getCustomerLastName() {
		return customerLastName;
	}

	public WebElement getUserEmail() {
		return userEmail;
	}

	public WebElement getUserPassword() {
		return userPassword;
	}

	public WebElement getAddressFirstName() {
		return addressFirstName;
	}

	public WebElement getAddressLastName() {
		return addressLastName;
	}

	public WebElement getAddressField() {
		return addressField;
	}

	public WebElement getCityField() {
		return cityField;
	}

	public List<WebElement> getStateField() {
		return stateField;
	}

	public WebElement getZipCodeField() {
		return zipCodeField;
	}

	public List<WebElement> getCountryField() {
		return countryField;
	}

	public WebElement getMobileField() {
		return mobileField;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public WebElement getAliasField() {
		return aliasField;
	}

	public void selectFromStateField(String option) {
		Select dropdown = new Select(driver.findElement(By.id("id_state")));
		dropdown.selectByVisibleText(option);
	}

	public void selectFromCountryField(String option) {
		Select dropdown = new Select(driver.findElement(By.id("id_country")));
		dropdown.selectByVisibleText(option);
	}

	public UserAccountPageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
