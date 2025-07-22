package controller.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.join.JoinService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/join")
public class JoinController {
    @Autowired
    private JoinService joinService;

    /**
     * 회원가입
     */
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerUser(
            @RequestBody Map<String, Object> paramMap,
            HttpServletRequest request,
            HttpSession session) {

        Map<String, Object> resultMap = new HashMap<>();

        try {
            String inputEmail = (String) paramMap.get("login_id");

            int registerResult = joinService.registerUser(paramMap);

            if (registerResult > 0) {
                session.removeAttribute("verifiedEmail");
                session.removeAttribute("emailVerifiedAt");

                resultMap.put("result", "Y");
                resultMap.put("message", "회원가입이 완료되었습니다.");

                return ResponseEntity.ok(resultMap);
            } else {
                resultMap.put("result", "N");
                resultMap.put("message", "회원가입에 실패했습니다.");
                return ResponseEntity.badRequest().body(resultMap);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
