<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ATM Interface</title>
</head>
<body>
<div>
    <form action="" method=post>
        <div>Please enter money : <input type="text" name="user_money" placeholder="Input your money"></div>
        <div> <button type="submit" name=save>SAVE</button> </div>
    </form>
    <c:if test="${checkinput == 'Input is Invalid'}">
        <div> ธนบัตร1000 บาท : <label id=b1000>${checkinput}</label> </div>
        <div> ธนบัตร500 บาท : <label id=b500>${checkinput}</label> </div>
        <div> ธนบัตร100 บาท : <label id=b100>${checkinput}</label> </div>
    </c:if>

    <c:if test="${checkinput == 'Input is Valid'}">
        <div> ธนบัตร1000 บาท : <label id=b1000>${atm.b1000}</label> </div>
        <div> ธนบัตร500 บาท : <label id=b500>${atm.b500}</label> </div>
        <div> ธนบัตร100 บาท : <label id=b100>${atm.b100}</label> </div>
    </c:if>

</div>

</body>
</html>
