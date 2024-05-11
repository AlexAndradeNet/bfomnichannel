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

import com.bf.omnichannel.interactions.PrintResults;
import com.bf.omnichannel.ui.vhq.VhqAppParametersPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.SoftAssertions;

public class VhqAppParametersTasks {

    private VhqAppParametersTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} opens App Parameters and check its content")
    public static Performable checkAppParameters(Actor theActor) {
        theActor.attemptsTo(
                Switch.toDefaultContext(),
                WaitUntil.the(
                        VhqAppParametersPage.SELECT_VALUE.of("EnablePromptClerkID"),
                        isClickable()));

        var softAssertions = new SoftAssertions();

        verifySoftAssertions(softAssertions, theActor, "EnablePromptClerkID", "SELECT", "DISABLED");
        verifySoftAssertions(softAssertions, theActor, "EnableServerID", "SELECT", "DISABLED");
        verifySoftAssertions(softAssertions, theActor, "EnableTicketNumber", "SELECT", "DISABLED");
        verifySoftAssertions(softAssertions, theActor, "EnableAutoBatch", "SELECT", "ENABLED");
        verifySoftAssertions(
                softAssertions, theActor, "AutomaticSettlementProcessingTime", "TEXTBOX", "23:00");
        verifySoftAssertions(softAssertions, theActor, "EnableTableNumber", "SELECT", "DISABLED");
        verifySoftAssertions(softAssertions, theActor, "EnableCashback", "SELECT", "DISABLED");
        verifySoftAssertions(softAssertions, theActor, "EnableLogo", "SELECT", "DISABLED");
        verifySoftAssertions(
                softAssertions, theActor, "EnableSemiIntegration", "SELECT", "DISABLED");
        verifySoftAssertions(softAssertions, theActor, "EnableAcceptTip", "SELECT", "DISABLED");

        theActor.attemptsTo(PrintResults.fromRecall(2));

        softAssertions.assertAll();

        return Task.where();
    }

    private static void verifySoftAssertions(
            SoftAssertions softAssertions,
            Actor theActor,
            String fieldName,
            String fieldType,
            String expectedValue) {
        Target target = VhqAppParametersPage.SELECT_VALUE.of(fieldName);

        if (!fieldType.equals("SELECT")) {
            target = VhqAppParametersPage.TEXTBOX_VALUE.of(fieldName);
        }

        theActor.attemptsTo(Scroll.to(target));

        String currentValue = Text.of(target).answeredBy(theActor);
        if (StringUtils.isEmpty(currentValue)) {
            currentValue = Attribute.of(target).named("value").answeredBy(theActor);
        }

        softAssertions
                .assertThat(currentValue)
                .as("%s should be %s".formatted(fieldName, expectedValue))
                .isEqualTo(expectedValue);

        String resultTag = (expectedValue.equals(currentValue)) ? "PASSED" : "FAILED";

        theActor.remember(fieldName, "%s|%s|%s".formatted(expectedValue, currentValue, resultTag));
    }
}
