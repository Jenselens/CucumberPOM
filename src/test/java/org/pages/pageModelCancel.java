package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.resources.Library;

public class pageModelCancel extends Library {
	public pageModelCancel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@name='ids[]'])[1]")
	private WebElement cancel;
	@FindBy(xpath = "//input[@name='cancelall']")
	private WebElement cancelselect;

	public WebElement getCancel() {
		return cancel;
	}

	public WebElement getCancelselect() {
		return cancelselect;
	}

	public void cancelid() {
		click(getCancel());
		click(getCancelselect());
		alrtAccept();
	}

}
