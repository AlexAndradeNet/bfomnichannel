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

import static com.bf.omnichannel.questions.HomeQuestions.ensureThatTheContextualMenuIsDisplayed;
import static com.bf.omnichannel.tasks.HomeTasks.*;

import com.bf.omnichannel.questions.GetExternalPageTitle;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

public class AdvancedUIStepsDefinitions {

    @When("{actor} clicks on the \"New Window\" button")
    public void clicksOnTheNewWindowButton(Actor actor) {
        openNewWindow(actor);
    }

    @And("{actor} clicks the {string} link in the new window/tab")
    public void waitSecondsBeforeClicksToTheLinkInTheNewWindowOrTab(
            Actor actor, String menuOption) {
        goToNewWindowOrTabAndWaitBeforeClickOnLink(actor, menuOption);
    }

    @Then("{actor} should see a page titled {string}")
    public void thePageTitleIs(Actor actor, String expectedTitle) {
        actor.attemptsTo(
                Ensure.that("The page title is correct", GetExternalPageTitle.mainTitle())
                        .isEqualToIgnoringCase(expectedTitle));
    }

    @And("{actor} should return to the main page after closing the new window")
    public void returnToTheMainPageAfterCloseTheNewWindow(Actor actor) {
        returnToTheDefaultContext(actor);
    }

    @When("{actor} clicks on the \"New Tab\" button")
    public void clicksOnTheNewTabButton(Actor actor) {
        openNewTab(actor);
    }

    @And("{actor} should returns to the main page after closing the new tab")
    public void returnToTheMainPageAfterCloseTheNewTab(Actor actor) {
        returnToTheDefaultContext(actor);
    }

    @Then("{actor} should see a page titled {string} within the iframe")
    public void thePageLoadedInTheIframeHasTheTitle(Actor actor, String pageTitle) {
        thePageTitleIs(actor, pageTitle);
    }

    @Then("{actor} should see the contextual menu")
    public void theContextualMenuReloadIsDisplayed(Actor actor) {
        ensureThatTheContextualMenuIsDisplayed(actor);
    }

    @When("{actor} hover over the \"Mouse Hover\" button")
    public void hoverOnTheButtonMouseHover(Actor actor) {
        hoverOverTheButton(actor);
    }

    @When("{actor} navigates to the {string} link inside the iframe")
    public void navigateToTheJobSupportLinkInTheIframe(Actor actor, String menuOption) {
        navigateAndInteractInIframe(actor, menuOption);
    }
}
