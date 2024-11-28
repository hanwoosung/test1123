package com.example.demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == 404) {
                model.addAttribute("errorCode", "404");
                model.addAttribute("errorMessage", "요청하신 페이지 없음");
                return "error/404";
            }

            else if (statusCode == 500) {
                model.addAttribute("errorCode", "500");
                model.addAttribute("errorMessage", "서버 내부에서 오류");
                return "error/500";
            }
        }

        // 기타 에러 처리
        model.addAttribute("errorCode", "UNKNOWN");
        model.addAttribute("errorMessage", "알 수 없는 오류");
        return "error/generalError";
    }
}
