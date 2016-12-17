package net.oneread.numtotext.Interfaces;

import java.util.List;

/**
 * ---------------------------------------------------
 * Created by Sermilion on 17/12/2016.
 * Project: Library
 * ---------------------------------------------------
 * <a href="http://www.ucomplex.org">ucomplex.org</a>
 * <a href="http://www.github.com/sermilion>github</a>
 * ---------------------------------------------------
 */

public interface NTTTextToNumProcessor {
    List<Long> process(List<String> items);
}
