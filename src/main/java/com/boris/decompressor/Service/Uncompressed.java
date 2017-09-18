package com.boris.decompressor.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * Created by boris on 17.09.17.
 */

@Service
@Component
public class Uncompressed implements FileDecompressor {

    @Override
    public boolean canDecompress(String fileExtension)
    {
        boolean isUncompressed = false;


        if(!fileExtension.equalsIgnoreCase("ZIP")
                && !fileExtension.equalsIgnoreCase("BZIP2")
                && !fileExtension.equalsIgnoreCase("GZIP"))
        {
            isUncompressed = true;
        }

        return isUncompressed;
    }

    @Override
    public void decompress(File inputFile) throws IOException{

        System.out.println("This file is not compressed: " + inputFile.getName());

    }

}
