package ua.ithillel.jakartaee.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter
public class LoggingFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        // forward
        log.info("Incoming request: {}", req.getRequestURI());

        chain.doFilter(req, res);
        // backward

        log.info("Response returned: {}", req.getRequestURI());
        log.debug("Response code: {}", res.getStatus());
    }
}
