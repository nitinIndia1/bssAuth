package com.bssAuth.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.DatatypeConverter;

//import jakarta.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bssAuth.beans.Document_;
import com.bssAuth.beans.Image_;
import com.bssAuth.model.Document;
import com.bssAuth.model.Image;
import com.bssAuth.repository.DocumentRepository;
import com.bssAuth.repository.ImageRepository;

@Service
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	private ImageRepository imgRepository;
	
	@Autowired
	private DocumentRepository docRepository;
	
	private static String UPLOADED_FOLDER = "/home/apache-tomcat-8.5.85/webapps/ROOT/";
	
	//private static String UPLOADED_FOLDER = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\ROOT\\";
	
	
	@Override
	public Document saveDocument(Document document, Document_ document_) {
		Document doc  = null;
		try {
			if(document==null)
			doc = new Document();
			else
				doc = document;
			if(document_.getImgType()==null) {
				return	null;
			}
			if(document_.getImgType().equals("bank")) {
				doc.setDocument1Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocumentUrl(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
				
			}
			else if (document_.getImgType().equals("electricity")){
				doc.setDocument2Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument2Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			
			else if(document_.getImgType().equals("permit")) {
				doc.setDocument3Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument3Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			//water,telecom,consent
			else if(document_.getImgType().equals("other")) {//other
				doc.setDocument4Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument4Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			
			else if(document_.getImgType().equalsIgnoreCase("UID")) {
				doc.setDocument5Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument5Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("water")) {
				doc.setDocument6Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument6Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("telecom")) {
				doc.setDocument7Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument7Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("consent")) {
				doc.setDocument8Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument8Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("incorporationLetter")) {
				doc.setDocument9Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument9Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("vat")) {
				doc.setDocument10Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument10Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("brn")) {
				doc.setDocument11Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument11Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("utility")) {
				doc.setDocument12Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument12Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("authorizationLetter")) {
				doc.setDocument13Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument13Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("emp_utility_org")) {
				doc.setDocument14Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument14Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("touristCert")) {
				doc.setDocument15Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument15Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("authorizationLetter_part2")) {
				doc.setDocument16Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument16Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("workPermit")) {
				doc.setDocument17Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument17Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			else if(document_.getImgType().equals("authorizationLetter_part3")) {
				doc.setDocument18Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument18Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			
			
			else if(document_.getImgType().equals("policeMemo")) {
				doc.setDocument19Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument19Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			
			else if(document_.getImgType().equals("applicationWithDamageSim")) {
				doc.setDocument20Type(document_.getBase64());
				
				String path =  saveImageInPath(document_);
				
				doc.setDocument20Url(path);
				
				
				Document document0 =  docRepository.saveAndFlush(doc);
				
				if(document0!=null) {
					return document0;
				}
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return null;
	}
	@Override
	public Document updateDocument(Document document, Document_ document_) {

//		try { 
//			if(document_.getImgType()==null) {
//				return null; 
//			}
//			if(document_.getImgType().equals("self")) {
//				document.setOriginalPhotoBase64(document_.getBase64());
//
//				String path = saveImageInPath(document_);
//
//				document.setOriginalPhotoUrl(path);
//
//				Image imageSaved = imgRepository.saveAndFlush(document); 
//				if(imageSaved!=null) {
//					return imageSaved; 
//				}
//
//			} else if(document_.getImgType().equals("verified")) {
//				document.setVerifiedPhotoBase64(document_.getBase64()); 
//				String path =saveImageInPath(document_); 
//				document.setVerifiedPhotoUrl(path); 
//				Image imageSaved =
//						imgRepository.saveAndFlush(document); 
//				if(imageSaved!=null) { return imageSaved;
//				} 
//			} 
//		}catch(Exception ex) { 
//			ex.printStackTrace(); 
//			return null; 
//		}
//
//		
		return null;
	}
	
	private String saveImageInPath(Document_ document_) {
        String path = null;
		
        if(document_.getBase64()==null || document_.getBase64().equalsIgnoreCase("null")) {
        	path="not able to save";
        	return path;
        }
        
        byte[] data = DatatypeConverter.parseBase64Binary(document_.getBase64());
        
        File file = new File(UPLOADED_FOLDER+document_.getToken()+File.separator);
        file.mkdir();
        
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file+File.separator+document_.getImgType()+".jpg"))) {
            outputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if(!file.exists()) {
        	path="not able to save";
        }
        else {
        	path = file.getAbsolutePath()+File.separator+document_.getImgType()+".jpg";
        	//path=path.replace("/home/apache-tomcat-8.5.85/webapps/ROOT/", "https://ekyc.chili.mu/");
        }
        System.out.println(path);
			return path;
	}
	
	@Override
	public void deleteDuplicateCustomerDocument(Document image) {
		docRepository.delete(image);
		
	}


}
