/**
 * 
 */

 // 送信フォーマットチェック
function formatcheck () {
  if (questionnaire.name.value == ""){
    // 名前入力チェック
	  alert("[ERROR]メールアドレスを入力してください");    //エラーメッセージを出力
	  console.log("[ERROR]");
    return false;    //送信ボタン本来の動作をキャンセルします
    } else if (questionnaire.age.value == "") {
      alert("[ERROR]年齢を入力してください");    //エラーメッセージを出力
      console.log("[ERROR]");
      return false;    //送信ボタン本来の動作をキャンセルします
    } else if (questionnaire.sex.value == "") {
	    alert("[ERROR]性別を入力してください");    //エラーメッセージを出力
  	  console.log("[ERROR]");
      return false;    //送信ボタン本来の動作をキャンセルします
    } else if (questionnaire.email.value == "") {
	    alert("[ERROR]メールアドレスを入力してください");    //エラーメッセージを出力
  	  console.log("[ERROR]");
      return false;    //送信ボタン本来の動作をキャンセルします
    } else if (questionnaire.feedback.value == "") {
	    alert("[ERROR]ご意見・ご感想を入力してください");    //エラーメッセージを出力
  	  console.log("[ERROR]");
      return false;    //送信ボタン本来の動作をキャンセルします
    } else {
      //条件に一致しない場合(メールアドレスが入力されている場合)
      return true;    //送信ボタン本来の動作を実行します
    }
}

