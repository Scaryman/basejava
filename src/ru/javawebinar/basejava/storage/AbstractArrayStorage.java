package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    static final int STORAGE_LIMIT = 10;
    final Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected void saveResume(Resume resume, Object uniqueStorageID) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("База полностью заполнена", resume.getUuid());
        } else {
            saveToArray(resume, (Integer) uniqueStorageID);
            size++;
        }
    }

    protected void updateResume(Object uniqueStorageID, Resume resume) {
        storage[(Integer) uniqueStorageID] = resume;
    }

    @Override
    protected void deleteResume(Object uniqueStorageID) {
        deleteFromArray((Integer) uniqueStorageID);
        size--;
        storage[size] = null;
    }

    @Override
    protected boolean resumeExists(Object uniqueStorageID) {
        return (Integer) uniqueStorageID >= 0;
    }

    @Override
    protected Resume getResume(Object uniqueStorageID) {
        return storage[(Integer) uniqueStorageID];
    }

    @Override
    protected Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract void saveToArray(Resume r, int index);

    protected abstract void deleteFromArray(int index);
}
