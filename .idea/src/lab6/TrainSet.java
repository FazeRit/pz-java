package lab6;

import lab5.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * A custom collection representing a Train, implemented as a Set
 * using a singly-linked list as its internal data structure.
 * This class is generic and can hold any type that extends RailVehicle.
 *
 * @param <T> The type of rail vehicles in the train, must extend RailVehicle.
 */
public class TrainSet<T extends RailVehicle> implements Set<T> {

    private Node<T> head;
    private int size = 0;

    private static class Node<T> {
        T car;
        Node<T> next;

        Node(T car, Node<T> next) {
            this.car = car;
            this.next = next;
        }
    }

    /**
     * Creates an empty train set.
     */
    public TrainSet() {
    }

    /**
     * Creates a train set initialized with vehicles from another collection.
     * Duplicates from the incoming collection will be ignored.
     * @param collection A collection of rail vehicles to add.
     */
    public TrainSet(Collection<? extends T> collection) {
        this();
        this.addAll(collection);
    }

    /**
     * Creates a train set with a single initial rail vehicle using a static factory method.
     * @param car The initial rail vehicle to add.
     * @return A new TrainSet instance containing the single car.
     */
    public static <T extends RailVehicle> TrainSet<T> of(T car) {
        TrainSet<T> set = new TrainSet<>();
        set.add(car);
        return set;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Node<T> current = head; current != null; current = current.next) {
            if (o.equals(current.car)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T car) {
        if (contains(car)) {
            return false;
        }
        Node<T> newNode = new Node<>(car, this.head);
        this.head = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head;
        Node<T> prev = null;
        while (current != null) {
            if (o.equals(current.car)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T car = current.car;
                current = current.next;
                return car;
            }
        };
    }

    public int calculateTotalPassengers() {
        int total = 0;
        for (T car : this) {
            total += car.getPassengerCount();
        }
        return total;
    }

    public int calculateTotalBaggage() {
        int total = 0;
        for (T car : this) {
            total += car.getBaggageWeight();
        }
        return total;
    }

    public TrainSet<T> findCarsByPassengerRange(int min, int max) {
        TrainSet<T> result = new TrainSet<>();
        for (T car : this) {
            if (car.getPassengerCount() >= min && car.getPassengerCount() <= max) {
                result.add(car);
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T car : c) {
            if (add(car)) {
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }
}