<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <title>アンケートフォーム - 確認</title>
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
  <div class="confirm">
    <h1>確認画面</h1>
    <p>以下の情報で送信します。よろしいですか？</p>

    <p><strong>お名前:</strong> ${name}</p>
    <p><strong>ご年齢:</strong> ${age}歳</p>
    <p><strong>性別:</strong> ${sex}</p>
    <p><strong>メールアドレス:</strong> ${email}</p>
    <p><strong>ご意見・ご感想:</strong><br>${feedback}</p>

    <form action="confirm" method="post">
        <input type="hidden" name="name" value="${name}">
        <input type="hidden" name="age" value="${age}">
        <input type="hidden" name="sex" value="${sex}">
        <input type="hidden" name="email" value="${email}">
        <input type="hidden" name="feedback" value="${feedback}">
        <input type="submit" value="送信" onclick="return formatcheck()">
        <input type="button" value="戻る" onclick="history.back()">
    </form>
  </div>
</body>
</html>
