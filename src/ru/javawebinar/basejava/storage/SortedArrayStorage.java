package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    /*private static class ResumeComparator implements Comparator<Resume> {

        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }

    private static final ResumeComparator RESUME_COMPARATOR = new ResumeComparator();*/

    //////////////////
    /*private static final Comparator<Resume> RESUME_COMPARATOR = new Comparator<Resume>() {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    };*/

    //////////////////
    //private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void saveToArray(Resume resume, int index) {
        index *= -1;
        System.arraycopy(storage, index - 1, storage, index, size - index + 1);
        storage[index - 1] = resume;
    }

    @Override
    protected void deleteFromArray(int index) {
        if (index + 1 < size) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        }
    }

    @Override
    protected Object getUniqueStorageID(String uuid) {
        Resume searchKey = new Resume(uuid, "");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }

}
