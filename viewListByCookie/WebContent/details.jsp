<%-- @author LZD	@time 2017/12/01 - 2017/12/01 --%>
<%--
	显示商品详情页，右侧显示最近浏览的五条商品信息
 --%>
<%@page import="java.util.ArrayList"%>
<%@ page import="DAO.itemsDao"%>
<%@ page import="entity.items"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
div {
	float: left;
	margin-left: 30px;
	margin-right: 30px;
	margin-top: 5px;
	margin-bottom: 5px;
}

div dd {
	margin: 0px;
	font-size: 10pt;
}

div dd.dd_name {
	color: blue;
}

div dd.dd_city {
	color: #000;
}
</style>
</head>
<body>
	<h1>商品详情</h1>
	<br>
	<br>
	<center>
		<table width="750" height="60" cellpadding="0" cellspacing="0"
			border="0">
			<tr>
				<!-- 显示商品详情 -->
				<%
					itemsDao itemsDao = new itemsDao();
					items item = new items();
					item = itemsDao.getItemById(Integer.parseInt(request.getParameter("id")));
					if (item != null) {
				%>
				<td width="70%" valign="top">
					<table>
						<tr>
							<td rowspan="4"><img src="images/<%=item.getPicture()%>"
								width="200" height="160" /></td>
						</tr>
						<tr>
							<td><B><%=item.getName()%></B></td>
						</tr>
						<tr>
							<td>产地：<%=item.getCity()%></td>
						</tr>
						<tr>
							<td>价格：<%=item.getPrice()%>￥
							</td>
						</tr>
					</table>
				</td>
				<%
					}
				%>

				<!-- 显示浏览过的商品 -->
				<!-- 因为当前页面既是详情页又显示浏览记录，
				在进入该页面时就应该先将当前页面作为浏览过的保存起来 -->
				<%
				String viewList = "";
				Cookie[] cookies = request.getCookies();
				//如果已有浏览记录，获取已有的浏览记录
				if((cookies!=null) && (cookies.length>0)) {
					for(Cookie c : cookies) {
						if(c.getName().equals("viewListCookie")) {
							viewList = c.getValue();
						}
					}
				}
				//添加当前页面作为最新浏览
				viewList += request.getParameter("id") + "#";
				
				//记录超过1000条时将记录清零
				String[] viewItems = viewList.split("#");
				if((viewItems != null) && (viewItems.length>0)) {
					if(viewItems.length >= 1000) {
						viewList = "";
					}
				}
				//重新加入Cookie
				System.out.println("添加的Cookie是:" + viewList);
				Cookie cookie = new Cookie("viewListCookie",viewList);
				response.addCookie(cookie);
				System.out.println("已成功添加Cookie");
				%>

				<td width="30%" bgcolor="#EEE" align="center"><br> <b>您浏览过的商品</b>
					<br>
					<!-- 遍历浏览过的商品 -->
					<%
					ArrayList<items> viewItemList = itemsDao.getViewList(viewList);
					if(viewItemList!=null && viewItemList.size()>0) {
						System.out.println("this is detials.jsp   viewItemList.size:" + viewItemList.size());
						for(items i : viewItemList) {
					%>
					<div>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=i.getId()%>"><img
									src="images/<%=i.getPicture()%>" width="120" height="90"
									border="1" /></a>
							</dt>
							<dd class="dd_name"><%=i.getName()%></dd>
							<dd class="dd_city">
								产地:<%=i.getCity()%>&nbsp;&nbsp;价格:<%=i.getPrice()%>
								￥
							</dd>
						</dl>
					</div></td>
				<%
					}
				}
				%>
			</tr>
		</table>
	</center>
</body>
</html>