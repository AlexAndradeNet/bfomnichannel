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
package com.bf.omnichannel.interactions;

import com.bf.omnichannel.utils.SimpleLogger;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class PrintResults implements Interaction {
    private static final SimpleLogger logger = new SimpleLogger(PrintResults.class);

    private final int reportType;

    public PrintResults(int reportType) {
        this.reportType = reportType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        final String PRINT_FORMAT_FOR_SALESFORCE = "| %s : %s |";
        final String PRINT_FORMAT_FOR_VHQ = "|%s|%s|\n";

        String reportFormat;

        var result = new StringBuilder();

        if (reportType == 1) {
            reportFormat = PRINT_FORMAT_FOR_SALESFORCE;
        } else {
            reportFormat = PRINT_FORMAT_FOR_VHQ;

            logger.info("\n########## VALIDATION ##########\n");
            result.append("|Field|Expected value|Actual value|Result|\n");
            result.append("|-----|--------------|------------|------|\n");
        }

        actor.recallAll()
                .forEach(
                        (key, value) -> {
                            if (!key.equals("scenarioData")) {
                                result.append(reportFormat.formatted(key, value));
                            }
                        });
        logger.info(String.valueOf(result));

        try {
            Serenity.recordReportData()
                    .asEvidence()
                    .withTitle("Test results data")
                    .andContents(result.toString());
        } catch (NullPointerException ignored) {
            // This is a workaround for a running from the IDE issue
        }
    }

    public static PrintResults fromRecall(int reportType) {
        return new PrintResults(reportType);
    }
}
