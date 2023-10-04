import service.CallBack;
import serviceImpl.CallBackImpl;

import java.util.Scanner;
import java.util.Stack;

public class View {
    private static final Stack<Integer> STACK = new Stack<>();
    private static final View view = new View();
    private static final CallBack CALL_BACK = new CallBackImpl();
    private static int results;

    public static void main(String[] args) {
        boolean exit = true;

       while (exit) {
            final Scanner scanner = new Scanner(System.in);

            System.out.println("Press 1 to add the value\nPress 2 to pop the value\nPress 3 to get the result\nPress 4 to exit");
            final String value = scanner.nextLine();

            switch (value) {
                case "1":
                    System.out.println("Enter the number ");
                    final int input = Integer.parseInt(scanner.nextLine());
                    view.add(input, CALL_BACK, STACK);
                    break;
                case "2":
                    view.delete(CALL_BACK, STACK);
                    System.out.println("available values " + STACK);
                    break;
                case "3":
                    System.out.println(
                            "Results: " + results
                    );
                    System.out.println("available values " + STACK);
                    break;
                case "4":
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    public void add(final int result, final CallBack callBack, final Stack<Integer> stack) {
        STACK.push(result);
        results = Math.toIntExact((callBack.add(result, stack)));
    }

    public void delete(final CallBack callBack, final Stack<Integer> stack) {
            STACK.pop();
            System.out.println("Result " + callBack.delete(stack));
        }
    }




