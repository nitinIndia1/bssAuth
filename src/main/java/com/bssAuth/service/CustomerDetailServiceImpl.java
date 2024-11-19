package com.bssAuth.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bssAuth.beans.FetchResponse;
import com.bssAuth.beans.IdRequest;
import com.bssAuth.beans.Image_;
import com.bssAuth.beans.OcrId;
import com.bssAuth.model.CustomerDetail;
import com.bssAuth.model.CustomerDetailsIdType;
import com.bssAuth.model.Image;
import com.bssAuth.model.CustomerDetailsResidentType;
import com.bssAuth.repository.CustomerDetailRepository;
import com.bssAuth.repository.ImageRepository;
import com.bssAuth.util.ApplicationResponse;
import com.bssAuth.util.CommonUtilityFunctions;
import com.bssAuth.util.CoreResponseHandler;
import com.bssAuth.util.ResponseStatusEnum;
import com.bssAuth.util.SuccessResponseBeanRefined;

@Service
public class CustomerDetailServiceImpl implements CustomerDetailService {

	@Autowired
	private CustomerDetailRepository custRepository;
	
//	@Autowired
//	private CustomerDetailService custService;
//	
	@Autowired
	private ImageService imgService;
	
	@Autowired
	private ImageRepository imgRepository;
	
	@Autowired
	private CommonUtilityFunctions utility;
	
	
	@Override
	public ResponseEntity<CoreResponseHandler> saveCustomer(OcrId ocrId,IdRequest idRequest,String self) {
		// TODO Auto-generated method stub
		long l_diff = 0;
		long l_time_start = System.currentTimeMillis();
		String token =null;
		try {
		CustomerDetail customerDetail = new CustomerDetail();
		//dd-MM-yyyy
		//SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		if(idRequest.getIdType().equalsIgnoreCase(CustomerDetailsIdType.METER_NUM.name())
				&& idRequest.getResidentType().equalsIgnoreCase(CustomerDetailsResidentType.TOURIST.name())
				
				){
			// NO ! tourist can not have a meter number

			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.BAD_REQUEST, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"Tourist can not have a meter number",l_diff+" ms") ,HttpStatus.BAD_REQUEST);												
		
		}
		
		customerDetail.setIdType(idRequest.getIdType());
		customerDetail.setResidentType(idRequest.getResidentType());
		customerDetail.setUserType(idRequest.getUserType());
		

		if(self!=null) {
			customerDetail.setSelf(self);
		}
		if(ocrId.getDob()==null) {
			customerDetail.setDob(null);
		}
		else {
			Date dob = null;
			try {
		dob = sdf.parse(ocrId.getDob());
		customerDetail.setDob(dob);
			}catch(Exception ex) {
				customerDetail.setDob(null);
			}
		}
		token = utility.getRandomNumber(9);
		
		Image_ image_ = new Image_();
		image_.setBase64(idRequest.getId64());
		image_.setImgType("kyc");
		image_.setToken(token);
		Image image  = imgService.saveImage(image_);
		customerDetail.setNationality(ocrId.getCountryCode()==null||ocrId.getCountryCode().equals("")?"":ocrId.getCountryCode());
		customerDetail.setGender(ocrId.getGender()==null||ocrId.getGender().equals("")?"":ocrId.getGender());
		customerDetail.setImage(image);
		
		customerDetail.setToken(token);
		
		Date dt = new Date();
		
		customerDetail.setCreateDate(dt);
		customerDetail.setUpdateDate(dt);
		customerDetail.setKycStatus("id proof submitted");
		SimpleDateFormat sdf2 = new  SimpleDateFormat("yyyy-MM-dd");
		
		CustomerDetail customerDetail_ = updateCustomer(customerDetail,sdf2.format(dt));
		if(customerDetail_!=null) {
			long l_end_time = System.currentTimeMillis();
			l_diff = l_end_time-l_time_start;
			ocrId.setToken(token);
			//return ocrId;
			return new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.OK, ResponseStatusEnum.SUCCESSFUL, ApplicationResponse.SUCCESSFUL,ocrId,l_diff+" ms") ,HttpStatus.OK);												

		}
		}catch(Exception ex) {
			ex.printStackTrace();
			long l_end_time = System.currentTimeMillis();
			l_diff = l_end_time-l_time_start;
			return null;
			//return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		long l_end_time = System.currentTimeMillis();
		l_diff = l_end_time-l_time_start;
		return null;
		//return	new ResponseEntity<CoreResponseHandler>(new SuccessResponseBeanRefined(HttpStatus.INTERNAL_SERVER_ERROR, ResponseStatusEnum.FAILED, ApplicationResponse.Failed,"ERROR",l_diff+" ms"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@Override
	public CustomerDetail findByToken(String token) {
		// TODO Auto-generated method stub
		CustomerDetail customerDetail  = custRepository.findByToken(token);
		if(customerDetail==null)
		return null;
		else
			return customerDetail;
	}
	//@CacheEvict(value = "custDetails", key = "#strDate", allEntries = true) 
	@Override
	public CustomerDetail updateCustomer(CustomerDetail customerDetail,String strDate) {
		// TODO Auto-generated method stub
		CustomerDetail customerDetail2 =  custRepository.saveAndFlush(customerDetail);
		return customerDetail2;
	}

	@Override
	public CustomerDetail findByID(String id) {
		// TODO Auto-generated method stub
		return custRepository.findByID(id);
	}
	
	@Override
	public void deleteDuplicateCustomer(CustomerDetail customerDetail) {
		custRepository.delete(customerDetail);
	}
	//@Cacheable(cacheNames ="custDetails", key = "#date")
	@Override
	public List<CustomerDetail> fetchByDate(String date) {
		System.out.println("@@@@@  "+date+"   @@@@@@");
		
		List<CustomerDetail> list =  custRepository.findByCreateDatess(date);
		//2023-12-21
		//List<CustomerDetail> list =  custRepository.findByCreateDatess(date,"2023-12-21");
		System.out.println(list.size());
		return list;
		
	}

}
