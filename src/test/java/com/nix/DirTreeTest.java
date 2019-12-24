package com.nix;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DirTreeTest {

    DirTree dirTree;
    DirTreeWalker dirTreeWalker = new DirTreeWalker();
    @Test
    public void size(){
        dirTree = dirTreeWalker.readAndAppendChild(new File("C:\\ALevel\\Project18_DirTree"));
        assertEquals(22,dirTree.size());
    }

}