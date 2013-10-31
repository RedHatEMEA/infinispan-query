package org.jboss.infinispan.query;

import java.util.List;

import org.apache.lucene.search.Query;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.query.CacheQuery;
import org.infinispan.query.Search;
import org.infinispan.query.SearchManager;


public class Application {
	
	public void testQuery() {
	      System.out.println("Demonstrating basic Query usage of Infinispan.");
	      
	      Configuration infinispanConfiguration = new ConfigurationBuilder()
	      .indexing()
	         .enable()
	         .indexLocalOnly(true)
	      .build();
	      DefaultCacheManager cacheManager = new DefaultCacheManager(infinispanConfiguration);
	      
	      Cache<String, Product> cache = cacheManager.getCache();
	      String[] ean = {"ean1","ean2"};
	      cache.put("b1", new Product("hobbit","author","editor",ean));
	      SearchManager sm = Search.getSearchManager(cache);
	      
	      QueryBuilder qb = sm.buildQueryBuilderForClass(Product.class).get();
	      Query q = qb.keyword().onField("ean").matching("ean1").createQuery();
	      CacheQuery cq = sm.getQuery(q, Product.class);	      
	      	      
	      
	      List<Object> list = cq.list();
	      System.out.println(list);
	   }
	 
	   public static void main(String[] args) throws Exception {
	      Application a = new Application();
	      a.testQuery();
	      System.out.println("Sample complete.");
	   }

}
