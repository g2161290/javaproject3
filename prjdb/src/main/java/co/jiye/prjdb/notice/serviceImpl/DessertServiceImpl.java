package co.jiye.prjdb.notice.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.jiye.prjdb.common.DataSource;
import co.jiye.prjdb.notice.map.DessertMapper;
import co.jiye.prjdb.notice.service.DessertService;
import co.jiye.prjdb.notice.service.DessertVO;

public class DessertServiceImpl implements DessertService {

	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private DessertMapper map = sqlSession.getMapper(DessertMapper.class);
	
	@Override
	public List<DessertVO> dessertSelectList() {
		return map.dessertSelectList();
	}

}
