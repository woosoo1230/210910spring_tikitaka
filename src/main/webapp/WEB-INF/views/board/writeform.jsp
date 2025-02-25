<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="pt-5">
<%@include file="../common/header.jsp" %>

<div class="container pt-5">
<main class="container">
  <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
      <h1 class="display-4 fst-italic">Tiki Taka</h1>
      <p class="lead my-3">사람들과 대화를 나누며 즐거움을 느껴보세요!</p>
      <!-- <p class="lead mb-0"><a href="#" class="text-white fw-bold">Continue reading...</a></p> -->
    </div>
  </div>


  <div class="row g-5">
    <div class="col-md-12">
      <h3 class="pb-4 mb-4 fst-italic border-bottom">
        글 작성하기
      </h3>

		<form action="insert" method="post" enctype="multipart/form-data">
		  <fieldset>
		    <div class="form-group">
		      <label for="exampleInputEmail1" class="form-label mt-4">제목</label>
		      <input type="text" class="form-control" id="exampleInputEmail1"  name="subject">
		    </div>
		    <div class="form-group">
		      <label for="exampleTextarea" class="form-label mt-4">내용</label>
		      <textarea class="form-control" id="exampleTextarea" rows="3" name="content"></textarea>
		    </div>
		    <div class="form-group">
		      <label for="formFile" class="form-label mt-4">사진 업로드하기</label>
		      <input class="form-control" type="file" id="formFile" name="filename" accept=".jpg, .png, .jpeg">
		    </div>
		    <input type="submit" class="btn btn-primary" value="작성">
		  </fieldset>
		</form>

      	

    </div>

  </div>

</main>
</div>
<%@include file="../common/footer.jsp" %>
</body>
</html>