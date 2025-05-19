import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GuitarShop shop = new GuitarShop();
        Scanner scanner = new Scanner(System.in);
        
        // Добавляем тестовые данные
        initializeShopWithDemoData(shop);
        
        while (true) {
            System.out.println("\nГитарный магазин - Меню:");
            System.out.println("1. Показать все гитары");
            System.out.println("2. Добавить гитару");
            System.out.println("3. Найти гитару по фильтру");
            System.out.println("4. Удалить гитару");
            System.out.println("5. Выход");
            System.out.print("Выберите опцию: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    shop.printAllGuitars();
                    break;
                case 2:
                    addNewGuitarInteractive(shop, scanner);
                    break;
                case 3:
                    filterGuitarsInteractive(shop, scanner);
                    break;
                case 4:
                    removeGuitarInteractive(shop, scanner);
                    break;
                case 5:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
    
    private static void initializeShopWithDemoData(GuitarShop shop) {
        shop.addGuitar("Fender", "Stratocaster", "Red", 1200.00, "Electric", "Alder", 2019, true);
        shop.addGuitar("Gibson", "Les Paul", "Sunburst", 2500.00, "Electric", "Mahogany", 2020, false);
        shop.addGuitar("Fender", "Telecaster", "Black", 1100.00, "Electric", "Ash", 2021, true);
        shop.addGuitar("Ibanez", "RG", "Blue", 900.00, "Electric", "Basswood", 2018, true);
        shop.addGuitar("Gibson", "SG", "Cherry", 1800.00, "Electric", "Mahogany", 2022, false);
        shop.addGuitar("Martin", "D-28", "Natural", 3000.00, "Acoustic", "Rosewood", 2020, true);
        shop.addGuitar("Taylor", "314ce", "Brown", 2200.00, "Acoustic", "Sitka Spruce", 2021, true);
        shop.addGuitar("Yamaha", "FG800", "Natural", 350.00, "Acoustic", "Spruce", 2019, false);
    }
    
    private static void addNewGuitarInteractive(GuitarShop shop, Scanner scanner) {
        System.out.print("Введите бренд: ");
        String brand = scanner.nextLine();
        System.out.print("Введите модель: ");
        String model = scanner.nextLine();
        System.out.print("Введите цвет: ");
        String color = scanner.nextLine();
        System.out.print("Введите цену: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введите тип (Electric/Acoustic): ");
        String type = scanner.nextLine();
        System.out.print("Введите материал корпуса: ");
        String bodyMaterial = scanner.nextLine();
        System.out.print("Введите год выпуска: ");
        int year = scanner.nextInt();
        System.out.print("Есть ли в наличии (true/false): ");
        boolean inStock = scanner.nextBoolean();
        
        shop.addGuitar(brand, model, color, price, type, bodyMaterial, year, inStock);
        System.out.println("Гитара добавлена успешно!");
    }
    
    private static void filterGuitarsInteractive(GuitarShop shop, Scanner scanner) {
        GuitarFilter filter = new GuitarFilter();
        
        System.out.print("Бренд (оставьте пустым чтобы пропустить): ");
        String brand = scanner.nextLine();
        if (!brand.isEmpty()) filter.brand = brand;
        
        System.out.print("Цвет (оставьте пустым чтобы пропустить): ");
        String color = scanner.nextLine();
        if (!color.isEmpty()) filter.color = color;
        
        System.out.print("Тип (Electric/Acoustic, оставьте пустым чтобы пропустить): ");
        String type = scanner.nextLine();
        if (!type.isEmpty()) filter.type = type;
        
        System.out.print("Минимальная цена (0 чтобы пропустить): ");
        filter.minPrice = scanner.nextDouble();
        System.out.print("Максимальная цена (0 чтобы пропустить): ");
        filter.maxPrice = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Минимальный год выпуска (0 чтобы пропустить): ");
        filter.minYear = scanner.nextInt();
        System.out.print("Максимальный год выпуска (0 чтобы пропустить): ");
        filter.maxYear = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Только в наличии (true/false): ");
        filter.inStockOnly = scanner.nextBoolean();
        scanner.nextLine();
        
        System.out.println("\nРезультаты поиска:");
        shop.printFilteredGuitars(filter);
    }
    
    private static void removeGuitarInteractive(GuitarShop shop, Scanner scanner) {
        System.out.print("Введите индекс гитары для удаления: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        
        if (shop.removeGuitar(index)) {
            System.out.println("Гитара удалена успешно!");
        } else {
            System.out.println("Не удалось удалить гитару. Проверьте индекс.");
        }
    }
}