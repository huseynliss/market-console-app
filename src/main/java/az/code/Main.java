package az.code;

import az.code.model.Product;
import az.code.model.ProductType;
import az.code.service.MarketService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MarketService marketService = new MarketService();


//        marketService.showAllProducts();

        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Product operations");
        System.out.println("2 - Sale operations");
        System.out.println("3 - exit");

        int command = scanner.nextInt();
        while (command != 3) {
            if (command == 1) {
                System.out.println("1 - Add product");
                System.out.println("2 - Update product");
                System.out.println("3 - Remove product");
                System.out.println("4 - Show all products");
                System.out.println("5 - Show products by category");
                System.out.println("6 - Filter by price");
                System.out.println("7 - Find product by name");
                int command2 = scanner.nextInt();
                if (command2 == 1) {
                    System.out.println("Add product details: ");
                    System.out.println("Product name: ");
                    String productName = String.valueOf(scanner.next());
                    System.out.println(productName);
                    System.out.println("Product count: ");
                    int count = scanner.nextInt();
                    System.out.println("Product type (FOOD, DRINK, SWEET, MEAT): ");
                    ProductType productType = ProductType.valueOf(scanner.next());
                    System.out.println("Product price: ");
                    double price = scanner.nextDouble();
                    marketService.addProduct(productName, count, productType, price);

                } else if (command2 == 2) {
                    System.out.println("Product code: ");
                    long code = scanner.nextLong();
                    System.out.println("Product name: ");
                    String productName = String.valueOf(scanner.next());
                    System.out.println(productName);
                    System.out.println("Product count: ");
                    int count = scanner.nextInt();
                    System.out.println("Product type (FOOD, DRINK, SWEET, MEAT): ");
                    ProductType productType = ProductType.valueOf(scanner.next());
                    System.out.println("Product price: ");
                    double price = scanner.nextDouble();
                    marketService.updateProduct(code, productName, count, productType, price);
                } else if (command2 == 3) {
                    System.out.println("Input the product code to be deleted");
                    long code = scanner.nextLong();
                    marketService.removeProduct(code);
                } else if (command2 == 4) {
                    marketService.showAllProducts();
                } else if (command2 == 5) {
                    System.out.println("1 - Food");
                    System.out.println("2 - Drink");
                    System.out.println("3 - Sweet");
                    System.out.println("4 - Meat");
                    long selectedCategoryId = scanner.nextInt();
                    if (selectedCategoryId == 1) {
                        marketService.showProductsByCategory(ProductType.FOOD);
                    } else if (selectedCategoryId == 2) {
                        marketService.showProductsByCategory(ProductType.DRINK);
                    } else if (selectedCategoryId == 3) {
                        marketService.showProductsByCategory(ProductType.SWEET);
                    } else if (selectedCategoryId == 4) {
                        marketService.showProductsByCategory(ProductType.MEAT);
                    }
                } else if (command2 == 6) {
                    System.out.println("Input minimum price");
                    double minPrice = scanner.nextDouble();
                    System.out.println("Input maximum price");
                    double maxPrice = scanner.nextDouble();
                    marketService.filterByPrice(minPrice, maxPrice);
                } else if (command2 == 7) {
                    System.out.println("Input product name");
                    String productName = scanner.next();
                    marketService.findProductByName(productName);
                }
            } else if (command==2) {
                
            }


//            marketService.showAllProducts();
            System.out.println("1 - Product operations");
            System.out.println("2 - Sale operations");
            System.out.println("3 - exit");
            command = scanner.nextInt();


        }

//        System.out.println("Bye");
    }

    public static void printMainMenu() {
        System.out.println("1 - Product operations");
        System.out.println("2 - Sale operations");
        System.out.println("3 - exit");
    }

    public static void printProductOpMenu() {
        System.out.println("1 - Add product");
        System.out.println("2 - Update product");
//        System.out.println("3 - Exit");
    }

    public static void printSaleOpMenu() {
        System.out.println("1 - Product operations");
        System.out.println("2 - Sale operations");
        System.out.println("3 - exit");
    }

}
