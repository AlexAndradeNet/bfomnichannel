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
package com.bf.omnichannel.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

import com.bf.omnichannel.interactions.*;
import com.bf.omnichannel.ui.ExternalPage;
import com.bf.omnichannel.ui.HomePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class HomeTasks {

    private HomeTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} open the main page")
    public static Performable openHomePage() {
        return Task.where(
                "{0} opens the home page",
                Open.browserOn().the(HomePage.class),
                WaitForPageLoad.complete(),
                WaitUntil.the(HomePage.TEXT_COUNTRY, isClickable()));
    }

    @Step("{0} select checkbox {1}")
    public static void selectCheckboxOption(Actor actor, String checkboxValue) {
        actor.attemptsTo(ForceClick.on(HomePage.CHECKBOX.of(checkboxValue.toLowerCase())));
    }

    @Step("{0} enter name {1} in alert")
    public static void alertName(Actor actor, String name) {
        actor.attemptsTo(
                Enter.theValue(name).into(HomePage.TEXTBOX_NAME),
                ClickOn.target(HomePage.BUTTON_ALERT));
    }

    @Step("{0} confirm name {1}")
    public static void confirmName(Actor actor, String name) {
        actor.attemptsTo(
                Enter.theValue(name).into(HomePage.TEXTBOX_NAME),
                ClickOn.target(HomePage.BUTTON_CONFIRM));
    }

    @Step("{0} interact with dropdown {1}")
    public static void selectDropdownOption(Actor actor, String option) {
        actor.attemptsTo(SelectDropdown.byVisibleText(HomePage.SELECT, option));
    }

    @Step("{0} select radio button {1}")
    public static void selectRadioButton(Actor actor, String radioButtonValue) {
        actor.attemptsTo(ForceClick.on(HomePage.RADIO_BUTTON.of(radioButtonValue.toLowerCase())));
    }

    @Step("{0} select menu {1}")
    public static void selectMenu(Actor actor, String menuOption) {
        actor.attemptsTo(
                Enter.theValue(menuOption).into(HomePage.TEXT_COUNTRY),
                WaitUntil.the(HomePage.MENU_COUNTRY.of(menuOption), isClickable()),
                ClickOn.target(HomePage.MENU_COUNTRY.of(menuOption)));
    }

    @Step("{0} hover over the button")
    public static void hoverOverTheButton(Actor actor) {
        actor.attemptsTo(HoverOn.target(HomePage.BUTTON_MOUSE_OVER));
    }

    @Step("{0} navigate and interact in iframe {1}")
    public static void navigateAndInteractInIframe(Actor actor, String option) {
        actor.attemptsTo(
                Scroll.to(HomePage.IFRAME),
                Switch.toFrame(HomePage.IFRAME_NAME),
                ClickOn.target(ExternalPage.MENU.of(option)));
    }

    @Step("{0} go to new window and wait before clicking on link {1}")
    public static void goToNewWindowOrTabAndWaitBeforeClickOnLink(Actor actor, String menuOption) {
        actor.attemptsTo(
                WaitForNewPageOrTabAndSwitch.andSwitch(),
                ClickOn.target(ExternalPage.MENU.of(menuOption)));
    }

    @Step("{0} return to the default context")
    public static void returnToTheDefaultContext(Actor actor) {
        actor.attemptsTo(Switch.toDefaultContext());
    }

    @Step("{0} open new tab")
    public static void openNewTab(Actor actor) {
        actor.attemptsTo(ClickOn.target(HomePage.BUTTON_OPEN_TAB));
    }

    @Step("{0} open new window")
    public static void openNewWindow(Actor actor) {
        actor.attemptsTo(ClickOn.target(HomePage.BUTTON_OPEN_WINDOW));
    }

    @Step("{0} hide object")
    public static void hideObject(Actor actor) {
        actor.attemptsTo(ClickOn.target(HomePage.BUTTON_HIDE));
    }

    @Step("{0} show object")
    public static void showObject(Actor actor) {
        actor.attemptsTo(ClickOn.target(HomePage.BUTTON_SHOW));
    }
}
