package net.oneread.numtotext.Processors;

import net.oneread.numtotext.Exception.NanException;
import net.oneread.numtotext.Interfaces.NTTTextToNumProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ---------------------------------------------------
 * Created by Sermilion on 17/12/2016.
 * Project: Library
 * ---------------------------------------------------
 * <a href="http://www.ucomplex.org">ucomplex.org</a>
 * <a href="http://www.github.com/sermilion>github</a>
 * ---------------------------------------------------
 */

public class NTTRussianTextToNum implements NTTTextToNumProcessor {

    static NTTRussianTextToNum getInstance() {
        return new NTTRussianTextToNum();
    }

    private Map<String, Long> keyValue = new HashMap<>();

    private NTTRussianTextToNum() {
        keyValue.put("один", 1L);
        keyValue.put("одна", 1L);
        keyValue.put("два", 2L);
        keyValue.put("две", 2L);
        keyValue.put("три", 3L);
        keyValue.put("четыре", 4L);
        keyValue.put("пять", 5L);
        keyValue.put("шесть", 6L);
        keyValue.put("семь", 7L);
        keyValue.put("восемь", 8L);
        keyValue.put("девять", 9L);
        keyValue.put("десять", 10L);

        keyValue.put("одиннадцать", 11L);
        keyValue.put("двенадцать", 12L);
        keyValue.put("тринадцать", 13L);
        keyValue.put("четырнадцать", 14L);
        keyValue.put("пятьнадцать", 15L);
        keyValue.put("шестьнадцать", 16L);
        keyValue.put("семьнадцать", 17L);
        keyValue.put("восемьнадцать", 18L);
        keyValue.put("девятьнадцать", 19L);
        keyValue.put("двадцать", 20L);

        keyValue.put("двадцать", 20L);
        keyValue.put("тридцать", 30L);
        keyValue.put("сорок", 40L);
        keyValue.put("пятьдесят", 50L);
        keyValue.put("шестьдесят", 60L);
        keyValue.put("семьдесят", 70L);
        keyValue.put("восемьдесят", 80L);
        keyValue.put("девяносто", 90L);

        keyValue.put("сто", 100L);
        keyValue.put("двести", 200L);
        keyValue.put("тристо", 300L);
        keyValue.put("четыресто", 400L);
        keyValue.put("пятьсот", 500L);
        keyValue.put("шестьсот", 600L);
        keyValue.put("семьсот", 700L);
        keyValue.put("восемьсот", 800L);
        keyValue.put("девятьсот", 900L);
        keyValue.put("тысяча", 1000L);
        keyValue.put("тысячи", 1000L);
        keyValue.put("тысяч", 1000L);

        keyValue.put("миллион", 1000000L);
        keyValue.put("миллиона", 1000000L);
        keyValue.put("миллионов", 1000000L);
        keyValue.put("миллиард", 1000000000L);
        keyValue.put("миллиарда", 1000000000L);
        keyValue.put("миллиардов", 1000000000L);
        keyValue.put("триллион", 1000000000000L);
        keyValue.put("триллиона", 1000000000000L);
        keyValue.put("триллионов", 1000000000000L);
    }

    @Override
    public List<Long> process(List<String> items) {
        List<Long> processedItems = new ArrayList<>();
        for (String number : items) {
            long newNum = textToNum(number);
            if (newNum != -1) {
                processedItems.add(newNum);
            }
        }
        return processedItems;
    }

    public long textToNum(String number) {
        ArrayList<Long> newParts = new ArrayList<>();
        String[] parts = number.split(" ");
        long result = 0L;
        for (String part : parts) {
            if(result==-1){
                result = 0;
            }
            if (keyValue.containsKey(part)) {
                long num = keyValue.get(part);
                if (num == 1000 || num == 1000000 || num == 1000000000 || num == 1000000000000L) {
                    result = result * num;
                    newParts.add(result);
                    result = 0L;
                } else {
                    result = result + num;
                }
            } else {
                try {
                    throw new NanException("Expected string represented number. Actual: "+part);
                } catch (NanException e) {
                    e.printStackTrace();
                    result = -1;
                }
            }
        }
        for (long part : newParts) {
            result += part;
        }
        return result;
    }
}
