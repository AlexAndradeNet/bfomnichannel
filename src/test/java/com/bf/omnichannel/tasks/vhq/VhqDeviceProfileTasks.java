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
package com.bf.omnichannel.tasks.vhq;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

import com.bf.omnichannel.interactions.ClickOn;
import com.bf.omnichannel.interactions.RemoveElement;
import com.bf.omnichannel.interactions.WaitForPageLoad;
import com.bf.omnichannel.interactions.WaitSpecificTime;
import com.bf.omnichannel.ui.vhq.VhqDeviceProfilePage;
import com.bf.omnichannel.utils.SimpleLogger;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class VhqDeviceProfileTasks {

    private static final SimpleLogger logger = new SimpleLogger(VhqDeviceProfileTasks.class);

    private VhqDeviceProfileTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} checks the terminal's serial number '{1}' and device id '{2}'")
    public static Performable checkSerialAndDeviceId(
            Actor theActor, String serialNumber, String tid) {
        theActor.attemptsTo(Switch.toFrame(VhqDeviceProfilePage.IFRAME_NAME));
        theActor.attemptsTo(
                Ensure.that(VhqDeviceProfilePage.MODEL_LABEL.of("T650c")).isDisplayed(),
                Ensure.that(VhqDeviceProfilePage.VALUE_LABEL.of("Serial Number"))
                        .hasText(serialNumber),
                Ensure.that(VhqDeviceProfilePage.VALUE_LABEL.of("Device ID")).hasText(tid));
        logger.info(
                "serialNumber: "
                        + Text.of(VhqDeviceProfilePage.VALUE_LABEL.of("Serial Number"))
                                .answeredBy(theActor));
        return Task.where();
    }

    @Step("{0} opens App Parameters and check its content")
    public static Performable openAppParameters(Actor theActor) {
        theActor.attemptsTo(
                ClickOn.target(VhqDeviceProfilePage.TAB_TITLE.of("Details")),
                WaitForPageLoad.complete(),
                WaitUntil.the(VhqDeviceProfilePage.TABLE_TITLE.of("Name"), isClickable()),
                RemoveElement.byTarget(
                        VhqDeviceProfilePage.TAB_TITLE.of(
                                "Diagnostic Profile")), // Prevent hover behavior that blocks the
                // next click
                WaitSpecificTime.forSeconds(2),
                ClickOn.target(VhqDeviceProfilePage.TAB_TITLE.of("Parameters")),
                WaitForPageLoad.complete(),
                WaitUntil.the(VhqDeviceProfilePage.TABLE_TITLE.of("Applications"), isClickable()),
                ClickOn.target(VhqDeviceProfilePage.BUTTON_PARAMETERS_APP_EDIT),
                WaitForPageLoad.complete());
        return Task.where();
    }
}
