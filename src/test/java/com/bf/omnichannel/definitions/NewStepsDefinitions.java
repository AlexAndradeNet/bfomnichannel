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
package com.bf.omnichannel.definitions;

import static com.bf.omnichannel.RunnerCucumberTestSuite.TEST_ONLY_VHQ;
import static com.bf.omnichannel.tasks.salesforce.SfTerminalTasks.getSerialAndTidFromTheNewTerminal;

import com.bf.omnichannel.definitions.data.DataTableAnalyzer;
import com.bf.omnichannel.interactions.PrintResults;
import com.bf.omnichannel.tasks.salesforce.SfCaseTasks;
import com.bf.omnichannel.tasks.salesforce.SfDashboardTasks;
import com.bf.omnichannel.tasks.salesforce.SfTerminalTasks;
import com.bf.omnichannel.tasks.vhq.VhqAppParametersTasks;
import com.bf.omnichannel.tasks.vhq.VhqDashboardTasks;
import com.bf.omnichannel.tasks.vhq.VhqDeviceProfileTasks;
import com.bf.omnichannel.tasks.vhq.VhqLoginTasks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import org.jetbrains.annotations.NotNull;

public class NewStepsDefinitions {

    @Given("{actor} created a new terminal with the following values")
    public void heCreatedANewTerminalWithTheFollowingValues(
            @NotNull Actor theActor, @NotNull DataTable dataTable) {

        DataTableAnalyzer.transformAndRememberScenarioData(theActor, dataTable);

        if (TEST_ONLY_VHQ) {
            return;
        }
        theActor.attemptsTo(
                SfDashboardTasks.openTerminalsPage(theActor),
                SfTerminalTasks.addNewTerminal(theActor));
    }

    @When("{actor} creates a new case to deliver the new terminal")
    public void heCreatesANewCaseToDeliverTheNewTerminal(Actor theActor) {
        if (TEST_ONLY_VHQ) {
            return;
        }
        theActor.attemptsTo(
                SfDashboardTasks.openCasesPage(theActor), SfCaseTasks.addNewCase(theActor));

        theActor.attemptsTo(
                SfCaseTasks.assignATerminalToTheCase(theActor),
                SfCaseTasks.reloadThePageUntilTheTerminalGetsConfigured(theActor),
                getSerialAndTidFromTheNewTerminal(theActor));

        theActor.attemptsTo(PrintResults.fromRecall(1));
    }

    @Then(
            "{actor} should see that the terminal is created correctly in VHQ, including the"
                    + " following calculated fields")
    public void
            heShouldSeeThatTheTerminalIsCreatedCorrectlyInVHQIncludingTheFollowingCalculatedFields(
                    Actor theActor, DataTable dataTable) {

        DataTableAnalyzer.transformAndRememberScenarioData(theActor, dataTable);

        String terminalSerialNumber =
                (TEST_ONLY_VHQ) ? "200-922-971" : theActor.recall("sfTerminalSerialNumber");
        String terminalTangoTID =
                (TEST_ONLY_VHQ) ? "99001198" : theActor.recall("sfTerminalTangoTID");

        theActor.wasAbleTo(VhqLoginTasks.openHomePage(theActor), VhqLoginTasks.login(theActor));
        theActor.attemptsTo(
                VhqDashboardTasks.searchByTerm(theActor, terminalSerialNumber),
                VhqDeviceProfileTasks.checkSerialAndDeviceId(
                        theActor, terminalSerialNumber, terminalTangoTID),
                VhqDeviceProfileTasks.openAppParameters(theActor),
                VhqAppParametersTasks.checkAppParameters(theActor));
    }
}
