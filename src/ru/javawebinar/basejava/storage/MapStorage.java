package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void saveResume(Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Object uniqueStorageID) {
        return storage.get(uniqueStorageID);
    }

    @Override
    protected Object getUniqueStorageID(String uuid) {
        if (storage.get(uuid) != null) {
            return uuid;
        } else {
            return null;
        }
    }
}
