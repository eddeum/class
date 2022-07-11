package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dto.Member;

/**
 * Servlet implementation class getmember
 */
@WebServlet("/member/getmember")
public class getmember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getmember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		String mid = (String)request.getSession().getAttribute("login");
		Member member = MemberDao.getmemberDao().getmember(mid);
		// dto -> json 변환
		try {
			JSONObject jsonObject = new JSONObject(); // 1. json 객체 선언
			jsonObject.put("mnum", member.getMnum() );
			jsonObject.put("mid", member.getMid() );
			jsonObject.put("mname", member.getMname() );
			jsonObject.put("mphone", member.getMphone() );
			jsonObject.put("memail", member.getMemail() );
			jsonObject.put("maddress", member.getMaddress() );
			jsonObject.put("mpoint", member.getMpoint() );
			jsonObject.put("mdate", member.getMdate());
			// json -> js 통신 [ ]
			response.setCharacterEncoding("UTF-8");			// 한글 인코딩
			response.setContentType("application/json");	// ** json형식으로 통신타입
			response.getWriter().print(jsonObject);
			
			System.out.println(jsonObject);
		}catch(Exception e) {System.out.println("getmember서블릿오류 :"+e);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
