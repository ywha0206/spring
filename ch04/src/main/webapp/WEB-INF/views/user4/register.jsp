<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>User1::register</title>
</head>
<body>
<h3>User1 등록</h3>

<a href="/ch04/">처음으로</a>
<a href="/ch04/user4/list">목록</a>

<form action="/ch04/user4/register" method="post">
  <table>
    <tr>
      <td>아이디</td>
      <td><input type="text" name="uid"/> </td>
    </tr>
    <tr>
      <td>이름</td>
      <td><input type="text" name="name"/> </td>
    </tr>
    <tr>
      <td>성별</td>
      <td><input type="text" name="gender"/> </td>
    </tr>
    <tr>
      <td>나이</td>
      <td><input type="number" name="age"/> </td>
    </tr>
    <tr>
      <td>전화번호</td>
      <td><input type="text" name="hp"/> </td>
    </tr>
    <tr>
      <td>주소</td>
      <td><input type="text" name="addr"/> </td>
    </tr>
    <tr>
      <td colspan="2" align="right">
        <input type="submit" value="등록하기"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>