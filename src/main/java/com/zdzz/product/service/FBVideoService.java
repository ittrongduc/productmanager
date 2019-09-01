package com.zdzz.product.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

@Service
public class FBVideoService {

    private static final int TYPE_HD_SRC = 0;
    private static final int TYPE_SD_SRC = 1;

    private static final String TYPE_HD_SRC_STRING = "hd_src:\"https";
    private static final String TYPE_SD_SRC_STRING = "sd_src:\"https";

    private static final int BUFFER_SIZE = 4096;

    private static String getURLSource(String url) throws IOException {
        URL urlObject = new URL(url);
        URLConnection urlConnection = urlObject.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

        return toString(urlConnection.getInputStream());
    }

    private static String toString(InputStream inputStream) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }

            return stringBuilder.toString();
        }
    }

    public void getVideo(String url, HttpServletResponse response) {
        try {

            Date date = new Date();

            String fileName = String.valueOf(date.getTime());

            response.setContentType("video/mp4");
            response.setHeader("Content-Disposition", "attachment;filename="+fileName+".mp4");

            OutputStream outputStream = response.getOutputStream();

            String temp = getURLSource(url);
            System.out.println(temp);


            if (temp.contains(TYPE_HD_SRC_STRING)) {

                System.out.println(TYPE_HD_SRC_STRING + "----CONTAIN");

                int start = temp.indexOf("hd_src:");
                int end = temp.lastIndexOf(",sd_src");
                String subString = temp.substring(start, end);
                String[] hihi = subString.split("hd_src:");

                String srcVal = hihi[1];
                String src = srcVal.replace("\"", "");

                BufferedInputStream in = new BufferedInputStream(new URL(src).openStream());
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    outputStream.write(dataBuffer, 0, bytesRead);
                }
                outputStream.flush();
                outputStream.close();

            }

            if (temp.contains(TYPE_SD_SRC_STRING)) {
                System.out.println(TYPE_SD_SRC_STRING + "----CONTAIN");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
