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

import com.bf.omnichannel.data.SecretsManager;
import com.bf.omnichannel.interactions.*;
import com.bf.omnichannel.ui.salesforce.SfLoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class LoginTasks {

    private LoginTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} open the main page")
    public static Performable openHomePage() {
        return Task.where(
                "{0} opens the home page",
                Open.browserOn().the(SfLoginPage.class), WaitForPageLoad.complete());
    }

    @Step("{0} enters the username and password")
    public static Performable login() {
        String username = SecretsManager.getInstance().getUsername();
        String password = SecretsManager.getInstance().getPassword();

        return Task.where(
                "{0} enters the username and password",
                Enter.theValue(username).into(SfLoginPage.TEXTBOX_USERNAME),
                Enter.theValue(password).into(SfLoginPage.TEXTBOX_PASSWORD),
                ClickOn.target(SfLoginPage.BUTTON_LOGIN));
    }
}
