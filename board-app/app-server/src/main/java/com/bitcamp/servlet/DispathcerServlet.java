package com.bitcamp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 역할:
// 페이지 컨트롤러의 앞쪽에서 클라이언트 요청을 받는 일을 한다.
// 클라이언트가 요청한 경로에 따라 적절한 페이지 컨트롤러를 실행한다.
// 페이이지 컨트롤러의 공통 기능을 수행한다.

// @WebServlet(value = "/service/*")
// @MultipartConfig(maxFileSize = 1024 * 1024 * 10) // 최대 10M까지 업로드 혀용
public class DispathcerServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  ///java.io.Seriallizable를 구현한 애들은 seriallizable 설정해야한다 아니면 랜덤한 값으로 설정된다.
  // seriallizable 객체를 seriallizable 바이트배열로 만들어서 내보낼때 사용한다.
  // 프로그램을 내보낼때는 항상 버전을 정해서 보내야한다.
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      // 프론트 컨트롤럴르 경유해서 실행할 페이지 컨트롤러의 경로를 알아낸다.
      //  - "/service" 다음에 오는 경로, 즉 * 에 해당하는 경로를 리턴한다.
      // System.out.println(pathInfo); -> /, /haha/nan/hul
      String pathInfo = req.getPathInfo();
      System.out.println(pathInfo);

      // 페이지 컨트롤러를 찾는다.
      Controller controller = (Controller) req.getServletContext().getAttribute(pathInfo);
      System.out.println("controller: " + req.getServletContext().getAttribute(pathInfo));

      if (controller == null) {
        throw new Exception("페이지 컨트롤러가 없습니다!");
      }

      // 페이지 컨트롤러를 실행한다.
      resp.setContentType("text/html;charset=UTF-8");
      String viewName = controller.execute(req, resp);

      if (viewName.startsWith("redirect:")) { // 예) "redirect:list"
        resp.sendRedirect(viewName.substring(9)); // 예) "list"
        return;
      } else {
        req.getRequestDispatcher(viewName).include(req, resp); // JSP를 실행한 후 리턴된다.
      }
    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, resp);
    }
  }
}
