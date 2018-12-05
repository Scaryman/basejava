package ru.javawebinar.basejava.storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ListStorageTest.class,
        MapResumeStorageTest.class,
        MapUuidStorageTest.class,
        SortedStorageTest.class,
        StorageTest.class
})

public class AllStorageTest {
}
