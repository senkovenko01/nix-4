package ua.com.alevel.controllers;

import ua.com.alevel.exceptions.InvalidInput;
import ua.com.alevel.exceptions.NoExistentDateFormat;
import ua.com.alevel.services.DataService;
import ua.com.alevel.services.InputService;

import java.util.Scanner;

public class MainController {
    private final DataService dataService = new DataService();
    private final InputService inputService = new InputService();

    public void run(){
        Scanner scanner = new Scanner(System.in);
        setFormat(scanner);
        while (true) {
            try {
                System.out.println("" +
                        "\n0 - exit" +
                        "\n1 - find the difference between dates" +
                        "\n2 - add to date" +
                        "\n3 - subtract from date" +
                        "\n4 - sort date by ascending" +
                        "\n5 - sort date by descending\n" +
                        "\n6 - change date format" +
                        "\ndate format now: (" + inputService.getFormat() + ")");
                String check = scanner.next();
                switch (check) {
                    case "1" :
                        findDifferent();
                        break;
                    case "2" :
                        plusToDate(scanner);
                        break;
                    case "3" :
                        minusToDate(scanner);
                        break;
                    case "4" :
                        sortByAsc(scanner);
                        break;
                    case "5" :
                        sortByDesc(scanner);
                        break;
                    case "6" :
                        setFormat(scanner);
                        break;
                    case "0" :
                        return;
                }

            } catch (NoExistentDateFormat exception) {
                System.out.println(exception.getMessage());
            } catch (InvalidInput e){
                System.out.println(e.getMessage());
            } catch (Exception exception) {
                System.out.println("Wrong date!!!");
            }
        }
    }

    public void findDifferent(){
        System.out.println("Write first date: ");
        String first = inputService.getFormattedData();
        System.out.println("Write second date: ");
        String second = inputService.getFormattedData();
        System.out.println("Different: ");
        dataService.difference(first, second);
    }

    public void plusToDate(Scanner scanner) {
        System.out.println("Enter your date: ");
        String first = inputService.getFormattedData();
        System.out.println("Enter the type you want to plus: " +
                "\n0) seconds" +
                "\n1) minutes" +
                "\n2) hours" +
                "\n3) days" +
                "\n4) months" +
                "\n5) years");
        int type = scanner.nextInt();
        System.out.println("How much do you want to plus: ");
        int count = scanner.nextInt();
        System.out.println("Result date:");
        dataService.plusDate(first,type,count, inputService);
    }

    public void minusToDate(Scanner scanner) {
        System.out.println("Enter your date:");
        String first = inputService.getFormattedData();
        System.out.println("Enter the type you want to subtract " +
                "\n0) seconds" +
                "\n1) minutes" +
                "\n2) hours" +
                "\n3) days" +
                "\n4) months" +
                "\n5) years");
        int type = scanner.nextInt();
        System.out.println("How much do you want to subtract: ");
        int count = scanner.nextInt();
        System.out.println("Result date");
        dataService.subtractDate(first,type,count, inputService);
    }

    public void sortByAsc(Scanner scanner) {
        System.out.println("Enter the number of dates you want to sort by asc ");
        int count = scanner.nextInt();
        System.out.println("Enter dates with enter: ");
        String []arr = new String[count];
        for (int i = 0; i < count; i++) {
            arr[i] = inputService.getFormattedData();
        }
        dataService.sortByAsc(arr, inputService);
    }

    public void sortByDesc(Scanner scanner) {
        System.out.println("Enter the number of dates you want to sort by desk ");
        int count = scanner.nextInt();
        System.out.println("Enter dates with enter: ");
        String []arr = new String[count];
        for (int i = 0; i < count; i++) {
            arr[i] = inputService.getFormattedData();
        }
        dataService.sortByDesc(arr, inputService);
    }
    public void setFormat(Scanner scanner) {
        System.out.println("Select the date format you want to work with: " +
                "\n1) dd/mm/yyyy 00:00:00" +
                "\n2) dd/mm/yyyy" +
                "\n3) d/m/yyyy 00:00:00" +
                "\n4) dd/mm/yyyy 00:00" +
                "\n5) d/m/yy" +
                "\n6) dd/mmmm/yyyy 00:00:00");
        int check = scanner.nextInt();
        switch (check) {
            case 1 :
                inputService.setFormat("dd/mm/yyyy 00:00:00");
                break;
            case 2 :
                inputService.setFormat("dd/mm/yyyy");
                break;
            case 3 :
                inputService.setFormat("d/m/yyyy 00:00:00");
                break;
            case 4 :
                inputService.setFormat("dd/mm/yyyy 00:00");
                break;
            case 5 :
                inputService.setFormat("d/m/yy");
                break;
            case 6 :
                inputService.setFormat("dd/mmmm/yyyy 00:00:00");
                break;
        }
    }
}
