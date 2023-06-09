/**
 * This class file was automatically generated by the AXDR compiler that is part of jDLMS (http://www.openmuc.org)
 */

package org.openmuc.jdlms.internal.asn1.cosem;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jdlms.internal.asn1.axdr.AxdrType;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrBitString;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrBoolean;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrEnum;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrNull;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrOctetString;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrSequenceOf;
import org.openmuc.jdlms.internal.asn1.axdr.types.AxdrVisibleString;

import com.beanit.asn1bean.ber.ReverseByteArrayOutputStream;

public class Data implements AxdrType {

    public byte[] code = null;

    public static enum Choices {
        _ERR_NONE_SELECTED(-1),
        NULL_DATA(0),
        ARRAY(1),
        STRUCTURE(2),
        BOOL(3),
        BIT_STRING(4),
        DOUBLE_LONG(5),
        DOUBLE_LONG_UNSIGNED(6),
        OCTET_STRING(9),
        VISIBLE_STRING(10),
        UTF8_STRING(12),
        BCD(13),
        INTEGER(15),
        LONG_INTEGER(16),
        UNSIGNED(17),
        LONG_UNSIGNED(18),
        COMPACT_ARRAY(19),
        LONG64(20),
        LONG64_UNSIGNED(21),
        ENUMERATE(22),
        FLOAT32(23),
        FLOAT64(24),
        DATE_TIME(25),
        DATE(26),
        TIME(27),
        DONT_CARE(255),;

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

    public static class SubSeqOfArray extends AxdrSequenceOf<Data> {

        @Override
        protected Data createListElement() {
            return new Data();
        }

        protected SubSeqOfArray(int length) {
            super(length);
        }

        public SubSeqOfArray() {
        } // Call empty base constructor

    }

    public static class SubSeqOfStructure extends AxdrSequenceOf<Data> {

        @Override
        protected Data createListElement() {
            return new Data();
        }

        protected SubSeqOfStructure(int length) {
            super(length);
        }

        public SubSeqOfStructure() {
        } // Call empty base constructor

    }

    public static class SubSeqCompactArray implements AxdrType {

        public byte[] code = null;
        public TypeDescription contentsDescription = null;

        public AxdrOctetString arrayContents = null;

        public SubSeqCompactArray() {
        }

        public SubSeqCompactArray(byte[] code) {
            this.code = code;
        }

        public SubSeqCompactArray(TypeDescription contentsDescription, AxdrOctetString arrayContents) {
            this.contentsDescription = contentsDescription;
            this.arrayContents = arrayContents;
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
                codeLength += arrayContents.encode(axdrOStream);

                codeLength += contentsDescription.encode(axdrOStream);

            }

            return codeLength;

        }

        @Override
        public int decode(InputStream iStream) throws IOException {
            int codeLength = 0;

            contentsDescription = new TypeDescription();
            codeLength += contentsDescription.decode(iStream);

            arrayContents = new AxdrOctetString();
            codeLength += arrayContents.decode(iStream);

            return codeLength;
        }

        public void encodeAndSave(int encodingSizeGuess) throws IOException {
            ReverseByteArrayOutputStream axdrOStream = new ReverseByteArrayOutputStream(encodingSizeGuess);
            encode(axdrOStream);
            code = axdrOStream.getArray();
        }

        @Override
        public String toString() {
            return "sequence: {" + "contentsDescription: " + contentsDescription + ", arrayContents: " + arrayContents
                    + "}";
        }

    }

    public AxdrNull nullData = null;

    public SubSeqOfArray array = null;

    public SubSeqOfStructure structure = null;

    public AxdrBoolean bool = null;

    public AxdrBitString bitString = null;

    public Integer32 doubleLong = null;

    public Unsigned32 doubleLongUnsigned = null;

    public AxdrOctetString octetString = null;

    public AxdrVisibleString visibleString = null;

    public AxdrOctetString utf8String = null;

    public Integer8 bcd = null;

    public Integer8 integer = null;

    public Integer16 longInteger = null;

    public Unsigned8 unsigned = null;

    public Unsigned16 longUnsigned = null;

