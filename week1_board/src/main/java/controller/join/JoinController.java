package controller.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping("/resister")
    @ResponseBody
    public Map<String, Object> resisterUser(HttpSession session,@RequestBody Map<String, Object> paramMap, HttpServletRequest request) throws Exception {

        Map<String, Object> returnmap = new HashMap<String,Object>();
        try {
            joinService.resisterUser(paramMap);

            returnmap.put("resultmsg","가입 되었습니다.");

        } catch (Exception e) {
            throw e;
        }

        return returnmap;
    }


}
