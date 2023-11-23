package de.zettsystems.common;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class FreezeTimeExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        ZoneId zoneId = ZoneId.of("Europe/Berlin");

        Time.useMockTime(LocalDateTime.now(zoneId), zoneId);
    }


    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        Time.useSystemDefaultZoneClock();
    }

}