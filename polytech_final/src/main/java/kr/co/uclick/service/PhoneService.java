package kr.co.uclick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.Phone;
import kr.co.uclick.entity.QPhone;
import kr.co.uclick.repository.PhoneRepository;

@Service
@Transactional
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;

	public void delete(Phone phone) {
		phoneRepository.delete(phone);
	}

	@Transactional(readOnly = true)
	public List<Phone> findAll() {
		return phoneRepository.findAll();
	}

	public void save(Phone phone) {
		phoneRepository.save(phone);
	}

	public Phone findById(Long phoneId) {
		Optional<Phone> phone = phoneRepository.findById(phoneId);
		return phone.get();
	}
	
	public Phone findPhoneByNumber(String number) {
		Optional<Phone> phone = phoneRepository.findOne(QPhone.phone.number.eq(number));
		return phone.orElse(null);
		
	}
	
//	@Cacheable(value = "area")
//	public List<Phone> findPhoneByNumberContaining(String number) {
//		return phoneRepository.findPhoneByNumberContaining(number);
//	}

}
