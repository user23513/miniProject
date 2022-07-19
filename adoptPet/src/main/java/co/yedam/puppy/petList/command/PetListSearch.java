package co.yedam.puppy.petList.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.puppy.comm.Command;
import co.yedam.puppy.petList.service.PetListService;
import co.yedam.puppy.petList.service.PetListServiceImpl;
import co.yedam.puppy.vo.PetListVO;

public class PetListSearch implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 검색
		PetListService dao = new PetListServiceImpl();
		List<PetListVO> list = new ArrayList<PetListVO>();
		ObjectMapper mapper = new ObjectMapper(); //jackson 라이브러리
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		
		list = dao.petListSearchList(key, val);
		String josnList = null;
		try {
			josnList = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
				
		return "ajax:"+josnList;
	}

}
