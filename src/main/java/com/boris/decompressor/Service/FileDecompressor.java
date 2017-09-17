package com.boris.decompressor.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by boris on 15.09.17.
 */


public interface FileDecompressor {

    boolean canDecompress(String fileExtension);
    void decompress(File inputFile) throws IOException;

}

