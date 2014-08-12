<%@page import="com.crmshopping.dto.*,java.util.*" %>
<HTML>
<HEAD>
<TITLE>Company Name</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=windows-1250">
<!-- ImageReady Preload Script (index.psd) -->
<SCRIPT TYPE="text/javascript">
<%!
ArrayList<Product> products;
%>
<%
if(request.getAttribute("products")!=null)
{
	products=(ArrayList<Product>)request.getAttribute("products");
}
%>
<!--

function newImage(arg) {
	if (document.images) {
		rslt = new Image();
		rslt.src = arg;
		return rslt;
	}
}

function changeImages() {
	if (document.images && (preloadFlag == true)) {
		for (var i=0; i<changeImages.arguments.length; i+=2) {
			document[changeImages.arguments[i]].src = changeImages.arguments[i+1];
		}
	}
}

var preloadFlag = false;
function preloadImages() {
	if (document.images) {
		about_us_over = newImage("images/about-us-over.gif");
		services_over = newImage("images/services-over.gif");
		catalog_over = newImage("images/catalog-over.gif");
		partners_over = newImage("images/partners-over.gif");
		contact_over = newImage("images/contact-over.gif");
		preloadFlag = true;
	}
}

// -->
</SCRIPT>
<!-- End Preload Script -->
<style type="text/css">
<!--
.style3 {
	color: #996600;
	font-size: 14px;
	font-weight: bold;
}
.style4 {
	color: #996600;
	font-size: 14px;
}
-->
</style>
</HEAD>

<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 ONLOAD="preloadImages();"><center>

<!-- ImageReady Slices (index.psd) -->
<TABLE WIDTH=775 BORDER=0 CELLPADDING=0 CELLSPACING=0 class="frame">
	<TR>
	  <TD COLSPAN=7>		  <img src="./images/title.gif" width=283 height=71 alt=""></TD>
		<TD COLSPAN=16><form name="form1" method="post" action="">
		  <input name="imageField" type="image" src="./images/top.gif" width="519" height="82" border="0">
	    </form></TD>
		<TD width="1">
			<IMG SRC="./images/spacer.gif" WIDTH=1 HEIGHT=26 ALT=""></TD>
	</TR>
	<TR>
		<TD height="90" COLSPAN=23><img src="./images/onsale.gif" width="802" height="90"></TD>
		<TD>
			<IMG SRC="./images/spacer.gif" WIDTH=1 HEIGHT=69 ALT=""></TD>
	</TR>
	<TR align="left" valign="top">
		<TD colspan="23" ROWSPAN=8> 
		
		<table width="804" id="productsTable">
			<%
				for(Product product:products)
				{%>
				<tr>
					<td width="185"><%=product.getName() %></td>
					<td width="311"><b>DESCRIPTION</b>&nbsp;</td>
					<td width="290"><B>COST</B>&nbsp;</td>
					<td width="290"><B>TO KNOW MORE DETAILS</B>&nbsp;</td>
				</tr>
				<tr>
					<td width="185"><img src='<%="images/"+product.getProductId()+".jpg"%>'/></td>
					<td width="311"><I><%=product.getDescription() %></I></td>
					<td width="290"><%=product.getCost() %></td>
					<td width="290" ><a href="product.do?action=call&productId=<%=product.getProductId()%>">Click to Talk</a></td>
				</tr>
				<%}
			%>
			
		</table></TD>
		
</TABLE>
<!-- End ImageReady Slices -->
</center></BODY>

</HTML>