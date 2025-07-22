package dto.board;
import java.util.Date;

public class BoardDto {
    private int board_id;                // 게시글 일련 번호
    private String board_name;           // 게시글 제목
    private String board_content;        // 게시글 내용
    private String user_name;            // 작성자
    private Date board_date;            // 작성날짜

    public BoardDto(int board_id, String board_name, String board_content, String user_name, Date board_date) {
        this.board_id = board_id;
        this.board_name = board_name;
        this.board_content = board_content;
        this.user_name = user_name;
        this.board_date = board_date;
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getBoard_name() {
        return board_name;
    }

    public void setBoard_name(String board_name) {
        this.board_name = board_name;
    }

    public String getBoard_content() {
        return board_content;
    }

    public void setBoard_content(String board_content) {
        this.board_content = board_content;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getBoard_date() {
        return board_date;
    }

    public void setBoard_date(Date board_date) {
        this.board_date = board_date;
    }


}
