package solrj;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class solrj {
public static void main(String[] args) throws Exception, IOException {
	String url="http://localhost:8080/solr/collection1";
	String baseurl="http://localhost:8080/solr";
	SolrServer solr=new HttpSolrServer(baseurl);
	SolrInputDocument doc=new SolrInputDocument();
	doc.setField("id",88);
	doc.setField("name","范冰冰");
	solr.add(doc,1000);
	
	
}
@Test
public void testDete() throws Exception, IOException{
String uri="http://localhost:8080/solr";
SolrServer solr=new HttpSolrServer(uri);
solr.deleteById("88");
solr.deleteByQuery("*:*");
solr.commit();
	
	
}
@Test
public void search() throws Exception{
	String url="http://localhost:8080/solr";
	SolrServer solr=new HttpSolrServer(url);
	SolrQuery params= new SolrQuery();
	params.set("q","*:*");
	QueryResponse response=solr.query(params);
	SolrDocumentList docs=response.getResults();
	long numFound=docs.getNumFound();
	
	for (SolrDocument so :docs) {
		System.out.println("id"+so.get("id"));
	}
	
}

}
