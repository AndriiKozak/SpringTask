package com.mycompany.springtask.file;

import com.mycompany.springtask.MyEntity;
import com.mycompany.springtask.MyRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MyRepository repository;
    @Autowired
    private HttpServletRequest request;

    @Override
    public int processCsvFile(BufferedReader reader) {
        return reader.lines().mapToInt(this::processCsvLine).sum();
    }

    @Override
    public File saveCopy(String fileDestination, MultipartFile file) throws IOException {
        File dest = new File(request.getServletContext().getRealPath(fileDestination) + file.getOriginalFilename());
        dest.getParentFile().mkdirs();
        file.transferTo(dest);
        return dest;
    }

    private int processCsvLine(String line) {
        String[] fields = line.split(",");
        int value;
        if (fields.length != 2) {
            throw new MalformedCsvException();
        }
        String key = fields[0];
        try {
            value = Integer.parseInt(fields[1]);
        } catch (NumberFormatException e) {
            throw new MalformedCsvException(e);
        }
        MyEntity entity = new MyEntity();
        entity.setKey(key);
        entity.setValue(value);
        repository.save(entity);
        return 1;
    }
}
