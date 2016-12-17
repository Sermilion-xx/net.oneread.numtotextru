package net.oneread.numtotext;

import net.oneread.numtotext.Exception.NanException;
import net.oneread.numtotext.Processors.NTTProcessorFactory;
import net.oneread.numtotext.Processors.NTTRussianTextToNumNumToTextProcessor;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * ---------------------------------------------------
 * Created by Sermilion on 17/12/2016.
 * Project: Library
 * ---------------------------------------------------
 * <a href="http://www.ucomplex.org">ucomplex.org</a>
 * <a href="http://www.github.com/sermilion>github</a>
 * ---------------------------------------------------
 */

public class RussianTextToNumberTest {

    private NTTRussianTextToNumNumToTextProcessor numbersProcessor;

    private void init(){
        numbersProcessor = (NTTRussianTextToNumNumToTextProcessor) NTTProcessorFactory.getRussianTextToNumProcessor();
    }

    @Test
    public void shouldReturn1ForText1(){
        init();
        numbersProcessor.textToNum("один");
        assertTrue(numbersProcessor.textToNum("один")==1);
    }

    @Test
    public void shouldReturn100ForText100(){
        init();
        numbersProcessor.textToNum("сто");
        assertTrue(numbersProcessor.textToNum("сто")==100);
    }

    @Test
    public void shouldReturn345ForText345(){
        init();
        numbersProcessor.textToNum("тристо сорок пять");
        assertTrue(numbersProcessor.textToNum("тристо сорок пять")==345);
    }

    @Test
    public void shouldReturn333345ForText333345(){
        init();
        long num = numbersProcessor.textToNum("тристо тридцать три тысячи тристо сорок пять");
        assertTrue(num==333345);
    }

    @Test
    public void shouldReturn1234567ForText1234567(){
        init();
        long num = numbersProcessor.textToNum("один миллион двести тридцать четыре тысячи пятьсот шестьдесят семь");
        assertTrue(num==1234567);
    }

    @org.junit.Test
    public void shouldReturn100234567ForText100234567(){
        init();
        long num = numbersProcessor.textToNum("сто миллионов двести тридцать четыре тысячи пятьсот шестьдесят семь");
        assertTrue(num==100234567);
    }

    @org.junit.Test
    public void shouldReturn999234567ForText999234567(){
        init();
        long num = numbersProcessor.textToNum("девятьсот девяносто девять миллионов двести тридцать четыре тысячи пятьсот шестьдесят семь");
        assertTrue(num==999234567);
    }

    @org.junit.Test
    public void shouldReturn1000000000ForText1000000000(){
        init();
        long num = numbersProcessor.textToNum("один миллиард");
        assertTrue(num==1000000000);
    }

    @org.junit.Test
    public void shouldReturnRu199235463987For199235463987(){
        init();
        long num = numbersProcessor.textToNum("сто девяносто девять миллиардов двести тридцать пять миллионов четыресто шестьдесят три тысячи девятьсот восемьдесят семь");
        assertTrue(num==199235463987L);
    }

    @org.junit.Test
    public void shouldReturnRu1000000000000For1000000000000(){
        init();
        long num = numbersProcessor.textToNum("один триллион");
        assertTrue(num == 1000000000000L);
    }

}
