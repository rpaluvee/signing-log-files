package com.guardtime.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * This class represents a binary hash tree
 */
@Getter
@Setter
public class HashTree {

    private Node root;
    private List<Node> leafNodes;

    public HashTree(Node root, List<Node> leafNodes) {
        this.root = root;
        this.leafNodes = leafNodes;
    }
}
