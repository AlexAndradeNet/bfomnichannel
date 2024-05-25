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
package com.bf.omnichannel.ui.salesforce;

import com.bf.omnichannel.enums.salesforce.SfTerminalFieldsEnum;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("page:home.page")
public class SfTerminalPage extends PageObject {

    private SfTerminalPage() {
        super();
    }

    private static final String COMBOBOX_LOCATOR_TEMPLATE =
            "//button[starts-with(@id, 'combobox') and contains(@aria-label, '%s')]";

    public static final Target BUTTON_NEW_TERMINAL =
            Target.the("button new terminal").locatedBy("//li[.='New']");

    public static final Target COMBOBOX_MAKE_AND_MODEL =
            Target.the("combobox " + SfTerminalFieldsEnum.MAKE_AND_MODEL.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.MAKE_AND_MODEL.getValue()));

    public static final Target COMBOBOX_COMMUNICATION_METHOD =
            Target.the("combobox " + SfTerminalFieldsEnum.COMMUNICATION_METHOD.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.COMMUNICATION_METHOD.getValue()));

    public static final Target COMBOBOX_CHARGE_EQUIPMENT =
            Target.the("combobox " + SfTerminalFieldsEnum.CHARGE_EQUIPMENT_COST.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.CHARGE_EQUIPMENT_COST.getValue()));

    public static final Target COMBOBOX_CLERK_OR_SERVER_ID_ENABLEMENT =
            Target.the("combobox " + SfTerminalFieldsEnum.CLERK_SERVER_ID_ENABLEMENT.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.CLERK_SERVER_ID_ENABLEMENT.getValue()));

    public static final Target COMBOBOX_CLERK_OR_SERVER_ID_LABEL =
            Target.the("combobox " + SfTerminalFieldsEnum.CLERK_SERVER_ID_LABEL.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.CLERK_SERVER_ID_LABEL.getValue()));

    public static final Target COMBOBOX_TICKET_NUMBER =
            Target.the("combobox " + SfTerminalFieldsEnum.TICKET_NUMBER.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.TICKET_NUMBER.getValue()));

    public static final Target COMBOBOX_TABLE_NUMBER =
            Target.the("combobox " + SfTerminalFieldsEnum.TABLE_NUMBER.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.TABLE_NUMBER.getValue()));

    public static final Target COMBOBOX_MERCHANT_RECEIPT_LOGO =
            Target.the("combobox " + SfTerminalFieldsEnum.MERCHANT_RECEIPT_LOGO.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.MERCHANT_RECEIPT_LOGO.getValue()));

    public static final Target COMBOBOX_TERMINAL_TYPE =
            Target.the("combobox " + SfTerminalFieldsEnum.TERMINAL_TYPE.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.TERMINAL_TYPE.getValue()));

    // Right panel

    public static final Target LOCATION_TEXTBOX =
            Target.the("combobox location")
                    .locatedBy("//input[@placeholder='Search Locations...']");

    public static final Target COMBOBOX_STATUS =
            Target.the("combobox " + SfTerminalFieldsEnum.STATUS.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.STATUS.getValue()));

    public static final Target COMBOBOX_PURCHASE_OR_RENTAL =
            Target.the("combobox " + SfTerminalFieldsEnum.PURCHASE_OR_RENTAL.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.PURCHASE_OR_RENTAL.getValue()));

    public static final Target COMBOBOX_DEFAULT_TERMINAL_SETTINGS =
            Target.the("combobox " + SfTerminalFieldsEnum.DEFAULT_TERMINAL_SETTINGS.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.DEFAULT_TERMINAL_SETTINGS.getValue()));

    public static final Target COMBOBOX_TERMINAL_AUTO_BATCH =
            Target.the("combobox " + SfTerminalFieldsEnum.TERMINAL_AUTO_BATCH.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.TERMINAL_AUTO_BATCH.getValue()));

    public static final Target COMBOBOX_AUTO_BATCH_TIME =
            Target.the("combobox " + SfTerminalFieldsEnum.AUTO_BATCH_TIME.getValue())
                    .locatedBy("//input[@name='Auto_Batch_Time__c']");

    public static final Target COMBOBOX_CASHBACK =
            Target.the("combobox " + SfTerminalFieldsEnum.CASHBACK.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.CASHBACK.getValue()));

    public static final Target COMBOBOX_ALPHANUMERIC_INVOICE_NUMBER =
            Target.the("combobox " + SfTerminalFieldsEnum.ALPHANUMERIC_INVOICE_NUMBER.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.ALPHANUMERIC_INVOICE_NUMBER.getValue()));

    public static final Target COMBOBOX_TIP_AT_TIME_OF_SALE =
            Target.the("combobox " + SfTerminalFieldsEnum.TIP_AT_TIME_OF_SALE.getValue())
                    .locatedBy(
                            COMBOBOX_LOCATOR_TEMPLATE.formatted(
                                    SfTerminalFieldsEnum.TIP_AT_TIME_OF_SALE.getValue()));

    public static final Target BUTTON_SAVE =
            Target.the("button save").locatedBy("//button[text()='Save']");

    public static final Target CREATED_TERMINAL_ID_LABEL =
            Target.the("label ID of new created terminal")
                    .locatedBy(
                            "//span[text()='Terminal']/ancestor::dt/following-sibling::dd//lightning-formatted-text");

    public static final Target ALERT_DIALOG =
            Target.the("icon close info").locatedBy("//div[@role='alertdialog']");

    // General dropdown

    public static final Target DROPDOWN_ITEM =
            Target.the("dropdown for '{0}'").locatedBy("//lightning-base-combobox-item[.='{0}']");

    // Printing version

    private static final String TABLE_ITEM_LOCATOR_TEMPLATE =
            "//td[text()='%s']/following-sibling::td[1]";

    public static final Target VALUE_TABLE_SERIAL_NUMBER =
            Target.the("table value of 'Serial Number'")
                    .locatedBy(TABLE_ITEM_LOCATOR_TEMPLATE.formatted("Serial Number"));

    public static final Target VALUE_TABLE_STATUS =
            Target.the("table value of 'Status'")
                    .locatedBy(TABLE_ITEM_LOCATOR_TEMPLATE.formatted("Status"));

    public static final Target VALUE_TABLE_TANGO_TID =
            Target.the("table value of 'Tango TID'")
                    .locatedBy(TABLE_ITEM_LOCATOR_TEMPLATE.formatted("Tango TID"));
}
