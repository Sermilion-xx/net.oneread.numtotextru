package net.oneread.numtotext;

import net.oneread.numtotext.Interfaces.NTTProcessor;

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

    public static NTTProcessor getRussianProcessor(){
        return NTTRussianProcessor.getInstance();
    }

}
