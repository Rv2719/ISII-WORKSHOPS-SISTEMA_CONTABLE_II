package ec.edu.espol.workshops;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import static org.junit.Assert.*;

public class StepsDefs {
	private int actualAnswer;
	private boolean license;
	public CarInsurance carInsurance = new CarInsurance();

	@Given("the age is {int}")
	public void the_age_is(int entero) {
		carInsurance.setAge(entero);
	}

	@And("the gender is {string}")
	public void the_gender_is(String gender) {
		carInsurance.setGender(gender.charAt(0));

	}

	@And("is his status is {string}")
	public void is_his_status_is(String status) {
		if (status.equals("married")) {
			carInsurance.setMarried(true);
		} else {
			carInsurance.setMarried(false);
		}
	}

	@And("he {string} license")
	public void he_license(String license) {
		if (license.equals("have")) {
			this.license = true;
		} else {
			this.license = false;
		}
	}

	@When("calculate the insurance")
	public void calculated_the_insurance() {
		actualAnswer = carInsurance.calculatePremium(license);
	}

	@Then("show {int}")

	public void show(int expectedValue) {
		assertEquals(expectedValue, actualAnswer);
	}

}
