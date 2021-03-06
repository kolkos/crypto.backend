package nl.kolkos.crypto.telegram.bot.backend.configuration.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.crypto.telegram.bot.backend.service.InterceptedPortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static nl.kolkos.crypto.telegram.bot.backend.constant.Constants.TOKEN_HEADER_FIELD_NAME;

@Log4j2
@RequiredArgsConstructor
public class HeaderInterceptor extends HandlerInterceptorAdapter {

    private final InterceptedPortfolioService interceptedPortfolioService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) {
        if (!checkToken(request)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("%s not found in the header", TOKEN_HEADER_FIELD_NAME));
        }

        String token = request.getHeaders(TOKEN_HEADER_FIELD_NAME).nextElement();
        interceptedPortfolioService.setToken(token);
        log.info("Received token '{}'", token);

        return true;
    }

    private boolean checkToken(HttpServletRequest request) {
        return request.getHeaders(TOKEN_HEADER_FIELD_NAME).hasMoreElements();
    }



}
