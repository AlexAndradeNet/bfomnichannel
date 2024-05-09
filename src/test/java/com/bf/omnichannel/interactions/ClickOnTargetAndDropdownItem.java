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

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

public class ClickOnTargetAndDropdownItem implements Interaction {

    private final Target target;
    private final String dropdownItemText;

    public ClickOnTargetAndDropdownItem(Target target, String dropdownItemText) {
        this.target = target;
        this.dropdownItemText = dropdownItemText;
    }

    public static ClickOnTargetAndDropdownItem thenSelect(Target target, String dropdownItemText) {
        return instrumented(ClickOnTargetAndDropdownItem.class, target, dropdownItemText);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        final Target DROPDOWN_ITEM =
                Target.the("dropdown for '{0}'")
                        .locatedBy("//lightning-base-combobox-item[.='{0}']");

        actor.attemptsTo(
                ClickOn.target(target), ClickOn.target(DROPDOWN_ITEM.of(dropdownItemText)));
    }
}
