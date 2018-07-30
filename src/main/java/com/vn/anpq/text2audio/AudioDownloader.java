package com.vn.anpq.text2audio;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by anpq on 2018/07/30.
 */
public class AudioDownloader {
    public void saveFileFromUrl(String url, String fileName) throws IOException {
        FileUtils.copyURLToFile(new URL(url), new File(fileName));
    }
}
