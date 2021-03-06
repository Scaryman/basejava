package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

@Ignore
public class AbstractArrayStorageTest extends AbstractStorageTest {
    AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = storage.size(); i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name" + i));
            }
        } catch(StorageException e) {
            Assert.fail("Save error");
        }
        storage.save(new Resume("Name0"));
    }
}
