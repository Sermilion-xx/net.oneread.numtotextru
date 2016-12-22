package net.oneread.numtotext.Processors;

import net.oneread.numtotext.Interfaces.NTTNumToTextProcessor;
import net.oneread.numtotext.Interfaces.NTTTextToNumProcessor;

/**
 * ---------------------------------------------------
 * Created by Sermilion on 14/12/2016.
 * Project: Library
 * ---------------------------------------------------
 * <a href="http://www.ucomplex.org">ucomplex.org</a>
 * <a href="http://www.github.com/sermilion>github</a>
 * ---------------------------------------------------
 */

public class NTTProcessorFactory {

    public static NTTNumToTextProcessor getRussianNumToTextProcessor(){
        return NTTRussianNumToText.getInstance();
    }

    public static NTTTextToNumProcessor getRussianTextToNumProcessor(){
        return NTTRussianTextToNum.getInstance();
    }

}
