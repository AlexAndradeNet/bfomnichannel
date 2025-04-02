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
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitUntilTextChange implements Interaction {

    private final Target target;
    private final String originalText;

    public WaitUntilTextChange(Target target, String originalText) {
        this.target = target;
        this.originalText = originalText;
    }

    public static Performable from(Target target, String originalText) {
        return new WaitUntilTextChange(target, originalText);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(
                        ExpectedConditions.not(
                                ExpectedConditions.textToBePresentInElement(
                                        target.resolveFor(actor), originalText))));
    }
}
