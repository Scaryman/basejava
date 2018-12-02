package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume r) {
        Object uniqueStorageID = getNotExistedUniqueStorageID(r.getUuid());
        saveResume(r, uniqueStorageID);
    }

    @Override
    public void update(Resume r) {
        Object uniqueStorageID = getExistedUniqueStorageID(r.getUuid());
        updateResume(uniqueStorageID, r);
    }

    @Override
    public Resume get(String uuid) {
        Object uniqueStorageID = getExistedUniqueStorageID(uuid);
        return getResume(uniqueStorageID);
    }

    @Override
    public void delete(String uuid) {
        Object uniqueStorageID = getExistedUniqueStorageID(uuid);
        deleteResume(uniqueStorageID);
    }

    private Object getExistedUniqueStorageID(String uuid) {
        Object uniqueStorageID = getUniqueStorageID(uuid);
        if (!resumeExists(uniqueStorageID)) {
            throw new NotExistStorageException(uuid);
        }
        return uniqueStorageID;
    }

    private Object getNotExistedUniqueStorageID(String uuid) {
        Object uniqueStorageID = getUniqueStorageID(uuid);
        if (resumeExists(uniqueStorageID)) {
            throw new ExistStorageException(uuid);
        }
        return uniqueStorageID;
    }

    protected abstract void saveResume(Resume resume, Object uniqueStorageID);

    protected abstract Resume getResume(Object uniqueStorageID);

    protected abstract Object getUniqueStorageID(String uuid);

    protected abstract void updateResume(Object uniqueStorageID, Resume resume);

    protected abstract void deleteResume(Object uniqueStorageID);

    protected abstract boolean resumeExists(Object uniqueStorageID);
}
