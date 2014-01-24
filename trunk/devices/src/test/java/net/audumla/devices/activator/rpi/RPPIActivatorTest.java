package net.audumla.devices.activator.rpi;

/*
 * *********************************************************************
 *  ORGANIZATION : audumla.net
 *  More information about this project can be found at the following locations:
 *  http://www.audumla.net/
 *  http://audumla.googlecode.com/
 * *********************************************************************
 *  Copyright (C) 2012 - 2013 Audumla.net
 *  Licensed under the Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
 *  You may not use this file except in compliance with the License located at http://creativecommons.org/licenses/by-nc-nd/3.0/
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 *  "AS IS BASIS", WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 */

import net.audumla.devices.activator.Activator;
import net.audumla.devices.activator.ActivatorState;
import net.audumla.devices.activator.factory.RPIGPIOActivator;
import net.audumla.devices.activator.factory.RPIGPIOActivatorFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

public class RPPIActivatorTest {
    private static final Logger logger = LoggerFactory.getLogger(RPPIActivatorTest.class);

    static RPIGPIOActivatorFactory rpi = new RPIGPIOActivatorFactory();

    static {
        try {
            rpi.initialize();
        } catch (Exception e) {
            logger.error("Cannot initialize PI", e);
        }
    }


    @Test
    public void testGPIOPins() throws Exception {
        assert rpi.getActivators().size() > 0;
        for (RPIGPIOActivator a : rpi.getActivators()) {
            RPIGPIOActivatorFactory.GPIOName.valueOf(a.getName());
        }
    }

    @Test
    public void testRawRelay() throws Exception {
        Collection<Activator> pins = new ArrayList<>();
        pins.add(rpi.getActivator(RPIGPIOActivatorFactory.GPIOName.GPIO0));
        pins.add(rpi.getActivator(RPIGPIOActivatorFactory.GPIOName.GPIO2));
        pins.add(rpi.getActivator(RPIGPIOActivatorFactory.GPIOName.GPIO3));
        pins.add(rpi.getActivator(RPIGPIOActivatorFactory.GPIOName.SPI_MOSI));
        pins.add(rpi.getActivator(RPIGPIOActivatorFactory.GPIOName.SPI_SCLK));
        pins.add(rpi.getActivator(RPIGPIOActivatorFactory.GPIOName.SPI_MOSI));
        pins.add(rpi.getActivator(RPIGPIOActivatorFactory.GPIOName.SPI_CE0));
        pins.add(rpi.getActivator(RPIGPIOActivatorFactory.GPIOName.SPI_CE1));

        Activator power = rpi.getActivator(RPIGPIOActivatorFactory.GPIOName.GPIO6);
        power.allowVariableState(false);
        power.allowSetState(true);
        power.setState(ActivatorState.DEACTIVATED);

        for (Activator a : pins) {
            assert a != null;
            a.allowVariableState(false);
            a.allowSetState(true);
            a.setState(ActivatorState.ACTIVATED);
        }

        power.setState(ActivatorState.ACTIVATED);


        for (int i = 0; i < 10; ++i) {
            for (Activator a : pins) {
                a.setState(ActivatorState.DEACTIVATED);
                synchronized (this) {
                    wait(200);
                }
                a.setState(ActivatorState.ACTIVATED);

            }
        }
        power.setState(ActivatorState.DEACTIVATED);

    }
}
