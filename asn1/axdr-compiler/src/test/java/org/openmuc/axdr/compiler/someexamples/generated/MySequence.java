/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.axdr.compiler.someexamples.generated;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jdlms.internal.asn1.axdr.AxdrType;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrVisibleString;

import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;

public class MySequence implements AxdrType {

    public byte[] code = null;
    public AxdrVisibleString implVisibleString = null;

    public MySequence() {
    }

    public MySequence(byte[] code) {
        this.code = code;
    }

    public MySequence(AxdrVisibleString implVisibleString) {
        this.implVisibleString = implVisibleString;
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
            codeLength += implVisibleString.encode(axdrOStream);

        }

        return codeLength;

    }

    @Override
    public int decode(InputStream iStream) throws IOException {
        int codeLength = 0;

        implVisibleString = new AxdrVisibleString();
        codeLength += implVisibleString.decode(iStream);

        return codeLength;
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        ReverseByteArrayOutputStream axdrOStream = new ReverseByteArrayOutputStream(encodingSizeGuess);
        encode(axdrOStream);
        code = axdrOStream.getArray();
    }

    @Override
    public String toString() {
        return "sequence: {" + "implVisibleString: " + implVisibleString + "}";
    }

}
