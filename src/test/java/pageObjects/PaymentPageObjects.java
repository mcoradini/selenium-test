package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPageObjects extends PageObjects {

	@FindBy(id="total_price")
	private WebElement totalPrice;

	@FindBy(className="bankwire")
	private WebElement bankWirePayment;

	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
	private WebElement confirmOrderButton;

	@FindBy(xpath="//*[@id=\"center_column\"]/div/p/strong")
	private WebElement orderCompleteInfo;

	@FindBy(xpath="//*[@id=\"center_column\"]/p/a")
	private WebElement backToOrdersButton;

	public WebElement getBackToOrdersButton() {
		return backToOrdersButton;
	}

	public WebElement getOrderCompleteInfo() {
		return orderCompleteInfo;
	}

	public WebElement getConfirmOrderButton() {
		return confirmOrderButton;
	}

	public WebElement getTotalPrice() {
		return totalPrice;
	}

	public WebElement getBankWirePayment() {
		return bankWirePayment;
	}

	public PaymentPageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
