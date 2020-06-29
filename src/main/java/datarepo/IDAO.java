package datarepo;

import java.math.BigDecimal;
import java.util.List;

public interface IDAO {

	void addRecord(BigDecimal id, BigDecimal patientId, long pulse, long power, long ppValue,
			long meanValue);
	
	Examination showResults(BigDecimal id);
	
	void deleteRecord(BigDecimal id);
	
	List<Examination> readAllRecords();
	
	List<Examination> readAllRecordsGivenPatientId(BigDecimal patientId);
	
}
