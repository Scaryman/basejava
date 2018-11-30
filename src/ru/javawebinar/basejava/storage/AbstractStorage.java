package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume r) {
        checkAndGetUniqueStorageID(r.getUuid(), false);
        saveResume(r);
    }

    @Override
    public void update(Resume r) {
        Object uniqueStorageID = checkAndGetUniqueStorageID(r.getUuid(), true);
        updateResume(uniqueStorageID, r);
    }

    @Override
    public Resume get(String uuid) {
        Object uniqueStorageID = checkAndGetUniqueStorageID(uuid, true);
        return getResume(uniqueStorageID);
    }

    @Override
    public void delete(String uuid) {
        Object uniqueStorageID = checkAndGetUniqueStorageID(uuid, true);
        deleteResume(uniqueStorageID);
    }

    private Object checkAndGetUniqueStorageID(String uuid, Boolean exists) {
        Object uniqueStorageID = getUniqueStorageID(uuid);
        if (exists && uniqueStorageID == null) {
            throw new NotExistStorageException(uuid);
        } else if (!exists && uniqueStorageID != null) {
            throw new ExistStorageException(uuid);
        }
        return uniqueStorageID;
    }

    protected abstract void saveResume(Resume resume);

    protected abstract Resume getResume(Object uniqueStorageID);

    protected abstract Object getUniqueStorageID(String uuid);

    protected abstract void updateResume(Object uniqueStorageID, Resume resume);

    protected abstract void deleteResume(Object uniqueStorageID);
}
