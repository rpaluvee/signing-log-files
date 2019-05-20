package com.guardtime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    protected static final String SMALL_LOGFILE_PATH = "src/test/resources/small_log.txt";
    protected static final String LARGE_LOGFILE_PATH = "src/test/resources/large_log.txt";
    protected static final String EMPTY_LOGFILE_PATH = "src/test/resources/empty_log.txt";

    protected List<String> readLinesToArray(String filePath) {
        List<String> entries = new ArrayList<>();
        try {
            entries = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }
}
