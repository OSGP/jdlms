/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jdlms.internal.asn1.axdr.AxdrType;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrEnum;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrNull;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrSequenceOf;

import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;

public class WriteResponse extends AxdrSequenceOf<WriteResponse.SubChoice> {

    @Override
    protected SubChoice createListElement() {
        return new SubChoice();
    }

    protected WriteResponse(int length) {
        super(length);
    }

    public WriteResponse() {
    } // Call empty base constructor

    public static class SubChoice implements AxdrType {

        public byte[] code = null;

        public static enum Choices {
            _ERR_NONE_SELECTED(-1),
            SUCCESS(0),
            DATA_ACCESS_ERROR(1),
            BLOCK_NUMBER(2),;

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

        public AxdrNull success = null;

        public AxdrEnum dataAccessError = null;

        public Unsigned16 blockNumber = null;

        public SubChoice() {
        }

        public SubChoice(byte[] code) {
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

            if (choice == Choices.BLOCK_NUMBER) {
                codeLength += blockNumber.encode(axdrOStream);
                AxdrEnum c = new AxdrEnum(2);
                codeLength += c.encode(axdrOStream);
                return codeLength;
            }

            if (choice == Choices.DATA_ACCESS_ERROR) {
                codeLength += dataAccessError.encode(axdrOStream);
                AxdrEnum c = new AxdrEnum(1);
                codeLength += c.encode(axdrOStream);
                return codeLength;
            }

            if (choice == Choices.SUCCESS) {
                codeLength += success.encode(axdrOStream);
                AxdrEnum c = new AxdrEnum(0);
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

            if (choice == Choices.SUCCESS) {
                success = new AxdrNull();
                codeLength += success.decode(iStream);
                return codeLength;
            }

            if (choice == Choices.DATA_ACCESS_ERROR) {
                dataAccessError = new AxdrEnum();
                codeLength += dataAccessError.decode(iStream);
                return codeLength;
            }

            if (choice == Choices.BLOCK_NUMBER) {
                blockNumber = new Unsigned16();
                codeLength += blockNumber.decode(iStream);
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

        public void setSuccess(AxdrNull newVal) {
            resetChoices();
            choice = Choices.SUCCESS;
            success = newVal;
        }

        public void setDataAccessError(AxdrEnum newVal) {
            resetChoices();
            choice = Choices.DATA_ACCESS_ERROR;
            dataAccessError = newVal;
        }

        public void setBlockNumber(Unsigned16 newVal) {
            resetChoices();
            choice = Choices.BLOCK_NUMBER;
            blockNumber = newVal;
        }

        private void resetChoices() {
            choice = Choices._ERR_NONE_SELECTED;
            success = null;
            dataAccessError = null;
            blockNumber = null;
        }

        @Override
        public String toString() {
            if (choice == Choices.SUCCESS) {
                return "choice: {success: " + success + "}";
            }

            if (choice == Choices.DATA_ACCESS_ERROR) {
                return "choice: {dataAccessError: " + dataAccessError + "}";
            }

            if (choice == Choices.BLOCK_NUMBER) {
                return "choice: {blockNumber: " + blockNumber + "}";
            }

            return "unknown";
        }

    }

}
