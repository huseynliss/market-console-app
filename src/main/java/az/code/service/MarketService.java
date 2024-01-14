package az.code.service;

import az.code.model.Product;
import az.code.model.ProductType;
import az.code.model.Purchase;

import java.util.ArrayList;
import java.util.List;

public class MarketService {
    private List<Product> products;
    private List<Purchase> purchases;

    public MarketService() {
        products = new ArrayList<>();
        purchases = new ArrayList<>();
    }

    public void addProduct(String name, int count, ProductType productType, double price) {
        Product product = new Product();
        product.setCode(System.currentTimeMillis());
        product.setName(name);
        product.setCount(count);
        product.setProductType(productType);
        product.setPrice(price);
        products.add(product);
    }

    public void updateProduct(long code, String name, int count, ProductType productType, double price) {
        Product productByCode = findProductByCode(products, code);
        productByCode.setName(name);
        productByCode.setCount(count);
        productByCode.setProductType(productType);
        productByCode.setPrice(price);
    }

    public void removeProduct(long code) {
        products.remove(findProductByCode(products, code));
    }

    public void showAllProducts() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void showProductsByCategory(ProductType productType) {
        for (Product product : products) {
            if (product.getProductType() == productType) {
                System.out.println(product);
            }
            ;
        }
    }

    public void filterByPrice(double min, double max) {
        for (Product product : products) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                System.out.println(product);
            }
        }
    }

    public void findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().contains(productName)) {
                System.out.println(product);
            }
        }
    }

    private static Product findProductByCode(List<Product> products, long targetCode) {
        for (Product product : products) {
            if (product.getCode() == targetCode) {
                return product;
            }
        }
        return null;
    }

    public void createPurchase()




}
