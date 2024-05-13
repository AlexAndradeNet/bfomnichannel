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
package com.bf.omnichannel.pojo;

import com.bf.omnichannel.enums.salesforce.*;
import com.bf.omnichannel.enums.vhq.VhqEnabledOrDisabledEnum;
import com.bf.omnichannel.pojo.auxiliar.AutoBatchTimePojo;
import com.bf.omnichannel.pojo.auxiliar.MakeAndModelPojo;
import com.bf.omnichannel.pojo.auxiliar.YesNoEnabledDisabledPojo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScenarioDataPojo {
    private String location;
    private MakeAndModelPojo makeAndModel;
    private String status;
    private SfCommunicationMethodEnum communicationMethod;
    private SfChargeEquipmentEnum chargeEquipmentCostInclShipping;
    private SfPurchaseOrRentalEnum purchaseOrRental;
    private SfYesOrNoEnum clerkServerIdEnablement;
    private SfClerkOrServerIDLabelEnum clerkServerIdLabel;
    private SfDefaultTerminalSettingsEnum defaultTerminalSettings;
    private YesNoEnabledDisabledPojo ticketNumber;
    private YesNoEnabledDisabledPojo terminalAutoBatch;
    private AutoBatchTimePojo autoBatchTime;
    private YesNoEnabledDisabledPojo tableNumber;
    private YesNoEnabledDisabledPojo cashback;
    private YesNoEnabledDisabledPojo merchantReceiptLogo;
    private YesNoEnabledDisabledPojo alphanumericInvoiceNumber;
    private SfTerminalTypeEnum terminalType;
    private YesNoEnabledDisabledPojo tipAtTimeOfSale;
    private VhqEnabledOrDisabledEnum vhqClerkID;
    private VhqEnabledOrDisabledEnum vhqServerID;
    private VhqEnabledOrDisabledEnum vhqRetailPullMode;
    private VhqEnabledOrDisabledEnum vhqRestaurantPushMode;
    private VhqEnabledOrDisabledEnum vhqSemiIntegration;
}
