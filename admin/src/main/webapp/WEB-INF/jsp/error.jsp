<%@ page language="java" contentType="application/json; charset=UTF-8" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%
    Object obj = request.getAttribute("error");
    String res = com.alibaba.fastjson.JSON.toJSONString(obj);
    out.print(res);
%>