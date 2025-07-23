package org.example.week1_board.dto.join;
import java.util.Date;

public class JoinDto {
    private int user_no;                // 회원 일련 번호
    private String login_id;            // 사용자 ID
    private String user_name;           // 이름
    private String user_email;          // 이메일
    private String password;            // 비밀번호
    private Date join_date;             // 가입날짜

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }     // 가입날짜

    public JoinDto(int user_no, String login_id, String user_name, String user_email, String password, Date join_date) {
        this.user_no = user_no;
        this.login_id = login_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.password = password;
        this.join_date = join_date;
    }
}
