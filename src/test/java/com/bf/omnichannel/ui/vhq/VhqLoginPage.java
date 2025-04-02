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
package com.bf.omnichannel.ui.vhq;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("page:vhq.url")
public class VhqLoginPage extends PageObject {

    private VhqLoginPage() {
        super();
    }

    public static final Target TEXTBOX_EMAIL_ID_OR_COMPANY =
            Target.the("textbox Email ID or Company")
                    .locatedBy("//input[@type='text' and @placeholder='Email ID or Company']");

    public static final Target TEXTBOX_LOGIN_NAME =
            Target.the("textbox Login name")
                    .locatedBy("//input[@type='text' and @placeholder='Login name']");

    public static final Target TEXTBOX_PASSWORD =
            Target.the("textbox Login name")
                    .locatedBy("//input[@type='password' and @placeholder='Password']");

    public static final Target BUTTON_SIGN_ME_IN =
            Target.the("button sign me in").locatedBy("//button[.='Sign me in']");
}
