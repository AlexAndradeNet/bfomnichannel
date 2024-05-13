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

    private static final String TEXTBOX_LOCATOR_TEMPLATE =
            "//label[starts-with(., '%s')]/following-sibling::*//input";
    private static final String SELECT_LOCATOR_TEMPLATE =
            "//label[starts-with(., '%s')]/following-sibling::*//a[@class='chosen-single']";

    public static final Target ENABLE_TICKET_NUMBER_SELECT =
            Target.the("select control for 'EnableTicketNumber'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableTicketNumber"));

    public static final Target ENABLE_AUTO_BATCH_SELECT =
            Target.the("select control for 'EnableAutoBatch'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableAutoBatch"));

    public static final Target AUTOMATIC_SETTLEMENT_PROCESSING_TIME_SELECT =
            Target.the("textbox for 'AutomaticSettlementProcessingTime'")
                    .locatedBy(
                            TEXTBOX_LOCATOR_TEMPLATE.formatted(
                                    "AutomaticSettlementProcessingTime"));

    public static final Target ENABLE_TABLE_NUMBER_SELECT =
            Target.the("select control for 'EnableTableNumber'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableTableNumber"));

    public static final Target ENABLE_CASHBACK_SELECT =
            Target.the("select control for 'EnableCashback'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableCashback"));

    public static final Target ENABLE_LOGO_SELECT =
            Target.the("select control for 'EnableLogo'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableLogo"));

    public static final Target ENABLE_INVOICE_NUMBER_SELECT =
            Target.the("select control for 'EnableInvoiceNumber'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableInvoiceNumber"));

    public static final Target ENABLE_ACCEPT_TIP_SELECT =
            Target.the("select control for 'EnableAcceptTip'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableAcceptTip"));

    public static final Target ENABLE_PROMPT_CLERK_ID_SELECT =
            Target.the("select control for 'EnablePromptClerkID'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnablePromptClerkID"));

    public static final Target ENABLE_SERVER_ID_SELECT =
            Target.the("select control for 'EnableServerID'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableServerID"));

    public static final Target ENABLE_RETAIL_PULL_MODE_SELECT =
            Target.the("select control for 'EnableRetailPullMode'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableRetailPullMode"));

    public static final Target ENABLE_RESTAURANT_PUSH_MODE_SELECT =
            Target.the("select control for 'EnableRestaurantPushMode'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableRestaurantPushMode"));

    public static final Target ENABLE_SEMI_INTEGRATION_SELECT =
            Target.the("select control for 'EnableSemiIntegration'")
                    .locatedBy(SELECT_LOCATOR_TEMPLATE.formatted("EnableSemiIntegration"));
}
