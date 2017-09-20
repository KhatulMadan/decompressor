package com.boris.decompressor.Service;



import java.io.File;
import java.io.IOException;

/**
 * Created by boris on 15.09.17.
 *
 * Interface for service classes responsible for decompressing the files.
 */


public interface FileDecompressor {

    boolean canDecompress(String fileExtension);
    void decompress(File inputFile) throws IOException;

}

