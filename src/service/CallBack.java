package service;

import java.util.Stack;

public interface CallBack {

    Long add(final long result, final Stack<Integer> stack);

    Long delete(final Stack<Integer> stack);
}
