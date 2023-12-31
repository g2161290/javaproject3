package co.jiye.prjdb.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jiye.prjdb.common.DataSource;
import co.jiye.prjdb.notice.map.ReplyMapper;
import co.jiye.prjdb.notice.service.EventVO;
import co.jiye.prjdb.notice.service.ReplyService;
import co.jiye.prjdb.notice.service.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper map = sqlSession.getMapper(ReplyMapper.class);
	
	@Override
	public boolean addReply(ReplyVO vo) {
		return map.insert(vo) == 1;
	}

	@Override
	public boolean editReply(ReplyVO vo) {
		return map.update(vo) == 1;
	}

	@Override
	public boolean delReply(int replyId) {
		return map.delete(replyId) == 1;
	}

	@Override
	public ReplyVO getReply(int replyId) {
		return map.select(replyId);
	}

	@Override
	public List<ReplyVO> listReply(int noticeId) {
		return map.list(noticeId);
	}

	@Override
	public List<EventVO> listEvent() {
		return map.listEvent();
	}

	@Override
	public boolean eventInsert(EventVO vo) {
		return map.eventInsert(vo)==1;
	}

}
