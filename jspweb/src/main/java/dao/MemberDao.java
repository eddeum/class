package dao;

import dto.Member;

public class MemberDao extends Dao {
	// 자식클래스로 객체 생성시 (부모 클래스의 생성자 호출)
	public MemberDao() {
		super(); // 부모클래스 생성자 호출
	}
	
	public static MemberDao memberDao = new MemberDao();	// dao 호출시 반복되는 new연산자 제거
	public static MemberDao getmemberDao() {return memberDao;}
	
	// 아이디 중복체크
	public boolean idcheck(String mid) {
		String sql = "select * from member where mid= '"+mid+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			} // if end
		}catch(Exception e) {System.out.println("아이디중복체크오류"+e);}
		return false;
	} // 아이디체크 end
	
	// 이메일 중복체크 메소드 
	public boolean emailcheck( String email ) {
	String sql = "select * from member where memail = '"+email+"'";
	try {  
		ps = con.prepareStatement(sql); 
		rs= ps.executeQuery(); 
		if( rs.next() ) return true;
		}catch (Exception e) {System.out.println("이메일중복체크오류"+e);} 
		return false;
	} // 이메일중복체크 end

	// 회원가입 메소드
	public boolean signup(Member member) {
		String sql = "insert into member(mid,mpassword,mname,mphone,memail,maddress) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpassword());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMphone());
			ps.setString(5, member.getMemail());
			ps.setString(6, member.getMaddress());
			ps.executeUpdate();
			return true;
		}catch (Exception e) {System.out.println("회원가입오류"+e);}
		return false;
	} // 회원가입 end
	
	// 로그인 메소드
	public int login(String mid, String mpassword) {
//		String sql = "select * from member where mid = '"+mid+"' and mpassword = '"
		String sql = "select * from member where mid=? and mpassword=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpassword);
			rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			}
			return 2;
		}catch (Exception e) {System.out.println("로그인오류"+e);}
		return 3;
	} // 로그인 end
	
}
