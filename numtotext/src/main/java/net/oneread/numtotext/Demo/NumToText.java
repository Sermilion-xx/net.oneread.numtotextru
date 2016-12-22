package net.oneread.numtotext.Demo;

import net.oneread.numtotext.Interfaces.NTTNumToTextProcessor;
import net.oneread.numtotext.Interfaces.NTTTextToNumProcessor;
import net.oneread.numtotext.Processors.NTTProcessorFactory;

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

    private List<Long> loadNumbersFromFile(String filename) {
        List<Long> mItems = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = in.readLine()) != null) {
                if (isNum(str)) {
                    mItems.add(Long.valueOf(str));
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mItems;
    }

    private List<String> loadTextNumbersFromFile(String filename) {
        List<String> mItems = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = in.readLine()) != null) {
                mItems.add(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mItems;
    }

    private static boolean isNum(String strNum) {
        boolean ret = true;
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }


    public static void main(String[] arg) {
        NumToText numToText = new NumToText();
        List<Long> list = numToText.loadNumbersFromFile("input.txt");
        NTTNumToTextProcessor processor = NTTProcessorFactory.getRussianNumToTextProcessor();
        List<String> processe = processor.process(list);
        System.out.println(processe);

        NTTWriter writer = new NTTWriter("output.txt");
        for (int i = 0; i < processe.size(); i++) {
            writer.write(processe.get(i));
        }
        writer.close();

        //Перевод текста в числа
        List<String> textList = numToText.loadTextNumbersFromFile("output.txt");
        NTTTextToNumProcessor backProcessor = NTTProcessorFactory.getRussianTextToNumProcessor();
        List<Long> backProcessed = backProcessor.process(textList);
        System.out.println(backProcessed);
    }

}
