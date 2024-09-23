
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>user2::list</title>
    <script>
        window.onload = function(){

            const del = document.querySelectorAll('.del');

            //리스트에 삭제 링크가 여러개이기 때문에 문서객체 리스트를 순회(반복)하면서 이벤트 처리
            //고전 문서객체 선택함수(getElement~)는 forEach 지원 안 함
            del.forEach(function(item){

                item.onclick = function(e){
                    const result = confirm('정말 삭제하시겠습니까?');

                    if(!result){
                        e.preventDefault();
                        //return;

                    }

                }
            });
        }
    </script>
</head>
<body>
<h3>user2 목록</h3>
<a href="/ch05/">처음으로</a>
<a href="/ch05/user2/register">등록</a>

<table border="1">
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>생년월일</th>
        <th>주소</th>
        <th>관리</th>
    </tr>
    <c:forEach var="user" items="${users}">
    <tr>
        <td>${user.uid}</td>
        <td>${user.name}</td>
        <td>${user.birth}</td>
        <td>${user.addr}</td>
        <td>
            <a href="/ch05/user2/modify?uid=${user.uid}">수정</a>
            <a href="/ch05/user2/delete?uid=${user.uid}" class="del">삭제</a>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>