package org.jboss.infinispan.query;

import org.apache.lucene.document.Document;
import org.hibernate.search.bridge.FieldBridge;
import org.hibernate.search.bridge.LuceneOptions;

public class StringArrayBridge implements FieldBridge {

	@Override
	public void set(String name, Object value, Document document,
			LuceneOptions luceneOptions) {
		String[] append = (String[]) value;
		for (String string : append) {
			luceneOptions.addFieldToDocument(name, string, document);
		}

	}
}
