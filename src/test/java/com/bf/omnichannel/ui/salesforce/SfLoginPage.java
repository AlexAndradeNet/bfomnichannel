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
package com.bf.omnichannel.ui.salesforce;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

@DefaultUrl("page:home.page")
public class SfLoginPage extends PageObject {

    private SfLoginPage() {
        super();
    }

    public static final Target TEXTBOX_USERNAME =
            Target.the("textbox username").locatedBy("//input[@type='email' and @id='username']");

    public static final Target TEXTBOX_PASSWORD =
            Target.the("textbox password")
                    .locatedBy("//input[@type='password' and @id='password']");

    public static final Target BUTTON_LOGIN =
            Target.the("button Log In to Sandbox")
                    .locatedBy("//input[@type='submit' and @value='Log In to Sandbox']");

    public static void waitUntilPageIsLoaded() {
        WaitUntil.the(TEXTBOX_USERNAME, isClickable());
    }
}
