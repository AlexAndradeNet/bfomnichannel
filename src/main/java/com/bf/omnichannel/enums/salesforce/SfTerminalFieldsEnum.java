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
package com.bf.omnichannel.enums.salesforce;

import com.bf.omnichannel.enums.EnumUtils;
import com.bf.omnichannel.enums.IValuableEnum;
import lombok.Getter;

@Getter
public enum SfTerminalFieldsEnum implements IValuableEnum {
    LOCATION("Location"),
    COMPANY_PROFILE("Company Profile"),
    MAKE_AND_MODEL("Make and Model"),
    STATUS("Status"),
    COMMUNICATION_METHOD("Communication Method"),
    CHARGE_EQUIPMENT_COST("Charge Equipment Cost incl. Shipping"),
    PURCHASE_OR_RENTAL("Purchase or Rental"),
    CLERK_SERVER_ID_ENABLEMENT("Clerk/Server ID Enablement"),
    CLERK_SERVER_ID_LABEL("Clerk/Server ID Label"),
    DEFAULT_TERMINAL_SETTINGS("Default Terminal Settings"),
    TICKET_NUMBER("Ticket Number"),
    TERMINAL_AUTO_BATCH("Terminal Auto Batch"),
    AUTO_BATCH_TIME("Auto Batch Time"),
    TABLE_NUMBER("Table Number"),
    CASHBACK("Cashback"),
    MERCHANT_RECEIPT_LOGO("Merchant Receipt Logo"),
    ALPHANUMERIC_INVOICE_NUMBER("Alphanumeric Invoice number"),
    TERMINAL_TYPE("Terminal Type"),
    TIP_AT_TIME_OF_SALE("Tip at Time of Sale"),
    ;

    private final String value;

    SfTerminalFieldsEnum(String value) {
        this.value = value;
    }

    // Use the helper method from EnumUtils
    public static SfTerminalFieldsEnum fromValue(String s) {
        return EnumUtils.fromValue(SfTerminalFieldsEnum.class, s);
    }
}
