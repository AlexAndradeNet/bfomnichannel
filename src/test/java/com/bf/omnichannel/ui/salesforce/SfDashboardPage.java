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

    public static final Target MENU_MORE = Target.the("menu more").locatedBy("//a/span[.='More']");

    public static final Target MENU_BY_TEXT =
            Target.the("menu {0}").locatedBy("//one-app-nav-bar-menu-item[.='{0}']");

    public static final Target SEARCH_BUTTON =
            Target.the("button seachbox").locatedBy("//button[.='Search...']");

    public static final Target SEARCH_TEXTBOX =
            Target.the("textbox seach").locatedBy("//input[@placeholder='Search...']");

    public static final Target FOUND_TERM_LINK =
            Target.the("link found term {0}").locatedBy("//a[text()='{0}']");

    public static void waitUntilPageIsLoaded() {
        WaitUntil.the(SEARCH_BUTTON, isClickable());
    }
}
