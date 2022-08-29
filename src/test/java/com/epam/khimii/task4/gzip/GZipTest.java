package com.epam.khimii.task4.gzip;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPOutputStream;

public class GZipTest {
    @Test
    public void shouldSaveProductListInGZip() throws IOException {
        int c;
        File archive = new File("GZipTest.txt.gz");
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(
                "fileForTask6.txt")));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(
                new FileOutputStream(archive)));
        while ((c = in.read()) != -1) {
            out.write(String.valueOf((char) c).getBytes("GBK"));
        }
        in.close();
        out.close();
        Assert.assertTrue(archive.exists());
    }
}
