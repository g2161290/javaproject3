package co.jiye.project.member.serviceImpl;

import org.apache.ibatis.session.SqlSession;

import co.jiye.project.common.DataSource;
import co.jiye.project.member.map.MemberMapper;
import co.jiye.project.member.service.MemberService;
import co.jiye.project.member.service.MemberVO;

public class MemberServiceImpl implements MemberService{
	private SqlSession sqlSession=DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

}
