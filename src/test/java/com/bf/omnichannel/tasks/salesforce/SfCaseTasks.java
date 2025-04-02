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
package com.bf.omnichannel.tasks.salesforce;

import static com.bf.omnichannel.RunnerCucumberTestSuite.SCENARIO_DATA_VARIABLE_NAME;
import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

import com.bf.omnichannel.interactions.*;
import com.bf.omnichannel.pojo.ScenarioDataPojo;
import com.bf.omnichannel.ui.salesforce.SfCasePage;
import com.bf.omnichannel.ui.salesforce.SfTerminalPage;
import com.bf.omnichannel.utils.SimpleLogger;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;

public class SfCaseTasks {
    private static final SimpleLogger logger = new SimpleLogger(SfCaseTasks.class);

    private SfCaseTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} add a new terminal {1}")
    public static Performable addNewCase(@NotNull Actor theActor) {

        ScenarioDataPojo scenarioData = theActor.recall(SCENARIO_DATA_VARIABLE_NAME);

        theActor.attemptsTo(
                WaitUntil.the(SfCasePage.BUTTON_INTEGRATION_GUIDE, isPresent()),
                ClickOn.target(SfCasePage.BUTTON_NEW_CASE),
                WaitForPageLoad.complete(),
                ClickOn.target(SfCasePage.CONFIGURATION_LABEL),
                ClickOn.target(SfCasePage.NEXT_BUTTON),
                WaitForPageLoad.complete(),
                WaitUntil.the(SfCasePage.COMPANY_PROFILE_TEXTBOX, isClickable()),
                Enter.theValue(scenarioData.getCompanyProfile())
                        .into(SfCasePage.COMPANY_PROFILE_TEXTBOX),
                ClickOn.target(SfCasePage.DROPDOWN_ITEM.of(scenarioData.getCompanyProfile())),
                ClickOnTargetAndDropdownItem.thenSelect(SfCasePage.PROFILE_TYPE_COMBOBOX, "POS"),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfCasePage.CASE_REASON_COMBOBOX, "New Merchant"),
                Scroll.to(SfCasePage.TYPE_COMBOBOX),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfCasePage.TYPE_COMBOBOX, "Duplicate account"),
                Scroll.to(SfCasePage.PROFILE_COMBOBOX),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfCasePage.PROFILE_COMBOBOX, "UK Omnichannel Verifone Terminal"),
                Enter.theValue(scenarioData.getLocation()).into(SfCasePage.LOCATION_TEXTBOX),
                ClickOn.target(SfCasePage.DROPDOWN_ITEM.of(scenarioData.getLocation())),
                Enter.theValue("Add additional terminal " + theActor.recall("sfTerminalId"))
                        .into(SfCasePage.SUBJECT_TEXTBOX),
                ClickOn.target(SfCasePage.BUTTON_SAVE),
                WaitForPageLoad.complete(),
                WaitUntil.the(SfCasePage.MORE_OPTIONS_BUTTON, isClickable())
                        .forNoMoreThan(100)
                        .seconds(),
                RemoveElement.byTarget(SfTerminalPage.ALERT_DIALOG),
                WaitUntil.the(SfCasePage.MORE_OPTIONS_BUTTON, isClickable())
                        .forNoMoreThan(100)
                        .seconds());
        // RememberInfo.forTarget(theActor, SfCasePage.CREATED_CASE_ID_LABEL, "sfCaseId"));

        return Task.where();
    }

    @Step("{0} assign a terminal to the case (create additional terminals)")
    public static Performable assignATerminalToTheCase(Actor theActor) {
        do {
            theActor.attemptsTo(
                    ClickOn.target(SfCasePage.MORE_OPTIONS_BUTTON),
                    ClickOn.target(SfCasePage.CREATE_ADDITIONAL_TERMINALS_MENU_ITEM),
                    WaitForPageLoad.complete(),
                    WaitUntil.the(SfCasePage.MORE_OPTIONS_BUTTON, isClickable())
                            .forNoMoreThan(100)
                            .seconds());
        } while (Text.of(SfCasePage.STATUS_LABEL).answeredBy(theActor).equals("New"));
        return Task.where();
    }

    @Step("{0} reload the page until the terminal gets configured")
    public static Performable reloadThePageUntilTheTerminalGetsConfigured(Actor theActor) {

        final String CONFIGURATION_COMPLETED = "Configuration Completed";

        logger.debug("XXXXXXXXXXXXXX Starting reloadThePageUntilTheTerminalGetsConfigured");

        do {
            theActor.attemptsTo(WaitSpecificTime.forSeconds(30));
            ((JavascriptExecutor) getDriver()).executeScript("window.location.reload(true);");
            theActor.attemptsTo(
                    WaitForPageLoad.complete(),
                    WaitUntil.the(SfCasePage.STATUS_LABEL, isClickable())
                            .forNoMoreThan(100)
                            .seconds());
        } while (!Text.of(SfCasePage.STATUS_LABEL)
                .answeredBy(theActor)
                .equals(CONFIGURATION_COMPLETED));

        logger.debug("XXXXXXXXXXXXXX Finished reloadThePageUntilTheTerminalGetsConfigured");

        theActor.attemptsTo(Ensure.that(SfCasePage.STATUS_LABEL).hasText(CONFIGURATION_COMPLETED));

        return Task.where();
    }
}
