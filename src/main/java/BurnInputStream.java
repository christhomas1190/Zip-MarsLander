import java.util.Scanner;

public class BurnInputStream implements BurnStream {
    Scanner scanner = new Scanner(System.in);

    @Override
    public int getNextBurn(DescentEvent status) {
        //moved loop to surround input. would run forever in input wasn't 0-200
        while (true) {
        System.out.println("Enter. burn amount 0-200");
        String[] tokens = scanner.nextLine().split(" ");
        if (tokens.length > 0) {
                try {
                    int burn = Integer.parseInt(tokens[0]);
                    return burn;
                } catch (NumberFormatException e) {
                    System.err.println("Must Enter a Number (0-200)");
                }
            }
        }
    }
}
