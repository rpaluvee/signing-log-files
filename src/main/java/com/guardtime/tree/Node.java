package com.guardtime.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represents a node in a tree.
 * Internal Nodes will have at least one child (always on the left).
 * Leaf Nodes will have no children (left = right = null).
 */
@Getter
@Setter
public class Node {

    private Node left;
    private Node right;
    private Node parent;
    private String hash;

}
