<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>資料返却完了画面</title>
</head>
<body>
<table >
	<div align="center" style="background:#cccccc">
		<h1>資料返却完了画面</h1>
		<p style="font-weight:bolder">名前　：　<span>${name.name }</span></p><br>
		<P style="font-weight:bolder">資料名　:　<span>${title.title }</span></P><br>
		<p style="font-weight:bolder">返却期限　:　<span>${rental_due_date.rental_due_date}</span></p>
		<br>
		<form action="./ReturnServlet" method="POST">
			<input type="hidden" value="returndone" name="action">
   			<input type="submit" value="戻る">
		</form>
	</div>
</table>
</body>
</html>