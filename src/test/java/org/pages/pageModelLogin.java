
package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.resources.Library;

public class pageModelLogin extends Library {
	public pageModelLogin() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtusername;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void loginpage(String user, String pass) {
		type(getTxtusername(), user);
		type(getTxtPassword(), pass);
		click(getBtnLogin());
	}

}
