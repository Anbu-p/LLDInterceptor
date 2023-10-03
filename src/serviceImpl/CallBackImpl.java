package serviceImpl;

import service.CallBack;

public class CallBackImpl implements CallBack {

    @Override
    public void add(final long result) {
        System.out.println("result " + result);
    }
}
