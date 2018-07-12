import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int n = 0; n < storage.length; n++)
            if (storage[n] == null)
                break;
            else
                storage[n] = null;
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (Resume el : storage)
            if (el == null)
                return new Resume();
            else if (el.uuid.equals(uuid))
                return el;
        return new Resume();
    }

    void delete(String uuid) {
        boolean elFound = false;
        for (int n = 0; n < storage.length; n++)
            if (storage[n] == null)
                break;
            else if (storage[n].uuid.equals(uuid)) {
                storage[n] = null;
                elFound = true;
            } else if (elFound) {
                storage[n - 1] = storage[n];
                storage[n] = null;
            }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int n;
        for (n = 0; n < storage.length; n++)
            if (storage[n] == null)
                break;
        return n++;
    }

}