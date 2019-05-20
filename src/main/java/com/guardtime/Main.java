package com.guardtime;

import com.guardtime.builder.HashChainBuilder;
import com.guardtime.builder.HashTreeBuilder;
import com.guardtime.tree.HashTree;
import com.guardtime.tree.Node;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> entries = Files.readAllLines(Paths.get(args[0]));

        HashTree hashTree = HashTreeBuilder.build(entries);
        List<Node> hashChain = HashChainBuilder.build(hashTree, "[INFO] BUILD SUCCESS");

        /*
        Node root = hashChain.get(hashChain.size() - 1);
        KSISignature ksiSignature = KsiSigner.signHash(root.getHash());
         */
    }

}
