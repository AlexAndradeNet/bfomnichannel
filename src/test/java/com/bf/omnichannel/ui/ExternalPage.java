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
package com.bf.omnichannel.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ExternalPage {
    private ExternalPage() {
        super();
    }

    public static final Target MENU =
            Target.the("menu {0} into Iframe").locatedBy("(//a[contains(text(), '{0}')])[1]");

    public static final Target PAGE_TITLE = Target.the("New page title").locatedBy("//h1");
}
