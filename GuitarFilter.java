public class GuitarFilter {
    public String brand;
    public String model;
    public String color;
    public String type;
    public String bodyMaterial;
    public double minPrice;
    public double maxPrice;
    public int minYear;
    public int maxYear;
    public boolean inStockOnly;
    
    public GuitarFilter() {
        minPrice = 0;
        maxPrice = 0;
        minYear = 0;
        maxYear = 0;
        inStockOnly = false;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setBodyMaterial(String bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }
    
    public void setPriceRange(double min, double max) {
        this.minPrice = min;
        this.maxPrice = max;
    }
    
    public void setYearRange(int min, int max) {
        this.minYear = min;
        this.maxYear = max;
    }
    
    public void setInStockOnly(boolean inStockOnly) {
        this.inStockOnly = inStockOnly;
    }
    
    public boolean isActive() {
        return brand != null || model != null || color != null || type != null || 
               bodyMaterial != null || minPrice != 0 || maxPrice != 0 || 
               minYear != 0 || maxYear != 0 || inStockOnly;
    }
    
    public void reset() {
        brand = null;
        model = null;
        color = null;
        type = null;
        bodyMaterial = null;
        minPrice = 0;
        maxPrice = 0;
        minYear = 0;
        maxYear = 0;
        inStockOnly = false;
    }
    
    public String getFilterDescription() {
        StringBuilder sb = new StringBuilder("Фильтр: ");
        if (brand != null) sb.append("Бренд=").append(brand).append(", ");
        if (color != null) sb.append("Цвет=").append(color).append(", ");
        if (type != null) sb.append("Тип=").append(type).append(", ");
        if (minPrice != 0 || maxPrice != 0) 
            sb.append(String.format("Цена=%.2f-%.2f, ", minPrice, maxPrice));
        if (minYear != 0 || maxYear != 0)
            sb.append(String.format("Год=%d-%d, ", minYear, maxYear));
        if (inStockOnly) sb.append("Только в наличии, ");
        
        String result = sb.toString();
        return result.endsWith(", ") ? result.substring(0, result.length() - 2) : result;
    }
}