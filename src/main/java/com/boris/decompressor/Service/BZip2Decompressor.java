package com.boris.decompressor.Service;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by boris on 17.09.17.
 *
 * Implementation of FileDecompressor interface.
 * Service class to decompress BZip2 files.
 */

@Service
@Component
public class BZip2Decompressor implements FileDecompressor {

    /**
     * Check if the file could be decompressed with this service class.
     * @param fileExtension is extension of the file that should be decompressed provided as a String.
     * @return true if the file is of BZip2 type.
     */

    @Override
    public boolean canDecompress(String fileExtension) {
        boolean isBZip2 = false;


        if (fileExtension.equalsIgnoreCase("BZIP2")) {
            isBZip2 = true;
        }

        return isBZip2;
    }

    /**
     * Decompress the file.
     * @param inputBZip2File is a compressed file.
     * @throws IOException
     */

    @Override
    public void decompress(File inputBZip2File) throws IOException {
        byte[] buffer = new byte[1024];

        FileInputStream in = new FileInputStream(inputBZip2File);
        FileOutputStream out = new FileOutputStream(inputBZip2File.getName());
        BZip2CompressorInputStream bzIn = new BZip2CompressorInputStream(in);
        int n = 0;
        while (-1 != (n = bzIn.read(buffer))) {
            out.write(buffer, 0, n);
        }
        out.close();
        bzIn.close();

        System.out.println("BZip2 is decompressed");
    }
}
