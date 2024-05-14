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

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class RemoveElement implements Interaction {

    private final Target target;
    private final WebElement element;

    public RemoveElement(Target target) {
        this.target = target;
        this.element = null;
    }

    public RemoveElement(WebElement element) {
        this.element = element;
        this.target = null;
    }

    public static RemoveElement byTarget(Target target) {
        return new RemoveElement(target);
    }

    public static RemoveElement byElement(WebElement element) {
        return new RemoveElement(element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        try {
            if (target != null) {
                js.executeScript(
                        "arguments[0].parentNode.removeChild(arguments[0])",
                        target.resolveFor(actor));
            } else if (element != null) {
                js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", element);
            }
        } catch (NoSuchElementException ignored) {
            // Do nothing
        }
    }
}
