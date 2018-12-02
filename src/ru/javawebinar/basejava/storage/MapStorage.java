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
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void saveResume(Resume resume, Object uniqueStorageID) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Object uniqueStorageID) {
        return storage.get(String.valueOf(uniqueStorageID));
    }

    @Override
    protected Object getUniqueStorageID(String uuid) {
        return uuid;
    }

    @Override
    protected void updateResume(Object uniqueStorageID, Resume resume) {
        storage.put(String.valueOf(uniqueStorageID), resume);
    }

    @Override
    protected void deleteResume(Object uniqueStorageID) {
        storage.remove(String.valueOf(uniqueStorageID));
    }

    @Override
    protected boolean resumeExists(Object uniqueStorageID) {
        return storage.get(String.valueOf(uniqueStorageID)) != null;
    }
}
