package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String>{

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
    protected void saveResume(Resume resume, String uniqueStorageID) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(String uniqueStorageID) {
        return storage.get(uniqueStorageID);
    }

    @Override
    protected String getUniqueStorageID(String uuid) {
        return uuid;
    }

    @Override
    protected void updateResume(String uniqueStorageID, Resume resume) {
        storage.put(uniqueStorageID, resume);
    }

    @Override
    protected void deleteResume(String uniqueStorageID) {
        storage.remove(uniqueStorageID);
    }

    @Override
    protected boolean isExist(String uniqueStorageID) {
        return storage.containsKey(uniqueStorageID);
    }

    @Override
    protected Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }
}
