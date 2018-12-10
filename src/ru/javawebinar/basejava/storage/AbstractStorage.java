package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<USID> implements Storage {

    @Override
    public void save(Resume resume) {
        USID uniqueStorageID = getNotExistedUniqueStorageID(resume.getUuid());
        saveResume(resume, uniqueStorageID);
    }

    @Override
    public void update(Resume resume) {
        USID uniqueStorageID = getExistedUniqueStorageID(resume.getUuid());
        updateResume(uniqueStorageID, resume);
    }

    @Override
    public Resume get(String uuid) {
        USID uniqueStorageID = getExistedUniqueStorageID(uuid);
        return getResume(uniqueStorageID);
    }

    @Override
    public void delete(String uuid) {
        USID uniqueStorageID = getExistedUniqueStorageID(uuid);
        deleteResume(uniqueStorageID);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = Arrays.asList(getAll());
        Collections.sort(list);
        return list;
    }

    private USID getExistedUniqueStorageID(String uuid) {
        USID uniqueStorageID = getUniqueStorageID(uuid);
        if (!isExist(uniqueStorageID)) {
            throw new NotExistStorageException(uuid);
        }
        return uniqueStorageID;
    }

    private USID getNotExistedUniqueStorageID(String uuid) {
        USID uniqueStorageID = getUniqueStorageID(uuid);
        if (isExist(uniqueStorageID)) {
            throw new ExistStorageException(uuid);
        }
        return uniqueStorageID;
    }

    protected abstract void saveResume(Resume resume, USID uniqueStorageID);

    protected abstract Resume getResume(USID uniqueStorageID);

    protected abstract USID getUniqueStorageID(String uuid);

    protected abstract void updateResume(USID uniqueStorageID, Resume resume);

    protected abstract void deleteResume(USID uniqueStorageID);

    protected abstract boolean isExist(USID uniqueStorageID);

    protected abstract Resume[] getAll();
}
