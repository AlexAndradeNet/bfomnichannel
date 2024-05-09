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

import com.bf.omnichannel.interactions.*;
import com.bf.omnichannel.tasks.salesforce.SfCaseTasks;
import com.bf.omnichannel.tasks.salesforce.SfDashboardTasks;
import com.bf.omnichannel.tasks.salesforce.SfLoginTasks;
import com.bf.omnichannel.tasks.salesforce.SfTerminalTasks;
import com.bf.omnichannel.ui.salesforce.SfCasePage;
import com.bf.omnichannel.ui.salesforce.SfDashboardPage;
import com.bf.omnichannel.ui.salesforce.SfTerminalPage;
import com.bf.omnichannel.utils.RegexTextExtractor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.jetbrains.annotations.NotNull;

public class LoginStepsDefinitions {
    @Given("{actor} created a new terminal for the location {string}")
    public void heHasCreatedANewTerminalForTheLocation(
            @NotNull Actor theActor, @NotNull String desiredLocation) {

        theActor.attemptsTo(
                SfDashboardTasks.openTerminalsPage(),
                SfTerminalTasks.addNewTerminal(desiredLocation));

        saveInfoForReuseDuringTheExecution(
                theActor, SfTerminalPage.CREATED_TERMINAL_ID_LABEL, "sfTerminalId");
    }

    @When("{actor} creates a new case for the company profile {string} in the location {string}")
    public void heCreatesANewCaseForCompany(
            @NotNull Actor theActor, @NotNull String companyProfile, @NotNull String location) {

        theActor.attemptsTo(
                SfDashboardTasks.openCasesPage(),
                SfCaseTasks.addNewCase(companyProfile, location, theActor.recall("sfTerminalId")));

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
    }

    @Then("{actor} should see that the terminal is correctly created in VHQ {string}")
    public void heShouldSeeThatTheTerminalIsCorrectlyCreatedInVHQ(
            Actor theActor, String termToSearch) {


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

        theActor.attemptsTo(Open.url(terminalPrintingUrl), WaitForPageLoad.complete());
    }

    private static void saveInfoForReuseDuringTheExecution(
            @NotNull Actor theActor, Target target, String serenityVariableName) {
        theActor.remember(serenityVariableName, Text.of(target).answeredBy(theActor));
        System.out.printf(
                "XXXXXXXXXXXXXX %s: %s%n",
                serenityVariableName, theActor.recall(serenityVariableName));
    }
}
