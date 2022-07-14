package co.yedam.puppy.board.service;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.Border;

import co.yedam.puppy.comm.DataSource;
import co.yedam.puppy.vo.BoardVO;
import oracle.ons.Closable;

public class BoardServiceImpl implements BoardService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<BoardVO> volReviewSelectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO volReviewSelectOne(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int volReviewUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int volReviewDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int volReviewInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> volReviewAddSelectList(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> boardSelectList(int startRow, int pageSize) {
		// 공지 전체목록
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql = "SELECT * FROM BOARD where board_id=10 ORDER BY BOARD_NO DESC";

		conn = dao.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setBoardId(rs.getInt("board_Id"));
				vo.setBoardTitle(rs.getString("board_title"));
				vo.setBoardWriter(rs.getString("board_writer"));
				vo.setBoardContent(rs.getString("board_content"));
				vo.setBoardDate(rs.getDate("board_date"));
				vo.setBoardHit(rs.getInt("board_hit"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// 글 상세보기
		String sql = "SELECT * FROM BOARD WHERE NOTICE_NO = ?";
		
		conn = dao.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardNo());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setBoardNo(rs.getInt("board_no"));
				vo.setBoardId(rs.getInt("board_Id"));
				vo.setBoardTitle(rs.getString("board_title"));
				vo.setBoardWriter(rs.getString("board_writer"));
				vo.setBoardContent(rs.getString("board_content"));
				vo.setBoardDate(rs.getDate("board_date"));
				vo.setBoardHit(rs.getInt("board_hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int noticeInsert(BoardVO vo) {
		// 공지 글쓰기
		int n = 0;
		String sql = "INSERT all INTO Board VALUES(1,10,'안녕하세요','ff','안녕하세요',SYSDATE,0)\r\n"
				+ "            into files VALUES(1,10,'파일','앙ㅁ','jpg')\r\n"
				+ "select * from dual";
		
		conn = dao.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardNo());
			psmt.setInt(2, vo.getBoardId());
			psmt.setString(3, vo.getBoardTitle());
			psmt.setString(4, vo.getBoardTitle());
			psmt.setString(5, vo.getBoardTitle());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int noticeUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> noticeSerarchList(String key, String val) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> adoptReviewSelectList(int startRow, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO adoptReviewSelect(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int adoptReviewInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adoptReviewUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int adoptReviewDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> adoptReviewSearchList(String key, String val) {
		// TODO Auto-generated method stub
		return null;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}