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

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElementVisibility implements Question<Boolean> {
    private final Target target;

    private ElementVisibility(Target target) {
        this.target = target;
    }

    public static Question<Boolean> of(Target target) {
        return new ElementVisibility(target);
    }

    @Override
    @Step("{0} checks if #target is visible")
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).isVisible();
    }
}
