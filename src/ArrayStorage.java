import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        if (size < storage.length) {
            if (getIndex(r.uuid) >= 0) {
                System.out.println("Такое резюме уже есть в базе");
            } else {
                storage[size] = r;
                size++;
            }
        } else {
            System.out.println("База полностью заполнена");
        }
    }

    void update(Resume r) {
        int index = getIndex(r.uuid);
        if (index >= 0) {
            storage[index] = r;
        } else {
            System.out.println("Резюме не найдено");
        }
    }

    Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("Резуюме не найдено");
            return null;
        }
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            if (index + 1 < size) {
                System.arraycopy(storage, index + 1, storage, index, size - index - 1);
            }
            size--;
            storage[size] = null;
        } else {
            System.out.println("Резуме не найдено");
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