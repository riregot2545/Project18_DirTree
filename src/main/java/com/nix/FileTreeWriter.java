package com.nix;

import java.io.File;
import java.io.IOException;

public interface FileTreeWriter<T> {
    void write(T tree, File output) throws IOException;
}
