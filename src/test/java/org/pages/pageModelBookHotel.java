package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.resources.Library;

public class pageModelBookHotel extends Library {
	public pageModelBookHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement first;
	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement last;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addr;
	@FindBy(xpath = "//input[@id='cc_num']")
	private WebElement ccno;
	@FindBy(xpath = "//select[@id='cc_type']")
	private WebElement cctyp;
	@FindBy(xpath = "//select[@id='cc_exp_month']")
	private WebElement month;
	@FindBy(xpath = "//select[@id='cc_exp_year']")
	private WebElement ccyr;
	@FindBy(xpath = "//input[@id='cc_cvv']")
	private WebElement cvv;
	@FindBy(xpath = "//input[@id='book_now']")
	private WebElement btnbk;

	public WebElement getFirst() {
		return first;
	}

	public WebElement getLast() {
		return last;
	}

	public WebElement getAddr() {
		return addr;
	}

	public WebElement getCcno() {
		return ccno;
	}

	public WebElement getCctyp() {
		return cctyp;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getCcyr() {
		return ccyr;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBtnbk() {
		return btnbk;
	}

	public void bookHotel(String FirstName, String SecondName, String Address, String ccno, String ccty, String ccMonth,
			String ccYear, String ccvvN) {
		type(getFirst(), FirstName);
		type(getLast(), SecondName);
		type(getAddr(), Address);
		type(getCcno(), ccno);
		selectbyvisi(getCctyp(), ccty);
		selectbyvisi(getMonth(), ccMonth);
		selectbyvisi(getCcyr(), ccYear);
		type(getCvv(), ccvvN);
		click(getBtnbk());
	}
}
