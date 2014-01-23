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

import net.audumla.automate.event.EventTransaction;
import net.audumla.automate.event.EventTransactionListener;
import net.audumla.devices.activator.Activator;
import net.audumla.devices.activator.ActivatorState;
import net.audumla.devices.activator.ActivatorProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;

public class RPIGPIOActivatorProvider implements ActivatorProvider, EventTransactionListener
{
    private static final Logger logger = LoggerFactory.getLogger(RPIGPIOActivatorProvider.class);

    @Override
    public void initialize() throws Exception {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public String getId() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Activator getActivator(Properties id) {
        return null;
    }

    @Override
    public Collection<? extends Activator> getActivators() {
        return null;
    }

    @Override
    public boolean setState(Activator activator, ActivatorState newState) throws Exception {
        return false;
    }

    @Override
    public boolean setStates(Map newStates) throws Exception {
        return false;
    }

    @Override
    public boolean onTransactionCommit(EventTransaction transaction, Map events) throws Exception {
        return false;
    }

    @Override
    public boolean onTransactionBegin(EventTransaction transaction) throws Exception {
        return false;
    }
}
