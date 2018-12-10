package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

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
    protected void saveResume(Resume resume, Integer uniqueStorageID) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("База полностью заполнена", resume.getUuid());
        } else {
            saveToArray(resume, uniqueStorageID);
            size++;
        }
    }

    protected void updateResume(Integer uniqueStorageID, Resume resume) {
        storage[uniqueStorageID] = resume;
    }

    @Override
    protected void deleteResume(Integer uniqueStorageID) {
        deleteFromArray(uniqueStorageID);
        size--;
        storage[size] = null;
    }

    @Override
    protected boolean isExist(Integer uniqueStorageID) {
        return uniqueStorageID >= 0;
    }

    @Override
    protected Resume getResume(Integer uniqueStorageID) {
        return storage[uniqueStorageID];
    }

    @Override
    protected Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract void saveToArray(Resume resume, int index);

    protected abstract void deleteFromArray(int index);
}
