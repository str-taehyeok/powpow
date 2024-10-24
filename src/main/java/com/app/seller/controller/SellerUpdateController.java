package com.app.seller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.dao.ProductDAO;
import com.app.vo.ProductVO;
import com.oreilly.servlet.MultipartRequest;

public class SellerUpdateController implements Action {

   @Override
   public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      Result result = new Result();
      ProductDAO productDAO = new ProductDAO();
      String directory =req.getServletContext().getRealPath("/assets/images/product");
      
      System.out.println(req.getParameter("id"));
      ProductVO product = productDAO.select(Long.parseLong(req.getParameter("id"))).orElseThrow(()->{
         throw new RuntimeException();
      });
      
      req.setAttribute("product", product);
	      
      result.setPath("update.jsp");
      return result;
      
   }

}
