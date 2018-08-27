package kr.co.uclick.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.Phone;
import kr.co.uclick.entity.QPhone;
import kr.co.uclick.entity.QSample;
import kr.co.uclick.repository.PhoneRepository;

@Service
//Business Logic
//별다른 코딩 필요없음
@Transactional
public class PhoneService {

	private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

	@Autowired
	private PhoneRepository phoneRepository;

	@CacheEvict(value = "area", allEntries = true)
	public void delete(Phone phone) {
		phoneRepository.delete(phone);
	}

	@Cacheable(value = "area")
	@Transactional(readOnly = true)
	public List<Phone> findAll() {
		return phoneRepository.findAll();
	}

	@Cacheable(value = "area")
	public Phone findPhoneByNumber(String number) {

		phoneRepository.findAll(QPhone.phone.number.eq(number));
		return phoneRepository.findPhoneByNumber(number);
	}

	@Cacheable(value = "area")
	public List<Phone> findPhoneByNumberContaining(String number) {
		return phoneRepository.findPhoneByNumberContaining(number);
	}

	@CacheEvict(value = "area", allEntries = true)
//	@CacheEvict(value = "area", key="#phone.id")
	public void save(Phone phone) {
		phoneRepository.save(phone);
	}

	@Cacheable(value = "area")
	public Phone findById(Long phoneId) {
		Optional<Phone> phone = phoneRepository.findById(phoneId);
		return phone.get();
	}

}
