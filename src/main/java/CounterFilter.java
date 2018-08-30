import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CounterFilter implements Filter {

    private ServletContext context;
    private static String PAGES_HIT_COUNTS = "PagesHitCounts";

    public void init(FilterConfig fConfig) {
        this.context = fConfig.getServletContext();
        this.context.setAttribute(PAGES_HIT_COUNTS, new HashMap<String, Integer>());
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        counterReq(req);

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

    private void counterReq(HttpServletRequest req) {
        Map<String, Integer> pagesHitCounts = (Map<String, Integer>) this.context.getAttribute(PAGES_HIT_COUNTS);
        String pageName = "page:" + req.getServletPath();
        if(!pageName.equals("page:/HitCounter.jsp")) {
            Integer hitCounter = (Integer) pagesHitCounts.get(pageName);
            hitCounter = hitCounter == null ? 1 : (hitCounter + 1);
            pagesHitCounts.put(pageName, hitCounter);
        }
    }

}