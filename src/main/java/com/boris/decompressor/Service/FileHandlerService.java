package com.boris.decompressor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by boris on 17.09.17.
 */

@Service
@Component
public class FileHandlerService {

    private List<FileDecompressor> services;



    @Autowired
    private FileDownloader fileDownloader;

    @Autowired
    private BZip2Decompressor bZip2Decompressor;

    @Autowired
    private GZipDecompressor gZipDecompressor;

    @Autowired
    private ZipDecompressor zipDecompressor;

    @Autowired
    private Uncompressed uncompressed;


public void processFile(String fileUrl) throws IOException {


    File myFile = fileDownloader.getFile(fileUrl);
    String extension = fileDownloader.getFileExtension(myFile);


    services.add(bZip2Decompressor);
    services.add(gZipDecompressor);
    services.add(zipDecompressor);
    services.add(uncompressed);


    for (int i = 0; i<services.size(); i++)
    {
       if (services.get(i).canDecompress(extension) == true)
       {
           services.get(i).decompress(myFile);
       }
    }


}


}
