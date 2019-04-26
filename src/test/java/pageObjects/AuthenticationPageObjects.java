package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPageObjects extends PageObjects {

	@FindBy(id="SubmitCreate")
	private WebElement createUserButton;

	@FindBy(id="email_create")
	private WebElement createEmailTextField;

	public WebElement getCreateUserButton() {
		return createUserButton;
	}

	public WebElement getCreateEmailTextField() {
		return createEmailTextField;
	}

	public AuthenticationPageObjects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

}
