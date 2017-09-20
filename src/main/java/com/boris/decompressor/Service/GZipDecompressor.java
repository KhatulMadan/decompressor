package com.boris.decompressor.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * Created by boris on 17.09.17.
 *
 * Implementation of FileDecompressor interface.
 * Service class to decompress GZip files.
 */

@Service
@Component
public class GZipDecompressor implements FileDecompressor {

    /**
     * Check if the file could be decompressed with this service class.
     * @param fileExtension is extension of the file that should be decompressed provided as a String.
     * @return true if the file is of GZip type.
     */

    @Override
    public boolean canDecompress(String fileExtension)
    {
        boolean isGzip = false;


        if(fileExtension.equalsIgnoreCase("GZIP"))
        {
            isGzip = true;
        }

        return isGzip;
    }

    /**
     * Decompress the file.
     * @param inputGzipFile is a compressed file.
     * @throws IOException
     */

    @Override
    public void decompress(File inputGzipFile) throws IOException {
        byte[] buffer = new byte[1024];




            GZIPInputStream gzis =
                    new GZIPInputStream(new FileInputStream(inputGzipFile));

            FileOutputStream out =
                    new FileOutputStream(inputGzipFile.getName());

            int len;
            while ((len = gzis.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }

            gzis.close();
            out.close();

            System.out.println("GZip is decompressed");


    }
}
