package kr.ac.kopo.board.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.board.domain.Gongji;

//hql : hibernate ���� �����Ǵ� �������(sql�� ����)
//criteria : �ڹ� Ŭ���� �̿��� �پ��� �˻� ������ ����� �� �ֵ��� ���ִ� API

@Transactional
@Repository
public class GongjiDaoImpl implements GongjiDao {

	@Autowired
	private SessionFactory sessionFactory;
	//instance �ڵ� mapping?
	
	private Session getSession() {
//		return sessionFactory.openSession();	
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Long count() {
		String hql = "SELECT COUNT(*) FROM Gongji";
		Query query = getSession().createQuery(hql);
		Long totalCount = (Long) query.uniqueResult();
		return totalCount;
	}
	
	@Override
	public Gongji selectOne(long id) {
		String hql = "FROM Gongji g WHERE g.id = " + id;
		Query query = getSession().createQuery(hql);
		return (Gongji) query.uniqueResult();
//		return (Gongji) query.list().get(0);
//		return (Users) getSession().get(Users.class, id);
	}

	@Override
	public List<Gongji> selectAll() {
		String hql = "FROM Gongji ORDER BY rootid desc";
		Query query = getSession().createQuery(hql);
		return query.list();
//		return getSession().createCriteria(Users.class).list();
	}
	
	@Override
	public List<Gongji> selectAllByPagination(int page, int itemSizePerPage) {
		String hql = "FROM Gongji ORDER BY rootid desc, recnt asc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((page - 1) * itemSizePerPage);
		query.setMaxResults(itemSizePerPage);
		return query.list();
	}
	
	@Override
	public int createOne(Gongji gongji) {
		return (int) getSession().save(gongji);
//		session.flush();
//		session.close();
	}

	@Override
	public void updateOne(Gongji gongji) {
		getSession().saveOrUpdate(gongji);
	}

	@Override
	public void deleteOne(Gongji gongji) {
		getSession().delete(gongji);
	}
	
	@Override
	public int deleteAll() {
		String hql = "DELETE FROM Gongji";
		Query query = getSession().createQuery(hql);
		return query.executeUpdate();
	}

	@Override
	public int selectRecnt(int rootid, int relevel, int recnt) {
        String hql = "select ifnull((select min(recnt) from gongji where rootid = "+rootid+" and relevel <= "+relevel+" and recnt > "+recnt+"),\r\n"
                +"(select max(recnt) + 1 from gongji where rootid = "+rootid+"))\r\n"
                +"from dual";
        Query query = getSession().createSQLQuery(hql);
        int updaterecnt = Integer.parseInt(query.uniqueResult().toString());
        return updaterecnt;
	}
	
	@Override
    public int updateRecnt(int rootid, int recnt) {
        String hql = "UPDATE Gongji SET recnt = recnt+1 where rootid = " + rootid + " and recnt >=" + recnt;
        Query query = getSession().createQuery(hql);
        return query.executeUpdate();
    }
	
	@Override
    public void deleteGongji(int rootid, int strecnt, int endrecnt) {
        String hql = "DELETE FROM Gongji where rootid = "+ rootid +" and recnt >= "+ strecnt +" and recnt < "+ endrecnt;
        Query query = getSession().createQuery(hql);
        query.executeUpdate();
        hql = "UPDATE Gongji SET recnt = recnt-"+(endrecnt - strecnt)+" where rootid = "+ rootid +" and recnt >= "+ endrecnt;
        query = getSession().createQuery(hql);
        query.executeUpdate();
    }
	
//	@Override
//	public int selectRecnt(Gongji rootid, int relevel, int recnt) {
//		//select ifnull(a,b) from table : a�� ���� null�̸� b��, a�� ���� null�� �ƴϸ� a�� ���������ϴ� �Լ�
//		//from dual(=from dummy table) : ���� ���̺��� ���ϴ� �� ��ȸ
//        String hql = "select ifnull((select min(recnt) from gongji where rootid = "+rootid.getId()+" and relevel <= "+relevel+" and recnt > "+recnt+"),\r\n"
//                +"(select max(recnt) + 1 from gongji where rootid = "+rootid.getId()+"))\r\n"
//                +"from dual";
//        Query query = getSession().createSQLQuery(hql);
//        int updaterecnt = Integer.parseInt(query.uniqueResult().toString());
//        return updaterecnt;
//        
//        //�� ���� ����        
//        //String hql = "select ifnull((select min(recnt) from gongji where rootid = "+rootid.getId()+" and relevel <= "+relevel+" and recnt > "+recnt+"),\r\n"
//        //+"(select max(recnt) + 1 from gongji where rootid = "+rootid.getId()+"))\r\n"
//        //+"from dual";
//
//        //���� ���� ����
//        //String hql = "select ifnull((select max(recnt) + 1 from gongji where rootid = "+rootid.getId()+" and relevel >= "+relevel+" and recnt >= "+recnt+"),\r\n"
//        //+"(select max(recnt) + 1 from gongji where rootid = "+rootid.getId()+"))\r\n"
//        //+"from dual";
//	}
	

	
//	@Override
//    public void deleteGongji(Gongji rootid, int strecnt, int endrecnt) {
//        String hql = "DELETE FROM Gongji where rootid = "+ rootid.getId() +" and recnt >= "+ strecnt +" and recnt < "+ endrecnt;
//        Query query = getSession().createQuery(hql);
//        query.executeUpdate();
//        hql = "UPDATE Gongji SET recnt = recnt-"+(endrecnt - strecnt)+" where rootid = "+ rootid.getId() +" and recnt >= "+ endrecnt;
//        query = getSession().createQuery(hql);
//        query.executeUpdate();
//    }
	

}
