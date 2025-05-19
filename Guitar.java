public class Guitar {
    public String brand;
    public String model;
    public String color;
    public double price;
    public String type;
    public String bodyMaterial;
    public int year;
    public boolean inStock;
    public int id;
    public static int nextId = 1;
    
    public Guitar() {
        this.id = nextId++;
    }
    
    public String toString() {
        return String.format("%d. %s %s %s (%s) - $%.2f\n   Тип: %s, Материал: %s, Год: %d, В наличии: %s",
                id, brand, model, type, color, price, type, bodyMaterial, year, inStock ? "Да" : "Нет");
    }
    
    public boolean matchesFilter(GuitarFilter filter) {
        boolean brandMatch = filter.brand == null || brand.equalsIgnoreCase(filter.brand);
        boolean colorMatch = filter.color == null || color.equalsIgnoreCase(filter.color);
        boolean typeMatch = filter.type == null || type.equalsIgnoreCase(filter.type);
        boolean priceMatch = (filter.minPrice == 0 || price >= filter.minPrice) && 
                           (filter.maxPrice == 0 || price <= filter.maxPrice);
        boolean yearMatch = (filter.minYear == 0 || year >= filter.minYear) && 
                          (filter.maxYear == 0 || year <= filter.maxYear);
        boolean stockMatch = !filter.inStockOnly || inStock;
        
        return brandMatch && colorMatch && typeMatch && priceMatch && yearMatch && stockMatch;
    }
    
    public void applyDiscount(double percent) {
        if (percent <= 0 || percent >= 100) {
            System.out.println("Неверная скидка");
            return;
        }
        price *= (1 - percent / 100);
        System.out.printf("Применена скидка %.0f%%. Новая цена: $%.2f\n", percent, price);
    }
    
    public void updateStockStatus(boolean inStock) {
        this.inStock = inStock;
        System.out.println("Статус наличия обновлен: " + (inStock ? "В наличии" : "Нет в наличии"));
    }
    
    public String getFullDescription() {
        return String.format("%s %s\nЦвет: %s\nЦена: $%.2f\nТип: %s\nМатериал: %s\nГод: %d\nВ наличии: %s",
                brand, model, color, price, type, bodyMaterial, year, inStock ? "Да" : "Нет");
    }
    
    public boolean isElectric() {
        return "Electric".equalsIgnoreCase(type);
    }
    
    public boolean isAcoustic() {
        return "Acoustic".equalsIgnoreCase(type);
    }
}