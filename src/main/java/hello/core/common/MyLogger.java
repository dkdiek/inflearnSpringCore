package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * hello.core.common
 * MyLogger
 *
 * @author : K
 */
@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
  
  private String uuid;
  private String requestURL;
  
  public void setRequestURL(String requestURL) {
    this.requestURL = requestURL;
  }
  
  public void log(String message) {
    System.out.println("[" + uuid + "]" + "[" + requestURL + "]" + message);
  }
  
  @PostConstruct
  public void init() {
    uuid = UUID.randomUUID().toString();
    System.out.println("[" + uuid + "]" + "[" + requestURL + "] request scope create: " + this );
  }
  
  @PreDestroy
  private void close() {
    System.out.println("[" + uuid + "]" + "[" + requestURL + "] request scope create: " + this );
  }
}
