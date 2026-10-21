package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class SauceDemoTest {
    private static final String URL = "https://www.saucedemo.com/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        int currentStep = 1;
        String currentAction = "Đăng nhập";
        boolean scenarioCompleted = false;

        try {
            // Bước 1: Mở trang SauceDemo và đăng nhập bằng tài khoản được cung cấp.
            driver.get(URL);
            sleep();
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            sleep();
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            sleep();
            driver.findElement(By.id("login-button")).click();
            sleep();
            printResult(1, "Đăng nhập", true);

            // Bước 2: Thêm sản phẩm đầu tiên vào giỏ hàng.
            currentStep = 2;
            currentAction = "Thêm sản phẩm vào giỏ hàng";
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            sleep();
            printResult(2, "Thêm sản phẩm vào giỏ hàng", true);

            // Bước 3: Click biểu tượng giỏ hàng để mở trang Your Cart.
            currentStep = 3;
            currentAction = "Mở trang Your Cart";
            driver.findElement(By.className("shopping_cart_link")).click();
            sleep();
            printResult(3, "Mở trang Your Cart", true);

            // Bước 4: Xóa sản phẩm vừa thêm khỏi giỏ hàng.
            currentStep = 4;
            currentAction = "Xóa sản phẩm khỏi giỏ hàng";
            driver.findElement(By.id("remove-sauce-labs-backpack")).click();
            sleep();
            printResult(4, "Xóa sản phẩm khỏi giỏ hàng", true);

            // Bước 5: Mở menu góc trái và đăng xuất khỏi hệ thống.
            currentStep = 5;
            currentAction = "Đăng xuất";
            driver.findElement(By.id("react-burger-menu-btn")).click();
            sleep();
            driver.findElement(By.id("logout_sidebar_link")).click();
            sleep();
            printResult(5, "Đăng xuất", true);
            scenarioCompleted = true;
        } catch (Exception exception) {
            printResult(currentStep, currentAction, false);
            System.out.println("Chi tiết lỗi: " + exception.getMessage());
        } finally {
            // Giữ trình duyệt mở để người dùng thao tác, sau đó nhấn Enter để đóng.
            if (scenarioCompleted) {
                System.out.println("Đã hoàn tất 5 bước. Bạn có thể thao tác trên Chrome.");
                System.out.println("Nhấn Enter trong terminal để đóng trình duyệt...");
                new Scanner(System.in).nextLine();
            }

            // Đóng trình duyệt sau khi người dùng nhấn Enter.
            driver.quit();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Luồng bị gián đoạn khi chờ thao tác.", exception);
        }
    }

    private static void printResult(int step, String action, boolean success) {
        String result = success ? "Thành công" : "Thất bại";
        System.out.printf("Bước %d - %s: %s%n", step, action, result);
    }
}
