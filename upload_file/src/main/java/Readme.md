! tạo ung dung quan li nhan vien!
-hiện các chức năng thêm, sửa, xoá, hiển thị của các nhân viên đã hoàn thành!

-khai báo class Person trong model chứa các trường và
tạo các bộ get set, constructor;
 -> trường "linkimg" mình sẽ dùng lưu lại tên của file;

- Để giảm sự phụ thuộc của controller vào các modun cấp thấp thì mình tạo ra 
 trong fodel repository  1 iterface PersonInterface chứa các phương thức thêm sửa, xoá, hiển, thi;

- class PersonRepo implements 'PersonInterface' và sẽ thực hiện các logic sử lí trong ; 

-fodel service có class 'StrorageService' chứa phương thức xử lí file nhận được từ phía browse va trả về 1 String là tên gốc của file đc gửi lên!

-Và trong file application.propeperties thêm một số mặc định về kích thước file gửi lên và đường dẫn lưu của file!

-fodel controller tạo ra các controller phù hợp với từng chức năg;

- 'PersonController' sẽ xử lí các chức năng về person; trong code mình sẽ comment lại các chức năng và ý nghĩa các câu lệnh!

- trong fodel IMAGE lưu các ảnh demo về trang quản lí! các bạn hãy tham khảo!

-> các anh thêm có định dạng jpeg!



