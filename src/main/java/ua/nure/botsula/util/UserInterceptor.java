package ua.nure.botsula.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ua.nure.botsula.model.Message;
import ua.nure.botsula.model.User;
import ua.nure.botsula.service.MessageService;
import ua.nure.botsula.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Alexandr on 17.05.2017.
 */
public class UserInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {


        return super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User auth = userService.findByLogin(name);

                HttpSession session = request.getSession(true);
        session.setAttribute("User", auth);
        List<Message> messages= messageService.findMessagesByStatusAndUser(auth);
        session.setAttribute("messages", messages);

        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {


        super.afterCompletion(request, response, handler, ex);
    }
}
