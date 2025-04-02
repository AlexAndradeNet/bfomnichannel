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
package com.bf.omnichannel.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class WaitForPageTitleChange implements Interaction {

    private final String expectedTitle;

    public WaitForPageTitleChange(String expectedTitle) {
        this.expectedTitle = expectedTitle;
    }

    public static Performable to(String expectedTitle) {
        return new WaitForPageTitleChange(expectedTitle);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(
                        dummy -> !TheWebPage.title().answeredBy(actor).equals(expectedTitle)));
    }
}
