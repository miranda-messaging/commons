package com.ltsllc.commons.util;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

public class TestHexConveter {
    @Test
    public void positiveToHighNibble () {
        int i = 0xF0;
        int j = HexConverter.toHighNibble(i);
        assert (j == 15);

        i = 0xA0;
        j = HexConverter.toHighNibble(i);
        assert (j == 10);

        i = 0x10;
        j = HexConverter.toHighNibble(i);
        assert (j == 1);

        i = 0x0;
        j = HexConverter.toHighNibble(i);
        assert (j == 0);
    }

    @Test
    public void postiveToHexString () {
        byte[] buffer = { 10, 11, 12, 13, 14, 15 };
        String expected = "0A0B0C0D0E0F";
        String actual = HexConverter.toHexString(buffer);
        assert (expected.equals(actual));
    }

    public boolean byteArraysAreEqual (byte[] ba1, byte[] ba2) {
        if (ba1 == ba2)
            return true;

        if (ba1 == null || ba2 == null || ba1.length != ba2.length)
            return false;

        for (int i = 0; i < ba1.length; i++) {
            if (ba1[i] != ba2[i])
                return false;
        }

        return true;
    }

    @Test
    public void positiveToByteArray () {
        byte[] expected = { 10, 11, 12, 13, 14, 15 };
        byte[] actual = HexConverter.toByteArray("0A0B0C0D0E0F");
        assert (byteArraysAreEqual(expected, actual));
    }

    @Test
    public void positiveToByte () {
        byte b1 = 0xA;

        String stringByte = "0a";

        byte b2 = (byte) HexConverter.toByte(stringByte.toCharArray(), 0);
        assert (b1 == b2);

        stringByte = "a0";
        b1 = (byte) 0xA0;
        b2 = (byte) HexConverter.toByte(stringByte.toCharArray(), 0);
        assert (b1 == b2);
    }

    @Test
    public void positiveToNibble () {
        char c = 'a';
        int expected = 10;
        int actual = HexConverter.toNibble(c);
        assert(expected == actual);
    }

    @Test
    public void positiveToHexString () {
        int i = 0xAA;
        String expected = "AA";
        String actual = HexConverter.toHexString(i);
        assert (expected.equals(actual));
    }

    public byte[] toByteArray(int[] ia) {
        byte[] ba = new byte[ia.length];
        for (int i = 0; i < ia.length; i++) {
            ba[i] = (byte) ia[i];
        }

        return ba;
    }

    @Test
    public void positiveToByteArray2 () throws IOException {
        String string = "AABBCCDDEEFF";
        StringReader stringReader = new StringReader(string);
        int[] expected1 = { 170, 187, 204, 221, 238, 255};
        byte[] expected = toByteArray(expected1);
        byte[] actual = HexConverter.toByteArray(stringReader);
        assert (byteArraysAreEqual(expected, actual));
    }
}
