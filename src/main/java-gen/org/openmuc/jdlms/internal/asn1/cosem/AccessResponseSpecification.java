/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jdlms.internal.asn1.axdr.AxdrType;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrEnum;

import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;

public class AccessResponseSpecification implements AxdrType {

    public byte[] code = null;

    public static enum Choices {
        _ERR_NONE_SELECTED(-1),
        ACCESS_RESPONSE_GET(1),
        ACCESS_RESPONSE_SET(2),
        ACCESS_RESPONSE_ACTION(3),;

        private int value;

        private Choices(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public static Choices valueOf(long tagValue) {
            Choices[] values = Choices.values();

            for (Choices c : values) {
                if (c.value == tagValue) {
                    return c;
                }
            }
            return _ERR_NONE_SELECTED;
        }
    }

    private Choices choice;

    public AccessResponseGet accessResponseGet = null;

    public AccessResponseSet accessResponseSet = null;

    public AccessResponseAction accessResponseAction = null;

    public AccessResponseSpecification() {
    }

    public AccessResponseSpecification(byte[] code) {
        this.code = code;
    }

    @Override
    public int encode(ReverseByteArrayOutputStream axdrOStream) throws IOException {
        if (code != null) {
            for (int i = code.length - 1; i >= 0; i--) {
                axdrOStream.write(code[i]);
            }
            return code.length;

        }
        if (choice == Choices._ERR_NONE_SELECTED) {
            throw new IOException("Error encoding AxdrChoice: No item in choice was selected.");
        }

        int codeLength = 0;

        if (choice == Choices.ACCESS_RESPONSE_ACTION) {
            codeLength += accessResponseAction.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(3);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.ACCESS_RESPONSE_SET) {
            codeLength += accessResponseSet.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(2);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.ACCESS_RESPONSE_GET) {
            codeLength += accessResponseGet.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(1);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        // This block should be unreachable
        throw new IOException("Error encoding AxdrChoice: No item in choice was encoded.");
    }

    @Override
    public int decode(InputStream iStream) throws IOException {
        int codeLength = 0;
        AxdrEnum choosen = new AxdrEnum();

        codeLength += choosen.decode(iStream);
        resetChoices();
        this.choice = Choices.valueOf(choosen.getValue());

        if (choice == Choices.ACCESS_RESPONSE_GET) {
            accessResponseGet = new AccessResponseGet();
            codeLength += accessResponseGet.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.ACCESS_RESPONSE_SET) {
            accessResponseSet = new AccessResponseSet();
            codeLength += accessResponseSet.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.ACCESS_RESPONSE_ACTION) {
            accessResponseAction = new AccessResponseAction();
            codeLength += accessResponseAction.decode(iStream);
            return codeLength;
        }

        throw new IOException("Error decoding AxdrChoice: Identifier matched to no item.");
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        ReverseByteArrayOutputStream axdrOStream = new ReverseByteArrayOutputStream(encodingSizeGuess);
        encode(axdrOStream);
        code = axdrOStream.getArray();
    }

    public Choices getChoiceIndex() {
        return this.choice;
    }

    public void setAccessResponseGet(AccessResponseGet newVal) {
        resetChoices();
        choice = Choices.ACCESS_RESPONSE_GET;
        accessResponseGet = newVal;
    }

    public void setAccessResponseSet(AccessResponseSet newVal) {
        resetChoices();
        choice = Choices.ACCESS_RESPONSE_SET;
        accessResponseSet = newVal;
    }

    public void setAccessResponseAction(AccessResponseAction newVal) {
        resetChoices();
        choice = Choices.ACCESS_RESPONSE_ACTION;
        accessResponseAction = newVal;
    }

    private void resetChoices() {
        choice = Choices._ERR_NONE_SELECTED;
        accessResponseGet = null;
        accessResponseSet = null;
        accessResponseAction = null;
    }

    @Override
    public String toString() {
        if (choice == Choices.ACCESS_RESPONSE_GET) {
            return "choice: {accessResponseGet: " + accessResponseGet + "}";
        }

        if (choice == Choices.ACCESS_RESPONSE_SET) {
            return "choice: {accessResponseSet: " + accessResponseSet + "}";
        }

        if (choice == Choices.ACCESS_RESPONSE_ACTION) {
            return "choice: {accessResponseAction: " + accessResponseAction + "}";
        }

        return "unknown";
    }

}