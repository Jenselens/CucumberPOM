package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.resources.Library;

public class pageModelBkConfirm extends Library {
	public pageModelBkConfirm() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='order_no']")
	private WebElement orderno;
	@FindBy(id = "my_itinerary")
	private WebElement cancel;

	public WebElement getCancel() {
		return cancel;
	}

	public WebElement getOrderno() {
		return orderno;
	}

	public String orderid() throws Exception {
		String attr = getAttr(getOrderno(), "value");
		return attr;

	}
}
