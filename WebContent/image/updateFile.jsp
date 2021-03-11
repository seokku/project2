<%@page import="com.webjjang.util.filter.AuthorityFilter"%>
<%@page import="com.webjjang.main.controller.Beans"%>
<%@page import="com.webjjang.main.controller.ExeService"%>
<%@page import="com.webjjang.image.vo.ImageVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/error/error_page.jsp"%>
<%
// 올라갈 파일의 서버의 상대 위치
String path = "/upload/image/";
String realPath = request.getServletContext().getRealPath(path);
int fileSize = 10 * 1024 * 1024;

// 파일 올리는 라이브러리 MultipartRequest 객체 생성 -> 자동으로 파일이 올라간다.
MultipartRequest multi = new MultipartRequest(request, realPath, fileSize,
		"utf-8",  new DefaultFileRenamePolicy());

String strNo = multi.getParameter("no");
String deleteFile = multi.getParameter("deleteFile");
String fileName = multi.getFilesystemName("imageFile");

// 파일 정보를 수정 - 번호, 파일명
ImageVO vo = new ImageVO();
vo.setNo(Long.parseLong(strNo));
vo.setFileName(path + fileName);

// DB에 파일 정보 수정
int result = (int) ExeService.execute(Beans.get(AuthorityFilter.url), vo);

// 자동으로 보기로 이동시킨다.
response.sendRedirect("view.jsp?no=" + strNo);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
realPath : <%= realPath %><br/>
strNo : <%= strNo %><br/>
deleteFile : <%= deleteFile %><br/>
fileName : <%= fileName %><br/>
</body>
</html>