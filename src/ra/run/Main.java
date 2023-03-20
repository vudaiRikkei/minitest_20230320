package ra.run;

import ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String copyright = "copyright belongs to Daipv@rekkeisoft.com";
    public static List<Product> productList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    private static Product product = new Product();

    public static void main(String[] args) {
        System.err.println(copyright);
        int choice;
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm \n" +
                    "2. Hiển thị thông tin các sản phẩm \n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần \n" +
                    "4. Xóa sản phẩm theo mã sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm \n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm\n" +
                    "7. Thoát");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: addProduct();
                    break;
                case 2: if (checkProductQuantity()){product.displayData();}
                    break;
                case 3: sortProductByInterestASC();
                    break;
                case 4: deleteById();
                    break;
                case 5: findProductByName();
                    break;
                case 6: changeProductStatus();
                    break;
                case 7: System.exit(0);
            }
        } while (choice != 7);
    }
    static void addProduct(){ // thêm sản phẩm
        System.out.println("nhập số lượn sản phẩm muốn thêm: ");
        int quantity = scanner.nextInt();
        for (int i = 0; i < quantity; i++) {
           product.inPutData();
           product.displayData();
        }
    }

    static void sortProductByInterestASC(){ //thuật toán sắp xếp theo lợi nhuận sản phẩm
        if (checkProductQuantity()) {
            for (int i = 0; i < productList.size(); i++) {
                int minIdx = i;
                for (int j = i + 1; j < productList.size(); j++) {
                    if (productList.get(i).getInterest() < productList.get(minIdx).getInterest()) {
                        minIdx = j;
                    }
                }
                Product temp = productList.get(minIdx);
                productList.set(minIdx, productList.get(i));
                productList.set(i, temp);
            }
        }
    }

    public static void deleteById(){ //hàm xóa
        if (checkProductQuantity()) {
            System.out.println("nhập id sản phầm cần xóa");
            int index = findIndexById(scanner.nextInt()); // index cần xóa qua hàm findIndexById() rồi truyền vào mảng để xóa
            if (index == -1) { //if này để tránh lỗi areayindexoutofbound
                System.out.println("không tìm thấy sản phẩm cần xóa!");
            } else productList.remove(index); //xóa
        }
    }
    public static int findIndexById(int id){ //hàm tìm kiếm indextheo id
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductid() == id){
                return i;
            }
        }
        return -1;
    }

    static void findProductByName(){ //hàm tìm kiếm sản phẩm theo tên.
        if (checkProductQuantity()){ //if này để check danh sách sản phẩm rỗng
            System.out.println("nhập tên sản phẩm cần xóa: ");
            String name = scanner.nextLine();
            for (int i = 0; i < productList.size(); i++) {
                if (name.equals(productList.get(i).getProductName())){
                    System.out.println(productList.get(i));
                }
            }
        }
    }
    static void changeProductStatus(){
        if (checkProductQuantity()) {//if này để check danh sách sản phẩm rỗng
            System.out.println("nhập id sản phẩm cần thay đổi status: ");
            int index = findIndexById(scanner.nextInt()); // lấy index để thay đổi status
            productList.get(index).setProductStatus(!productList.get(index).isProductStatus()); //thay đổi status
        }
    }

    static boolean checkProductQuantity(){ //hàm check list sản phẩm rỗng
        if (productList.size() == 0){
            System.out.println("danh sách sản phẩm rỗng");
            return false;
        }else {
            System.out.println("danh sách hiện có " + productList.size() + "sản phẩm: ");
            return true;
        }
    }

}
