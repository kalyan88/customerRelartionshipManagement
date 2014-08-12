<%@ page import="java.util.*, com.crmshopping.dto.*"%>
<HTML>
<HEAD>
<TITLE>WELCOME</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=windows-1250">
<!-- ImageReady Preload Script (index.psd) -->
<SCRIPT TYPE="text/javascript">
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

function getSubCategories(){
	document.getElementById("actionMethod").value = "getCategories";
	document.form1.action = "category.do";
	document.form1.submit();
}

function getProducts(){
	//document.getElementById("actionMethod").value = "getProductsByCategoryId";
	var element=document.getElementById("subCategory").selectedIndex;
	var text=document.getElementById("subCategory").options[element].value;
	alert(text);
	document.form1.action = "product.do?action=getProductsByCategoryId&subCategory="+text;
	document.form1.submit();
}

// -->
</SCRIPT>
<!-- End Preload Script -->
</HEAD>
<link href="css/styles.css" rel="stylesheet" type="text/css">
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 ONLOAD="preloadImages();"><center>

<!-- ImageReady Slices (index.psd) -->
<TABLE WIDTH=775 BORDER=0 CELLPADDING=0 CELLSPACING=0 class="frame">
	<TR>
		<TD COLSPAN=7 ROWSPAN=2>
			<IMG SRC="images/title.gif" WIDTH=268 HEIGHT=78 ALT=""></TD>
		<TD COLSPAN=4>
			<A HREF="#"
				ONMOUSEOVER="window.status='about us'; changeImages('about_us', 'images/about-us-over.gif'); return true;"
				ONMOUSEOUT="window.status=''; changeImages('about_us', 'images/about-us.gif'); return true;">
				<IMG NAME="about_us" SRC="images/about-us.gif" WIDTH=98 HEIGHT=52 BORDER=0 ALT="about us"></A></TD>
		<TD COLSPAN=2>
			<A HREF="#"
				ONMOUSEOVER="window.status='services'; changeImages('services', 'images/services-over.gif'); return true;"
				ONMOUSEOUT="window.status=''; changeImages('services', 'images/services.gif'); return true;">
				<IMG NAME="services" SRC="images/services.gif" WIDTH=107 HEIGHT=52 BORDER=0 ALT="services"></A></TD>
		<TD COLSPAN=4>
			<A HREF="#"
				ONMOUSEOVER="window.status='catalog'; changeImages('catalog', 'images/catalog-over.gif'); return true;"
				ONMOUSEOUT="window.status=''; changeImages('catalog', 'images/catalog.gif'); return true;">
				<IMG NAME="catalog" SRC="images/catalog.gif" WIDTH=101 HEIGHT=52 BORDER=0 ALT="catalog"></A></TD>
		<TD COLSPAN=3>
			<A HREF="#"
				ONMOUSEOVER="window.status='partners'; changeImages('partners', 'images/partners-over.gif'); return true;"
				ONMOUSEOUT="window.status=''; changeImages('partners', 'images/partners.gif'); return true;">
				<IMG NAME="partners" SRC="images/partners.gif" WIDTH=102 HEIGHT=52 BORDER=0 ALT="partners"></A></TD>
		<TD COLSPAN=2>
			<A HREF="#"
				ONMOUSEOVER="window.status='contact'; changeImages('contact', 'images/contact-over.gif'); return true;"
				ONMOUSEOUT="window.status=''; changeImages('contact', 'images/contact.gif'); return true;">
				<IMG NAME="contact" SRC="images/contact.gif" WIDTH=99 HEIGHT=52 BORDER=0 ALT="contact"></A></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=52 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=15>
			<IMG SRC="images/top.gif" WIDTH=507 HEIGHT=26 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=26 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=4>
			<IMG SRC="images/se1.gif" WIDTH=216 HEIGHT=54 ALT=""></TD>
		<TD COLSPAN=6>
			<IMG SRC="images/se2.gif" WIDTH=111 HEIGHT=54 ALT=""></TD>
		<TD COLSPAN=12 ROWSPAN=4><table width="300" height="15" border="0">
          <tr>
            <td width="120">
			<form name="form1" method="post" action="category.do">
			<input type="hidden" name="actionMethod" id="actionmethod" />	 
             <select id="superCategoryId" name="superCategoryId" size="1" class="text7" onChange="getSubCategories()">
				<%
					ArrayList<Category> categories = (ArrayList<Category>)session.getAttribute("categories");
					String selectedCategory = (String)session.getAttribute("selectedCategory");					
					
					if(categories != null){
						for(Category category: categories){
							//System.out.println(category.getCategoryName());
							String presentCategory = category.getCategoryId();
							System.out.println(selectedCategory+"        "+presentCategory);
							if(selectedCategory != null){
								if(selectedCategory.equals(presentCategory)){
								%> 
	        			        	<option value="<%=category.getCategoryId()%>" selected><%=category.getCategoryName()%></option>		
								<%}else{%>
									<option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>		
								<%}
							}else{%>
								<option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>		
						  <%}
					}
				}
				%>
				                <option >SELECT CATEGORY</option>
             </select>
             </form>
            </td>
            <td width="169">
              <select name="select" size="1" class="text7" id="subCategory" name="subCategory">
                <option selected>SELECT SUB CATEGORY</option>
				<%
					ArrayList<Category> subCategories = (ArrayList<Category>)session.getAttribute("subCategories");
					
					if(subCategories != null){
						for(Category category: subCategories){
							System.out.println(category.getCategoryName());
				%> 
                <option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>		
				<%}}%>
              </select>
            </td>
            <td width="47">
              <input name="Submit" type="submit" class="text7" value="GO" onclick="getProducts()">
            </td>
          </tr>
        </table></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=54 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=2 ROWSPAN=2>
			<IMG SRC="images/se3.gif" WIDTH=48 HEIGHT=27 ALT=""></TD>
	  <TD COLSPAN=2 ROWSPAN=2 align="left" valign="middle" background="images/bse.gif">			</TD>
		<TD COLSPAN=2 ROWSPAN=2>
			<A HREF="#">
				<IMG SRC="images/go.gif" WIDTH=38 HEIGHT=27 BORDER=0 ALT="go"></A></TD>
		<TD COLSPAN=4 ROWSPAN=2>
			<IMG SRC="images/se4.gif" WIDTH=73 HEIGHT=27 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=4 ALT=""></TD>
	</TR>
	<TR>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=23 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=10>
			<IMG SRC="images/se5.gif" WIDTH=327 HEIGHT=40 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=40 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=22>
			<IMG SRC="images/onsale.gif" WIDTH=775 HEIGHT=69 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=69 ALT=""></TD>
	</TR>
	<TR>
		<TD ROWSPAN=9>
			<IMG SRC="images/rev5.gif" WIDTH=44 HEIGHT=357 ALT=""></TD>
		<TD COLSPAN=8>
			<IMG SRC="images/rev1.gif" WIDTH=278 HEIGHT=39 ALT=""></TD>
		<TD COLSPAN=13>
			<IMG SRC="images/new1.gif" WIDTH=453 HEIGHT=39 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=39 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=2 ROWSPAN=6>
			<IMG SRC="images/rev2.gif" WIDTH=69 HEIGHT=180 ALT=""></TD>
		<TD COLSPAN=6>
			<IMG SRC="images/rev3.gif" WIDTH=209 HEIGHT=26 ALT=""></TD>
		<TD ROWSPAN=6>
			<IMG SRC="images/new2.gif" WIDTH=31 HEIGHT=180 ALT=""></TD>
		<TD COLSPAN=5 ROWSPAN=2>
			<IMG SRC="images/new4.gif" WIDTH=196 HEIGHT=87 ALT=""></TD>
		<TD COLSPAN=3 ROWSPAN=6>
			<IMG SRC="images/new3.gif" WIDTH=35 HEIGHT=180 ALT=""></TD>
		<TD COLSPAN=4 ROWSPAN=2>
			<IMG SRC="images/new5.gif" WIDTH=191 HEIGHT=87 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=26 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=6 ROWSPAN=2 align="left" valign="top">			Erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.<br>
	    <br>
	    <a href="#" class="or">read more </a></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=61 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=5 ROWSPAN=3 align="left" valign="top">			<span class="text1">Lorem ipsum dolor sit amet, consetetur<br> 
	    sadi pscing sed diam</span><br>
	    Erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea <br>
	    rebum. Lorem ipsum dolor sit amet, consetetur sadi pscing elitr, sed diam </TD>
		<TD COLSPAN=4 ROWSPAN=3 align="left" valign="top">			<span class="text1">Lorem ipsum dolor sit amet, consetetur sadi pscing sed diam</span><br>
	    Erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea<br> 
	    rebum. Lorem ipsum dolor sit amet, consetetur sadi pscing elitr, sed diam </TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=7 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=6>
			<IMG SRC="images/rev4.gif" WIDTH=209 HEIGHT=21 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=21 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=6 ROWSPAN=2 align="left" valign="top">			Erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.<br>
          <br>
          <a href="#" class="or">read more </a></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=47 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=2 align="left" valign="top"> <a href="#" class="or">read	more	</a>	</TD>
		<TD COLSPAN=3 align="left" valign="top">			<a href="#" class="or">add to cart</a></TD>
		<TD align="left" valign="top">			<a href="#" class="or">read	more</a></TD>
		<TD COLSPAN=3 align="left" valign="top">			<a href="#" class="or">add to cart</a></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=18 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=4>
			<IMG SRC="images/ns1.gif" WIDTH=199 HEIGHT=48 ALT=""></TD>
		<TD COLSPAN=6>
			<IMG SRC="images/part1.gif" WIDTH=123 HEIGHT=48 ALT=""></TD>
		<TD COLSPAN=3 ROWSPAN=2>
			<IMG SRC="images/part3.gif" WIDTH=145 HEIGHT=138 ALT=""></TD>
		<TD COLSPAN=8 ROWSPAN=2>
			<IMG SRC="images/call.gif" WIDTH=264 HEIGHT=138 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=48 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=4 align="left" valign="top">			<span class="text2">18/04/05</span><br>
		  Erat, sed diam voluptua. At vero eos et accusam et justo duo <a href="#" class="l">read more<br>
		  </a><br>
        <b>Need website hosting? We recommend <a href="http://www.lunarpages.com/?id=webdotcom&campaign=mtt" class="l" target="_blank">LunarPages</a></b></TD>
		<TD COLSPAN=3>
			<IMG SRC="images/part2.gif" WIDTH=28 HEIGHT=90 ALT=""></TD>
		<TD COLSPAN=3 align="left" valign="top">			Erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Lorem <br>
	      <a href="#" class="or">read more</a></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=90 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=22>
			<IMG SRC="images/down.gif" WIDTH=775 HEIGHT=22 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=1 HEIGHT=22 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=23 align="center" valign="middle" background="images/bcopy.gif" class="text3" height="52">				  <a href="#">Home</a> | <a href="#">About Us</a> | <a href="#">Products</a> | <a href="#">Partners</a> | <a href="#">Catalog</a> | <a href="#">Promotions</a> | <a href="#">News</a> | <a href="#">Contact Us</a>&nbsp;</TD>
	</TR>
	<TR>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=44 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=4 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=65 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=103 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=27 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=11 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=14 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=3 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=51 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=5 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=13 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=48 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=59 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=38 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=38 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=11 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=14 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=10 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=62 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=30 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=16 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="images/spacer.gif" WIDTH=83 HEIGHT=1 ALT=""></TD>
		<TD></TD>
	</TR>
</TABLE>
<!-- End ImageReady Slices -->
</center></BODY>

</HTML>