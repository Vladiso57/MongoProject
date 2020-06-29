package datarepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class MongoHandling implements IDAO {
	
	@Autowired
	MongoOperations mongoOps;

	@Override
	public void addRecord(BigDecimal id, BigDecimal patientId, long pulse, long power, long ppValue,
			long meanValue) {
		
		Examination examination = new Examination(id, patientId, pulse, power, ppValue, meanValue);
		deleteRecord(id);
		mongoOps.insert(examination);
		
	}

	@Override
	public Examination showResults(BigDecimal id) {
		
		Examination examination = mongoOps.findById(id, Examination.class);
		return examination;
		
	}

	@Override
	public void deleteRecord(BigDecimal id) {
		
		Examination examination = mongoOps.findById(id, Examination.class);
		if(examination != null)
			 mongoOps.remove(examination);
		
	}
	
	@Override
	public List<Examination> readAllRecords() {
		
		List<Examination> examinations = mongoOps.findAll(Examination.class);
		return examinations;
		
	}

	@Override
	public List<Examination> readAllRecordsGivenPatientId(BigDecimal patientId) {
		
		List<Examination> allExaminations = mongoOps.findAll(Examination.class);
		List<Examination> filteredExaminations = new ArrayList<>();
		for(Examination examination : allExaminations) 
			if(examination.getpatientId().equals(patientId))
				filteredExaminations.add(examination);
		return filteredExaminations;
		
	}

}
