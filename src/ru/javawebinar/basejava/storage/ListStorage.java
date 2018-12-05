package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> storage = new ArrayList<>();

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
        storage.add(resume);
    }

    @Override
    protected Resume getResume(Object uniqueStorageID) {
        return storage.get((Integer) uniqueStorageID);
    }

    @Override
    protected Object getUniqueStorageID(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void updateResume(Object uniqueStorageID, Resume resume) {
        storage.set((Integer) uniqueStorageID, resume);
    }

    @Override
    protected void deleteResume(Object uniqueStorageID) {
        storage.remove(((Integer) uniqueStorageID).intValue());
    }

    @Override
    protected boolean resumeExists(Object uniqueStorageID) {
        return uniqueStorageID != null;
    }

    @Override
    protected Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }
}
