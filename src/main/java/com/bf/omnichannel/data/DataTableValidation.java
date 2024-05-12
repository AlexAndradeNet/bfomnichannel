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
package com.bf.omnichannel.data;

import java.util.List;
import java.util.Set;

public class DataTableValidation {
    private static final Set<String> EXPECTED_COLUMN_NAMES =
            Set.of(
                    "Location",
                    "Make and Model",
                    "Status",
                    "Communication Method",
                    "Charge Equipment Cost incl. Shipping",
                    "Purchase or Rental",
                    "Clerk/Server ID Enablement",
                    "Clerk/Server ID Label",
                    "Default Terminal Settings",
                    "Ticket Number",
                    "Terminal Auto Batch",
                    "Auto Batch Time",
                    "Table Number",
                    "Cashback",
                    "Merchant Receipt Logo",
                    "Alphanumeric Invoice number",
                    "Terminal Type",
                    "Tip at Time of Sale",
                    "Clerk ID",
                    "Server ID",
                    "Semi-Integration");

    private DataTableValidation() {
        // Prevent instantiation
    }

    public static void validateRowNames(List<String> actualColumnNames) {
        List<String> newList =
                actualColumnNames.subList(
                        1, actualColumnNames.size()); // Remove the first column name

        // Check if all actual column names are expected
        for (String columnName : newList) {
            if (!EXPECTED_COLUMN_NAMES.contains(columnName)) {
                throw new AssertionError(
                        "Unexpected column name found: '%s'".formatted(columnName));
            }
        }
    }
}
