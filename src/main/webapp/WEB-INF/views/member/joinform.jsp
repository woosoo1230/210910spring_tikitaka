<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@4.5.2/dist/sandstone/bootstrap.min.css" integrity="sha384-zEpdAL7W11eTKeoBJK1g79kgl9qjP7g84KfK3AZsuonx38n8ad+f5ZgXtoSDxPOh" crossorigin="anonymous">
<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
      .id_ok{ display: none;}
      .id_already{color:#6A82FB; display: none;}
      
      .nickname_ok{ display: none;}
      .nickname_already{color:#6A82FB; display: none;}
    
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    function checkId(){
        var mid = $('#mid').val(); 
        //alert(mid)
        $.ajax({
            url:'/semiproject/idCheck', 
            type:'post', //POST 방식으로 전달
            data:{mid:mid},
            success:function(cnt){
                //console.log("처리 성공 시 변경되는 내용");
            	if(cnt != 1){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
                    $('.id_ok').css("display","inline-block"); 
                    $('.id_already').css("display", "none");
                } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                    $('.id_already').css("display","inline-block");
                    $('.id_ok').css("display", "none");
                }
            },
            error:function(){
                alert("에러입니다");
            }
        });
    };
    
    function checkNickname(){
        var nickname = $('#nickname').val(); 
        //alert(nickname);
        $.ajax({
            url:'/semiproject/nicknameCheck', 
            type:'post', //POST 방식으로 전달
            data:{nickname:nickname},
            success:function(cnt){
                //console.log("처리 성공 시 변경되는 내용");
            	if(cnt != 1){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
                    $('.nickname_ok').css("display","inline-block"); 
                    $('.nickname_already').css("display", "none");
                } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                    $('.nickname_already').css("display","inline-block");
                    $('.nickname_ok').css("display", "none");
                }
            },
            error:function(){
                alert("에러입니다");
            }
        });
    };
    
    function pwCheck(){
    	var mpw = $("#mpw").val();
    	var mpw2 = $("#mpw2").val();
    	if(mpw != mpw2){
    		$("#pwCheckMessage").html("비밀번호가 일치하지 않습니다.");
    	}else{
    		$("#pwCheckMessage").html("");
    	}
    }
    
    $(function(){
    	$("#joinBtn").click(function(){
    		if($("#mid").val().length == 0){
    			alert("아이디를 입력하세요");
    			$("#mid").focus();
    			return false;
    		}
    		if($("#mpw").val().length == 0){
    			alert("비밀번호를 입력하세요");
    			$("#mpw").focus();
    			return false;
    		}
    		if($("#mpw2").val().length == 0){
    			alert("비밀번호 확인을 입력하세요");
    			$("#mpw2").focus();
    			return false;
    		}
    		if($("#mname").val().length == 0){
    			alert("이름을 입력하세요");
    			$("#mname").focus();
    			return false;
    		}
    		if($("#nickname").val().length == 0){
    			alert("닉네임을 입력하세요");
    			$("#nickname").focus();
    			return false;
    		}
    	});
    });
</script>

</head>
<body  class="pt-5">
<%@include file="../common/header.jsp" %>

<div class="text-center container mt-5">
<main class="form-signin">
  
	<div class="container">
		<form action="${pageContext.request.contextPath}/joinmember" method="post">
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col" colspan="3">회원 가입 양식</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">아이디</th>
			      <td><input type="text" class="form-control" id="mid" name="mid"></td>
			      <td>
					<span class="id_ok">사용 가능한 아이디입니다.</span>
					<span class="id_already">이미 사용 중인 아이디입니다. 다시 작성해주세요.</span>
			      <button type="button" class="btn btn-secondary" onclick="checkId();">아이디 중복체크</button>
			      </td>
			    </tr>
			    <tr>
			      <th scope="row">비밀번호</th>
			      <td colspan="2"><input type="password" class="form-control" id="mpw" name="mpw" onkeyup="pwCheck();"></td>
			    </tr>
			    <tr>
			      <th scope="row">비밀번호 확인</th>
			      <td colspan="2"><input type="password" class="form-control" id="mpw2" name="mpw2" onkeyup="pwCheck();"></td>
			    </tr>
			    <tr>
			      <th scope="row">이름</th>
			      <td colspan="2"><input type="text" class="form-control" id="mname" name="mname"></td>
			    </tr>
			    <tr>
			      <th scope="row">닉네임</th>
			      <td><input type="text" class="form-control" id="nickname" name="nickname"></td>
			      <td>
			      	<span class="nickname_ok">사용 가능한 닉네임입니다.</span>
					<span class="nickname_already">이미 사용 중인 닉네임입니다. 다시 작성해주세요.</span>
			      	<button type="button" class="btn btn-secondary" onclick="checkNickname();">닉네임 중복체크</button>
			      </td>
			    </tr>
			     <tr>
			      <td colspan="3" ><h5 style="color: tomato;" id="pwCheckMessage"></h5>
			      <input type="submit" class="btn btn-secondary" id="joinBtn" value="회원가입"></td>
			    </tr>
			  </tbody>
			</table>
		</form>
	</div>
</main>
</div>

<div class="b-example-divider"></div>

<%@include file="../common/footer.jsp" %>




</body>
</html>