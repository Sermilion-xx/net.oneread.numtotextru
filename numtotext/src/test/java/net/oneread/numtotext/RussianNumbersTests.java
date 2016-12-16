package net.oneread.numtotext;

import net.oneread.numtotext.Exception.NanException;
import net.oneread.numtotext.Exception.NumberOverTrillionException;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * ---------------------------------------------------
 * Created by Sermilion on 14/12/2016.
 * Project: Library
 * ---------------------------------------------------
 * <a href="http://www.ucomplex.org">ucomplex.org</a>
 * <a href="http://www.github.com/sermilion>github</a>
 * ---------------------------------------------------
 */

public class RussianNumbersTests {

    private NTTRussianProcessor numbersProcessor;

    private void init(){
        numbersProcessor = (NTTRussianProcessor) NTTProcessorFactory.getRussianProcessor();
    }

    @org.junit.Test
    public void shouldReturnOdinFor1(){
        init();
        assertTrue(numbersProcessor.numToString(1).equals("один"));
    }


    @org.junit.Test
    public void shouldReturnRu12For12(){
        init();
        assertTrue(numbersProcessor.numToString(12).equals("двенадцать"));
    }


    @org.junit.Test
    public void shouldReturnRu21For21(){
        init();
        assertTrue(numbersProcessor.numToString(25).equals("двадцать пять"));
    }

    @org.junit.Test
    public void shouldReturnRu45For45(){
        init();
        assertTrue(numbersProcessor.numToString(45).equals("сорок пять"));
    }

    @org.junit.Test
    public void shouldReturnRu99For99(){
        init();
        assertTrue(numbersProcessor.numToString(99).equals("девяносто девять"));
    }

    @org.junit.Test
    public void shouldReturnRu100For100(){
        init();
        assertTrue(numbersProcessor.numToString(100).equals("сто"));
    }

    @org.junit.Test
    public void shouldReturnRu101For101(){
        init();
        assertTrue(numbersProcessor.numToString(101).equals("сто один"));
    }

    @org.junit.Test
    public void shouldReturnRu125For125(){
        init();
        assertTrue(numbersProcessor.numToString(125).equals("сто двадцать пять"));
    }

    @org.junit.Test
    public void shouldReturnRu149For149(){
        init();
        assertTrue(numbersProcessor.numToString(149).equals("сто сорок девять"));
    }

    @org.junit.Test
    public void shouldReturnRu249For249(){
        init();
        assertTrue(numbersProcessor.numToString(249).equals("двести сорок девять"));
    }

    @org.junit.Test
    public void shouldReturnRu449For449(){
        init();
        assertTrue(numbersProcessor.numToString(449).equals("четыреста сорок девять"));
    }

    @org.junit.Test
    public void shouldReturnRu1000For1000(){
        init();
        assertTrue(numbersProcessor.numToString(1000).equals("одна тысяча"));
    }

    @org.junit.Test
    public void shouldReturnRu1134For1134(){
        init();
        assertTrue(numbersProcessor.numToString(1134).equals("одна тысяча сто тридцать четыре"));
    }

    @org.junit.Test
    public void shouldReturnRu2845For2845(){
        init();
        assertTrue(numbersProcessor.numToString(2845).equals("две тысячи восемьсот сорок пять"));
    }

    @org.junit.Test
    public void shouldReturnRu3845For3845(){
        init();
        assertTrue(numbersProcessor.numToString(3845).equals("три тысячи восемьсот сорок пять"));
    }

    @org.junit.Test
    public void shouldReturnRu5845For5845(){
        init();
        assertTrue(numbersProcessor.numToString(5845).equals("пять тысяч восемьсот сорок пять"));
    }


    @org.junit.Test
    public void shouldReturnRu5678For5678(){
        init();
        String result = numbersProcessor.numToString(5678);
        assertTrue(result.equals("пять тысяч шестьсот семьдесят восемь"));
    }

