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
        String filepath = args.length > 0 && args[0] != null ? args[0] : "";
        String entry = args.length > 1 && args[1] != null ? args[1] : "";

        if (!filepath.isEmpty() && !entry.isEmpty()) {
            List<String> entries = Files.readAllLines(Paths.get(filepath));

            HashTree hashTree = HashTreeBuilder.build(entries);
            List<Node> hashChain = HashChainBuilder.build(hashTree, entry);

            /*
            Node root = hashChain.get(hashChain.size() - 1);
            KSISignature ksiSignature = KsiSigner.signHash(root.getHash());
             */
        }

    }

}
