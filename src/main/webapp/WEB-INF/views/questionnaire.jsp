<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <title>アンケートフォーム</title>
  <meta charset="UTF-8">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=M+PLUS+2:wght@600&display=swap" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Yusei+Magic&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="./css/style.css">
  <script type="text/javascript" src="./js/script.js"></script>
</head>
<body>
  <div class="questionnaire">
    <h1><strong>アンケートフォーム</strong></h1>
    <form action="questionnaire" method="post" name="questionnaire">
    <ul>
        <li><label for="name">お名前:</label>
        <input type="text" id="name" name="name" required></li><br>
        
        <li><label for="age">年齢:</label>
        <input type="number" id="age" name="age" required></li><br>
        
        <li><label for="sex">性別:</label>
        <select name="sex" required>
        <option value="man">男性</option>
        <option value="woman">女性</option>
        <option value="another">その他</option>
        </select></li><br>
        
        <li><label for="email">メールアドレス:</label>
        <input type="email" id="email" name="email" required></li><br>
        
        <li><label for="feedback"> ~ ご意見・ご感想 ~ </label></li>
        <textarea id="feedback" name="feedback" rows="4" cols="50" required></textarea><br>
        </ul>
        <input type="submit" value="送信" onclick="return formatcheck()">
    </form>
    </div>
</body>
</html>
