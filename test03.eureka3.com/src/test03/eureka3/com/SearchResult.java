package test03.eureka3.com;

import java.sql.ResultSet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.*;

public class SearchResult extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	
	// ログ出力クラス
	public static Log log = LogFactory.getLog(SearchResult.class);
	
	// 検索キー
	private String strCode = "";
	
	// 検索キーのセット
	public void setCondition(String value) {
		this.strCode = value;
	}
	
	// タグ実行
	public int doStartTag() throws JspException {
		
		try {
			
			MySQLAccessor acc = new MySQLAccessor();
			
			acc.setDataSource("test");
			acc.setUserId("test");
			acc.setPassword("password");
			
			acc.createConnectionString();
			acc.createConnection();
			
			ResultSet rs = acc.executeSelectTest03(strCode);
			
			rs.next();
			
			pageContext.getOut().write(rs.getString("PREF_CODE"));
			pageContext.getOut().write(rs.getString("PREF_NAME"));
			
		} catch(Exception e) {
			
			log.error("Error Occured : ", e);
			
			throw new JspException(e);
			
		}
		
		return SKIP_BODY;
		
	}
	
}
