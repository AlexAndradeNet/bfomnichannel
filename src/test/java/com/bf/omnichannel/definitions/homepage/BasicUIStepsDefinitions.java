/*
nuvei.com CONFIDENTIAL

Copyright (c) 2024. All Rights Reserved.

NOTICE: The source code contained or described herein and all documents
related to the source code ("Material") are owned by Nuvei Inc.
or its companies, suppliers or licensors.

Dissemination of this information or reproduction of this material
is strictly forbidden unless prior written permission is obtained
from Nuvei Inc.
*/
package com.bf.omnichannel.definitions.homepage;

import static com.bf.omnichannel.questions.HomeQuestions.*;
import static com.bf.omnichannel.tasks.HomeTasks.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class BasicUIStepsDefinitions {

    @When("{actor} select the {string} option in the radio button")
    public void selectTheOptionInTheRadioButton(Actor actor, String radioButtonValue) {
        selectRadioButton(actor, radioButtonValue);
    }

    @Then("{actor} should see that the {string} option is selected")
    public void theOptionIsSelected(Actor actor, String radioButtonValue) {
        ensureRadioButtonIsSelected(actor, radioButtonValue);
    }

    @When("{actor} select {string} from the country menu")
    public void selectFromCountryMenu(Actor actor, String country) {
        selectMenu(actor, country);
    }

    @Then("{actor} should see that the country text field value is set to {string}")
    public void theWasWroteIntoTheCountryTextField(Actor actor, String country) {
        ensureMenuOptionIsSelected(actor, country);
    }

    @When("{actor} select {string} from the dropdown")
    public void selectFromDropdown(Actor actor, String optionValue) {
        selectDropdownOption(actor, optionValue);
    }

    @Then("{actor} should see that {string} is selected in the dropdown menu")
    public void theIsTheSelectedValueInTheDropdown(Actor actor, String optionValue) {
        ensureDropdownOptionIsSelected(actor, optionValue);
    }

    @When("{actor} selects {string} in the checkbox")
    public void selectInTheCheckbox(Actor actor, String option) {
        selectCheckboxOption(actor, option);
    }

    @Then("{actor} should see that the {string} checkbox is checked")
    public void theIsTheSelectedValueInTheCheckbox(Actor actor, String optionValue) {
        ensureCheckboxOptionIsSelected(actor, optionValue);
    }

    @When("{actor} triggers an Alert Dialog with the name {string}")
    public void alertTheName(Actor actor, String value) {
        alertName(actor, value);
    }

    @Then("{actor} should see an Alert Dialog with the text {string}")
    public void theAlertHasTheText(Actor actor, String alertText) {
        ensureAlertHasText(actor, alertText);
    }

    @When("{actor} triggers a Confirmation Dialog for the name {string}")
    public void confirmTheName(Actor actor, String value) {
        confirmName(actor, value);
    }

    @Then("{actor} should see a Confirmation Dialog with the prompt {string}")
    public void theConfirmHasTheText(Actor actor, String value) {
        ensureAlertHasText(actor, value);
    }

    @When("{actor} reads the third value listed in the price table")
    public void readTheThirdPrice(Actor actor) {
        // Do nothing
    }

    @Then("{actor} should see that the third price is {int}")
    public void theThirdPriceIs(Actor actor, int price) {
        ensurePriceIsCorrect(actor, price);
    }

    @Given("{actor} can see that the \"HideShow Example\" text box is visible")
    public void theTextBoxHideShowExampleIsDisplayed(Actor actor) {
        ensureTextboxVisibility(actor, true);
    }

    @When("{actor} requests to hide the \"HideShow Example\" text box")
    public void askForHideIt(Actor actor) {
        hideObject(actor);
    }

    @Then("{actor} should see the text box become hidden")
    public void theTextBoxIsHidden(Actor actor) {
        ensureTextboxVisibility(actor, false);
    }

    @And("{actor} requests to show it again")
    public void askForShowIt(Actor actor) {
        showObject(actor);
    }

    @Then("{actor} should see the text box become visible again")
    public void theTextBoxIsDisplayed(Actor actor) {
        ensureTextboxVisibility(actor, true);
    }

    @And("{actor} should see that the {string} checkbox also is checked")
    public void sheShouldSeeThatTheCheckboxAlsoIsChecked(Actor actor, String checkboxValue) {
        ensureCheckboxOptionIsSelected(actor, checkboxValue);
    }
}
