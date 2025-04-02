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
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.jetbrains.annotations.NotNull;

public class RememberInfo implements Interaction {

    private final Target target;
    private final String serenityVariableName;

    public RememberInfo(Target target, String serenityVariableName) {
        this.target = target;
        this.serenityVariableName = serenityVariableName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember(serenityVariableName, Text.of(target).answeredBy(actor));
    }

    public static RememberInfo forTarget(
            @NotNull Actor theActor, Target target, String serenityVariableName) {
        return new RememberInfo(target, serenityVariableName);
    }
}
