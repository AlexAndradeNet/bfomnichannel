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
import com.bf.omnichannel.pojo.ScenarioDataPojo;
import com.bf.omnichannel.ui.vhq.VhqAppParametersPage;
import com.bf.omnichannel.utils.RegexTextExtractor;
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

        ScenarioDataPojo scenarioData = theActor.recall("scenarioData");

        theActor.attemptsTo(
                Switch.toDefaultContext(),
                WaitUntil.the(VhqAppParametersPage.ENABLE_PROMPT_CLERK_ID_SELECT, isClickable())
                        .forNoMoreThan(100)
                        .seconds());

        var softAssertions = new SoftAssertions();

        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_PROMPT_CLERK_ID_SELECT,
                scenarioData.getVhqClerkID().getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_INVOICE_NUMBER_SELECT,
                scenarioData
                        .getAlphanumericInvoiceNumber()
                        .getVhqEnabledOrDisabledEnum()
                        .getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_SERVER_ID_SELECT,
                scenarioData.getVhqServerID().getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_TABLE_NUMBER_SELECT,
                scenarioData.getTableNumber().getVhqEnabledOrDisabledEnum().getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_TICKET_NUMBER_SELECT,
                scenarioData.getTicketNumber().getVhqEnabledOrDisabledEnum().getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.AUTOMATIC_SETTLEMENT_PROCESSING_TIME_SELECT,
                scenarioData.getAutoBatchTime().getVhqAutoBatchTime());

        theActor.attemptsTo(Scroll.to(VhqAppParametersPage.ENABLE_RETAIL_PULL_MODE_SELECT));

        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_RETAIL_PULL_MODE_SELECT,
                scenarioData.getVhqRetailPullMode().getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_RESTAURANT_PUSH_MODE_SELECT,
                scenarioData.getVhqRestaurantPushMode().getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_SEMI_INTEGRATION_SELECT,
                scenarioData.getVhqSemiIntegration().getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_CASHBACK_SELECT,
                scenarioData.getCashback().getVhqEnabledOrDisabledEnum().getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_AUTO_BATCH_SELECT,
                scenarioData.getTerminalAutoBatch().getVhqEnabledOrDisabledEnum().getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_LOGO_SELECT,
                scenarioData.getMerchantReceiptLogo().getVhqEnabledOrDisabledEnum().getValue());
        verifySoftAssertions(
                softAssertions,
                theActor,
                VhqAppParametersPage.ENABLE_ACCEPT_TIP_SELECT,
                scenarioData.getVhqAcceptTips().getValue());

        theActor.attemptsTo(PrintResults.fromRecall(2));

        softAssertions.assertAll();

        return Task.where();
    }

    private static void verifySoftAssertions(
            SoftAssertions softAssertions, Actor theActor, Target target, String expectedValue) {

        String currentValue = Text.of(target).answeredBy(theActor);
        if (StringUtils.isEmpty(currentValue)) {
            currentValue = Attribute.of(target).named("value").answeredBy(theActor);
        }

        String fieldName = RegexTextExtractor.get(target.getName(), "'(.*)'");

        softAssertions
                .assertThat(currentValue)
                .as("%s should be %s".formatted(fieldName, expectedValue))
                .isEqualTo(expectedValue);

        String resultTag = (expectedValue.equals(currentValue)) ? "PASSED" : "FAILED";

        theActor.remember(fieldName, "%s|%s|%s".formatted(expectedValue, currentValue, resultTag));
    }
}
