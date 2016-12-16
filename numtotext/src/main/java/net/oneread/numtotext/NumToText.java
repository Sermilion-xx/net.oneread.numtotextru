package net.oneread.numtotext;

import net.oneread.numtotext.Interfaces.NTTProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ---------------------------------------------------
 * Created by Sermilion on 14/12/2016.
 * Project: Library
 * ---------------------------------------------------
 * <a href="http://www.ucomplex.org">ucomplex.org</a>
 * <a href="http://www.github.com/sermilion>github</a>
 * ---------------------------------------------------
 */

class NumToText {

    private List<String> loadDataFromFile(String filename) {
        List<String> mItems = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = in.readLine()) != null)
                mItems.add(str);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mItems;
    }


    public static void main(String[] arg){
        NumToText numToText = new NumToText();
        List<String> list = numToText.loadDataFromFile("input.txt");
        NTTProcessor processor = NTTProcessorFactory.getRussianProcessor();
        List<String> processe = processor.process(list);
        System.out.println(processe);

        NTTWriter writer = new NTTWriter("output.txt");
        for(int i = 0; i < processe.size(); i++) {
            writer.writeToWriter(processe.get(i));
        }
        writer.closeWriter();
    }

}
