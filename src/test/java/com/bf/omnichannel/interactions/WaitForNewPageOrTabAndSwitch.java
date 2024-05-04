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

import java.time.Duration;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForNewPageOrTabAndSwitch implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();
        String originalHandle = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(windowsOrTabs -> driver.getWindowHandles().size() > 1);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        WaitForPageLoad.complete().performAs(actor);
    }

    public static Interaction andSwitch() {
        return new WaitForNewPageOrTabAndSwitch();
    }
}
