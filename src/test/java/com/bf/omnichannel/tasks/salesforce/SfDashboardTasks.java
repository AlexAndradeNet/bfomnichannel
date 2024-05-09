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

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

import com.bf.omnichannel.interactions.*;
import com.bf.omnichannel.ui.salesforce.SfDashboardPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

public class SfDashboardTasks {

    private SfDashboardTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} opens Terminals page by menu")
    public static Performable openTerminalsPage() {
        return openPageByMenu("Terminals");
    }

    @Step("{0} opens Cases page by menu")
    public static Performable openCasesPage() {
        return openPageByMenu("Cases");
    }

    public static Performable openPageByMenu(String menuOption) {
        return Task.where(
                ClickOn.target(SfDashboardPage.MENU_MORE),
                WaitUntil.the(SfDashboardPage.MENU_BY_TEXT.of(menuOption), isClickable()),
                Scroll.to(SfDashboardPage.MENU_BY_TEXT.of(menuOption)),
                ClickOn.target(SfDashboardPage.MENU_BY_TEXT.of(menuOption)),
                WaitForPageLoad.complete());
    }

    @Step("{0} Search the location {1}")
    public static Performable searchByTerm(String searchedTerm) {
        return Task.where(
                ClickOn.target(SfDashboardPage.SEARCH_BUTTON),
                Enter.theValue(searchedTerm)
                        .into(SfDashboardPage.SEARCH_TEXTBOX)
                        .thenHit(Keys.ENTER),
                WaitForPageLoad.complete(),
                Scroll.to(SfDashboardPage.FOUND_TERM_LINK.of(searchedTerm)));
    }
}
