package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/questionnaire")
public class QuestionnaireController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String view = "/WEB-INF/views/questionnaire.jsp";
        request.getRequestDispatcher(view).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォームから送信されたデータを取得
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        // 性別の値変換
        if(sex.equals("man")) {
        	sex = "男性";
        	System.out.println("[SUCCESS][PATH:QuestionnaireController.java] 性別の値を変更しました");
        	System.out.println(sex);
        } else if (sex.equals("woman")) {
        	sex = "女性";
        	System.out.println("[SUCCESS][PATH:QuestionnaireController.java] 性別の値を変更しました");
        	System.out.println(sex);
        } else if (sex.equals("another")) {
        	sex = "その他";
        	System.out.println("[SUCCESS][PATH:QuestionnaireController.java] 性別の値を変更しました");
        	System.out.println(sex);
        } else if (sex.equals("男性") || sex.equals("女性") || sex.equals("その他")) {
        	System.out.println("[CHECK][PATH:QuestionnaireController.java] 性別の値を変更済みです");
        	System.out.println(sex);
        } else {
        	System.out.println("[ERROR][PATH:QuestionnaireController.java] 性別が設定されていません");
        	System.out.println(sex);
        }
        String email = request.getParameter("email");
        String feedback = request.getParameter("feedback");

        // 取得したデータをリクエスト属性として設定
        request.setAttribute("name", name);
        request.setAttribute("age", age);
        request.setAttribute("sex", sex);
        request.setAttribute("email", email);
        request.setAttribute("feedback", feedback);

        // confirm.jsp にリダイレクト
        String view = "/WEB-INF/views/confirm.jsp";
        request.getRequestDispatcher(view).forward(request, response);
    }
}
