package serviceImpl;

import service.CallBack;

import java.util.Stack;

public class CallBackImpl implements CallBack {

    @Override
    public Long add(final long result, final Stack<Integer> stack) {
        return stack.stream().mapToInt(Integer::intValue).sum() + result;
    }

    @Override
    public Long delete(final Stack<Integer> stack) {
        return (long) stack.stream().mapToInt(Integer::intValue).sum();
    }
}
