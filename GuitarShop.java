import java.util.ArrayList;
import java.util.List;

public class GuitarShop {
    private List<Guitar> guitars = new ArrayList<>();
    private int totalSales = 0;
    private double totalRevenue = 0.0;
    
    public void addGuitar(String brand, String model, String color, double price, 
                         String type, String bodyMaterial, int year, boolean inStock) {
        Guitar guitar = new Guitar();
        guitar.brand = brand;
        guitar.model = model;
        guitar.color = color;
        guitar.price = price;
        guitar.type = type;
        guitar.bodyMaterial = bodyMaterial;
        guitar.year = year;
        guitar.inStock = inStock;
        guitars.add(guitar);
    }
    
    public boolean removeGuitar(int id) {
        for (int i = 0; i < guitars.size(); i++) {
            if (guitars.get(i).id == id) {
                guitars.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public void printAllGuitars() {
        if (guitars.isEmpty()) {
            System.out.println("В магазине нет гитар.");
            return;
        }
        
        System.out.println("Все гитары в магазине (" + guitars.size() + "):");
        for (Guitar guitar : guitars) {
            System.out.println(guitar.toString());
        }
    }
    
    public void printFilteredGuitars(GuitarFilter filter) {
        List<Guitar> filtered = new ArrayList<>();
        for (Guitar guitar : guitars) {
            if (guitar.matchesFilter(filter)) {
                filtered.add(guitar);
            }
        }
        
        if (filtered.isEmpty()) {
            System.out.println("Гитары по заданным критериям не найдены.");
            return;
        }
        
        System.out.println("Найдено гитар: " + filtered.size());
        for (Guitar guitar : filtered) {
            System.out.println(guitar.toString());
        }
    }
    
    public void sellGuitar(int id) {
        for (Guitar guitar : guitars) {
            if (guitar.id == id && guitar.inStock) {
                guitar.inStock = false;
                totalSales++;
                totalRevenue += guitar.price;
                System.out.println("Продана гитара: " + guitar.brand + " " + guitar.model);
                return;
            }
        }
        System.out.println("Гитара с ID " + id + " не найдена или нет в наличии.");
    }
    
    public void applyDiscountToAll(double percent) {
        if (percent <= 0 || percent >= 100) {
            System.out.println("Неверная скидка");
            return;
        }
        
        for (Guitar guitar : guitars) {
            guitar.applyDiscount(percent);
        }
        System.out.println("Скидка применена ко всем гитарам.");
    }
    
    public void printInventoryReport() {
        int electricCount = 0;
        int acousticCount = 0;
        int inStockCount = 0;
        
        for (Guitar guitar : guitars) {
            if (guitar.isElectric()) electricCount++;
            if (guitar.isAcoustic()) acousticCount++;
            if (guitar.inStock) inStockCount++;
        }
        
        System.out.println("\nОтчет по инвентарю:");
        System.out.println("Всего гитар: " + guitars.size());
        System.out.println("Электрогитар: " + electricCount);
        System.out.println("Акустических гитар: " + acousticCount);
        System.out.println("В наличии: " + inStockCount);
        System.out.println("Продано всего: " + totalSales);
        System.out.println("Общий доход: $" + String.format("%.2f", totalRevenue));
    }
    
    public Guitar findMostExpensiveGuitar() {
        if (guitars.isEmpty()) return null;
        
        Guitar mostExpensive = guitars.get(0);
        for (Guitar guitar : guitars) {
            if (guitar.price > mostExpensive.price) {
                mostExpensive = guitar;
            }
        }
        return mostExpensive;
    }
    
    public Guitar findCheapestGuitar() {
        if (guitars.isEmpty()) return null;
        
        Guitar cheapest = guitars.get(0);
        for (Guitar guitar : guitars) {
            if (guitar.price < cheapest.price) {
                cheapest = guitar;
            }
        }
        return cheapest;
    }
}