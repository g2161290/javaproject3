package co.jiye.prjdb.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jiye.prjdb.notice.map.ReplyMapper;
import co.jiye.prjdb.notice.service.ReplyVO;

public class MainExe {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);
		
		ReplyVO rvo= new ReplyVO();
//		rvo.setNoticeId(1);
//		rvo.setReply("댓글테스팅");
		rvo.setReplyId(1);
		System.out.println(map.select(rvo.getReplyId()));
		
		List<ReplyVO> list =map.list(1);
		for(ReplyVO vo: list) {
			System.out.println(vo.toString());
		}
	}
}
