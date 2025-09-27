import java.util.*;

class GenericCollection<T> {
    List<T> itemsMoss = new ArrayList<>();

    void add(T item) {
        itemsMoss.add(item);
    }

    Optional<T> find(java.util.function.Predicate<T> condition) {
        for (T item : itemsMoss) {
            if (condition.test(item)) return Optional.of(item);
        }
        return Optional.empty();
    }

    void showAll() {
        Iterator<T> it = itemsMoss.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}