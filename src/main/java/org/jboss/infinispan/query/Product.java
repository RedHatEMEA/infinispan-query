package org.jboss.infinispan.query;

import java.util.Arrays;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Indexed;

@Indexed
public class Product {

	@Field String title;
    @Field String author;
    @Field String editor;
    
    @Field(bridge = @FieldBridge(impl = StringArrayBridge.class))
    //@FieldBridge(impl = StringArrayBridge.class)
    String[] ean;
    
    public Product(String title, String author, String editor,String[] ean) {
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.ean = ean;
    }    
    
    public String[] getEan() {
		return ean;
	}




	@Override
	public String toString() {
		return "Product [title=" + title + ", author=" + author + ", editor="
				+ editor + ", ean=" + Arrays.toString(ean) + "]";
	}
    
}
