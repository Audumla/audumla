package com.oracle.deviceaccess;

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

import java.io.IOException;
import java.nio.channels.Channel;

public abstract interface Peripheral<A extends Peripheral<? super A>> extends Channel {
    public static final int BIG_ENDIAN = 1;
    public static final int LITTLE_ENDIAN = 0;
    public static final int MIXED_ENDIAN = 2;

    public abstract <Z extends A> PeripheralDescriptor<Z> getDescriptor();

    public abstract boolean isOpen();

    public abstract void close()
            throws IOException;

    public abstract void tryLock(int paramInt)
            throws IOException;

    public abstract void unlock()
            throws IOException;
}