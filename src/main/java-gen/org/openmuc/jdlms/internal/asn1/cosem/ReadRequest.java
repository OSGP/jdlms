/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrSequenceOf;

public class ReadRequest extends AxdrSequenceOf<VariableAccessSpecification> {

    @Override
    protected VariableAccessSpecification createListElement() {
        return new VariableAccessSpecification();
    }

    protected ReadRequest(int length) {
        super(length);
    }

    public ReadRequest() {
    } // Call empty base constructor

}