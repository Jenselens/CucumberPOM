package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.resources.Library;

public class pageModelSearchHotel extends Library {
	public pageModelSearchHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='location']")
	private WebElement sltLoca;
	@FindBy(xpath = "//select[@id='hotels']")
	private WebElement sltHotel;
	@FindBy(xpath = "//select[@id='room_type']")
	private WebElement sltRoomType;
	@FindBy(xpath = "//select[@id='room_nos']")
	private WebElement sltnoOfRoom;
	@FindBy(xpath = "//input[@id='Submit']")
	private WebElement btnSearch;

	public WebElement getSltLoca() {
		return sltLoca;
	}

	public WebElement getSltHotel() {
		return sltHotel;
	}

	public WebElement getSltRoomType() {
		return sltRoomType;
	}

	public WebElement getSltnoOfRoom() {
		return sltnoOfRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public void searchHotel(String Location, String Hotel, String Room, String NoOfRoom) {
		selectbyvisi(getSltLoca(), Location);
		selectbyvisi(getSltHotel(), Hotel);
		selectbyvisi(getSltRoomType(), Room);
		selectbyvisi(getSltnoOfRoom(), NoOfRoom);
		click(getBtnSearch());
	}
}
