package co.yedam.puppy.admin.service;

import java.util.List;

import co.yedam.puppy.calendar.vo.CalendarVO;
import co.yedam.puppy.member.vo.MemberVO;
import co.yedam.puppy.petList.vo.PetListVO;

public interface AdminService {
	//경아
	//관리자마이페이지
	List<MemberVO> allMemberList(int startRow, int pageSize);
	List<PetListVO> allAdoptList(int startRow, int pageSize);
	List<CalendarVO> allVolunteerList(int startRow, int pageSize);
	//모든회원후원정보리스트 메소드있어ㅇㅑ됨
}