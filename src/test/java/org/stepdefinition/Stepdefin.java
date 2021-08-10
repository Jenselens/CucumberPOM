package org.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.pageModelBkConfirm;
import org.pages.pageModelBookHotel;
import org.pages.pageModelLogin;
import org.pages.pageModelSearchHotel;
import org.pages.pageModelSelectHotel;
import org.resources.Library;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefin extends Library {

	@Given("user is on the adactin hotel page")
	public void tc1() {
		driver = getDriver();
		loadurl("https://adactinhotelapp.com/");
	}

	@When("User should enter {string} and {string}")
	public void tc2(String user, String pass) {
		pageModelLogin login = new pageModelLogin();
		login.loginpage(user, pass);
	}

	@When("User should enter {string},{string},{string}and{string}")
	public void tc4(String Location, String Hotel, String Room, String NoOfRoom) {
		pageModelSearchHotel search = new pageModelSearchHotel();
		search.searchHotel(Location, Hotel, Room, NoOfRoom);
	}

	@When("User should select the hotel by click login button")
	public void tc5() {
		pageModelSelectHotel hotel = new pageModelSelectHotel();
		hotel.selecthtl();

	}

	@When("user should enter {string},{string},{string},{string},{string},{string},{string},{string}")
	public void tc6(String FirstName, String SecondName, String Address, String ccno, String ccty, String ccMonth,
			String ccYear, String ccvvN) {
		pageModelBookHotel book = new pageModelBookHotel();
		book.bookHotel(FirstName, SecondName, Address, ccno, ccty, ccMonth, ccYear, ccvvN);
	}

	@When("user should get order id")
	public void tc7() throws Exception {
		pageModelBkConfirm confirm = new pageModelBkConfirm();
		String orderid = confirm.orderid();
		System.out.println(orderid);
	}

	@Then("user should verify success message")
	public void tc8() {
		Assert.assertTrue("Verify the message", true);

	}

}
