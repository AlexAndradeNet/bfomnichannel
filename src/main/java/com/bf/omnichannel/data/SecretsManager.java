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

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class SecretsManager {

    @Getter private static final SecretsManager instance = new SecretsManager();
    private final String salesForceUsername;
    private final String salesForcePassword;
    private final String vhqUsername;
    private final String vhqPassword;

    private SecretsManager() {
        Dotenv dotenv = Dotenv.configure().load();

        salesForceUsername = getEnv(dotenv, "SBX_SALESFORCE_USERNAME");
        salesForcePassword = getEnv(dotenv, "SBX_SALESFORCE_PASSWORD");

        vhqUsername = getEnv(dotenv, "SBX_VHQ_USERNAME");
        vhqPassword = getEnv(dotenv, "SBX_VHQ_PASSWORD");
    }

    private static String getEnv(Dotenv dotenv, String key) {
        String value = StringUtils.defaultIfBlank(System.getProperty(key), dotenv.get(key));

        if (StringUtils.isBlank(value)) {
            throw new IllegalStateException(
                    "No value found for "
                            + key
                            + ". Check your .env file or system environment variables.");
        }

        return value;
    }
}
