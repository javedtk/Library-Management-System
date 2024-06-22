package com.Packages.dao;

import java.util.List;

import com.Packages.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Integer>{

	public List<Book> findByAuthorname(String authorname);
	
	public List<Book> findByTitle(String title);
	
	public List<Book> findByPublicationname(String publicationname);
	
	public Book findByBkid(int bkid);
	
	public List<Book> findByOrderByPriceAsc();
	
	public String findByBkidAndAuthorname(int bkid, String authorname);
	
	public List<Book> findByPriceBetween(String startPrice, String endPrice);
}
