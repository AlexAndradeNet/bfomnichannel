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

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import com.bf.omnichannel.interactions.*;
import com.bf.omnichannel.tasks.salesforce.SfCaseTasks;
import com.bf.omnichannel.tasks.salesforce.SfDashboardTasks;
import com.bf.omnichannel.tasks.salesforce.SfTerminalTasks;
import com.bf.omnichannel.tasks.vhq.VhqAppParametersTasks;
import com.bf.omnichannel.tasks.vhq.VhqDashboardTasks;
import com.bf.omnichannel.tasks.vhq.VhqDeviceProfileTasks;
import com.bf.omnichannel.tasks.vhq.VhqLoginTasks;
import com.bf.omnichannel.ui.salesforce.SfCasePage;
import com.bf.omnichannel.ui.salesforce.SfDashboardPage;
import com.bf.omnichannel.ui.salesforce.SfTerminalPage;
import com.bf.omnichannel.utils.RegexTextExtractor;
import com.bf.omnichannel.utils.SimpleLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;

public class LoginStepsDefinitions {
    private static final SimpleLogger logger = new SimpleLogger(LoginStepsDefinitions.class);

    @Given(
            "{actor} created a new terminal for the location {string} and Default Terminal Settings"
                    + " to {string} and Tip at Time of Sale {string}")
    public void heHasCreatedANewTerminalForTheLocation(
            @NotNull Actor theActor,
            @NotNull String desiredLocation,
            @NotNull String defaultTerminalSettings,
            @NotNull String tipAtTimeOfSale) {

        theActor.attemptsTo(
                SfDashboardTasks.openTerminalsPage(theActor),
                SfTerminalTasks.addNewTerminal(
                        theActor, desiredLocation, defaultTerminalSettings, tipAtTimeOfSale));

        logger.info(
                "######### Test Case: defaultTerminalSettings %s, tipAtTimeOfSale %s%n"
                        .formatted(defaultTerminalSettings, tipAtTimeOfSale));
        saveInfoForReuseDuringTheExecution(
                theActor, SfTerminalPage.CREATED_TERMINAL_ID_LABEL, "sfTerminalId");
    }

    @When("{actor} creates a new case for the company profile {string} in the location {string}")
    public void heCreatesANewCaseForCompany(
            @NotNull Actor theActor, @NotNull String companyProfile, @NotNull String location) {

        theActor.attemptsTo(
                SfDashboardTasks.openCasesPage(theActor),
                SfCaseTasks.addNewCase(
                        theActor, companyProfile, location, theActor.recall("sfTerminalId")));

        saveInfoForReuseDuringTheExecution(theActor, SfCasePage.CREATED_CASE_ID_LABEL, "sfCaseId");

        theActor.attemptsTo(
                SfCaseTasks.assignATerminalToTheCase(theActor),
                SfCaseTasks.reloadThePageUntilTheTerminalGetsConfigured(theActor));

        getSerialAndTidFromTheNewTerminal(theActor, theActor.recall("sfTerminalId"));
        saveInfoForReuseDuringTheExecution(
                theActor,
                SfTerminalPage.VALUE_TABLE_ITEM.of("Serial Number"),
                "sfTerminalSerialNumber");
        saveInfoForReuseDuringTheExecution(
                theActor, SfTerminalPage.VALUE_TABLE_ITEM.of("Tango TID"), "sfTerminalTangoTID");

        theActor.attemptsTo(PrintResults.fromRecall(1));
    }

    @Then(
            "{actor} should see that the terminal is correctly created in VHQ by serial {string}"
                    + " and TID {string}")
    public void heShouldSeeThatTheTerminalIsCorrectlyCreatedInVHQ(
            Actor theActor, String serialNumber, String tid) {

        theActor.wasAbleTo(VhqLoginTasks.openHomePage(), VhqLoginTasks.login());
        theActor.attemptsTo(
                VhqDashboardTasks.searchByTerm(theActor, serialNumber),
                VhqDeviceProfileTasks.checkSerialAndDeviceId(theActor, serialNumber, tid),
                VhqDeviceProfileTasks.openAppParameters(theActor),
                VhqAppParametersTasks.checkAppParameters(theActor));
    }

    private static void getSerialAndTidFromTheNewTerminal(Actor theActor, String termToSearch) {
        theActor.attemptsTo(SfDashboardTasks.searchByTerm(termToSearch));

        String terminalResultURL =
                Attribute.of(SfDashboardPage.FOUND_TERM_LINK.of(termToSearch))
                        .named("href")
                        .asString()
                        .answeredBy(theActor);

        String terminalUrlId = RegexTextExtractor.get(terminalResultURL, "r\\/(.*)\\/view");

        String terminalPrintingUrl =
                "https://safecharge--ongoing.sandbox.my.salesforce.com/%s/p"
                        .formatted(terminalUrlId);

        theActor.attemptsTo(
                Open.url(terminalPrintingUrl),
                WaitForPageLoad.complete(),
                WaitUntil.the(SfTerminalPage.VALUE_TABLE_ITEM.of("Serial Number"), isVisible())
                        .forNoMoreThan(100)
                        .seconds());

        while (Text.of(SfTerminalPage.VALUE_TABLE_ITEM.of("Serial Number"))
                .answeredBy(theActor)
                .isEmpty()) {
            ((JavascriptExecutor) getDriver()).executeScript("window.location.reload(true);");
            theActor.attemptsTo(WaitForPageLoad.complete(), WaitSpecificTime.forSeconds(30));
        }

        theActor.attemptsTo(
                Ensure.that(
                                Text.of(SfTerminalPage.VALUE_TABLE_ITEM.of("Status"))
                                        .answeredBy(theActor))
                        .isNotEmpty(),
                Ensure.that(
                                Text.of(SfTerminalPage.VALUE_TABLE_ITEM.of("Serial Number"))
                                        .answeredBy(theActor))
                        .isNotEmpty(),
                Ensure.that(
                                Text.of(SfTerminalPage.VALUE_TABLE_ITEM.of("Tango ID"))
                                        .answeredBy(theActor))
                        .isNotEmpty());
    }

    private static void saveInfoForReuseDuringTheExecution(
            @NotNull Actor theActor, Target target, String serenityVariableName) {
        theActor.remember(serenityVariableName, Text.of(target).answeredBy(theActor));
    }
}
