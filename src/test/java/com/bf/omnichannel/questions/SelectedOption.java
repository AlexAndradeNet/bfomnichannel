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
package com.bf.omnichannel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectedOption implements Question<String> {
    private final Target dropdown;

    public SelectedOption(Target dropdown) {
        this.dropdown = dropdown;
    }

    public static Question<String> from(Target dropdown) {
        return new SelectedOption(dropdown);
    }

    @Override
    public String answeredBy(Actor actor) {
        WebElement dropdownElement = dropdown.resolveFor(actor);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getText();
    }
}
