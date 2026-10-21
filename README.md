# Lab9 Selenium - SauceDemo

Chương trình Java sử dụng Selenium WebDriver để tự động hóa 5 thao tác liên tiếp trên trang [SauceDemo](https://www.saucedemo.com/).

## Chức năng

Class `seleniumtest.SauceDemoTest` thực hiện:

1. Đăng nhập bằng tài khoản `standard_user`.
2. Thêm sản phẩm Sauce Labs Backpack vào giỏ hàng.
3. Mở trang **Your Cart**.
4. Xóa sản phẩm khỏi giỏ hàng.
5. Mở menu bên trái và đăng xuất.

Chương trình in kết quả **Thành công/Thất bại** sau mỗi bước và chờ 2 giây giữa các thao tác để dễ quan sát.

## Yêu cầu

- Java JDK 17 trở lên.
- Apache Maven.
- Google Chrome.
- Kết nối Internet để truy cập SauceDemo và tải ChromeDriver thông qua Selenium Manager.

## Cấu trúc chính

```text
seleniumtest/
├── pom.xml
├── src/
│   └── main/
│       └── java/
│           └── seleniumtest/
│               ├── Main.java
│               └── SauceDemoTest.java
└── README.md
```

## Cách chạy

Mở PowerShell tại thư mục chứa `pom.xml`:

```powershell
cd "D:\Kiểm Định\Lab9\seleniumtest"
```

Biên dịch project:

```powershell
mvn compile
```

Chạy chương trình:

```powershell
mvn exec:java '-Dexec.mainClass=seleniumtest.SauceDemoTest'
```

Nếu chương trình hoàn tất, Chrome sẽ được giữ mở để quan sát. Quay lại cửa sổ terminal và nhấn **Enter** để đóng trình duyệt.

## Kết quả mong đợi

```text
Bước 1 - Đăng nhập: Thành công
Bước 2 - Thêm sản phẩm vào giỏ hàng: Thành công
Bước 3 - Mở trang Your Cart: Thành công
Bước 4 - Xóa sản phẩm khỏi giỏ hàng: Thành công
Bước 5 - Đăng xuất: Thành công
```

## Thông tin đăng nhập kiểm thử

```text
Username: standard_user
Password: secret_sauce
```
