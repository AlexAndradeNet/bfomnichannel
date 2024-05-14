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

import static com.bf.omnichannel.RunnerCucumberTestSuite.TEST_ONLY_VHQ;
import static net.serenitybdd.core.Serenity.getDriver;

import com.bf.omnichannel.data.SecretsManager;
import com.bf.omnichannel.interactions.ClickOn;
import com.bf.omnichannel.interactions.WaitForPageLoad;
import com.bf.omnichannel.ui.salesforce.SfLoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.jetbrains.annotations.NotNull;

public class SfLoginTasks {

    private SfLoginTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} open the main page")
    public static Performable openHomePage(@NotNull Actor theActor) {
        theActor.attemptsTo(Open.browserOn().the(SfLoginPage.class), WaitForPageLoad.complete());
        return Task.where("{0} opens the home page");
    }

    @Step("{0} enters the username and password")
    public static Performable login(@NotNull Actor theActor) {
        if (TEST_ONLY_VHQ) {
            return Task.where("{0} testing only VHQ now, skipping login to Salesforce");
        }

        if (isAlreadyLoggedIn()) {
            return Task.where("{0} is already logged in");
        }

        String username = SecretsManager.getInstance().getSalesForceUsername();
        String password = SecretsManager.getInstance().getSalesForcePassword();

        theActor.attemptsTo(
                Enter.theValue(username).into(SfLoginPage.TEXTBOX_USERNAME),
                Enter.theValue(password).into(SfLoginPage.TEXTBOX_PASSWORD),
                ClickOn.target(SfLoginPage.BUTTON_LOGIN),
                WaitForPageLoad.complete());

        return Task.where("{0} enters the username and password");
    }

    private static boolean isAlreadyLoggedIn() {
        String currentUrl = getDriver().getCurrentUrl();
        return (currentUrl.contains("/lightning") || currentUrl.contains("/one"));
    }
}
