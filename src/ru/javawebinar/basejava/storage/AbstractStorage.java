package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume r) {
        if (resumeExists(r.getUuid())) {
            throw new ExistStorageException(r.getUuid());
        } else {
            saveResume(r);
        }

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
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

    protected abstract Boolean resumeExists(String uuid);
    protected abstract void saveResume(Resume resume);
}
