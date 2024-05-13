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

import static net.serenitybdd.core.Serenity.getDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

import com.bf.omnichannel.data.SecretsManager;
import com.bf.omnichannel.interactions.ClickOn;
import com.bf.omnichannel.interactions.WaitForPageLoad;
import com.bf.omnichannel.interactions.WaitSpecificTime;
import com.bf.omnichannel.ui.vhq.VhqDashboardPage;
import com.bf.omnichannel.ui.vhq.VhqLoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class VhqLoginTasks {

    private VhqLoginTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} open the main page")
    public static Performable openHomePage(Actor theActor) {
        theActor.attemptsTo(
                Open.url("https://vhqtest.us3.vfivcs.com/"), WaitForPageLoad.complete());
        return Task.where("{0} opens the home page");
    }

    @Step("{0} enters the username and password")
    public static Performable login(Actor theActor) {
        String username = SecretsManager.getInstance().getVhqUsername();
        String password = SecretsManager.getInstance().getVhqPassword();

        theActor.attemptsTo(
                Enter.theValue("nuvei")
                        .into(VhqLoginPage.TEXTBOX_EMAIL_ID_OR_COMPANY)
                        .thenHit(Keys.ENTER),
                WaitForPageLoad.complete(),
                new WaitUntilAngularIsReady(),
                WaitSpecificTime.forSeconds(2));

        ((JavascriptExecutor) getDriver()).executeScript("window.location.reload(true);");

        theActor.attemptsTo(
                WaitForPageLoad.complete(),
                new WaitUntilAngularIsReady(),
                WaitSpecificTime.forSeconds(2),
                Enter.theValue(username).into(VhqLoginPage.TEXTBOX_LOGIN_NAME).thenHit(Keys.TAB),
                Enter.theValue(password).into(VhqLoginPage.TEXTBOX_PASSWORD).thenHit(Keys.TAB),
                WaitSpecificTime.forSeconds(2),
                ClickOn.target(VhqLoginPage.BUTTON_SIGN_ME_IN),
                WaitForPageLoad.complete(),
                new WaitUntilAngularIsReady(),
                WaitUntil.the(VhqDashboardPage.TEXTBOX_SEARCH, isClickable()),
                WaitUntil.the(VhqDashboardPage.OK_MODAL_BUTTON, isClickable())
                        .forNoMoreThan(30)
                        .seconds(),
                ClickOn.target(VhqDashboardPage.OK_MODAL_BUTTON));

        return Task.where("{0} enters the username and password");
    }
}
