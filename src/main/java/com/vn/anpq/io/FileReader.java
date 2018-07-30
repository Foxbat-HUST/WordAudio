package com.vn.anpq.io;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anpq on 2018/07/30.
 */
public class FileReader {

    public List<String> readWordList(String filePath, String...serpators) throws IOException {
        List<String> lines=readFileContent(filePath);
        List<String> words=new ArrayList<>();
        for(int i=0;i<lines.size();i++){
            String line=lines.get(i);
            if(line==null||line.isEmpty()){
                continue;
            }
            if(line.split("：").length<2){
                System.out.println("line: "+(i+1)+" text: "+line+" parse error");
                continue;
            }
            words.add(line.split("：")[1]);
        }
        return words;
    }

    private List<String> readFileContent(String filePath) throws IOException {
        File file=new File(filePath);
        List<String> lines = FileUtils.readLines(file, "UTF-8");
        return lines;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new FileReader().readWordList("test_file.txt", new String[]{":"}));
    }
}
