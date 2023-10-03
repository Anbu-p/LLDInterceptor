import service.CallBack;
import serviceImpl.CallBackImpl;

import java.util.Scanner;
import java.util.Stack;

public class View {
    private static final Stack<Integer> STACK = new Stack<>();
    private static final View view = new View();
    private static final CallBack CONTROLLER = new CallBackImpl();

    public static void main(String[] args) {
        do {
            final Scanner scanner = new Scanner(System.in);
            System.out.println("Press 1 to add the value\nPress 2 to pop the value");
            final String value = scanner.nextLine();

            switch (value) {
                case "1":
                    System.out.println("Enter the number ");
                    final int input = Integer.parseInt(scanner.nextLine());

                    view.add(input, CONTROLLER);
                    System.out.println("available values " + STACK);
                    break;
                case "2":
                    view.delete(CONTROLLER);
                    System.out.println("available values " + STACK);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while(STACK.stream().count() < 20);
    }

    public void add(final int result, final CallBack callBack) {
        if (!STACK.isEmpty()) {
            final long currentResult = STACK.stream().mapToInt(Integer::intValue).sum() + result;

            STACK.push(result);
            callBack.add((int) currentResult);
        } else {
            STACK.add(result);
            callBack.add(result);
        }
    }

    public void delete(final CallBack callBack) {
        if(!STACK.isEmpty()) {
            STACK.pop();
            final long currentResult = STACK.stream().mapToInt(Integer::intValue).sum();

            callBack.add((int) currentResult);
        }
    }
}



