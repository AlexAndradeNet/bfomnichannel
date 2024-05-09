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
public class SfCasePage extends PageObject {

    private SfCasePage() {
        super();
    }

    public static final Target DIALOG_TITLE =
            Target.the("dialog`s title").locatedBy("//div[contains(@class, 'modal-body')]//h2");

    public static final Target CASE_OWNER_ALIAS_LABEL =
            Target.the("label case owner alias").locatedBy("//span[.='Case Owner Alias']");

    public static final Target BUTTON_NEW_CASE =
            Target.the("button new terminal").locatedBy("//li[.='New']");

    public static final Target BUTTON_INTEGRATION_GUIDE =
            Target.the("button integration guide").locatedBy("//li[.='Integration Guide']");

    public static final Target CANCEL_BUTTON =
            Target.the("button new terminal").locatedBy("(//button[.='Cancel'])[2]");

    public static final Target CONFIGURATION_LABEL =
            Target.the("label configuration")
                    .locatedBy("//span[contains(@class, 'label') and text()='Configuration']");

    public static final Target NEXT_BUTTON =
            Target.the("button next").locatedBy("//button[.='Next']");

    public static final Target COMPANY_PROFILE_TEXTBOX =
            Target.the("textbox company profile")
                    .locatedBy("//input[@placeholder='Search Company Profiles...']");

    public static final Target PROFILE_TYPE_COMBOBOX =
            Target.the("combobox profile type")
                    .locatedBy(
                            "//button[contains(@id, 'combobox') and contains(@aria-label, 'Profile"
                                    + " Type')]");

    public static final Target CASE_REASON_COMBOBOX =
            Target.the("combobox case reason")
                    .locatedBy(
                            "//button[contains(@id, 'combobox') and contains(@aria-label, 'Case"
                                    + " Reason')]");

    public static final Target TYPE_COMBOBOX =
            Target.the("combobox type")
                    .locatedBy(
                            "//button[contains(@id, 'combobox') and starts-with(@aria-label, 'Type"
                                    + " -')]");

    public static final Target PROFILE_COMBOBOX =
            Target.the("combobox profile")
                    .locatedBy(
                            "//button[contains(@id, 'combobox') and starts-with(@aria-label,"
                                    + " 'Profile -')]");

    public static final Target LOCATION_TEXTBOX =
            Target.the("textbox location").locatedBy("//input[@placeholder='Search Locations...']");

    public static final Target SUBJECT_TEXTBOX =
            Target.the("textbox location").locatedBy("//input[@name='Subject']");

    public static final Target BUTTON_SAVE =
            Target.the("button save").locatedBy("//button[text()='Save']");

    public static final Target CREATED_CASE_ID_LABEL =
            Target.the("label ID of new created terminal")
                    .locatedBy(
                            "//span[text()='Case"
                                + " Number']/ancestor::dt/following-sibling::dd//lightning-formatted-text");

    public static final Target STATUS_LABEL =
            Target.the("label status of the case")
                    .locatedBy(
                            "//span[text()='Status']/ancestor::dt/following-sibling::dd//lightning-formatted-text");

    public static final Target STATUS_NEW_VALUE_LABEL =
            Target.the("label status of the case")
                    .locatedBy(
                            "//span[text()='New"
                                + " Value']/ancestor::dt/following-sibling::dd//lightning-formatted-text");

    public static final Target MORE_OPTIONS_BUTTON =
            Target.the("button more options")
                    .locatedBy("//li[.='Create Omnichannel Multiclient']/following-sibling::li");

    public static final Target CREATE_ADDITIONAL_TERMINALS_MENU_ITEM =
            Target.the("menu item Create additional terminals")
                    .locatedBy("//a[.='Create Additional Terminals']");

    public static final Target CREATE_ACCOUNT_RESPONSE_LABEL =
            Target.the("label for Created account response")
                    .locatedBy(
                            "//span[text()='Create Account"
                                + " Response']/ancestor::dt/following-sibling::dd//lightning-formatted-text");

    // General dropdown

    public static final Target DROPDOWN_ITEM =
            Target.the("dropdown for '{0}'")
                    .locatedBy("//lightning-base-combobox-formatted-text[@title='{0}']");
}
