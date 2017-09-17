package com.boris.decompressor.Service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by boris on 15.09.17.
 */

@Service
@Component
public class ZipDecompressor implements FileDecompressor {

    @Override
    public boolean canDecompress(String fileExtension)
    {
        boolean isZip = false;


        if(fileExtension.equalsIgnoreCase("ZIP"))
        {
            isZip = true;
        }

        return isZip;
    }


    @Override
    public void decompress(File inputZipFile) throws IOException {
        byte[] buffer = new byte[1024];
        ZipInputStream zis =
                new ZipInputStream(new FileInputStream(inputZipFile));
        //get the zipped file list entry
        ZipEntry ze = zis.getNextEntry();

        while(ze!=null){

            String fileName = ze.getName();
            File newFile = new File(fileName);

            System.out.println("file unzip : " + newFile.getAbsoluteFile());



            FileOutputStream fos = new FileOutputStream(newFile);

            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }

            fos.close();
            ze = zis.getNextEntry();
        }

        zis.closeEntry();
        zis.close();

        System.out.println("Zip is decompressed");


    }


}