    public SubSeqCompactArray compactArray = null;

    public Integer64 long64 = null;

    public Unsigned64 long64Unsigned = null;

    public Enum enumerate = null;

    public AxdrOctetString float32 = null;

    public AxdrOctetString float64 = null;

    public AxdrOctetString dateTime = null;

    public AxdrOctetString date = null;

    public AxdrOctetString time = null;

    public AxdrNull dontCare = null;

    public Data() {
    }

    public Data(byte[] code) {
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

        if (choice == Choices.DONT_CARE) {
            codeLength += dontCare.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(255);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.TIME) {
            codeLength += time.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(27);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.DATE) {
            codeLength += date.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(26);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.DATE_TIME) {
            codeLength += dateTime.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(25);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.FLOAT64) {
            codeLength += float64.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(24);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.FLOAT32) {
            codeLength += float32.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(23);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.ENUMERATE) {
            codeLength += enumerate.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(22);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.LONG64_UNSIGNED) {
            codeLength += long64Unsigned.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(21);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.LONG64) {
            codeLength += long64.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(20);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.COMPACT_ARRAY) {
            codeLength += compactArray.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(19);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.LONG_UNSIGNED) {
            codeLength += longUnsigned.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(18);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.UNSIGNED) {
            codeLength += unsigned.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(17);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.LONG_INTEGER) {
            codeLength += longInteger.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(16);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.INTEGER) {
            codeLength += integer.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(15);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.BCD) {
            codeLength += bcd.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(13);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.UTF8_STRING) {
            codeLength += utf8String.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(12);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.VISIBLE_STRING) {
            codeLength += visibleString.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(10);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.OCTET_STRING) {
            codeLength += octetString.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(9);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.DOUBLE_LONG_UNSIGNED) {
            codeLength += doubleLongUnsigned.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(6);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.DOUBLE_LONG) {
            codeLength += doubleLong.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(5);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.BIT_STRING) {
            codeLength += bitString.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(4);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.BOOL) {
            codeLength += bool.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(3);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.STRUCTURE) {
            codeLength += structure.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(2);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.ARRAY) {
            codeLength += array.encode(axdrOStream);
            AxdrEnum c = new AxdrEnum(1);
            codeLength += c.encode(axdrOStream);
            return codeLength;
        }

        if (choice == Choices.NULL_DATA) {
            codeLength += nullData.encode(axdrOStream);
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

        if (choice == Choices.NULL_DATA) {
            nullData = new AxdrNull();
            codeLength += nullData.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.ARRAY) {
            array = new SubSeqOfArray();
            codeLength += array.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.STRUCTURE) {
            structure = new SubSeqOfStructure();
            codeLength += structure.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.BOOL) {
            bool = new AxdrBoolean();
            codeLength += bool.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.BIT_STRING) {
            bitString = new AxdrBitString();
            codeLength += bitString.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.DOUBLE_LONG) {
            doubleLong = new Integer32();
            codeLength += doubleLong.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.DOUBLE_LONG_UNSIGNED) {
            doubleLongUnsigned = new Unsigned32();
            codeLength += doubleLongUnsigned.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.OCTET_STRING) {
            octetString = new AxdrOctetString();
            codeLength += octetString.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.VISIBLE_STRING) {
            visibleString = new AxdrVisibleString();
            codeLength += visibleString.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.UTF8_STRING) {
            utf8String = new AxdrOctetString();
            codeLength += utf8String.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.BCD) {
            bcd = new Integer8();
            codeLength += bcd.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.INTEGER) {
            integer = new Integer8();
            codeLength += integer.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.LONG_INTEGER) {
            longInteger = new Integer16();
            codeLength += longInteger.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.UNSIGNED) {
            unsigned = new Unsigned8();
            codeLength += unsigned.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.LONG_UNSIGNED) {
            longUnsigned = new Unsigned16();
            codeLength += longUnsigned.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.COMPACT_ARRAY) {
            compactArray = new SubSeqCompactArray();
            codeLength += compactArray.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.LONG64) {
            long64 = new Integer64();
            codeLength += long64.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.LONG64_UNSIGNED) {
            long64Unsigned = new Unsigned64();
            codeLength += long64Unsigned.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.ENUMERATE) {
            enumerate = new Enum();
            codeLength += enumerate.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.FLOAT32) {
            float32 = new AxdrOctetString(4);
            codeLength += float32.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.FLOAT64) {
            float64 = new AxdrOctetString(8);
            codeLength += float64.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.DATE_TIME) {
            dateTime = new AxdrOctetString(12);
            codeLength += dateTime.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.DATE) {
            date = new AxdrOctetString(5);
            codeLength += date.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.TIME) {
            time = new AxdrOctetString(4);
            codeLength += time.decode(iStream);
            return codeLength;
        }

        if (choice == Choices.DONT_CARE) {
            dontCare = new AxdrNull();
            codeLength += dontCare.decode(iStream);
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

    public void setNullData(AxdrNull newVal) {
        resetChoices();
        choice = Choices.NULL_DATA;
        nullData = newVal;
    }

    public void setArray(SubSeqOfArray newVal) {
        resetChoices();
        choice = Choices.ARRAY;
        array = newVal;
    }

    public void setStructure(SubSeqOfStructure newVal) {
        resetChoices();
        choice = Choices.STRUCTURE;
        structure = newVal;
    }

    public void setBool(AxdrBoolean newVal) {
        resetChoices();
        choice = Choices.BOOL;
        bool = newVal;
    }

    public void setBitString(AxdrBitString newVal) {
        resetChoices();
        choice = Choices.BIT_STRING;
        bitString = newVal;
    }

    public void setDoubleLong(Integer32 newVal) {
        resetChoices();
        choice = Choices.DOUBLE_LONG;
        doubleLong = newVal;
    }

    public void setDoubleLongUnsigned(Unsigned32 newVal) {
        resetChoices();
        choice = Choices.DOUBLE_LONG_UNSIGNED;
        doubleLongUnsigned = newVal;
    }

    public void setOctetString(AxdrOctetString newVal) {
        resetChoices();
        choice = Choices.OCTET_STRING;
        octetString = newVal;
    }

    public void setVisibleString(AxdrVisibleString newVal) {
        resetChoices();
        choice = Choices.VISIBLE_STRING;
        visibleString = newVal;
    }

    public void setUtf8String(AxdrOctetString newVal) {
        resetChoices();
        choice = Choices.UTF8_STRING;
        utf8String = newVal;
    }

    public void setBcd(Integer8 newVal) {
        resetChoices();
        choice = Choices.BCD;
        bcd = newVal;
    }

    public void setInteger(Integer8 newVal) {
        resetChoices();
        choice = Choices.INTEGER;
        integer = newVal;
    }

    public void setLongInteger(Integer16 newVal) {
        resetChoices();
        choice = Choices.LONG_INTEGER;
        longInteger = newVal;
    }

    public void setUnsigned(Unsigned8 newVal) {
        resetChoices();
        choice = Choices.UNSIGNED;
        unsigned = newVal;
    }

    public void setLongUnsigned(Unsigned16 newVal) {
        resetChoices();
        choice = Choices.LONG_UNSIGNED;
        longUnsigned = newVal;
    }

    public void setCompactArray(SubSeqCompactArray newVal) {
        resetChoices();
        choice = Choices.COMPACT_ARRAY;
        compactArray = newVal;
    }

    public void setLong64(Integer64 newVal) {
        resetChoices();
        choice = Choices.LONG64;
        long64 = newVal;
    }

    public void setLong64Unsigned(Unsigned64 newVal) {
        resetChoices();
        choice = Choices.LONG64_UNSIGNED;
        long64Unsigned = newVal;
    }

    public void setEnumerate(Enum newVal) {
        resetChoices();
        choice = Choices.ENUMERATE;
        enumerate = newVal;
    }

    public void setFloat32(AxdrOctetString newVal) {
        resetChoices();
        choice = Choices.FLOAT32;
        float32 = newVal;
    }

    public void setFloat64(AxdrOctetString newVal) {
        resetChoices();
        choice = Choices.FLOAT64;
        float64 = newVal;
    }

    public void setDateTime(AxdrOctetString newVal) {
        resetChoices();
        choice = Choices.DATE_TIME;
        dateTime = newVal;
    }

    public void setDate(AxdrOctetString newVal) {
        resetChoices();
        choice = Choices.DATE;
        date = newVal;
    }

    public void setTime(AxdrOctetString newVal) {
        resetChoices();
        choice = Choices.TIME;
        time = newVal;
    }

    public void setDontCare(AxdrNull newVal) {
        resetChoices();
        choice = Choices.DONT_CARE;
        dontCare = newVal;
    }

    private void resetChoices() {
        choice = Choices._ERR_NONE_SELECTED;
        nullData = null;
        array = null;
        structure = null;
        bool = null;
        bitString = null;
        doubleLong = null;
        doubleLongUnsigned = null;
        octetString = null;
        visibleString = null;
        utf8String = null;
        bcd = null;
        integer = null;
        longInteger = null;
        unsigned = null;
        longUnsigned = null;
        compactArray = null;
        long64 = null;
        long64Unsigned = null;
        enumerate = null;
        float32 = null;
        float64 = null;
        dateTime = null;
        date = null;
        time = null;
        dontCare = null;
    }

    @Override
    public String toString() {
        if (choice == Choices.NULL_DATA) {
            return "choice: {nullData: " + nullData + "}";
        }

        if (choice == Choices.ARRAY) {
            return "choice: {array: " + array + "}";
        }

        if (choice == Choices.STRUCTURE) {
            return "choice: {structure: " + structure + "}";
        }

        if (choice == Choices.BOOL) {
            return "choice: {bool: " + bool + "}";
        }

        if (choice == Choices.BIT_STRING) {
            return "choice: {bitString: " + bitString + "}";
        }

        if (choice == Choices.DOUBLE_LONG) {
            return "choice: {doubleLong: " + doubleLong + "}";
        }

        if (choice == Choices.DOUBLE_LONG_UNSIGNED) {
            return "choice: {doubleLongUnsigned: " + doubleLongUnsigned + "}";
        }

        if (choice == Choices.OCTET_STRING) {
            return "choice: {octetString: " + octetString + "}";
        }

        if (choice == Choices.VISIBLE_STRING) {
            return "choice: {visibleString: " + visibleString + "}";
        }

        if (choice == Choices.UTF8_STRING) {
            return "choice: {utf8String: " + utf8String + "}";
        }

        if (choice == Choices.BCD) {
            return "choice: {bcd: " + bcd + "}";
        }

        if (choice == Choices.INTEGER) {
            return "choice: {integer: " + integer + "}";
        }

        if (choice == Choices.LONG_INTEGER) {
            return "choice: {longInteger: " + longInteger + "}";
        }

        if (choice == Choices.UNSIGNED) {
            return "choice: {unsigned: " + unsigned + "}";
        }

        if (choice == Choices.LONG_UNSIGNED) {
            return "choice: {longUnsigned: " + longUnsigned + "}";
        }

        if (choice == Choices.COMPACT_ARRAY) {
            return "choice: {compactArray: " + compactArray + "}";
        }

        if (choice == Choices.LONG64) {
            return "choice: {long64: " + long64 + "}";
        }

        if (choice == Choices.LONG64_UNSIGNED) {
            return "choice: {long64Unsigned: " + long64Unsigned + "}";
        }

        if (choice == Choices.ENUMERATE) {
            return "choice: {enumerate: " + enumerate + "}";
        }

        if (choice == Choices.FLOAT32) {
            return "choice: {float32: " + float32 + "}";
        }

        if (choice == Choices.FLOAT64) {
            return "choice: {float64: " + float64 + "}";
        }

        if (choice == Choices.DATE_TIME) {
            return "choice: {dateTime: " + dateTime + "}";
        }

        if (choice == Choices.DATE) {
            return "choice: {date: " + date + "}";
        }

        if (choice == Choices.TIME) {
            return "choice: {time: " + time + "}";
        }

        if (choice == Choices.DONT_CARE) {
            return "choice: {dontCare: " + dontCare + "}";
        }

        return "unknown";
    }

}
