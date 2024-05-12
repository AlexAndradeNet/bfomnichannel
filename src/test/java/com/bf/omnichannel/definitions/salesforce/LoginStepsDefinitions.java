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

import static com.bf.omnichannel.tasks.salesforce.SfTerminalTasks.getSerialAndTidFromTheNewTerminal;

import com.bf.omnichannel.interactions.PrintResults;
import com.bf.omnichannel.tasks.salesforce.SfCaseTasks;
import com.bf.omnichannel.tasks.salesforce.SfDashboardTasks;
import com.bf.omnichannel.tasks.salesforce.SfTerminalTasks;
import com.bf.omnichannel.tasks.vhq.VhqAppParametersTasks;
import com.bf.omnichannel.tasks.vhq.VhqDashboardTasks;
import com.bf.omnichannel.tasks.vhq.VhqDeviceProfileTasks;
import com.bf.omnichannel.tasks.vhq.VhqLoginTasks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.jetbrains.annotations.NotNull;

public class LoginStepsDefinitions {

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
    }

    @When("{actor} creates a new case for the company profile {string} in the location {string}")
    public void heCreatesANewCaseForCompany(
            @NotNull Actor theActor, @NotNull String companyProfile, @NotNull String location) {

        theActor.attemptsTo(
                SfDashboardTasks.openCasesPage(theActor),
                SfCaseTasks.addNewCase(
                        theActor, companyProfile, location, theActor.recall("sfTerminalId")));

        theActor.attemptsTo(
                SfCaseTasks.assignATerminalToTheCase(theActor),
                SfCaseTasks.reloadThePageUntilTheTerminalGetsConfigured(theActor),
                getSerialAndTidFromTheNewTerminal(theActor, theActor.recall("sfTerminalId")));

        theActor.attemptsTo(PrintResults.fromRecall(1));
    }

    @Then("{actor} should see that the terminal is correctly created in VHQ")
    public void heShouldSeeThatTheTerminalIsCorrectlyCreatedInVHQ(Actor theActor) {

        heShouldSeeThatTheTerminalIsCorrectlyCreatedInVHQ(
                theActor,
                theActor.recall("sfTerminalSerialNumber"),
                theActor.recall("sfTerminalTangoTID"));
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
}
