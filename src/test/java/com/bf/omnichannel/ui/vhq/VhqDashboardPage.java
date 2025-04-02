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
public class VhqDashboardPage extends PageObject {

    private VhqDashboardPage() {
        super();
    }

    public static final Target TEXTBOX_SEARCH =
            Target.the("textbox Search")
                    .locatedBy("//input[@type='text' and @placeholder='Search by Serial Number']");

    public static final Target LICENSES_COUNT_SPAN =
            Target.the("span Licenses count")
                    .locatedBy("//span[@id='CW_TOTAL_DEVICE_COUNTcounterCountPro']");

    public static final Target OK_LICENCES_BUTTON =
            Target.the("button Ok Modal").locatedBy("//button[@id='pbtnOK']");

    public static final Target OK_INFO_BUTTON =
            Target.the("button Ok Modal").locatedBy("//button[@id='infoBtnOk']");
}
