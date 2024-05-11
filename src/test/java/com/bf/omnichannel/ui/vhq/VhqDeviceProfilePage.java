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
public class VhqDeviceProfilePage extends PageObject {

    private VhqDeviceProfilePage() {
        super();
    }

    public static final Target LABEL_NETWORK_CONFIGURATION =
            Target.the("label Network Configuration")
                    .locatedBy("//td[contains(., 'Network Configuration')]/following-sibling::td");

    public static final String IFRAME_NAME = "iframeDeviceLiteDiv";

    public static final Target MODEL_LABEL =
            Target.the("label for model {0}").locatedBy("//span[.='Model : {0} ']");

    public static final Target VALUE_LABEL =
            Target.the("label {0}").locatedBy("//div[@class='row' and contains(., '{0}')]/div[2]");

    public static final Target TAB_TITLE =
            Target.the("tab {0}")
                    .locatedBy("//div[@class='mat-tab-label-content' and contains(., '{0}')]");

    public static final Target TABLE_TITLE =
            Target.the("table title").locatedBy("//span[text()='{0}']");

    public static final Target SPINNER =
            Target.the("tab Parameters").locatedBy("//div[@id='loadingDiv']");

    public static final Target BUTTON_PARAMETERS_APP_EDIT =
            Target.the("button App Parameters (com.nuvei.xx)").locatedBy("(//a[.='Edit'])[4]");
}
