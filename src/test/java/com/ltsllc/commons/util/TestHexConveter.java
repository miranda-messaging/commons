package com.ltsllc.commons.util;

import org.junit.Test;

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
}
