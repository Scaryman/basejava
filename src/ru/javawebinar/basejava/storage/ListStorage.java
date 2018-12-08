package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

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
    protected void saveResume(Resume resume, Integer uniqueStorageID) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(Integer uniqueStorageID) {
        return storage.get(uniqueStorageID);
    }

    @Override
    protected Integer getUniqueStorageID(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void updateResume(Integer uniqueStorageID, Resume resume) {
        storage.set(uniqueStorageID, resume);
    }

    @Override
    protected void deleteResume(Integer uniqueStorageID) {
        storage.remove(uniqueStorageID.intValue());
    }

    @Override
    protected boolean isExists(Integer uniqueStorageID) {
        return uniqueStorageID != null;
    }

    @Override
    protected Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }
}
