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

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.bf.omnichannel.interactions.*;
import com.bf.omnichannel.pojo.ScenarioDataPojo;
import com.bf.omnichannel.ui.salesforce.SfDashboardPage;
import com.bf.omnichannel.ui.salesforce.SfTerminalPage;
import com.bf.omnichannel.utils.RegexTextExtractor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;

public class SfTerminalTasks {

    private SfTerminalTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} adds a new terminal on location '{1}'")
    public static Performable addNewTerminal(@NotNull Actor theActor) {

        ScenarioDataPojo scenarioData = theActor.recall("scenarioData");

        theActor.attemptsTo(
                ClickOn.target(SfTerminalPage.BUTTON_NEW_TERMINAL),
                WaitForPageLoad.complete(),
                WaitUntil.the(SfTerminalPage.LOCATION_TEXTBOX, isClickable())
                        .forNoMoreThan(100)
                        .seconds(),
                Enter.theValue(scenarioData.getLocation()).into(SfTerminalPage.LOCATION_TEXTBOX),
                ClickOn.target(SfTerminalPage.DROPDOWN_ITEM.of(scenarioData.getLocation())),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_MAKE_AND_MODEL,
                        scenarioData.getMakeAndModel().getSfMakeAndModelEnum().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_STATUS, scenarioData.getStatus()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_COMMUNICATION_METHOD,
                        scenarioData.getCommunicationMethod().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_CHARGE_EQUIPMENT,
                        scenarioData.getChargeEquipmentCostInclShipping().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_PURCHASE_OR_RENTAL,
                        scenarioData.getPurchaseOrRental().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_CLERK_OR_SERVER_ID_ENABLEMENT,
                        scenarioData.getClerkServerIdEnablement().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_DEFAULT_TERMINAL_SETTINGS,
                        scenarioData.getDefaultTerminalSettings().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_CLERK_OR_SERVER_ID_LABEL,
                        scenarioData.getClerkServerIdLabel().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_TERMINAL_AUTO_BATCH,
                        scenarioData.getTerminalAutoBatch().getSFYesOrNoEnum().getValue()),
                Scroll.to(SfTerminalPage.COMBOBOX_TICKET_NUMBER),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_TICKET_NUMBER,
                        scenarioData.getTicketNumber().getSFYesOrNoEnum().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_AUTO_BATCH_TIME,
                        scenarioData.getAutoBatchTime().getSFAutoBatchTime()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_TABLE_NUMBER,
                        scenarioData.getTableNumber().getSFYesOrNoEnum().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_CASHBACK,
                        scenarioData.getCashback().getSFYesOrNoEnum().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_MERCHANT_RECEIPT_LOGO,
                        scenarioData.getMerchantReceiptLogo().getSFYesOrNoEnum().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_ALPHANUMERIC_INVOICE_NUMBER,
                        scenarioData.getAlphanumericInvoiceNumber().getSFYesOrNoEnum().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_TERMINAL_TYPE,
                        scenarioData.getTerminalType().getValue()),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_TIP_AT_TIME_OF_SALE,
                        scenarioData.getTipAtTimeOfSale().getValue()),
                ClickOn.target(SfTerminalPage.BUTTON_SAVE),
                WaitForPageLoad.complete(),
                RemoveElement.byTarget(SfTerminalPage.ALERT_DIALOG),
                WaitUntil.the(SfTerminalPage.CREATED_TERMINAL_ID_LABEL, isVisible()),
                RememberInfo.forTarget(
                        theActor, SfTerminalPage.CREATED_TERMINAL_ID_LABEL, "sfTerminalId"));

        return Task.where();
    }

    @Step("{0} gets the serial number and Tango ID from the new terminal {1}")
    public static Performable getSerialAndTidFromTheNewTerminal(Actor theActor) {

        String termToSearch = theActor.recall("sfTerminalId");

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
                WaitUntil.the(SfTerminalPage.VALUE_TABLE_SERIAL_NUMBER, isVisible())
                        .forNoMoreThan(100)
                        .seconds());

        while (Text.of(SfTerminalPage.VALUE_TABLE_SERIAL_NUMBER).answeredBy(theActor).isEmpty()) {
            ((JavascriptExecutor) getDriver()).executeScript("window.location.reload(true);");
            theActor.attemptsTo(WaitForPageLoad.complete(), WaitSpecificTime.forSeconds(30));
        }

        theActor.attemptsTo(
                Ensure.that(Text.of(SfTerminalPage.VALUE_TABLE_STATUS).answeredBy(theActor))
                        .isNotEmpty(),
                Ensure.that(Text.of(SfTerminalPage.VALUE_TABLE_SERIAL_NUMBER).answeredBy(theActor))
                        .isNotEmpty(),
                Ensure.that(Text.of(SfTerminalPage.VALUE_TABLE_TANGO_TID).answeredBy(theActor))
                        .isNotEmpty(),
                RememberInfo.forTarget(
                        theActor,
                        SfTerminalPage.VALUE_TABLE_SERIAL_NUMBER,
                        "sfTerminalSerialNumber"),
                RememberInfo.forTarget(
                        theActor, SfTerminalPage.VALUE_TABLE_TANGO_TID, "sfTerminalTangoTID"));

        return Task.where();
    }
}
