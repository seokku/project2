package com.webjjang.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.util.PageObject;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class NoticeDAO {
	
	
	// 필요한 객체 선언
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 공지사항 리스트 
	public List<NoticeVO> list(PageObject pageObject) throws Exception {

		System.out.println("NoticeDAO.list().pageObject :" + pageObject);
		List<NoticeVO> list = null;
		
		try {
			// 1.2.
			con = DBInfo.getConnection();
			// 3.4.
			pstmt = con.prepareStatement(DBSQL.NOTICE_LIST);
			pstmt.setLong(1, pageObject.getStartRow());
			pstmt.setLong(2, pageObject.getEndRow());
			// 5.
			rs = pstmt.executeQuery();
			// 6.
			if(rs !=null) {
				while(rs.next()) {
					if(list == null) list = new ArrayList<NoticeVO>();
					NoticeVO vo = new NoticeVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setStartDate(rs.getString("startDate"));
					vo.setEndDate(rs.getString("endDate"));
					vo.setUpdateDate(rs.getString("updateDate"));
					list.add(vo);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("공지사항 리스트 DB 처리 중 오류");
		} finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	
	// 공지사항 전체 데이터 갯수 가져오기
		public long getTotalRow() throws Exception {
			System.out.println("NoticeDAO.getTotalRow()");
			long result = 0;
			
			try {
				// 1.2.
				con = DBInfo.getConnection();
				// 3.4.
				pstmt = con.prepareStatement(DBSQL.NOTICE_GET_TOTALROW);
				// 5.
				rs = pstmt.executeQuery();
				// 6.
				if(rs !=null && rs.next()) {
						result = rs.getLong(1);
					}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new Exception("공지사항 전체 데이터 가져오기 DB 처리 중 오류");
			} finally {
				DBInfo.close(con, pstmt, rs);
			}
			
			return result;
		} // end of getTotalRow
		
	// 공지 등록 처리 
		public int write(NoticeVO vo) throws Exception {
			int result = 0;
			
			try {
				// 1.2.
				con = DBInfo.getConnection();
				// 3.4.
				pstmt = con.prepareStatement(DBSQL.NOTICE_WRITE);
				pstmt.setString(1, vo.getTitle());
				pstmt.setString(2, vo.getContent());
				pstmt.setString(3, vo.getStartDate());
				pstmt.setString(4, vo.getEndDate());
				// 5.
				result = pstmt.executeUpdate();
				// 6.
				System.out.println("NoticeDAO.write() - 공지 등록 완료~!");
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new Exception ("공지 등록 DB 처리 중 오류");
			} finally {
				DBInfo.close(con, pstmt, rs);
			}
			
			return result;
		}
		
}
