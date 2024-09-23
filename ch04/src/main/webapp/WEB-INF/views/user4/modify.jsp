
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User1::modify</title>
</head>
<body>
<h3>User4 수정</h3>

<a href="/ch04/">처음으로</a>
<a href="/ch04/user4/list">목록</a>

<form action="/ch04/user4/modify" method="post">
    <table>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="uid" value="${user.uid}" readonly /> </td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="${user.name}"/> </td>
        </tr>
        <tr>
            <td>성별</td>
            <td><input type="text" name="gender" value="${user.gender}"/> </td>
        </tr>
        <tr>
            <td>나이</td>
            <td><input type="number" name="age" value="${user.age}"/> </td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="hp" value="${user.hp}"/> </td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="addr" value="${user.addr}"/> </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="수정하기"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
