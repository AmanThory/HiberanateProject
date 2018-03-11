package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import model.ProductDAO;
import model.Supplier;

/**
 * Servlet implementation class ProductController
 */
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("t1"));
		String pname = request.getParameter("t2");
		int pcost = Integer.parseInt(request.getParameter("t3"));
		int p2id = Integer.parseInt(request.getParameter("p1"));
		String p2name = request.getParameter("p2");
		int p2cost = Integer.parseInt(request.getParameter("p3"));
		
		String sname = request.getParameter("t4");
		String s1name = request.getParameter("t5");
		
		if(pid != 0)
		{
			Product p = new Product();
			p.setPid(pid);
			p.setPname(pname);
			p.setPcost(pcost);
			
			Product p1 = new Product();
			p1.setPid(p2id);
			p1.setPname(p2name);
			p1.setPcost(p2cost);
			
			Supplier s = new Supplier();
			s.setSupplierName(sname);
			s.getProduct().add(p1);
			s.getProduct().add(p);
			
			p.getSupplier().add(s); 
			p1.getSupplier().add(s); 
			
			Supplier s1 = new Supplier();
			s1.setSupplierName(s1name);
            
			p.getSupplier().add(s1);
			p1.getSupplier().add(s1);
			
			ProductDAO pd = new ProductDAO();
			boolean b = pd.insertProduct(p,p1,s,s1);
			
			if(b){
		  	    RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
			    rd.forward(request, response);
			    
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("Product.jsp");
		    rd.forward(request, response);
		    
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
