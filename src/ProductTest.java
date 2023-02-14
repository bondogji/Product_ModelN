import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    // test constructor
    @org.junit.jupiter.api.Test
    @DisplayName("Test Product constructor")
    void Product() {
        Product p = new Product("00001", "Apple", "A red fruit full of vitamins", 1.00);
        assertEquals("00001", p.getID());
        assertEquals("Apple", p.getName());
        assertEquals("A red fruit full of vitamins", p.getDescription());
        assertEquals(1.00, p.getCost());
    }


    @org.junit.jupiter.api.Test
    @DisplayName("Set Name to Banana")
    void setName() {
        Product p = new Product("00001", "Apple", "A red fruit full of vitamins", 1.00);
        p.setName("Banana");
        assertEquals("Banana", p.getName());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Set Description to A yellow fruit full of potassium")
    void setDescription() {
        Product p = new Product("00001", "Apple", "A red fruit full of vitamins", 1.00);
        p.setDescription("A yellow fruit full of potassium");
        assertEquals("A yellow fruit full of potassium", p.getDescription());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Set Cost to 2.00")
    void setCost() {
        Product p = new Product("00001", "Apple", "A red fruit full of vitamins", 1.00);
        p.setCost(2.00);
        assertEquals(2.00, p.getCost());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Expect full product data to be Apple: A red fruit full of vitamins")
    void fullProductData() {
        Product p = new Product("00001", "Apple", "A red fruit full of vitamins", 1.00);
        assertEquals("Apple: A red fruit full of vitamins", p.fullProductData());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Expect toCSVDataRecord to be: 00001, Apple, A red fruit, 1.00")
    void toCSVDataRecord() {
        Product p = new Product("00001", "Apple", "A red fruit full of vitamins", 1.00);
        assertEquals("00001, Apple, A red fruit full of vitamins, 1.00", p.toCSVDataRecord());
    }
}
