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
package com.bf.omnichannel.definitions.data;

import static com.bf.omnichannel.RunnerCucumberTestSuite.SCENARIO_DATA_VARIABLE_NAME;

import com.bf.omnichannel.data.DataTableValidation;
import com.bf.omnichannel.enums.DataTableColumnsEnum;
import com.bf.omnichannel.enums.salesforce.*;
import com.bf.omnichannel.enums.vhq.VhqEnabledOrDisabledEnum;
import com.bf.omnichannel.enums.vhq.VhqMakeAndModelEnum;
import com.bf.omnichannel.pojo.ScenarioDataPojo;
import com.bf.omnichannel.pojo.auxiliar.AutoBatchTimePojo;
import com.bf.omnichannel.pojo.auxiliar.MakeAndModelPojo;
import com.bf.omnichannel.pojo.auxiliar.YesNoEnabledDisabledPojo;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;

public class DataTableAnalyzer {
    private DataTableAnalyzer() {
        throw new IllegalStateException("Utility class");
    }

    public static void transformAndRememberScenarioData(Actor theActor, DataTable dataTable) {

        DataTableValidation.validateRowNames(dataTable.column(0));

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        ScenarioDataPojo scenarioData = theActor.recall(SCENARIO_DATA_VARIABLE_NAME);

        if (scenarioData == null) {
            scenarioData = new ScenarioDataPojo();
        }

        for (Map<String, String> columns : rows) {
            var yesOrNoEnabledDisabledPojo = new YesNoEnabledDisabledPojo();

            String salesforceValue = columns.get(DataTableColumnsEnum.SALESFORCE.getValue());
            String sfValue = columns.get(DataTableColumnsEnum.SF_VALUE.getValue());
            String vhqValue = columns.get(DataTableColumnsEnum.EXPECTED_VHQ_VALUE.getValue());

            if (salesforceValue != null) {
                processSalesforceData(
                        columns,
                        scenarioData,
                        yesOrNoEnabledDisabledPojo,
                        salesforceValue,
                        sfValue,
                        vhqValue);
            }

            String vhqField = columns.get(DataTableColumnsEnum.VHQ_FIELD.getValue());
            if (vhqField != null) {
                processVhqData(columns, scenarioData, vhqField);
            }
        }
        theActor.remember(SCENARIO_DATA_VARIABLE_NAME, scenarioData);
    }

    private static void processSalesforceData(
            Map<String, String> columns,
            ScenarioDataPojo scenarioData,
            YesNoEnabledDisabledPojo yesOrNoEnabledDisabledPojo,
            String salesforceValue,
            String sfValue,
            String vhqValue) {
        switch (salesforceValue) {
            case "Location":
                scenarioData.setLocation(sfValue);
                break;
            case "Company Profile":
                scenarioData.setCompanyProfile(sfValue);
                break;
            case "Make and Model":
                MakeAndModelPojo makeAndModel = new MakeAndModelPojo();
                makeAndModel.setSfMakeAndModelEnum(SfMakeAndModelEnum.fromValue(sfValue));
                makeAndModel.setVhqMakeAndModelEnum(VhqMakeAndModelEnum.fromValue(vhqValue));
                scenarioData.setMakeAndModel(makeAndModel);
                break;
            case "Status":
                scenarioData.setStatus(sfValue);
                break;
            case "Communication Method":
                scenarioData.setCommunicationMethod(SfCommunicationMethodEnum.fromValue(sfValue));
                break;
            case "Charge Equipment Cost incl. Shipping":
                scenarioData.setChargeEquipmentCostInclShipping(
                        SfChargeEquipmentEnum.fromValue(sfValue));
                break;
            case "Purchase or Rental":
                scenarioData.setPurchaseOrRental(SfPurchaseOrRentalEnum.fromValue(sfValue));
                break;
            case "Clerk/Server ID Enablement":
                scenarioData.setClerkServerIdEnablement(SfYesOrNoEnum.fromValue(sfValue));
                break;
            case "Clerk/Server ID Label":
                scenarioData.setClerkServerIdLabel(SfClerkOrServerIDLabelEnum.fromValue(sfValue));
                break;
            case "Default Terminal Settings":
                scenarioData.setDefaultTerminalSettings(
                        SfDefaultTerminalSettingsEnum.fromValue(sfValue));
                break;
            case "Ticket Number":
                yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(SfYesOrNoEnum.fromValue(sfValue));
                yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                        VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                scenarioData.setTicketNumber(yesOrNoEnabledDisabledPojo);
                break;
            case "Terminal Auto Batch":
                yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(SfYesOrNoEnum.fromValue(sfValue));
                yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                        VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                scenarioData.setTerminalAutoBatch(yesOrNoEnabledDisabledPojo);
                break;
            case "Auto Batch Time":
                var autoBatchTimePojo = new AutoBatchTimePojo();
                autoBatchTimePojo.setSFAutoBatchTime(sfValue);
                autoBatchTimePojo.setVhqAutoBatchTime(vhqValue);
                scenarioData.setAutoBatchTime(autoBatchTimePojo);
                break;
            case "Table Number":
                yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(SfYesOrNoEnum.fromValue(sfValue));
                yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                        VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                scenarioData.setTableNumber(yesOrNoEnabledDisabledPojo);
                break;
            case "Cashback":
                yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(SfYesOrNoEnum.fromValue(sfValue));
                yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                        VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                scenarioData.setCashback(yesOrNoEnabledDisabledPojo);
                break;
            case "Merchant Receipt Logo":
                yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(SfYesOrNoEnum.fromValue(sfValue));
                yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                        VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                scenarioData.setMerchantReceiptLogo(yesOrNoEnabledDisabledPojo);
                break;
            case "Alphanumeric Invoice number":
                yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(SfYesOrNoEnum.fromValue(sfValue));
                yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                        VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                scenarioData.setAlphanumericInvoiceNumber(yesOrNoEnabledDisabledPojo);
                break;
            case "Terminal Type":
                scenarioData.setTerminalType(SfTerminalTypeEnum.fromValue(sfValue));
                break;
            case "Tip at Time of Sale":
                scenarioData.setTipAtTimeOfSale(SfYesOrNoEnum.fromValue(sfValue));
                break;
            default:
                exceptionForUnexpectedColumn(columns.toString());
                break;
        }
    }

    private static void processVhqData(
            Map<String, String> columns, ScenarioDataPojo scenarioData, String vhqField) {
        String vhqValue = columns.get(DataTableColumnsEnum.VHQ_VALUE.getValue());
        switch (vhqField) {
            case "Clerk ID":
                scenarioData.setVhqClerkID(VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                break;
            case "Server ID":
                scenarioData.setVhqServerID(VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                break;
            case "Accept Tips":
                scenarioData.setVhqAcceptTips(VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                break;
            case "RetailPullMode":
                scenarioData.setVhqRetailPullMode(VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                break;
            case "RestaurantPushMode":
                scenarioData.setVhqRestaurantPushMode(VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                break;
            case "Semi-Integration":
                scenarioData.setVhqSemiIntegration(VhqEnabledOrDisabledEnum.fromValue(vhqValue));
                break;
            default:
                exceptionForUnexpectedColumn(columns.toString());
                break;
        }
    }

    private static void exceptionForUnexpectedColumn(String columnName) {
        throw new IllegalArgumentException(
                "Unexpected column name found: '%s'".formatted(columnName));
    }
}
