package com.mycompany.springtask.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {

    static final private String FILE_DESTINATION = "/files/";
    @Autowired
    private FileService fileService;

    @RequestMapping("/selectFile")
    public String selectFile() {
        return "selectFile";
    }

    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public String upploadFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        Integer total = 0;

        fileService.saveCopy(FILE_DESTINATION, file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        try {
            total = fileService.processCsvFile(reader);
        } catch (MalformedCsvException e) {
            e.setFlie(file);
            throw e;
        }
        model.addAttribute("total", total);
        return "resultFile";
    }

    @RequestMapping(value = "uploadTarFile", method = RequestMethod.POST)
    public String upploadTarFile(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        Integer total = 0;
        fileService.saveCopy(FILE_DESTINATION, file);
        TarArchiveInputStream tarIn = new TarArchiveInputStream(new GzipCompressorInputStream(file.getInputStream()));
        TarArchiveEntry tarEntry = tarIn.getNextTarEntry();
        while (tarEntry != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(tarIn));
            try {
                total = fileService.processCsvFile(reader);
            } catch (MalformedCsvException e) {
                e.setFlie(file);
                throw e;
            }
            tarEntry = tarIn.getNextTarEntry();
        }
        model.addAttribute("total", total);
        return "resultFile";
    }
}
