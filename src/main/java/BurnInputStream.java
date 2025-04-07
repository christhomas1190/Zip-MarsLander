import java.util.Scanner;

public class BurnInputStream implements BurnStream {
    Scanner scanner = new Scanner(System.in);

    @Override
    public int getNextBurn(DescentEvent status) {
        //moved loop to surround input. would run forever in input wasn't 0-200
        while (true) {
        System.out.println("Enter. burn amount 0-200");
        String[] tokens = scanner.nextLine().split(" ");
        //I changed code so that only numbers from 0-200 can be used
        if (tokens.length > 0) {
                    int burn = Integer.parseInt(tokens[0]);
                    //Burn number must be or be between 0-200
                    if(burn>=0 && burn<=200){
                        return burn;
                    }
                }
            }
        }
    }

