package co.jiye.prjdb.notice.service;

import java.util.List;

public interface ReplyService {
	public boolean addReply(ReplyVO vo);
	public boolean editReply(ReplyVO vo);
	public boolean delReply(int replyId);
	public ReplyVO getReply(int replyId);
	public List<ReplyVO> listReply(int noticeId);
	public List<EventVO> listEvent();
	public boolean eventInsert(EventVO vo);
}
