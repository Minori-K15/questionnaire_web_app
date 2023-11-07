package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/confirm")
public class ConfirmController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// ログ
    	System.out.println("[INFO][PATH:ConfirmController.java]処理開始ログ");
    	// 受付番号の発行
        String uuid = UUID.randomUUID().toString();
        
        // 発行した受付番号ををリクエスト属性として設定
        request.setAttribute("uuid", uuid);
        
        // 取得したデータをリクエスト属性として設定
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        // 性別の値変換
        if(sex.equals("man")) {
        	sex = "男性";
        	System.out.println("[SUCCESS][PATH:ConfirmController.java] 性別の値を変更しました");
        	System.out.println(sex);
        } else if (sex.equals("woman")) {
        	sex = "女性";
        	System.out.println("[SUCCESS][PATH:ConfirmController.java] 性別の値を変更しました");
        	System.out.println(sex);
        } else if (sex.equals("another")) {
        	sex = "その他";
        	System.out.println("[SUCCESS][PATH:ConfirmController.java] 性別の値を変更しました");
        	System.out.println(sex);
        } else if (sex.equals("男性") || sex.equals("女性") || sex.equals("その他")) {
        	System.out.println("[CHECK][PATH:ConfirmController.java] 性別の値を変更済みです");
        	System.out.println(sex);
        } else {
        	System.out.println("[ERROR][PATH:ConfirmController.java] 性別が設定されていません");
        	System.out.println(sex);
        }
        String email = request.getParameter("email");
        String feedback = request.getParameter("feedback");
        
    	// 処理実行ログ出力
    	System.out.println("[INFO][PATH:ConfirmController.java]値取得確認");
    	System.out.println("[INFO]" + name);
    	System.out.println("[INFO]" + age + "歳");
    	System.out.println("[INFO]" + sex);
    	System.out.println("[INFO]" + email);
    	System.out.println("[INFO]" + feedback);
        
        // 現在日時を取得
        LocalDateTime nowDate = LocalDateTime.now();
        
        // 日付フォーマット
        String pattern = "yyyy年MM月dd日 HH時mm分ss秒 E曜日";
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(pattern);
        
        // 現在の日時をフォーマットに変更
        String formatNowDate = dtf1.format(nowDate); 
        
        // ファイル定義
        String filePath =  "/Users/kutsukake.minori/Documents/eclipse/questionnaire_web_app/src/main/webapp/export/" + "test_" + uuid + ".txt";
        // テキストファイル作成・書き込み用のメゾット呼び出し
        FileWriter(filePath, formatNowDate, uuid, name, age, sex, email, feedback );
        // thanks.jsp にリダイレクト
        String view = "/WEB-INF/views/thanks.jsp";
        request.getRequestDispatcher(view).forward(request, response);
    }

    // テキストファイルを作成してデータを抽出
    protected void FileWriter(String filePath, String formatNowDate, String uuid, String name, String age, String sex, String email, String feedback) {
        System.out.println("[INFO][PATH:ConfirmController.java]テキストファイル作成処理開始");
    	try {
       		// テキストファイル作成
   			Path files = Paths.get(filePath);
   			Files.createFile(files);
               System.out.println("[INFO][PATH:ConfirmController.java]テキストファイルが作成されました" + files);
               System.out.println("[INFO][PATH:ConfirmController.java]テキストファイルの書き込みを開始します");
               
            if (Files.notExists(files)) {
                System.out.println("[ERROR][PATH:ConfirmController.java]テキストファイルが存在しました");
            } else {
                // ログ
                System.out.println("[INFO][PATH:ConfirmController.java]テキストファイルの作成に成功しました");
                // テキストファイルの書き込み
                File file = new File(filePath);
                FileWriter filewriter = new FileWriter(file);
                // 処理実行ログ出力
                System.out.println(file);
                
                //　テキスト出力内容 
                filewriter.write("日付：" + formatNowDate + "\r\n");
                filewriter.write("UUID：" + uuid + "\r\n");
                filewriter.write("名前：" + name + "\r\n");
                filewriter.write("年齢：" + age + "歳" + "\r\n");
                filewriter.write("性別：" + sex + "\r\n");
                filewriter.write("メールアドレス：" + email + "\r\n");
                filewriter.write("意見・感想：" + feedback);
                filewriter.close();
                // ログ
                System.out.println("[SUCCESS][PATH:ConfirmController.java]テキストファイルへデータ出力が成功しました");
            }
        } catch (IOException e) {
            e.printStackTrace();
            // ログ
            System.out.println("[ERROR][PATH:ConfirmController.java]テキストファイルへデータ出力失敗しました");
        }
    }
}
