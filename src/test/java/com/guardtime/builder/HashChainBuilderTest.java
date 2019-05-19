package com.guardtime.builder;

import com.guardtime.TestUtil;
import com.guardtime.tree.HashTree;
import com.guardtime.tree.Node;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HashChainBuilderTest extends TestUtil {

    @Test
    public void returnsCorrectRoot() {
        HashTree hashTree = HashTreeBuilder.build(readLinesToArray(SMALL_LOGFILE_PATH));
        List<Node> hashChain = HashChainBuilder.build(hashTree, "[INFO] No tests to run.");
        assertEquals(hashTree.getRoot().getHash(), hashChain.get(hashChain.size() - 1).getHash());
    }

    @Test(expected = RuntimeException.class)
    public void throwsExceptionIfEntryNotFound() {
        HashTree hashTree = HashTreeBuilder.build(readLinesToArray(SMALL_LOGFILE_PATH));
        HashChainBuilder.build(hashTree, "bla");
    }

}
