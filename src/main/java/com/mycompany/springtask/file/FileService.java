package com.mycompany.springtask.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    int processCsvFile(BufferedReader reader);

    File saveCopy(String fileDestination, MultipartFile file) throws IOException;

}
