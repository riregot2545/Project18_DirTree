package com.nix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirTreeWriter implements FileTreeWriter<DirTree>{

    public void write(DirTree tree, File output) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write(prettyPrint(tree));
            writer.flush();
        }

    }

    private String prettyPrint(DirTree tree) {
        int offset = 0;
        StringBuilder stringBuilder = new StringBuilder();
        directoryAppender(tree.getRoot(), offset, stringBuilder);
        return stringBuilder.toString();
    }

    private void directoryAppender(DirTree.DirNode node, int offset, StringBuilder buffer) {
        buffer.append(getCurrentOffset(offset));
        buffer.append("|---< ");
        buffer.append(node.getDirectory().getName());
        buffer.append("\n");
        for (DirTree.DirNode subDirectory : node.getSubDirectories()) {
            directoryAppender(subDirectory, offset + 1, buffer);
        }
    }

    private String getCurrentOffset(int offset) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < offset; i++) {
            stringBuilder.append("|  ");
        }
        return stringBuilder.toString();
    }
}
