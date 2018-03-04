package com.ltsllc.commons.util;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestUtils {
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
    public void positiveReadCompletely () throws IOException {
        byte[] input = { 10, 11, 12, 13 };
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
        byte[] output = Utils.readCompletely(byteArrayInputStream);
        assert (byteArraysAreEqual(input, output));
    }

    @Test
    public void negativeReadComplely () throws IOException {
        byte[] expected = {};
        byte[] actual = Utils.readCompletely((InputStream) null);
        assert (byteArraysAreEqual(expected,actual));

        byte[] buffer = {};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
        actual = Utils.readCompletely(byteArrayInputStream);
        assert (byteArraysAreEqual(expected, actual));
    }
}
