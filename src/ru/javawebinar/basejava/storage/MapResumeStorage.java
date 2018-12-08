package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void saveResume(Resume resume, Resume uniqueStorageID) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Resume resume) {
        return resume;
    }

    @Override
    protected Resume getUniqueStorageID(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void updateResume(Resume uniqueStorageID, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(Resume resume) {
        storage.remove(resume.getUuid());
    }

    @Override
    protected boolean isExists(Resume resume) {
        return resume != null;
    }

    @Override
    protected Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }
}
