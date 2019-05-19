package com.guardtime.builder;

import com.guardtime.tree.HashTree;
import com.guardtime.tree.Node;
import com.guardtime.util.HashTreeUtil;
import com.guardtime.util.Sha256;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to get the hash chain from hash tree
 */
public class HashChainBuilder {

    public static List<Node> build(HashTree hashTree, String entry) {
        List<Node> hashChain = new ArrayList<>();
        String hash = Sha256.hash(entry);

        Node leafNode = HashTreeUtil.findLeaf(hash, hashTree.getLeafNodes());

        if (leafNode == null) {
            throw new RuntimeException("Entry not found in tree");
        }

        buildHashChainRecursively(hashChain, leafNode);

        if (!isHashChainValid(hashChain)) {
            throw new RuntimeException("Can't build invalid hash chain");
        }

        return hashChain;
    }

    private static void buildHashChainRecursively(List<Node> hashChain, Node node) {
        if (node != null) {
            hashChain.add(node);
            buildHashChainRecursively(hashChain, node.getParent());
        }
    }

    /*
     * Validates that the hash chain belongs to the hash tree
     */
    private static boolean isHashChainValid(List<Node> hashChain) {
        for (Node node : hashChain) {
            Node parent = node.getParent();

            if (parent == null) {
                if (!node.getHash().equals(Sha256.hash(node.getLeft().getHash() + node.getRight().getHash()))) {
                    return false;
                }
                break;
            }

            if (parent.getRight() == null) {
                if (!parent.getHash().equals(parent.getLeft().getHash())) {
                    return false;
                }
            } else {
                if (!parent.getHash().equals(Sha256.hash(parent.getLeft().getHash() + parent.getRight().getHash()))) {
                    return false;
                }
            }
        }

        return true;
    }

}
