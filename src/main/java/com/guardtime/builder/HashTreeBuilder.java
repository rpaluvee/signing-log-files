package com.guardtime.builder;

import com.guardtime.tree.HashTree;
import com.guardtime.tree.Node;
import com.guardtime.util.Sha256;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to build a hash tree
 */
public class HashTreeBuilder {

    public static HashTree build(List<String> entries) {
        if (entries.isEmpty()) {
            throw new IllegalArgumentException("Can't build hash tree of empty array");
        }
        List<Node> leafNodes = buildLeafNodes(entries);
        List<Node> internalNodes = new ArrayList<>(leafNodes);

        while (internalNodes.size() > 1) {
            internalNodes = buildInternalNodes(internalNodes);
        }
        Node root = internalNodes.get(0);

        return new HashTree(root, leafNodes);
    }

    private static List<Node> buildLeafNodes(List<String> entries) {
        List<Node> leafNodes = new ArrayList<>();

        for(String entry : entries) {
            leafNodes.add(buildLeafNode(entry));
        }

        return leafNodes;
    }

    private static Node buildLeafNode(String entry) {
        Node node = new Node();
        node.setHash(Sha256.hash(entry));

        return node;
    }

    private static List<Node> buildInternalNodes(List<Node> children) {
        List<Node> internalNodes = new ArrayList<>();

        for (int i = 0; i < children.size() - 1; i += 2) {
            Node leftChild = children.get(i);
            Node rightChild = children.get(i + 1);

            Node parent = buildInternalNode(leftChild, rightChild);
            internalNodes.add(parent);
        }

        // in case of odd number of children you need to add the last node to the next layer
        if (children.size() % 2 != 0) {
            Node child = children.get(children.size() - 1);
            Node parent = buildInternalNode(child, null);
            internalNodes.add(parent);
        }

        return internalNodes;
    }

    private static Node buildInternalNode(Node leftChild, Node rightChild) {
        Node parent = new Node();
        parent.setLeft(leftChild);
        parent.setRight(rightChild);

        if (rightChild == null) {
            parent.setHash(Sha256.hash(leftChild.getHash()));
            leftChild.setParent(parent);
        } else {
            parent.setHash(Sha256.hash(leftChild.getHash() + rightChild.getHash()));
            leftChild.setParent(parent);
            rightChild.setParent(parent);
        }

        return parent;
    }

}
