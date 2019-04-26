package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.AddressPageObject;
import pageObjects.AuthenticationPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.PaymentPageObjects;
import pageObjects.ShippingPageObjects;
import pageObjects.ShoppingCartPageObjects;
import pageObjects.UserAccountPageObjects;

public class StoreTest extends SeleniumTestStart {

	private static HomePageObjects homePage = new HomePageObjects(driver);
	private static ShoppingCartPageObjects shoppingCart = new ShoppingCartPageObjects(driver);
	private static AuthenticationPageObjects authenticationPage = new AuthenticationPageObjects(driver);
	private static UserAccountPageObjects userAccountPage = new UserAccountPageObjects(driver);
	private static AddressPageObject addressPage = new AddressPageObject(driver);
	private static ShippingPageObjects shippingPage = new ShippingPageObjects(driver);
	private static PaymentPageObjects paymentPage = new PaymentPageObjects(driver);

	private static final String CUSTOMER_FIRST_NAME = "Marco";
	private static final String CUSTOMER_LAST_NAME = "Coradini";
	private static final String PASSWORD = "123!@#";
	private static final String ADDRESS = "Street 1";
	private static final String CITY = "New York";
	private static final String STATE = "New York";
	private static final String COUNTRY = "United States";
	private static final String ZIP_CODE = "12345";
	private static final String MOBILE = "9977885544";
	private static final String ALIAS = "Home";
	private static final String ORDER_COMPLETED = "Your order on My Store is complete.";

	Actions SeleniumActions = new Actions(driver);
	WebDriverWait wait = new WebDriverWait(driver, 15);

	@Test
	public void makePurchase() {

		String productName;
		String selectedProduct = "2";
		String productQuantity = "1 Product";
		String totalPrice;
		String userEmail = generateRandomEmail();

		//Seleciona produto na loja e adiciona ao carrinho.
		productName = homePage.getSelectedProductName(selectedProduct).getText();
		selectProductFromStore(selectedProduct);

		//Aguarda janela popup com o produto para proceder ao carrinho.
		wait.until(ExpectedConditions.elementToBeClickable(homePage.getProceedToCheckoutButton()));
		SeleniumActions.click(homePage.getProceedToCheckoutButton()).perform();

		//Verifica dados do produto e armazena o valor total do produto para comparação futura.
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCart.getProceedToCheckoutButton()));
		assertEquals(productQuantity, shoppingCart.getProductQuantity().getText());
		assertEquals(productName, shoppingCart.getProductAdded().getText());
		totalPrice = shoppingCart.getTotalCartPrice().getText();
		SeleniumActions.click(shoppingCart.getProceedToCheckoutButton()).perform();

		//Inicia processo de criação de um novo usuário no sistema.
		SeleniumActions.sendKeys(authenticationPage.getCreateEmailTextField(), userEmail).perform();
		SeleniumActions.click(authenticationPage.getCreateUserButton()).perform();

		//Preenche campos e cria usuário
		wait.until(ExpectedConditions.elementToBeClickable(userAccountPage.getCustomerFirstName()));
		createUser(CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME, userEmail, PASSWORD, ADDRESS, CITY, STATE, COUNTRY, ZIP_CODE, MOBILE, ALIAS);

		//Verifica informações referentes ao endereço
		wait.until(ExpectedConditions.elementToBeClickable(addressPage.getCheckoutButton()));
		assertTrue(addressPage.getSavedDeliveryAddress().getText().contains(ALIAS));
		assertTrue(addressPage.checkAddressInfo(CITY));
		assertTrue(addressPage.checkBillingInfo(CITY));
		SeleniumActions.click(addressPage.getCheckoutButton()).perform();

		//Aceita termos de serviço
		SeleniumActions.click(shippingPage.getTermsOfServiceCheckbox()).perform();
		SeleniumActions.click(shippingPage.getGetCheckoutButton()).perform();

		//Efetua pagamento
		makePaymentByBankWire(totalPrice);
	}

	/*
	 * Método que seleciona um produto da loja a sua escolha, onde "product" deve ser um nro de 1 a 7.
	 */
	public void selectProductFromStore(String product) {
		SeleniumActions.moveToElement(homePage.getSelectedProduct(product)).perform();
		SeleniumActions.moveToElement(homePage.getSelectAddToCartButton(product)).perform();
		SeleniumActions.click(homePage.getSelectAddToCartButton(product)).perform();
	}
	/*
	 * Método para criação de usuário. Separei porque poderia ser utilizado em um novo teste.
	 */
	public void createUser(String firstName, String lastName, String email, String password, String address, String city, String state, String country, String zipCode, String mobile, String alias) {
		SeleniumActions.sendKeys(userAccountPage.getCustomerFirstName(), firstName).perform();
		SeleniumActions.sendKeys(userAccountPage.getCustomerLastName(), lastName).perform();
		assertEquals(email, userAccountPage.getUserEmail().getAttribute("value"));
		SeleniumActions.sendKeys(userAccountPage.getUserPassword(), password).perform();
		assertEquals(firstName, userAccountPage.getAddressFirstName().getAttribute("value"));
		assertEquals(lastName, userAccountPage.getAddressLastName().getAttribute("value"));
		SeleniumActions.sendKeys(userAccountPage.getAddressField(), address).perform();
		SeleniumActions.sendKeys(userAccountPage.getCityField(), city).perform();

		userAccountPage.selectFromStateField(state);
		userAccountPage.selectFromCountryField(country);

		SeleniumActions.sendKeys(userAccountPage.getZipCodeField(), zipCode).perform();
		SeleniumActions.sendKeys(userAccountPage.getMobileField(), mobile).perform();
		userAccountPage.getAliasField().clear();
		SeleniumActions.sendKeys(userAccountPage.getAliasField(), alias).perform();
		SeleniumActions.click(userAccountPage.getRegisterButton()).perform();
	}

	/*
	 * Método para pagamento via bankWire. Separei porque poderia ser utilizado em um novo teste.
	 */
	public void makePaymentByBankWire(String price) {
		assertEquals(paymentPage.getTotalPrice().getText(), price);
		SeleniumActions.click(paymentPage.getBankWirePayment()).perform();
		wait.until(ExpectedConditions.elementToBeClickable(paymentPage.getConfirmOrderButton()));
		SeleniumActions.click(paymentPage.getConfirmOrderButton()).perform();
		wait.until(ExpectedConditions.elementToBeClickable(paymentPage.getBackToOrdersButton()));
		assertEquals(paymentPage.getOrderCompleteInfo().getText(), ORDER_COMPLETED);
		SeleniumActions.click(paymentPage.getBackToOrdersButton()).perform();
	}
	/*
	 * Método para gerar um endereço de email aleatório.
	 */
	public String generateRandomEmail() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		return "username"+ randomInt +"@randomail.com";
	}
}
