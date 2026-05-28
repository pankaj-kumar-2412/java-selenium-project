package com.seleniumproject.tests;

import com.seleniumproject.config.ConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfigReaderTest {
    @Test
    void shouldReadDefaultsFromConfigFile() {
        String baseUrl = ConfigReader.get("amazon.base.url", "");
        int waitSeconds = ConfigReader.getInt("wait.seconds", 0);

        Assertions.assertFalse(baseUrl.isBlank());
        Assertions.assertTrue(waitSeconds > 0);
    }
}

