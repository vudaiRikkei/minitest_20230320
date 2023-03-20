package ra.bussinessImp;

import ra.bussiness.IProduct;
import ra.run.Main;

import java.util.Scanner;

public class Product implements IProduct {
    private int productid;

    private String productName;

    private String title;

    private String descriptions;

    private float importPrice;

    private float exportPrice;

    private float interest;

    private boolean productStatus;

    public Product(int productid, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productid = productid;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Product() {
    }

    @Override
    public void inPutData() {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input product data!");
        System.out.println("product ID:");
        product.productid = Integer.parseInt(scanner.next());
        System.out.println("product name: ");
        product.productName = scanner.next();
        System.out.println("title:");
        product.title = scanner.next();
        System.out.println("descriptions");
        product.descriptions = scanner.next();
        System.out.println("importPrice");
        product.importPrice = scanner.nextFloat();
        System.out.println("exportPrice");
        product.exportPrice = scanner.nextFloat();
        System.out.println("productStatus, 1 = true, 2 = false: ");
        product.productStatus = true ? scanner.nextInt() == 1 : false;
        product.interest = product.exportPrice - product.importPrice;
        Main.productList.add(product);
    }

    @Override
    public void displayData() {
        System.out.println("product list: ");
        for (int i = 0; i < Main.productList.size(); i++) {
            System.out.print(i + 1 + ": ");
            System.out.println(Main.productList.get(i));
        }

    }

    @Override
    public String toString() {
        return "Product{" +
                "productid=" + productid +
                ", productName='" + productName + '\'' +
                ", title='" + title + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", productStatus=" + productStatus +
                '}';
    }
}
