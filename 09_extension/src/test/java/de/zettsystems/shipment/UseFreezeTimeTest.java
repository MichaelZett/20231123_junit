package de.zettsystems.shipment;

import de.zettsystems.common.FreezeTimeExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(FreezeTimeExtension.class)
class UseFreezeTimeTest {

    @Test
    void testFreezeTime() throws InterruptedException {
        Shipment testee = new Shipment("Playstation");

        testee.sendShipment();

        Thread.sleep(3000L);

        testee.arrive();

        System.out.println(testee.getDuration().getSeconds() + " Sekunden");
    }

}