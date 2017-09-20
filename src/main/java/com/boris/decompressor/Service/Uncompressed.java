package com.boris.decompressor.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by boris on 17.09.17.
 *
 * Implementation of FileDecompressor interface.
 * Service class that is used when provided file is not compressed
 * or the file requires any other type of decompression (not supported by this micro-service).
 */

@Service
@Component
public class Uncompressed implements FileDecompressor {

    /**
     * Check if the file could be decompressed with this service class.
     * @param fileExtension is extension of the file that should be decompressed provided as a String.
     * @return always false to define unsupported compression or uncompressed file.
     */

    @Override
    public boolean canDecompress(String fileExtension)
    {
      return false;
    }

    /**
     * Print the message about unsupported compression.
     * @param inputFile is a file.
     * @throws IOException
     */

    @Override
    public void decompress(File inputFile) throws IOException{

        System.out.println("This file is not compressed or compression is not supported: " + inputFile.getName());

    }

}
