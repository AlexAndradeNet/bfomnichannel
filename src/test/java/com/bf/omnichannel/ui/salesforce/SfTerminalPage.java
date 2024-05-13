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
            Target.the("combobox make and model")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Make and Model"));

    public static final Target COMBOBOX_COMMUNICATION_METHOD =
            Target.the("combobox communication method")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Communication Method"));

    public static final Target COMBOBOX_CHARGE_EQUIPMENT =
            Target.the("combobox charge equipment")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Charge Equipment"));

    public static final Target COMBOBOX_CLERK_OR_SERVER_ID_ENABLEMENT =
            Target.the("combobox Clerk/Server ID enablement")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Clerk/Server ID Enablement"));

    public static final Target COMBOBOX_CLERK_OR_SERVER_ID_LABEL =
            Target.the("combobox Clerk/Server ID label")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Clerk/Server ID Label"));

    public static final Target COMBOBOX_TICKET_NUMBER =
            Target.the("combobox ticket number")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Ticket Number"));

    public static final Target COMBOBOX_TABLE_NUMBER =
            Target.the("combobox table number")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Table Number"));

    public static final Target COMBOBOX_MERCHANT_RECEIPT_LOGO =
            Target.the("combobox merchant receipt logo")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Merchant Receipt Logo"));

    public static final Target COMBOBOX_TERMINAL_TYPE =
            Target.the("combobox terminal type")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Terminal Type"));

    // Right panel

    public static final Target LOCATION_TEXTBOX =
            Target.the("combobox location")
                    .locatedBy("//input[@placeholder='Search Locations...']");

    public static final Target COMBOBOX_STATUS =
            Target.the("combobox status").locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Status"));

    public static final Target COMBOBOX_PURCHASE_OR_RENTAL =
            Target.the("combobox purchase or rental")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Purchase or Rental"));

    public static final Target COMBOBOX_DEFAULT_TERMINAL_SETTINGS =
            Target.the("combobox default terminal settings")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Default Terminal Settings"));

    public static final Target COMBOBOX_TERMINAL_AUTO_BATCH =
            Target.the("combobox terminal auto batch")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Terminal Auto Batch"));

    public static final Target COMBOBOX_AUTO_BATCH_TIME =
            Target.the("combobox auto batch time").locatedBy("//input[@name='Auto_Batch_Time__c']");

    public static final Target COMBOBOX_CASHBACK =
            Target.the("combobox cashback")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Cashback"));

    public static final Target COMBOBOX_ALPHANUMERIC_INVOICE_NUMBER =
            Target.the("combobox alphanumeric invoice number")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Alphanumeric Invoice number"));

    public static final Target COMBOBOX_TIP_AT_TIME_OF_SALE =
            Target.the("combobox tip at time of sale")
                    .locatedBy(COMBOBOX_LOCATOR_TEMPLATE.formatted("Tip at Time of Sale"));

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
