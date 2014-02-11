package net.audumla.devices.io.channel.gpio;

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

import net.audumla.devices.io.channel.DeviceChannel;

public interface GPIODeviceChannel {
    public enum IOMode {DIGITAL_INPUT, DIGITAL_OUTPUT, ANALOG_INPUT, ANALOG_OUTPUT, PWM_OUTPUT}

    public enum ResistorMode {PULL_UP, PULL_DOWN, NONE}

    DeviceChannel createIOChannel();

    void setIOMode(IOMode mode, int... pins);

    IOMode[] getIOModes();

    int getIOCount();

    void setResistorModes(ResistorMode mode, int... pins);

    ResistorMode[] getResistorModes();


}
