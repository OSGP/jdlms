/*
 * This class file was automatically generated by ASN1bean v1.13.0 (http://www.beanit.com)
 */

package org.openmuc.jdlms.internal.asn1.iso.acse;

import java.math.BigInteger;

import com.beanit.asn1bean.ber.types.BerInteger;

public class ReleaseRequestReason extends BerInteger {

    private static final long serialVersionUID = 1L;

    public ReleaseRequestReason() {
    }

    public ReleaseRequestReason(byte[] code) {
        super(code);
    }

    public ReleaseRequestReason(BigInteger value) {
        super(value);
    }

    public ReleaseRequestReason(long value) {
        super(value);
    }

}
