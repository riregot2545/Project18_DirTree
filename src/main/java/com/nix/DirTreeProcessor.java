package com.nix;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class DirTreeProcessor {
    private static final Logger logger = LoggerFactory.getLogger(DirTreeProcessor.class);

    private final File processedDir;
    private final File outputFile;
    private final DirTreeWalker dirTreeWalker;
    private final DirTreeWriter dirTreeWriter;

    public DirTreeProcessor(File processedDir, File outputFile) {
        if (!processedDir.exists()) {
            throw new IllegalArgumentException("Directory "+processedDir.getAbsolutePath()+" is not exist!");
        }
        if (!processedDir.isDirectory()) {
            throw new IllegalArgumentException("Directory is file!");
        }

        if (!outputFile.exists()) {
            logger.debug("Output file is not exist! It will be created when write.");
        }
        if (outputFile.isDirectory()) {
            throw new IllegalArgumentException("Output file is directory");
        }
        this.processedDir = processedDir;
        this.outputFile = outputFile;
        this.dirTreeWalker = new DirTreeWalker();
        this.dirTreeWriter = new DirTreeWriter();
    }

    public void proceed() {
        DirTree tree = dirTreeWalker.readAndAppendChild(processedDir);
        logger.debug("Read tree with size:" + tree.size());
        try {
            dirTreeWriter.write(tree, outputFile);
            logger.debug("Writing to file is finished: "+outputFile.getAbsolutePath());
        } catch (IOException e) {
            logger.error("IOException when write tree to file. Message:" + e.getMessage());
        }
    }
}
