1-Mục đích của cookie là gì?
2-Cookie là công nghệ chỉ có trong Spring Boot. Đúng hay Sai?
3-Thuộc tính Expires/Max-Age tính bằng đơn vị gì? Ý nghĩa của nó là gì?
4-Thuộc tính Domain của Cookie có ý nghĩa gì?
5-Thuộc tính nào cho phép mã JavaScript ở client có thể đọc được giá trị của Cookie?
6-Thuộc tính Path có tác dụng như thế nào?


// Trả lời
1- tạo ra và lưu 1 file chứa các thông tin đăng nhập và hành vi của người dùng trên thiết bị của người dùng (máy tính, smartphone,..), và các lần truy cập kế tiếp sẽ ko cần xác minh lại nếu thời gian cookei chưa hết!

2- Sai.

3- tính bằng 'giây'. Ý nghĩa: xác định thời gian mà mỗi cookei tồn tại!

4- thuộc tính domain chỉ ra tên miền, địa chỉ đường link được gõ trong url, máy chủ nào sẽ nhận được request này!

5- thuộc tính HttpOnly là false!

6-