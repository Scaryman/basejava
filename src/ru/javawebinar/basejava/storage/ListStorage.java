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
    protected void saveResume(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume getResume(Object uniqueStorageID) {
        return storage.get((Integer) uniqueStorageID);
    }

//    @Override
//    protected Resume getResume(String uuid) {
//        for (Resume r : storage) {
//            if (r.getUuid().equals(uuid)) {
//                return r;
//            }
//        }
//        return null;
//    }

    @Override
    protected Object getUniqueStorageID(String uuid) {
        for (int i = 0; i <= storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}
