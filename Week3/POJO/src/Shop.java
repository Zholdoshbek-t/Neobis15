import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {

    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Object> orders = new ArrayList<>();

    public void start() {
        System.out.println("Welcome to Omozon, the cheapest online shop!");
        boolean cancel = false;
        while (!cancel) {
            System.out.println("\n**************************************");
            System.out.println("Please, choose the option:");
            System.out.println("  1) Buy");
            System.out.println("  2) Check the cart");
            System.out.println("  3) Remove order");
            System.out.println("  4) Pay");
            System.out.println("  5) Cancel purchase");
            System.out.println("**************************************");
            System.out.print("Enter the number >>> ");
            String num = scanner.nextLine();
            switch (num) {
                case "1":
                    makeOrder();
                    break;
                case "2":
                    checkCart();
                    break;
                case "3":
                    removeOrder();
                    break;
                case "4":
                    pay();
                    cancel = true;
                    break;
                case "5":
                    cancel = true;
                    break;
                default:
                    System.out.println("  Wrong input! You can enter only number between 1 and 5.");
                    break;
            }
        }
    }

    private void makeOrder() {
        boolean finish = false;
        while (!finish) {
            System.out.println("\n<><><><><><><><><><><><><><><><><><><>");
            System.out.println("Pick the product you want to order: ");
            System.out.println("  1) Car");
            System.out.println("  2) Phone");
            System.out.println("  3) Laptop");
            System.out.println("  4) Donut");
            System.out.println("  5) Cake");
            System.out.println("  6) Finish");
            System.out.println("<><><><><><><><><><><><><><><><><><><>");
            System.out.print("Enter the number >>> ");
            String num = scanner.nextLine();
            switch (num) {
                case "1":
                    orders.add(orderCar());
                    break;
                case "2":
                    orders.add(orderPhone());
                    break;
                case "3":
                    orders.add(orderLaptop());
                    break;
                case "4":
                    orders.add(orderDonut());
                    break;
                case "5":
                    orders.add(orderCake());
                    break;
                case "6":
                    finish = true;
                    break;
                default:
                    System.out.println("  Wrong input! You can enter only number between 1 and 6.");
                    break;
            }
        }
    }

    private Car orderCar() {
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        String year = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        return new Car(brand, model, year, color);
    }

    private Phone orderPhone() {
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Phone memory(GB): ");
        String phoneMemory = scanner.nextLine();
        return new Phone(brand, model, phoneMemory);
    }

    private Laptop orderLaptop() {
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Size(inches): ");
        String size = scanner.nextLine();
        System.out.print("CPU: ");
        String cpu = scanner.nextLine();
        System.out.print("Storage Drive(HDD/SSD): ");
        String storageDrive = scanner.nextLine();
        return new Laptop(brand, model, size, cpu, storageDrive);
    }

    private Donut orderDonut() {
        System.out.print("Coating: ");
        String coating = scanner.nextLine();
        System.out.print("Topping: ");
        String topping = scanner.nextLine();
        System.out.print("Drizzle: ");
        String drizzle = scanner.nextLine();
        return new Donut(coating, topping, drizzle);
    }

    private Cake orderCake() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Size: ");
        String size = scanner.nextLine();
        return new Cake(name, size);
    }

    private void checkCart() {
        if (orders.size() == 0) {
            System.out.println("\nYou have not made any purchase.");
        } else {
            System.out.println("\n(CART)\n");
            for (int i = 0; i < orders.size(); i++) {
                System.out.println("Order number " + (i + 1));
                System.out.println(orders.get(i).toString());
            }
            System.out.println("(CART)");
        }
    }

    private void removeOrder() {
        if (orders.size() == 0) {
            System.out.println("\n  Sorry, but your shopping cart is empty.");
            System.out.println("  Try to make some orders.");
        } else {
            System.out.println("Do you want to check the cart?");
            System.out.print("Enter 'y' or 'n' >>> ");
            String answer = scanner.nextLine();
            if (!answer.equals("y") && !answer.equals("n")) {
                System.out.println(" You should enter only 'y' or 'n'." +
                        "However, we will consider your input as 'No'.");
            } else if (answer.equals("y")) {
                checkCart();
            }
            try {
                System.out.print(" Please, enter the number of order you wish to remove >>> ");
                int remove = scanner.nextInt() - 1;
                scanner.nextLine();
                if (remove >= orders.size()) {
                    System.out.println("\n  There is no order with such index. Try again.");
                } else {
                    Object removedOrder = orders.remove(remove);
                    System.out.println("\nThe order was removed:");
                    System.out.println(removedOrder.toString());
                }
            } catch (InputMismatchException e) {
                System.out.println("  Wrong input! You can enter only numbers.");
            }
        }
    }

    private void pay() {
        if (orders.size() == 0) {
            System.out.println("\n  Your shopping cart is empty...");
        } else {
            System.out.println("\n   Congratulations!");
            System.out.println("   You are our first client and that's why you get all for FREE!");
            System.out.println("   We look forward to your return.");
        }
    }

}
