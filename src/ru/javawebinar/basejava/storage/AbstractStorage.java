package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume r) {
        Object uniqueStorageID = getUniqueStorageID(r.getUuid());
        if (uniqueStorageID != null) {
            throw new ExistStorageException(r.getUuid());
        } else {
            saveResume(r);
        }
    }

    @Override
    public void update(Resume r) {
//        Resume resume = get(r.getUuid());
//        resume = r;
    }

    @Override
    public Resume get(String uuid) {
        Object uniqueStorageID = getUniqueStorageID(uuid);
        if (uniqueStorageID == null) {
            throw new NotExistStorageException(uuid);
        } else {
            return getResume(uniqueStorageID);
        }
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public int size() {
        return 0;
    }

//    protected abstract Boolean resumeExists(String uuid);
    protected abstract void saveResume(Resume resume);
    protected abstract Resume getResume(Object uniqueStorageID);
    protected abstract Object getUniqueStorageID(String uuid);
}
