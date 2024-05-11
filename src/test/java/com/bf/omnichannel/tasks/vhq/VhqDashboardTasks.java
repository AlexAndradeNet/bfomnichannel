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

import com.bf.omnichannel.interactions.WaitForPageLoad;
import com.bf.omnichannel.ui.vhq.VhqDashboardPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class VhqDashboardTasks {

    private VhqDashboardTasks() {
        throw new IllegalStateException("Utility class");
    }

    @Step("{0} Search the location {1}")
    public static Performable searchByTerm(Actor theActor, String searchedTerm) {

        theActor.attemptsTo(
                Enter.theValue(searchedTerm)
                        .into(VhqDashboardPage.TEXTBOX_SEARCH)
                        .thenHit(Keys.ENTER),
                WaitForPageLoad.complete());
        return Task.where();
    }
}
