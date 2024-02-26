package package1;

import java.io.PrintWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagAdapter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTag extends TagSupport{

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.print("This Is Custom Tag");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
}
