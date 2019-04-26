package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects extends PageObjects {

	private String PRODUCT_XPATH = "//*[@id='homefeatured']/li[%s]/div/div[1]";
	private String PRODUCT_NAME_XPATH = "//*[@id='homefeatured']/li[%s]/div/div[2]/h5/a";
	private String ADD_TO_CART_XPATH = "//*[@id=\"homefeatured\"]/li[%s]/div/div[2]/div[2]/a[1]/span";

	@FindBy(xpath="//*[@id=\"homefeatured\"]/li[1]/div/div[1]")
	private WebElement firstProduct;

	@FindBy(xpath="//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a")
	private WebElement productName;

	@FindBy(xpath="//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[2]/span")
	private WebElement moreButton;

	@FindBy(xpath="//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span")
	private WebElement addToCartButton;

	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	private WebElement proceedToCheckoutButton;

	public HomePageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getFirstProduct() {
		return firstProduct;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getMoreButton() {
		return moreButton;
	}

	public WebElement getProceedToCheckoutButton() {
		return proceedToCheckoutButton;
	}

	private WebElement SelectedProduct(String product) {
	    return driver.findElement(By.xpath(String.format(PRODUCT_XPATH, product)));
	}

	private WebElement SelectedProductName(String product) {
	    return driver.findElement(By.xpath(String.format(PRODUCT_NAME_XPATH, product)));
	}

	private WebElement SelectAddToCartButton(String product) {
	    return driver.findElement(By.xpath(String.format(ADD_TO_CART_XPATH, product)));
	}

	public WebElement getSelectedProduct(String product) {
		return SelectedProduct(product);
	}

	public WebElement getSelectedProductName(String product) {
		return SelectedProductName(product);
	}

	public WebElement getSelectAddToCartButton(String product) {
		return SelectAddToCartButton(product);
	}
}
