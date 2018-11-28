package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected Boolean resumeExists(String uuid) {
        for (Resume r : storage) {
            if (r.getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void saveResume(Resume resume) {
        storage.add(resume);
    }
}
