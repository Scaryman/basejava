package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
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
        return storage.get(uniqueStorageID);
    }

    @Override
    protected Object getUniqueStorageID(String uuid) {
        return uuid;
    }

    @Override
    protected void updateResume(Object uniqueStorageID, Resume resume) {
        storage.put((String) uniqueStorageID, resume);
    }

    @Override
    protected void deleteResume(Object uniqueStorageID) {
        storage.remove(uniqueStorageID);
    }

    @Override
    protected boolean resumeExists(Object uniqueStorageID) {
        return storage.containsKey(uniqueStorageID);
    }

    @Override
    protected Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }
}
