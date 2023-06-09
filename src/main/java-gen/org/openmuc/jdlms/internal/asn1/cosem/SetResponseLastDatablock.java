/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jdlms.internal.asn1.axdr.AxdrType;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrEnum;

import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;

public class SetResponseLastDatablock implements AxdrType {

    public byte[] code = null;
    public InvokeIdAndPriority invokeIdAndPriority = null;

    public AxdrEnum result = null;

    public Unsigned32 blockNumber = null;

    public SetResponseLastDatablock() {
    }

    public SetResponseLastDatablock(byte[] code) {
        this.code = code;
    }

    public SetResponseLastDatablock(InvokeIdAndPriority invokeIdAndPriority, AxdrEnum result, Unsigned32 blockNumber) {
        this.invokeIdAndPriority = invokeIdAndPriority;
        this.result = result;
        this.blockNumber = blockNumber;
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
            codeLength += blockNumber.encode(axdrOStream);

            codeLength += result.encode(axdrOStream);

            codeLength += invokeIdAndPriority.encode(axdrOStream);

        }

        return codeLength;

    }

    @Override
    public int decode(InputStream iStream) throws IOException {
        int codeLength = 0;

        invokeIdAndPriority = new InvokeIdAndPriority();
        codeLength += invokeIdAndPriority.decode(iStream);

        result = new AxdrEnum();
        codeLength += result.decode(iStream);

        blockNumber = new Unsigned32();
        codeLength += blockNumber.decode(iStream);

        return codeLength;
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        ReverseByteArrayOutputStream axdrOStream = new ReverseByteArrayOutputStream(encodingSizeGuess);
        encode(axdrOStream);
        code = axdrOStream.getArray();
    }

    @Override
    public String toString() {
        return "sequence: {" + "invokeIdAndPriority: " + invokeIdAndPriority + ", result: " + result + ", blockNumber: "
                + blockNumber + "}";
    }

}
