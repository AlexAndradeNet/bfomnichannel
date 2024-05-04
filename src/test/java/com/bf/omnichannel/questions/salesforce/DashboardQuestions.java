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
package com.bf.omnichannel.questions.salesforce;

import static com.bf.omnichannel.ui.salesforce.SfDashboardPage.BUTTON_SEARCH;

import com.bf.omnichannel.questions.ElementVisibility;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.AlertText;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.targets.Target;

public class DashboardQuestions {

    private DashboardQuestions() {
        throw new IllegalStateException("Utility class");
    }

    @Subject("{0} verify that the '{1}' option is selected")
    public static void verifyOptionIsSelected(Actor actor, String optionType, Target target) {
        actor.attemptsTo(
                Ensure.that(
                                "Verifying if the option '" + optionType + "' is selected",
                                Attribute.of(target).named("selected").asBoolean())
                        .isTrue());
    }

    @Subject("{0} verify that the alert has the text '{1}'")
    public static void ensureAlertHasText(Actor actor, String expectedText) {
        actor.attemptsTo(Ensure.that(AlertText.currentlyVisible()).isEqualTo(expectedText));
    }

    public static void ensureSearchBarIsVisible(Actor actor) {
        actor.attemptsTo(Ensure.that(ElementVisibility.of(BUTTON_SEARCH)).isTrue());
    }
}
