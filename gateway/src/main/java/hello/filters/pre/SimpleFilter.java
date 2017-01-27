package hello.filters.pre;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import com.netflix.zuul.util.HTTPRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.Iterator;

public class SimpleFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    ctx.setDebugRouting(true);
    ctx.setDebugRequest(true);
    HttpServletRequest request = ctx.getRequest();
    log.info("11111111 ------- GATEWAY 1");
    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

    log.info("REQUEST:: " + request.getScheme() + " " + request.getRemoteAddr() + ":" + request.getRemotePort());
    log.info("REQUEST:: " + request.getRemoteHost());
    log.info("REQUEST:: " + request.getRemoteUser());
    log.info("REQUEST:: > " + request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol());

    return null;
  }

}
