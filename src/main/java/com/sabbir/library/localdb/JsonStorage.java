package com.sabbir.library.localdb;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonStorage {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> void save(String file, List<T> data) {
        try {
            mapper.writeValue(new File(file), data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> load(String file, TypeReference<List<T>> type) {
        try {
            return mapper.readValue(new File(file), type);
        } catch (Exception e) {
            return List.of();
        }
    }
}
