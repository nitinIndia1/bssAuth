package com.bssAuth.service;

import com.bssAuth.beans.Document_;
import com.bssAuth.beans.Image_;
import com.bssAuth.model.Document;
import com.bssAuth.model.Image;

public interface DocumentService {

	
	Document saveDocument(Document document, Document_ document_);
	Document updateDocument(Document document, Document_ document_);
	void deleteDuplicateCustomerDocument(Document document);
	
	
	
}
