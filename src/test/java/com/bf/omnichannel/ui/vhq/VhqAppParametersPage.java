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
package com.bf.omnichannel.ui.vhq;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("page:vhq.url")
public class VhqAppParametersPage extends PageObject {

    private VhqAppParametersPage() {
        super();
    }

    public static final Target TEXTBOX_VALUE =
            Target.the("textbox {0}")
                    .locatedBy("//label[starts-with(., '{0}')]/following-sibling::*//input");

    public static final Target SELECT_VALUE =
            Target.the("select {0}")
                    .locatedBy(
                            "//label[starts-with(.,"
                                    + " '{0}')]/following-sibling::*//a[@class='chosen-single']");
}
