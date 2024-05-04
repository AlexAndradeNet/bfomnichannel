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

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ForceClick implements Interaction {
    private final Target target;

    public ForceClick(Target target) {
        this.target = target;
    }

    public static Interaction on(Target target) {
        return new ForceClick(target);
    }

    @Override
    @Step("{0} forcefully clicks on #target")
    public <T extends Actor> void performAs(T actor) {
        WebElement webElement = target.resolveFor(actor);
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("arguments[0].click();", webElement);
    }
}
