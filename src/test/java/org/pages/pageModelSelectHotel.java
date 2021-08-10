package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.resources.Library;

public class pageModelSelectHotel extends Library {
	public pageModelSelectHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='radiobutton_0']")
	private WebElement btnClick;
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement btnContinue;

	public WebElement getBtnClick() {
		return btnClick;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void selecthtl() {
		click(getBtnClick());
		click(getBtnContinue());
	}
}
