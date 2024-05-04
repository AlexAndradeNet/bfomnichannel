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
import org.apache.commons.lang3.StringUtils;

public class SecretsManager {

    private final String username;
    private final String password;

    private SecretsManager() {
        Dotenv dotenv = Dotenv.configure().load();
        username = getEnv(dotenv, "SBX_SALESFORCE_USERNAME");
        password = getEnv(dotenv, "SBX_SALESFORCE_PASSWORD");
    }

    private static final class InstanceHolder {
        private static final SecretsManager instance = new SecretsManager();
    }

    public static synchronized SecretsManager getInstance() {
        return InstanceHolder.instance;
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
