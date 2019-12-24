package com.nix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class DirTree {

    private DirNode root;

    public int size() {
        return size(root);
    }

    private int size(DirNode newRoot) {
        int size = newRoot.getSubDirectories().size();
        for (DirNode sub : newRoot.getSubDirectories()) {
            size += size(sub);
        }
        return size;
    }


    @Getter
    public static class DirNode {
        private File directory;
        private List<DirNode> subDirectories;

        public DirNode(File directory) {
            if (!directory.isDirectory())
                throw new IllegalArgumentException("File is not directory!");
            this.directory = directory;
            subDirectories = new ArrayList<>();
        }

        public void appendSub(DirNode node) {
            subDirectories.add(((node)));
        }
    }
}
