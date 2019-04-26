package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPageObjects extends PageObjects {

	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]/span")
	private WebElement proceedToCheckoutButton;

	@FindBy(id="cart_summary")
	private List<WebElement> cartTable;

	@FindBy(xpath="//*[@id=\"cart_summary\"]/tbody/tr/td[2]/p")
	private WebElement productAdded;

	@FindBy(id="summary_products_quantity")
	private WebElement productQuantity;

	@FindBy(id="total_price")
	private WebElement totalCartPrice;

	public WebElement getProductAdded() {
		return productAdded;
	}

	public List<WebElement> getCartTable() {
		return cartTable;
	}

	public WebElement getProceedToCheckoutButton() {
			return proceedToCheckoutButton;
		}

	public WebElement getProductQuantity() {
		return productQuantity;
	}

	public WebElement getTotalCartPrice() {
		return totalCartPrice;
	}

	public ShoppingCartPageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}