    @org.junit.Test
    public void shouldReturnRu9874For9874(){
        init();
        String result = numbersProcessor.numToString(9874);
        assertTrue(result.equals("девять тысяч восемьсот семьдесят четыре"));
    }

    @org.junit.Test
    public void shouldReturnRu10000For10000(){
        init();
        String result = numbersProcessor.numToString(10000);
        assertTrue(result.equals("десять тысяч"));
    }

    @org.junit.Test
    public void shouldReturnRu10562For10562(){
        init();
        String result = numbersProcessor.numToString(10562);
        assertTrue(result.equals("десять тысяч пятьсот шестьдесят два"));
    }

    @org.junit.Test
    public void shouldReturnRu25562For25562(){
        init();
        String result = numbersProcessor.numToString(25562);
        assertTrue(result.equals("двадцать пять тысяч пятьсот шестьдесят два"));
    }

    @org.junit.Test
    public void shouldReturnRu46562For46262(){
        init();
        String result = numbersProcessor.numToString(46262);
        assertTrue(result.equals("сорок шесть тысяч двести шестьдесят два"));
    }

    @org.junit.Test
    public void shouldReturnRu99999For99999(){
        init();
        String result = numbersProcessor.numToString(99999);
        assertTrue(result.equals("девяносто девять тысяч девятьсот девяносто девять"));
    }

    @org.junit.Test
    public void shouldReturnRu100000For100000(){
        init();
        String result = numbersProcessor.numToString(100000);
        assertTrue(result.equals("сто тысяч"));
    }

    @org.junit.Test
    public void shouldReturnRu126765For126765(){
        init();
        String result = numbersProcessor.numToString(126765);
        assertTrue(result.equals("сто двадцать шесть тысяч семьсот шестьдесят пять"));
    }

    @org.junit.Test
    public void shouldReturnRu886765For886765(){
        init();
        String result = numbersProcessor.numToString(886765);
        assertTrue(result.equals("восемьсот восемьдесят шесть тысяч семьсот шестьдесят пять"));
    }

    @org.junit.Test
    public void shouldReturnRu1000000For1000000(){
        init();
        String result = numbersProcessor.numToString(1000000);
        assertTrue(result.equals("один миллион"));
    }

    @org.junit.Test
    public void shouldReturnRu1000001For1000001(){
        init();
        String result = numbersProcessor.numToString(1000001);
        assertTrue(result.equals("один миллион один"));
    }

    @org.junit.Test
    public void shouldReturnRu1234567For1234567(){
        init();
        String result = numbersProcessor.numToString(1234567);
        assertTrue(result.equals("один миллион двести тридцать четыре тысячи пятьсот шестьдесят семь"));
    }

    @org.junit.Test
    public void shouldReturnRu100234567For100234567(){
        init();
        String result = numbersProcessor.numToString(100234567);
        assertTrue(result.equals("сто миллионов двести тридцать четыре тысячи пятьсот шестьдесят семь"));
    }

    @org.junit.Test
    public void shouldReturnRu999234567For999234567(){
        init();
        String result = numbersProcessor.numToString(999234567);
        assertTrue(result.equals("девятьсот девяносто девять миллионов двести тридцать четыре тысячи пятьсот шестьдесят семь"));
    }

    @org.junit.Test
    public void shouldReturnRu1000000000For1000000000(){
        init();
        String result = numbersProcessor.numToString(1000000000);
        assertTrue(result.equals("один миллиард"));
    }

    @org.junit.Test
    public void shouldReturnRu199235463987For199235463987(){
        init();
        String result = numbersProcessor.numToString(199235463987L);
        assertTrue(result.equals("сто девяносто девять миллиардов двести тридцать пять миллионов четыреста шестьдесят три тысячи девятьсот восемьдесят семь"));
    }

    @org.junit.Test
    public void shouldReturnRu1000000000000For1000000000000(){
        init();
        String result = numbersProcessor.numToString(1000000000000L);
        assertTrue(result.equals("один триллион"));
    }





}
