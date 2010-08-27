<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>


<html>
<head>
<title>Hello Archetype</title>
</head>
<body>
<f:view>
<h:form>
		<h:outputText value="#{helloArchetype.returnMessage}" />
</h:form>
</f:view>
</body>
</html>
