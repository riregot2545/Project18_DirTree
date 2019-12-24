package com.nix;

import java.io.File;

//Тут был косяк DirTreeReader, но это не ридер по факту. Он видь только ходит по дирам и строит дерево
public class DirTreeWalker implements FileTreeReader<DirTree> {

    public DirTree readAndAppendChild(File rootFile) {
        DirTree.DirNode rootNode = new DirTree.DirNode(rootFile);
        readAndAppendChild(rootNode);
        return new DirTree(rootNode);
    }

    private void readAndAppendChild(DirTree.DirNode newRoot) {
        File[] fileSubDirs = newRoot.getDirectory().listFiles(File::isDirectory);
        if (fileSubDirs != null) {
            for (File fileSubDir : fileSubDirs) {
                newRoot.appendSub(new DirTree.DirNode(fileSubDir));
            }
        }
        for (DirTree.DirNode subDirectory : newRoot.getSubDirectories()) {
            readAndAppendChild(subDirectory);
        }
    }

}
