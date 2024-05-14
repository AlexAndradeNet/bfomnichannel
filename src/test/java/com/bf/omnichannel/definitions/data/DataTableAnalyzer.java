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

            if (columns.get(DataTableColumnsEnum.SALESFORCE.getValue()) != null) {
                switch (columns.get(DataTableColumnsEnum.SALESFORCE.getValue())) {
                    case "Location":
                        scenarioData.setLocation(
                                columns.get(DataTableColumnsEnum.SF_VALUE.getValue()));
                        break;
                    case "Company Profile":
                        scenarioData.setCompanyProfile(
                                columns.get(DataTableColumnsEnum.SF_VALUE.getValue()));
                        break;
                    case "Make and Model":
                        MakeAndModelPojo makeAndModel = new MakeAndModelPojo();
                        makeAndModel.setSfMakeAndModelEnum(
                                SfMakeAndModelEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        makeAndModel.setVhqMakeAndModelEnum(
                                VhqMakeAndModelEnum.fromValue(
                                        columns.get(
                                                DataTableColumnsEnum.EXPECTED_VHQ_VALUE
                                                        .getValue())));
                        scenarioData.setMakeAndModel(makeAndModel);
                        break;
                    case "Status":
                        scenarioData.setStatus(
                                columns.get(DataTableColumnsEnum.SF_VALUE.getValue()));
                        break;
                    case "Communication Method":
                        scenarioData.setCommunicationMethod(
                                SfCommunicationMethodEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        break;
                    case "Charge Equipment Cost incl. Shipping":
                        scenarioData.setChargeEquipmentCostInclShipping(
                                SfChargeEquipmentEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        break;
                    case "Purchase or Rental":
                        scenarioData.setPurchaseOrRental(
                                SfPurchaseOrRentalEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        break;
                    case "Clerk/Server ID Enablement":
                        scenarioData.setClerkServerIdEnablement(
                                SfYesOrNoEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        break;
                    case "Clerk/Server ID Label":
                        scenarioData.setClerkServerIdLabel(
                                SfClerkOrServerIDLabelEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        break;
                    case "Default Terminal Settings":
                        scenarioData.setDefaultTerminalSettings(
                                SfDefaultTerminalSettingsEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        break;
                    case "Ticket Number":
                        yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(
                                SfYesOrNoEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(
                                                DataTableColumnsEnum.EXPECTED_VHQ_VALUE
                                                        .getValue())));
                        scenarioData.setTicketNumber(yesOrNoEnabledDisabledPojo);
                        break;
                    case "Terminal Auto Batch":
                        yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(
                                SfYesOrNoEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(
                                                DataTableColumnsEnum.EXPECTED_VHQ_VALUE
                                                        .getValue())));
                        scenarioData.setTerminalAutoBatch(yesOrNoEnabledDisabledPojo);
                        break;
                    case "Auto Batch Time":
                        var autoBatchTimePojo = new AutoBatchTimePojo();
                        autoBatchTimePojo.setSFAutoBatchTime(
                                columns.get(DataTableColumnsEnum.SF_VALUE.getValue()));
                        autoBatchTimePojo.setVhqAutoBatchTime(
                                columns.get(DataTableColumnsEnum.EXPECTED_VHQ_VALUE.getValue()));
                        scenarioData.setAutoBatchTime(autoBatchTimePojo);
                        break;
                    case "Table Number":
                        yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(
                                SfYesOrNoEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(
                                                DataTableColumnsEnum.EXPECTED_VHQ_VALUE
                                                        .getValue())));
                        scenarioData.setTableNumber(yesOrNoEnabledDisabledPojo);
                        break;
                    case "Cashback":
                        yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(
                                SfYesOrNoEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(
                                                DataTableColumnsEnum.EXPECTED_VHQ_VALUE
                                                        .getValue())));
                        scenarioData.setCashback(yesOrNoEnabledDisabledPojo);
                        break;
                    case "Merchant Receipt Logo":
                        yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(
                                SfYesOrNoEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(
                                                DataTableColumnsEnum.EXPECTED_VHQ_VALUE
                                                        .getValue())));
                        scenarioData.setMerchantReceiptLogo(yesOrNoEnabledDisabledPojo);
                        break;
                    case "Alphanumeric Invoice number":
                        yesOrNoEnabledDisabledPojo.setSFYesOrNoEnum(
                                SfYesOrNoEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        yesOrNoEnabledDisabledPojo.setVhqEnabledOrDisabledEnum(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(
                                                DataTableColumnsEnum.EXPECTED_VHQ_VALUE
                                                        .getValue())));
                        scenarioData.setAlphanumericInvoiceNumber(yesOrNoEnabledDisabledPojo);
                        break;
                    case "Terminal Type":
                        scenarioData.setTerminalType(
                                SfTerminalTypeEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        break;
                    case "Tip at Time of Sale":
                        scenarioData.setTipAtTimeOfSale(
                                SfYesOrNoEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.SF_VALUE.getValue())));
                        break;
                    default:
                        exceptionForUnexpectedColumn(columns.toString());
                        break;
                }
            }

            if (columns.get(DataTableColumnsEnum.VHQ_FIELD.getValue()) != null) {
                switch (columns.get(DataTableColumnsEnum.VHQ_FIELD.getValue())) {
                    case "Clerk ID":
                        scenarioData.setVhqClerkID(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.VHQ_VALUE.getValue())));
                        break;
                    case "Server ID":
                        scenarioData.setVhqServerID(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.VHQ_VALUE.getValue())));
                        break;
                    case "Accept Tips":
                        scenarioData.setVhqAcceptTips(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.VHQ_VALUE.getValue())));
                        break;
                    case "RetailPullMode":
                        scenarioData.setVhqRetailPullMode(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.VHQ_VALUE.getValue())));
                        break;
                    case "RestaurantPushMode":
                        scenarioData.setVhqRestaurantPushMode(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.VHQ_VALUE.getValue())));
                        break;
                    case "Semi-Integration":
                        scenarioData.setVhqSemiIntegration(
                                VhqEnabledOrDisabledEnum.fromValue(
                                        columns.get(DataTableColumnsEnum.VHQ_VALUE.getValue())));
                        break;
                    default:
                        exceptionForUnexpectedColumn(columns.toString());
                        break;
                }
            }
        }
        theActor.remember(SCENARIO_DATA_VARIABLE_NAME, scenarioData);
    }

    private static void exceptionForUnexpectedColumn(String columnName) {
        throw new IllegalArgumentException(
                "Unexpected column name found: '%s'".formatted(columnName));
    }
}
