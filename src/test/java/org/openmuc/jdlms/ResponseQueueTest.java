/*
 * Copyright 2012-2022 Fraunhofer ISE
 *
 * This file is part of jDLMS.
 * For more information visit http://www.openmuc.org
 *
 * jDLMS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * jDLMS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with jDLMS.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openmuc.jdlms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openmuc.jdlms.internal.asn1.cosem.COSEMpdu;

public class ResponseQueueTest {

    @Test
    public void testNotNullAndRethrow() {
        assertThrows(IOException.class, () -> {
            ResponseQueue rq = new ResponseQueue();

            rq.putError(new IOException());

            rq.poll(0, null);
        });
    }

    @Test
    public void testTimeout() {
        assertThrows(ResponseTimeoutException.class, () -> {
            ResponseQueue rq = new ResponseQueue();

            rq.poll(1, TimeUnit.MILLISECONDS);
        });
    }

    @Test
    public void test() throws Exception {
        ResponseQueue rq = new ResponseQueue();

        COSEMpdu pdu = new COSEMpdu();
        rq.put(pdu);

        COSEMpdu resPdu = rq.poll(0, null);

        assertEquals(pdu, resPdu);
    }
}