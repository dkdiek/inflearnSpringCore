package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * hello.core.web
 * LogDemoService
 *
 * @author : K
 */
@Service
@RequiredArgsConstructor
public class LogDemoService {
  
//  private final ObjectProvider<MyLogger> myLoggerProvider;
  private final MyLogger myLogger;
  
  public void logic(String id) {
//    myLoggerProvider.getObject()
    myLogger.log("service id=" + id);
  }
}
