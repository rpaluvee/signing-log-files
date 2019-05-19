package com.guardtime.util;

import com.guardtime.tree.Node;

import java.util.List;

public class HashTreeUtil {

    /*
     * Finds the first leaf with specified hash
     */
    public static Node findLeaf(String hash, List<Node> leafNodes) {
        return leafNodes.stream()
                .filter((leaf) -> leaf.getHash().equals(hash))
                .findFirst()
                .orElse(null);
    }

}
