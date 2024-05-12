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

import com.bf.omnichannel.enums.salesforce.SfClerkOrServerIDLabelEnum;
import com.bf.omnichannel.enums.salesforce.SfDefaultTerminalSettingsEnum;
import com.bf.omnichannel.enums.salesforce.SfTerminalTypeEnum;
import com.bf.omnichannel.enums.salesforce.SfYesOrNoEnum;
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
    private String communicationMethod;
    private String chargeEquipmentCostInclShipping;
    private String purchaseOrRental;
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
    private String vhqClerkID;
    private String vhqServerID;
    private String vhqSemiIntegration;
}
