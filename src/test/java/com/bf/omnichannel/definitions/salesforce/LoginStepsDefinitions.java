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
package com.bf.omnichannel.definitions.salesforce;

import static com.bf.omnichannel.questions.salesforce.DashboardQuestions.ensureSearchBarIsVisible;

import com.bf.omnichannel.interactions.WaitForPageLoad;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

public class LoginStepsDefinitions {

    @When("{actor} is on the landing page")
    public void heIsOnTheLandingPage(Actor actor) {
        actor.attemptsTo(WaitForPageLoad.complete());
    }

    @Then("{actor} should see the Search bar is visible")
    public void heShouldSeeThatTheOptionIsSelected(Actor actor) {
        ensureSearchBarIsVisible(actor);
    }
}
