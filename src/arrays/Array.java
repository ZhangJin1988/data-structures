package arrays;

/**
 * @author zhangjin
 * @create 2018-08-08 10:32
 */
public class Array<E> {

    private E[] data;
    private int size;


    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }


    public Array() {
        this(10);
    }


    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    //在index索引位置插入一个新元素e

    public void add(int index, E e) throws IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Require index >=0 and index <= size.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;

    }


    public void addLast(E e) throws IllegalArgumentException {
        add(size, e);
    }

    public void addFirst(E e) throws IllegalArgumentException {
        add(0, e);
    }

    //获取索引位置的元素
    public E get(int index) throws IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    public void set(int index, E e) throws IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed. Index is illegal.");
        }
        data[index] = e;
    }


    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }


    //查找数组中元素e所在的索引 如果不存在元素e 则返回-1
    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remmove failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }


    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Array: size = %d , capactity = %d\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public static void main(String[] args) {
        Array demo = new Array();
        demo.addLast(10);
        demo.addLast(10);
        demo.addLast(10);
        demo.addLast(10);
        demo.addLast(10);
        demo.addLast(10);
        demo.addLast(10);
        System.out.println(demo);
    }

}
