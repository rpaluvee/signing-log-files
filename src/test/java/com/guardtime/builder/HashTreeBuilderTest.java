package com.guardtime.builder;

import com.guardtime.TestUtil;
import com.guardtime.tree.HashTree;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashTreeBuilderTest extends TestUtil {

    @Test
    public void returnsCorrectSize() {
        HashTree hashTree = HashTreeBuilder.build(readLinesToArray(SMALL_LOGFILE_PATH));
        assertEquals(24, hashTree.getLeafNodes().size());
    }

    @Test
    public void returnsCorrectSizeWithLargerLog() {
        HashTree hashTree = HashTreeBuilder.build(readLinesToArray(LARGE_LOGFILE_PATH));
        assertEquals(140, hashTree.getLeafNodes().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfEmptyFile() {
        HashTreeBuilder.build(readLinesToArray(EMPTY_LOGFILE_PATH));
    }

}
