package model;


import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Product;
public class ProductDAO 
{
	private Transaction trans;
	private boolean b = true;
	private Session sess;
	public boolean insertProduct(Product p,Product p1,Supplier s,Supplier s1)
	{
		try
		{
        DbConfig db = new DbConfig();
		Session sess = db.getSess();
		trans = sess.beginTransaction();
		sess.save(p);
		sess.save(p1);
		sess.save(s);
		sess.save(s1);
		
		trans.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			trans.rollback();
			b=false;	
		}
		return b;
	}
	public boolean updateProduct(Product p)
	{
		try{
			DbConfig db = new DbConfig();
			Session sess = db.getSess();
			trans = sess.beginTransaction();
			sess.update(p);
			trans.commit();
		   }catch(Exception e){
			   
			   e.printStackTrace();
			   trans.rollback();
			   b = false;
		   }
		   return b;
	}
	public boolean deleteProduct(Product p)
	{
		try
		{
        DbConfig db = new DbConfig();
		Session sess = db.getSess();
		trans = sess.beginTransaction();
		Product p1 = (Product)sess.get(Product.class, p.getPid());
		sess.delete(p1);
		trans.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			trans.rollback();
			b=false;	
		}
		return b;
	}
	
	
	
}
