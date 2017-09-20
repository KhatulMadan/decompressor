package com.boris.decompressor.Service;

/**
 * Created by boris on 17.09.17.
 *
 * Service class to download a compressed file from GoogleDrive
 */



import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
@Component
public class FileDownloader {

    private static final int BUFFER_SIZE = 4096;
    private String saveDir = "/Users/boris/Java/decompressor";

    /**
     * Download the requested file.
     * @param fileURL is link to a file that needs to be downloaded from GoogleDrive.
     * @return downloaded file.
     * @throws IOException
     */


    public File getFile(String fileURL)
            throws IOException {

        File myFile = null;
        String newfileURL = "https://drive.google.com/uc?export=download&id=" + fileURL.substring(33);

        URL url = new URL(newfileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        int responseCode = httpConn.getResponseCode();

        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpConn.getHeaderField("Content-Disposition");
            String contentType = httpConn.getContentType();
            int contentLength = httpConn.getContentLength();

            if (disposition != null) {
                // extracts file name from header field
                int index = disposition.indexOf("filename*=UTF-8''");

                if (index > 0) {
                    fileName = disposition.substring(index + 17,
                            disposition.length());
                }
            } else {
                // extracts file name from URL
                fileName = newfileURL.substring(newfileURL.lastIndexOf("/") + 1,
                        newfileURL.length());
            }

            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);

            // opens input stream from the HTTP connection
            InputStream inputStream = httpConn.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            myFile = new File(saveFilePath);

            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(myFile);

            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();

            System.out.println("File downloaded");
        } else {
            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
        }
        httpConn.disconnect();
        return myFile;
    }

    /**
     * Get the file extension as a String.
     * @param file downloaded file.
     * @return file extension as a String.
     */

    public String getFileExtension(File file)
    {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}