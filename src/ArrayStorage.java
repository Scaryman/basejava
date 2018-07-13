import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int n = 0; n < size; n++) {
            if (storage[n].uuid.equals(uuid)) {
                return storage[n];
            }
        }
        return new Resume();
    }

    void delete(String uuid) {
        for (int n = 0; n < size; n++) {
            if (storage[n].uuid.equals(uuid)) {
                if (n + 1 < size) {
                    System.arraycopy(storage, n + 1, storage, n, size - n - 1);
                }
                size--;
                storage[size] = null;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

}