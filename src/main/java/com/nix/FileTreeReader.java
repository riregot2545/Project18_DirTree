package com.nix;

import java.io.File;

public interface FileTreeReader<T> {
    T readAndAppendChild(File rootFile);
}
