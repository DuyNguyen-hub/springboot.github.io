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


<img width="1430" alt="Screen Shot 2021-07-26 at 13 49 02" src="https://user-images.githubusercontent.com/80323466/126945086-8bb556e4-1d7e-47cf-a694-4f26a18886d0.png">
//
<img width="641" alt="Screen Shot 2021-07-26 at 13 49 43" src="https://user-images.githubusercontent.com/80323466/126945154-45c55554-a187-42e8-bc06-a6cabef0983e.png">
//
<img width="716" alt="Screen Shot 2021-07-26 at 13 50 27" src="https://user-images.githubusercontent.com/80323466/126945219-2b442fd4-9ce7-4369-8bb6-9e76e30358a0.png">
//
<img width="1466" alt="Screen Shot 2021-07-26 at 13 51 40" src="https://user-images.githubusercontent.com/80323466/126945354-4a3af547-2da7-4c41-9983-0e477d55110f.png">

