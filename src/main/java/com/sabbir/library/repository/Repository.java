package com.sabbir.library.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository<T> {
    protected Map<Integer, T> storage = new HashMap<>();

    public void save(int id, T entity){
        storage.put(id, entity);
    }

    public T findById(int id){
        return storage.get(id);
    }

    public List<T> findAll(){
        return new ArrayList<>(storage.values());
    }

    public void remove(int id){
        storage.remove(id);
    }
}
