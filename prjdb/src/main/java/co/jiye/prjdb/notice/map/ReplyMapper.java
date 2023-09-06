package co.jiye.prjdb.notice.map;

import java.util.List;

import co.jiye.prjdb.notice.service.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public int update(ReplyVO vo);
	public int delete(int replyId);
	public ReplyVO select(int replyId);
	public List<ReplyVO> list(int noticeID);
}
