package com.mycompany.springtask.file;

import org.springframework.web.multipart.MultipartFile;

public class MalformedCsvException extends RuntimeException {

    private MultipartFile flie;

    /**
     * Creates a new instance of <code>MalformedCsvException</code> without
     * detail message.
     */
    public MalformedCsvException() {
    }

    /**
     * Constructs an instance of <code>MalformedCsvException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public MalformedCsvException(String msg) {
        super(msg);
    }

    public MalformedCsvException(Throwable cause) {
        super(cause);
    }

    /**
     * @return the flie
     */
    public MultipartFile getFlie() {
        return flie;
    }

    /**
     * @param flie the flie to set
     */
    public void setFlie(MultipartFile flie) {
        this.flie = flie;
    }

}
