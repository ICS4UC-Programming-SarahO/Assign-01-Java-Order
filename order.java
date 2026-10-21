import java.util.Scanner;

/**
 * Takes user orders for Shawarma or Burgers, validates input to prevent crashes,
 * and calculates total costs for all orders combined with tax.
 *
 * @author Sarah Ouamou
 * @version 6.9
 * @since 2026-10-20
 */
public final class order {

    /**
     * Main program execution without helper functions.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        // Constants
        final double hst = 0.13;
        final double vegPlate = 10.00;
        final double meatPlate = 12.99;
        final double vegWrap = 7.99;
        final double meatWrap = 9.99;
        final double drinkPrice = 1.99;
        final double burgerPrice = 8.99;
        final double largeBurgerAdd = 2.00;
        final double comboAdd = 3.00;

        final Scanner scanner = new Scanner(System.in);
        boolean continueOrdering = true;
        double runningSubtotal = 0.0; // Accumulates total across all items ordered

        System.out.println("  Welcome to Sarah's Shawarma & Burger Joint!");

        // Main ordering loop
        do {
            int mainChoice = 0;
            boolean validMainInput = false;

            // Input validation loop for main menu
            while (!validMainInput) {
                System.out.print("\nSelect Main Menu Option:\n1 - Shawarma Menu\n2 - Burger Menu\nChoice (1-2): ");
                if (scanner.hasNextInt()) {
                    mainChoice = scanner.nextInt();
                    if (mainChoice >= 1 && mainChoice <= 2) {
                        validMainInput = true;
                    } else {
                        System.out.println("Out of range error! Enter a number between 1 and 2.");
                    }
                } else {
                    System.out.println("Invalid input type! Please enter an integer number.");
                    scanner.next();
                }
            }

            double currentItemPrice = 0.0;

            if (mainChoice == 1) {
                System.out.println("\n--- Shawarma Menu ---");

                // Get type choice (Plate vs Wrap)
                int typeChoice = 0;
                boolean validTypeInput = false;
                while (!validTypeInput) {
                    System.out.print("1 - Plate\n2 - Wrap\nSelect option (1-2): ");
                    if (scanner.hasNextInt()) {
                        typeChoice = scanner.nextInt();
                        if (typeChoice >= 1 && typeChoice <= 2) {
                            validTypeInput = true;
                        } else {
                            System.out.println("Out of range error! Enter a number between 1 and 2.");
                        }
                    } else {
                        System.out.println("Invalid input type! Please enter an integer number.");
                        scanner.next();
                    }
                }

                // Get filling choice (Meat vs Veg)
                int fillingChoice = 0;
                boolean validFillingInput = false;
                while (!validFillingInput) {
                    System.out.print("1 - Meat\n2 - Vegetarian\nSelect filling (1-2): ");
                    if (scanner.hasNextInt()) {
                        fillingChoice = scanner.nextInt();
                        if (fillingChoice >= 1 && fillingChoice <= 2) {
                            validFillingInput = true;
                        } else {
                            System.out.println("Out of range error! Enter a number between 1 and 2.");
                        }
                    } else {
                        System.out.println("Invalid input type! Please enter an integer number.");
                        scanner.next();
                    }
                }

                // Calculate base price
                if (typeChoice == 1) {
                    currentItemPrice = (fillingChoice == 1) ? meatPlate : vegPlate;
                } else {
                    currentItemPrice = (fillingChoice == 1) ? meatWrap : vegWrap;
                }
                System.out.println("Base price: $" + currentItemPrice);

                // Drink option
                int drinkChoice = 0;
                boolean validDrinkInput = false;
                while (!validDrinkInput) {
                    System.out.print("Add a drink for $1.99? (1 = Yes, 2 = No): ");
                    if (scanner.hasNextInt()) {
                        drinkChoice = scanner.nextInt();
                        if (drinkChoice >= 1 && drinkChoice <= 2) {
                            validDrinkInput = true;
                        } else {
                            System.out.println("Out of range error! Enter a number between 1 and 2.");
                        }
                    } else {
                        System.out.println("Invalid input type! Please enter an integer number.");
                        scanner.next();
                    }
                }

                if (drinkChoice == 1) {
                    currentItemPrice += drinkPrice;
                }

            } else if (mainChoice == 2) {
                System.out.println("\n--- Burger Menu ---");

                // Get size choice
                int sizeChoice = 0;
                boolean validSizeInput = false;
                while (!validSizeInput) {
                    System.out.print("1 - Large ($10.99)\n2 - Regular ($8.99)\nSelect size (1-2): ");
                    if (scanner.hasNextInt()) {
                        sizeChoice = scanner.nextInt();
                        if (sizeChoice >= 1 && sizeChoice <= 2) {
                            validSizeInput = true;
                        } else {
                            System.out.println("Out of range error! Enter a number between 1 and 2.");
                        }
                    } else {
                        System.out.println("Invalid input type! Please enter an integer number.");
                        scanner.next();
                    }
                }

                currentItemPrice = burgerPrice + ((sizeChoice == 1) ? largeBurgerAdd : 0.0);

                // Get combo choice
                int comboChoice = 0;
                boolean validComboInput = false;
                while (!validComboInput) {
                    System.out.print("Make it a combo (Fries & Drink) for $3.00 extra? (1 = Yes, 2 = No): ");
                    if (scanner.hasNextInt()) {
                        comboChoice = scanner.nextInt();
                        if (comboChoice >= 1 && comboChoice <= 2) {
                            validComboInput = true;
                        } else {
                            System.out.println("Out of range error! Enter a number between 1 and 2.");
                        }
                    } else {
                        System.out.println("Invalid input type! Please enter an integer number.");
                        scanner.next();
                    }
                }

                if (comboChoice == 1) {
                    currentItemPrice += comboAdd;
                }
            }

            // Add the current item's cost to the total running subtotal
            runningSubtotal += currentItemPrice;

            // Ask if user wants to place another order (pls say no)
            int againChoice = 0;
            boolean validAgainInput = false;
            while (!validAgainInput) {
                System.out.print("\nWould you like to place another order? (1 = Yes, 2 = No): ");
                if (scanner.hasNextInt()) {
                    againChoice = scanner.nextInt();
                    if (againChoice >= 1 && againChoice <= 2) {
                        validAgainInput = true;
                    } else {
                        System.out.println("Out of range error! Enter a number between 1 and 2.");
                    }
                } else {
                    System.out.println("Invalid input type! Please enter an integer number.");
                    scanner.next();
                }
            }

            if (againChoice == 2) {
                continueOrdering = false;
            }

        } while (continueOrdering);

        // Calculate final grand total for ALL orders combined
        // This took so long kms lolololol
        final double tax = runningSubtotal * hst;
        final double grandTotal = runningSubtotal + tax;

        // Print Final Receipt
        System.out.println("\n--- Final Order Receipt ---");
        System.out.printf("Subtotal:  $%6.2f%n", runningSubtotal);
        System.out.printf("HST (13%%): $%6.2f%n", tax);
        System.out.printf("Total:     $%6.2f%n", grandTotal);
        System.out.println("Please pull up to the window to pay and collect your order!");
        System.out.println("\nThank you for visiting! Have a wonderful day.");
        System.out.println("⸜(｡˃ ᵕ ˂ )⸝♡");
        scanner.close();
    }
}
