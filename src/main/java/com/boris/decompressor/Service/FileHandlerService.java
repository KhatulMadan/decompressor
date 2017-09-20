package com.boris.decompressor.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by boris on 17.09.17.
 *
 * Service class that provides the correct decompressor for a file that should be decompressed and decompress it.
 */

@Service
@Component
public class FileHandlerService {

    @Autowired
    private FileDownloader fileDownloader;

    @Autowired
    private List<FileDecompressor> services;

    /**
     * Download a file that should be decompressed.
     * Iterate through the types of decompressors to find the correct one that should be used.
     * Let you know if a file is compressed with unsupported compression or uncompressed at all.
     * @param fileUrl the link to a file that should be downloaded and decompressed.
     * @throws IOException
     */

public void processFile(String fileUrl) throws IOException {


    File myFile = fileDownloader.getFile(fileUrl);
    String extension = fileDownloader.getFileExtension(myFile);



        FileDecompressor  decompressor = services.stream().filter(fileDecompressor -> fileDecompressor.canDecompress(extension)).findFirst().orElse( new Uncompressed ());
            decompressor.decompress(myFile);





}


}
