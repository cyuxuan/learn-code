package com.github.ompc.greys.core.util.collection;

import java.util.NoSuchElementException;

/**
 * 线程不安全固定栈深的堆栈实现<br/>
 * 固定堆栈深度的实现能比JDK自带的堆栈实现提高10倍的性能.
 * Created by oldmanpushcart@gmail.com on 15/6/21.
 * @param <E>
 */
public class ThreadUnsafeFixGaStack<E> implements GaStack<E> {

    private final static int EMPTY_INDEX = -1;
    private final Object[] elementArray;
    private final int max;
    private int current = EMPTY_INDEX;

    public ThreadUnsafeFixGaStack(int max) {
        this.max = max;
        this.elementArray = new Object[max];
    }

    private void checkForPush() {
        // stack is full
        if (current == max) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void checkForPopOrPeek() {
        // stack is empty
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public E pop() {
        checkForPopOrPeek();
        //noinspection unchecked
        return (E) elementArray[current--];
    }

    @Override
    public void push(E e) {
        checkForPush();
        elementArray[++current] = e;
    }

    @Override
    public E peek() {
        checkForPopOrPeek();
        //noinspection unchecked
        return (E) elementArray[current];
    }

    @Override
    public boolean isEmpty() {
        return current == EMPTY_INDEX;
    }

}
