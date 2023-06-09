/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jdlms.internal.asn1.axdr.AxdrType;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrBoolean;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrDefault;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrOctetString;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrOptional;

import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;

public class InitiateRequest implements AxdrType {

    public byte[] code = null;
    public AxdrOptional<AxdrOctetString> dedicatedKey = new AxdrOptional<>(new AxdrOctetString(), false);

    public AxdrDefault<AxdrBoolean> responseAllowed = new AxdrDefault<>(new AxdrBoolean(), new AxdrBoolean(true));

    public AxdrOptional<Integer8> proposedQualityOfService = new AxdrOptional<>(new Integer8(), false);

    public Unsigned8 proposedDlmsVersionNumber = null;

    public Conformance proposedConformance = null;

    public Unsigned16 clientMaxReceivePduSize = null;

    public InitiateRequest() {
    }

    public InitiateRequest(byte[] code) {
        this.code = code;
    }

    public InitiateRequest(AxdrOctetString dedicatedKey, AxdrBoolean responseAllowed, Integer8 proposedQualityOfService,
            Unsigned8 proposedDlmsVersionNumber, Conformance proposedConformance, Unsigned16 clientMaxReceivePduSize) {
        this.dedicatedKey.setValue(dedicatedKey);
        this.responseAllowed.setValue(responseAllowed);
        this.proposedQualityOfService.setValue(proposedQualityOfService);
        this.proposedDlmsVersionNumber = proposedDlmsVersionNumber;
        this.proposedConformance = proposedConformance;
        this.clientMaxReceivePduSize = clientMaxReceivePduSize;
    }

    @Override
    public int encode(ReverseByteArrayOutputStream axdrOStream) throws IOException {

        int codeLength;

        if (code != null) {
            codeLength = code.length;
            for (int i = code.length - 1; i >= 0; i--) {
                axdrOStream.write(code[i]);
            }
        }
        else {
            codeLength = 0;
            codeLength += clientMaxReceivePduSize.encode(axdrOStream);

            codeLength += proposedConformance.encode(axdrOStream);

            codeLength += proposedDlmsVersionNumber.encode(axdrOStream);

            codeLength += proposedQualityOfService.encode(axdrOStream);

            codeLength += responseAllowed.encode(axdrOStream);

            codeLength += dedicatedKey.encode(axdrOStream);

        }

        return codeLength;

    }

    @Override
    public int decode(InputStream iStream) throws IOException {
        int codeLength = 0;

        dedicatedKey = new AxdrOptional<>(new AxdrOctetString(), false);
        codeLength += dedicatedKey.decode(iStream);

        responseAllowed = new AxdrDefault<>(new AxdrBoolean(), new AxdrBoolean(true));
        codeLength += responseAllowed.decode(iStream);

        proposedQualityOfService = new AxdrOptional<>(new Integer8(), false);
        codeLength += proposedQualityOfService.decode(iStream);

        proposedDlmsVersionNumber = new Unsigned8();
        codeLength += proposedDlmsVersionNumber.decode(iStream);

        proposedConformance = new Conformance();
        codeLength += proposedConformance.decode(iStream);

        clientMaxReceivePduSize = new Unsigned16();
        codeLength += clientMaxReceivePduSize.decode(iStream);

        return codeLength;
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        ReverseByteArrayOutputStream axdrOStream = new ReverseByteArrayOutputStream(encodingSizeGuess);
        encode(axdrOStream);
        code = axdrOStream.getArray();
    }

    @Override
    public String toString() {
        return "sequence: {" + "dedicatedKey: " + dedicatedKey + ", responseAllowed: " + responseAllowed
                + ", proposedQualityOfService: " + proposedQualityOfService + ", proposedDlmsVersionNumber: "
                + proposedDlmsVersionNumber + ", proposedConformance: " + proposedConformance
                + ", clientMaxReceivePduSize: " + clientMaxReceivePduSize + "}";
    }

}
