package de.hsos.prog3.nelsonmorais.ab03;

import java.io.Serializable;
import java.util.*;

public class Ringpuffer<T> implements Deque<T>, Cloneable, RandomAccess, Serializable {

    ArrayList<T> elements;
    private int head;
    private int tail;
    private int size;
    private int capacity;
    public boolean fixedCapacity;
    private boolean discarding;


    Ringpuffer(int capacity, boolean fixedCapacity, boolean discarding) {
        elements = new ArrayList<>(capacity);
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.fixedCapacity = fixedCapacity;
        this.discarding = discarding;

    }


    @Override
    public void addFirst(T t) {
        if (t != null) {
            if (fixedCapacity) {
                if (size < capacity) {
                    if (elements.size() == capacity) {
                        elements.set(head, t);
                    } else {
                        elements.add(head, t);
                    }

                    head++;
                    size++;
                    if (head >= capacity) {
                        head = 0;
                    }
                } else {
                    if (discarding) {
                        elements.set(head, t);

                        head++;
                        tail++;
                        if (head >= capacity) {
                            head = 0;
                            tail = 0;
                        }
                    } else {
                        throw new IllegalStateException("Discarding not Allowed.");
                    }
                }
            } else {
                elements.add(head, t);
                head++;
                size++;
                if (size > capacity) {
                    capacity++;
                }
            }

        } else {
            throw new NullPointerException("Can't add NULL");
        }
    }


    @Override
    public void addLast(T t) {

        if (t != null) {
            if (fixedCapacity) {
                if (size < capacity) {
                    elements.add(tail, t);
                    size++;
                    head++;
                    if (head >= capacity) {
                        head = 0;
                    }
                } else {
                    if (discarding) {
                        elements.set(tail, t);
                        tail++;
                        head++;
                        if (head >= capacity) {
                            tail = 0;
                            head = 0;
                        }
                    } else {
                        throw new IllegalStateException("Discarding not Allowed.");
                    }
                }
            } else {
                elements.add(tail, t);
                head++;
                size++;
                if (size > capacity) {
                    capacity++;
                }

            }
        }
    }

    @Override
    public boolean offerFirst(T t) {

        try {
            addFirst(t);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;

    }

    @Override
    public boolean offerLast(T t) {

        try {
            addLast(t);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public T removeFirst() {
        T t;
        if (size != 0) {
            if (head != 0) {
                t = elements.get(head - 1);
                size--;
                head--;
            } else {
                t = elements.get(size - 1);
                size--;
                head = size;
            }
            return t;
        } else {
            throw new NoSuchElementException("Deque is empty");
        }
    }

    @Override
    public T removeLast() {
        T t = elements.get(tail);
        if (size != 0) {
            tail++;
            size--;
            if (tail > capacity) {

                tail = 0;
            }
            return t;
        } else {
            throw new NoSuchElementException("Deque is empty");
        }
    }

    @Override
    public T pollFirst() {
        try {
            return removeFirst();
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public T pollLast() {
        try {
            return removeLast();
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public T getFirst() {
        T temp = peekFirst();
        if (temp == null) {
            throw new NoSuchElementException();
        }
        return temp;
    }

    @Override
    public T getLast() {
        T temp = peekLast();
        if (temp == null) {
            throw new NoSuchElementException();
        }
        return temp;
    }

    @Override
    public T peekFirst() {
        if (!isEmpty()) {
            if (head == 0) {
                return elements.get(capacity - 1);
            } else {
                return elements.get(head - 1);
            }
        }
        return null;
    }

    @Override
    public T peekLast() {
        if (!isEmpty()) {
            return elements.get(tail);
        }
        return null;

    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        int counter = 1;
        if (o == null) {
            return false;
        }
        Iterator<T> it = iterator();
        while (it.hasNext()) {

            if (it.next().equals(o)) {
                elements.remove(head - counter);
                size--;
                return true;
            }
            counter++;
        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        int counter = 0;
        if (o == null) {
            return false;
        }
        Iterator<T> it = descendingIterator();
        while (it.hasNext()) {

            if (it.next().equals(o)) {
                elements.remove(tail + counter);
                size--;
                return true;
            }
            counter++;
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        try {
            addLast(t);

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return true;
    }

    @Override
    public boolean offer(T t) {
        try {
            add(t);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public T remove() {
        try {
            return removeFirst();
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public T poll() {

        try {
            return remove();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public T element() {
        if (size != 0) {
            return elements.get(head - 1);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public T peek() {
        return peekFirst();
    }

    @Override
    public void push(T t) {
        try {
            addFirst(t);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public T pop() {
        try {
            return removeFirst();
        } catch (Exception e) {
            throw new NoSuchElementException();
        }

    }

    @Override
    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (!elements.contains(c)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        ArrayList<T> tmp = new ArrayList<>(capacity);
        head = 0;
        tail = 0;
        size = 0;
        elements = tmp;

    }

    @Override
    public boolean contains(Object o) {
        Iterator<T> it = iterator();

        while (it.hasNext()) {
            if (it.next().equals(o)) {
                return true;
            }
        }
        return false;
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
    public Iterator<T> iterator() {
        DequeIt it = new DequeIt();

        return it;
    }


    private class DequeIt implements Iterator<T> {
        private int start;
        private int counter = 0;

        public DequeIt() {
            this.start = head - 1;
        }

        @Override
        public boolean hasNext() {


            if (counter != size) {
                if (start < 0) {
                    start = capacity - 1;
                    counter++;
                    return true;
                }
                if (start >= tail) {
                    counter++;
                    return true;

                }
                if (start < tail) {
                    counter++;
                    return true;
                }
            }

            return false;
        }


        @Override
        public T next() {
            T tret = elements.get(start--);

            return tret;
        }
    }

    @Override
    public Object[] toArray() {
        ArrayList<T> temp = new ArrayList<>(capacity);
        Iterator<T> it = descendingIterator();
        while (it.hasNext()) {
            temp.add(it.next());
        }

        return (Object[]) temp.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        ArrayList<T> temp = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (contains(a[i])) {
                temp.add(a[i]);
            }
        }
        return (T[]) temp.toArray();
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new DescDequeIt();
    }

    private class DescDequeIt implements Iterator<T> {
        private int start;
        private int counter = 0;

        public DescDequeIt() {
            this.start = tail;
        }

        @Override
        public boolean hasNext() {
            if (counter != size) {
                if (start >= capacity) {
                    start = 0;
                    counter++;
                    return true;
                }
                if (start <= head) {
                    counter++;
                    return true;
                }
                if (start > head) {
                    counter++;
                    return true;
                }
            }

            return false;

        }

        @Override
        public T next() {
            T tret = elements.get(start++);

            return tret;
        }

    }

    public void printSchreiber() {
        Iterator<T> it = descendingIterator();
        int i = 1;
        System.out.println("Printing the last 60 Minutes:\n\n");
        while (it.hasNext()) {
            System.out.print(i++ + "min: ");
            System.out.print(it.next());
            System.out.println(" meters.");

        }
    }


    @Override
    public String toString() {
        return "Ringpuffer{" +
                "elements=" + elements +
                ", head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                ", capacity=" + capacity +
                ", fixedCapacity=" + fixedCapacity +
                ", discarding=" + discarding +
                '}';
    }
}
