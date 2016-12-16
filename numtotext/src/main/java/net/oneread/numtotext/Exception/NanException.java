package net.oneread.numtotext.Exception;

/**
 * ---------------------------------------------------
 * Created by Sermilion on 16/12/2016.
 * Project: Library
 * ---------------------------------------------------
 * <a href="http://www.ucomplex.org">ucomplex.org</a>
 * <a href="http://www.github.com/sermilion>github</a>
 * ---------------------------------------------------
 */

public class NanException extends IllegalArgumentException {

    @Override
    public String getMessage() {
        return "Input is not a number";
    }
}
