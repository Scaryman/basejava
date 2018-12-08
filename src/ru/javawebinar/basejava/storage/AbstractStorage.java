package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        Object uniqueStorageID = getNotExistedUniqueStorageID(resume.getUuid());
        saveResume(resume, uniqueStorageID);
    }

    @Override
    public void update(Resume resume) {
        Object uniqueStorageID = getExistedUniqueStorageID(resume.getUuid());
        updateResume(uniqueStorageID, resume);
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

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = Arrays.asList(getAll());
        Collections.sort(list);
        return list;
    }

    private Object getExistedUniqueStorageID(String uuid) {
        Object uniqueStorageID = getUniqueStorageID(uuid);
        if (!isExists(uniqueStorageID)) {
            throw new NotExistStorageException(uuid);
        }
        return uniqueStorageID;
    }

    private Object getNotExistedUniqueStorageID(String uuid) {
        Object uniqueStorageID = getUniqueStorageID(uuid);
        if (isExists(uniqueStorageID)) {
            throw new ExistStorageException(uuid);
        }
        return uniqueStorageID;
    }

    protected abstract void saveResume(Resume resume, Object uniqueStorageID);

    protected abstract Resume getResume(Object uniqueStorageID);

    protected abstract Object getUniqueStorageID(String uuid);

    protected abstract void updateResume(Object uniqueStorageID, Resume resume);

    protected abstract void deleteResume(Object uniqueStorageID);

    protected abstract boolean isExists(Object uniqueStorageID);

    protected abstract Resume[] getAll();
}
