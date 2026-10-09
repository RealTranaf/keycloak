**Tìm hiểu thêm về Keycloak**

Keycloak sử dụng các authentication protocol là OAuth 2.0, OpenID Connect (OIDC) và SAML.

**OAuth 2.0**

OAuth là phương thức xác thực giúp ứng dụng bên thứ 3 có thể được ủy quyền bởi người dùng để truy cập tới resource nằm trong một service khác. OAuth 2.0 là bản nâng cấp của OAuth1.0, là một giao thức chứng thực cho phép các ứng dụng chia sẻ một phần resource với nhau mà không cần xác thực qua username và password như cách truyền thống từ đó giúp hạn chế được những phiền toái khi phải nhập login ở quá nhiều nơi hoặc đăng ký quá nhiều tài khoản mật khẩu.

OAuth 2.0 định nghĩa 4 vai trò:

- Resource owner: user có khả năng truy cập, chủ sở hữu của resource mà ứng dụng cung cấp.
- Resource server: nơi lưu trữ resource, có khả năng xử lý yêu cầu truy cập tới các resource được bảo vệ.
- Client: ứng dụng bên thứ 3 muốn truy cập vào tài nguyên được chia sẻ với tư cách là resource owner, trước khi truy cập ứng dụng cần sự ủy quyền của user.
- Authorizations server: xác thực, kiểm tra thông tin mà user gửi tới để cấp quyền truy cập cho ứng dụng bằng cách sinh ra các đoạn access token. Resource server cx có thể đảm nhiệm vai trò authorization server.

Token: đoạn mã được sinh ra bởi authorization server khi có yêu cầu được gửi đến từ client. Có 2 loại token là access token và refresh token.

