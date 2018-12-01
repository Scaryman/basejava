package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveToArray(Resume r, int index) {
        index *= -1;
        System.arraycopy(storage, index - 1, storage, index, size - index + 1);
        storage[index - 1] = r;
    }

    @Override
    protected void deleteFromArray(int index) {
        if (index + 1 < size) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        }
    }

    @Override
    protected Object getUniqueStorageID(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
