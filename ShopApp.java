/*
the bad thing in the original code:

all attributes were public which breaks encapsulation
(checking stock and balance) was repeated
no method handled adding products to cart
customer data and product logic were mixed inside main
*/

class Product {
    private String name;
    private int price;
    private boolean inStock;

    public Product(String name, int price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public int getPrice() {
        return this.price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public String getName() {
        return name;
    }
}

class Customer {
    private int balance;
    private int itemsCount;

    public Customer(int balance) {
        this.balance = balance;
        this.itemsCount = 0;
    }

    public void addProduct(Product product) {
        if (!product.isInStock()) {
            System.out.println(product.getName() + " not in stock");
            return;
        }

        if (balance >= product.getPrice()) {
            balance -= product.getPrice();
            itemsCount++;
            System.out.println(product.getName() + " added to cart");
        } else {
            System.out.println("Not enough balance for " + product.getName());
        }
    }
}

public class ShopApp {
    public static void main(String[] args) {

        Customer customer = new Customer(100);

        Product phone = new Product("Phone", 85, true);
        Product book = new Product("Book", 30, false);

        customer.addProduct(phone);
        customer.addProduct(book);
    }
}
