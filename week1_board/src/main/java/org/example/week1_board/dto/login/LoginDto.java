package org.example.week1_board.dto.login;

public class LoginDto {
    private String login_id;            // 사용자 ID
    private String password;            // 비밀번호

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDto(String login_id, String password) {
        this.login_id = login_id;
        this.password = password;
    }
}
