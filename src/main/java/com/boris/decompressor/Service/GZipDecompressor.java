package com.boris.decompressor.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.zip.GZIPInputStream;

/**
 * Created by boris on 17.09.17.
 */

@Service
@Component
public class GZipDecompressor implements FileDecompressor {

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
