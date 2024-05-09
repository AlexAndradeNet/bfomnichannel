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

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.bf.omnichannel.interactions.ClickOn;
import com.bf.omnichannel.interactions.ClickOnTargetAndDropdownItem;
import com.bf.omnichannel.interactions.RemoveElement;
import com.bf.omnichannel.interactions.WaitForPageLoad;
import com.bf.omnichannel.ui.salesforce.SfTerminalPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.jetbrains.annotations.NotNull;

public class SfTerminalTasks {

    private SfTerminalTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} adds a new terminal on location '{1}'")
    public static Performable addNewTerminal(@NotNull String desiredLocation) {
        return Task.where(
                ClickOn.target(SfTerminalPage.BUTTON_NEW_TERMINAL),
                WaitForPageLoad.complete(),
                WaitUntil.the(SfTerminalPage.LOCATION_TEXTBOX, isClickable()),
                Enter.theValue(desiredLocation).into(SfTerminalPage.LOCATION_TEXTBOX),
                ClickOn.target(SfTerminalPage.DROPDOWN_ITEM.of(desiredLocation)),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_MAKE_AND_MODEL, "Verifone Android Model T650c"),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_STATUS, "Submitted"),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_COMMUNICATION_METHOD, "IP/SSL"),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_CHARGE_EQUIPMENT, "Partner"),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_PURCHASE_OR_RENTAL, "Purchase from Nuvei"),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_DEFAULT_TERMINAL_SETTINGS,
                        "RETAIL with Tip Set-up"),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_TERMINAL_AUTO_BATCH, "Yes"),
                Scroll.to(SfTerminalPage.COMBOBOX_AUTO_BATCH_TIME),
                ClickOnTargetAndDropdownItem.thenSelect(
                        SfTerminalPage.COMBOBOX_AUTO_BATCH_TIME, "23:00"),
                ClickOn.target(SfTerminalPage.BUTTON_SAVE),
                WaitForPageLoad.complete(),
                RemoveElement.byTarget(SfTerminalPage.ALERT_DIALOG),
                WaitUntil.the(SfTerminalPage.CREATED_TERMINAL_ID_LABEL, isVisible()));
    }
}
