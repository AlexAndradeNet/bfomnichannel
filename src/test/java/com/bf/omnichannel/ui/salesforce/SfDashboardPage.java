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
public class SfDashboardPage extends PageObject {

    private SfDashboardPage() {
        super();
    }

    public static final Target BUTTON_SEARCH =
            Target.the("button seachbox").locatedBy("//button[.='Search...']");

    public static void waitUntilPageIsLoaded() {
        WaitUntil.the(BUTTON_SEARCH, isClickable());
    }
}
