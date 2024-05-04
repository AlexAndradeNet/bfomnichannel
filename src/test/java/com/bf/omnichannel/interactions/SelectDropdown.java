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

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;

public class SelectDropdown implements Interaction {
    private final Target dropdown;
    private final String option;

    public SelectDropdown(Target dropdown, String option) {
        this.dropdown = dropdown;
        this.option = option;
    }

    public static Interaction byVisibleText(Target dropdown, String option) {
        return instrumented(SelectDropdown.class, dropdown, option);
    }

    @Override
    @Step("{0} selects '#option' from #dropdown")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectFromOptions.byVisibleText(option).from(dropdown));
    }
}
