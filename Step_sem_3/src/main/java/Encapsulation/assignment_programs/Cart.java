package Encapsulation.assignment_programs;

public class Cart {
    private final String cartId;
    private final double[] itemPrices;
    private int itemCount;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.itemPrices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (price >= 0 && itemCount < itemPrices.length) {
            itemPrices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}

