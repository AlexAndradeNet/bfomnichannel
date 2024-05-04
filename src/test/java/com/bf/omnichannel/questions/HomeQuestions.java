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
package com.bf.omnichannel.questions;

import com.bf.omnichannel.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.AlertText;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.targets.Target;

public class HomeQuestions {

    private HomeQuestions() {
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

    @Subject("{0} verify that the radio button '{1}' is selected")
    public static void ensureRadioButtonIsSelected(Actor actor, String radioButtonValue) {
        verifyOptionIsSelected(
                actor, "radio button", HomePage.RADIO_BUTTON.of(radioButtonValue.toLowerCase()));
    }

    @Subject("{0} verify that the checkbox '{1}' is selected")
    public static void ensureCheckboxOptionIsSelected(Actor actor, String checkboxValue) {
        verifyOptionIsSelected(
                actor, "checkbox", HomePage.CHECKBOX.of(checkboxValue.toLowerCase()));
    }

    @Subject("{0} verify that the menu option '{1}' is selected")
    public static void ensureMenuOptionIsSelected(Actor actor, String menuOption) {
        actor.attemptsTo(
                Ensure.that(HomePage.TEXT_COUNTRY).value().asAString().isEqualTo(menuOption));
    }

    @Subject("{0} verify that the dropdown option '{1}' is selected")
    public static void ensureDropdownOptionIsSelected(Actor actor, String menuOption) {
        actor.attemptsTo(Ensure.that(SelectedOption.from(HomePage.SELECT)).isEqualTo(menuOption));
    }

    @Subject("{0} verify that the alert has the text '{1}'")
    public static void ensureAlertHasText(Actor actor, String expectedText) {
        actor.attemptsTo(Ensure.that(AlertText.currentlyVisible()).isEqualTo(expectedText));
    }

    @Subject("{0} verify that the price is {1}")
    public static void ensurePriceIsCorrect(Actor actor, int price) {
        actor.attemptsTo(
                Scroll.to(HomePage.COURSE_THIRD_PRICE),
                Ensure.that(HomePage.COURSE_THIRD_PRICE).text().isEqualTo(String.valueOf(price)));
    }

    @Subject("{0} verify that the textbox for show/hide is {1}")
    public static void ensureTextboxVisibility(Actor actor, boolean isVisible) {
        actor.attemptsTo(
                Ensure.that(ElementVisibility.of(HomePage.TEXTBOX_SHOW_HIDE)).isEqualTo(isVisible));
    }

    @Subject("{0} verify that the contextual menu is displayed")
    public static void ensureThatTheContextualMenuIsDisplayed(Actor actor) {
        actor.attemptsTo(Ensure.that(HomePage.MENU_MOUSE_OVER).isDisplayed());
    }
}
