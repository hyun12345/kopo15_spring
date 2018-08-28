package kr.co.uclick.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import kr.co.uclick.entity.QSample;
import kr.co.uclick.entity.Sample;
import kr.co.uclick.repository.SampleRepository;

@Service
//Business Logic
//별다른 코딩 필요없음
@Transactional
public class SampleService {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

	@Autowired
	private SampleRepository sampleRepository;

	public void delete(Sample entity) {
		sampleRepository.delete(entity);
	}

	@Transactional(readOnly = true)
	public List<Sample> findAll() {
		return sampleRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Sample> findSampleByName(String name) {

		sampleRepository.findAll(QSample.sample.name.eq(name));
		sampleRepository.doSample(name);

		return sampleRepository.findSampleByName(name);
	}

	public void save(Sample sample) {
		sampleRepository.save(sample);
	}

	public void findById(Long sampleId) {
		sampleRepository.findById(sampleId);
	}
	
	//캐시 테스트
	public Sample selectOne(Long sampleId) {
		StopWatch sw = new StopWatch();
		sw.start();
		Sample sample = sampleRepository.selectOne(sampleId);
		sw.stop();
		
		logger.debug("total time : {}", sw.getTotalTimeSeconds());
		
		return sample;
	}
	
	public void updateOne(Sample sample) {
		StopWatch sw = new StopWatch();
		sw.start();
		sampleRepository.updateOne(sample);
		sw.stop();
		
		logger.debug("total time : {}", sw.getTotalTimeSeconds());
	}
}
