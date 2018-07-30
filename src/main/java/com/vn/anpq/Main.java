package com.vn.anpq;

import com.vn.anpq.io.FileReader;
import com.vn.anpq.text2audio.AudioDownloader;
import com.vn.anpq.text2audio.AudioUrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anpq on 2018/07/30.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String filePath="test_file.txt";
        FileReader reader=new FileReader();
        AudioUrl urlGetter=new AudioUrl();
        AudioDownloader downloader=new AudioDownloader();

        List<String> words=reader.readWordList(filePath,"：");
        for(int index=0;index<words.size();index++){
            String word=words.get(index);
            String expFileName=String.format("%03d%s.mp3", (index+1),word);
            String url=urlGetter.getAudioUrl(word,9);
            downloader.saveFileFromUrl(url,expFileName);
        }
    }
}
